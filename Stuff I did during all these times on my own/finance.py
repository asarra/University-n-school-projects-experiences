# -*- coding: utf-8 -*-
from Tkinter import *
import re,time,json,requests,brotli,os

requests.packages.urllib3.disable_warnings()

url={
	"boerse":"https://www.boerse-online.de/rss",
	"alpha":"https://seekingalpha.com/news/top-news/feed",
	"planspiel":"https://www.planspiel-boerse.de/skherford/_js_DS/0/content_extern/news.json",
	"planspiel_specific":"https://www.planspiel-boerse.de/skherford/_js_DS/0/content_extern/news/",
	"plus500_once":"https://www.plus500.de/",
	"plus500_search":"https://www.plus500.de/api/InstrumentsSearch",
	"plus500_search_list":"https://www.plus500.de/api/LiveData/FeedsUpdates",
	"googleNews":"https://www.google.de/search?q=finance&asearch=wp_tab_async&async=kptab:YOUR_STOCKS,stick:1,_fmt:prog"}
bad_words=["kein","verändert Preis","Crash","schwach","schlecht","riskant","warnen"]
good_words=["gut","steigt","wächst","sinkt"]

#not constant
id_msg="f1e0bf3104085d75d242681b2b909e101fe75a50d08fd4a8eddc72e06ef487ca"
eingabe="Gold"

def getHeaders():
	headers={}
	headers["Connection"]="keep-alive"
	headers["Content-Type"]="application/x-www-form-urlencoded; charset=UTF-8"
	headers["User-Agent"]="Chrome/70.0.3538.77"
	return headers

def looped_currentAktienkurs(url,eingabe,token,headers):
	data="term=%s&token=%s&searchCount=5"%(eingabe,token)
	r=requests.post(url["plus500_search"],headers=headers,verify=False, data=data)
	name=json.loads(r.text)["Data"]["results"][0]["EnglishName"]
	id=json.loads(r.text)["Data"]["results"][0]["Id"]
	return name,id

def currentAktienkurs(url,eingabe):
	headers=getHeaders()
	r = requests.get(url["plus500_once"], headers=headers, verify=False).text.encode("utf-8")
	token = re.search(r'\"token\"\s\:\s\"(\w+\S+)\"',r).group(1)
	if token:
		return looped_currentAktienkurs(url,eingabe,token,headers)
	else:
		print("Something is wrong in the function 'currentAktienkurs'!")

def prepareForIteration(id):
	headers=getHeaders()
	del headers["Content-Type"]
	return requests.get(url["plus500_search_list"],params={"instrumentIds":id},verify=False,headers=headers).text

def prepareWhileForFutureThreading():
	global eingabe
	print "Es wird nach %s gesucht"%eingabe
	name,id=currentAktienkurs(url,eingabe)
	try:
		while id:
			end=time.time()
			r=prepareForIteration(id)
			r=r[2:-2].replace("\\","")
			print u"\n\tAktueller Aktienkurs von %s (in Dollar, wenn kein Währungsvergleich gemacht wird)"%name
			print "\tKaufpreis:\t\t%s"%json.loads(r)["BuyPrice"]
			print "\tVerkaufspreis:\t\t%s"%json.loads(r)["SellPrice"]
			print u"\tHöchster Preis:\t\t%s"%json.loads(r)["HighPrice"]
			print "\tNiedrigster Preis:\t%s"%json.loads(r)["LowPrice"]
			print u"\tPreisänderung:\t\t%s"%json.loads(r)["ChangePercentText"]
			if json.loads(r)["ChangePercent"]>=.2:
				print "\tADVICE:\t\t\tSELL!"
			elif json.loads(r)["ChangePercent"]<=-.2:
				print "\tADVICE:\t\t\tBUY!"
			else:
				print "\tADVICE:\t\t\tDon't buy anything atm!"
			print "\tEND_WHILE\t\t%s"%(time.time()-end)
			time.sleep(3)
			os.system("cls")
	except Exception as e:
		print e;pass

def getGoogleSpecificHeaders():
	headers={}
	headers["Connection"]="keep-alive"
	headers["User-Agent"]="User-Agent: Mozilla/5 (Windows NT 7) AppleWebKit/537 Chrome/70 Safari/537"
	headers["Accept-Encoding"]="gzip, deflate, br"
	headers["Accept-Language"]="Accept-Language: de-DE,de"
	return headers

def googleNews(url):
	headers=getGoogleSpecificHeaders()
	r=requests.get(url["googleNews"],verify=False,headers=headers)
	bro=brotli.decompress(r.content)
	#pure_html=re.search(r"(<style>(.+\s){1,6}.+v></div>)",bro).group(1)
	list_pure_html_articles=re.finditer(r'style="-webkit-line-clamp:2">(([\w+\s+ä+ö+ü+:+\.+\,+\!+]*)|(\S))+</div>',bro,re.MULTILINE)
	return [m.group(0)[78:-6] for m in list_pure_html_articles if isinstance(m.group(0)[78:-6], basestring)]
	
def seekingalphaNews(url):
	r=requests.get(url["alpha"],verify=False,headers=getHeaders())
	return [x.group(0)[7:-8] for x in re.finditer(r"(<title>(([\w+\s+ä+ö+ü+:+\.+\,+\!+]*)|(\S))+</title>)",r.content,re.MULTILINE)]

def boerseNews(url):
	r=requests.get(url["boerse"],verify=False,headers=getHeaders())
	return [x.group(0)[7:-8] for x in re.finditer(r"(<title>(([\w+\s+ä+ö+ü+:+\.+\,+\!+]*)|(\S))+</title>)",r.content,re.MULTILINE)]

def planSpielNews(url):
	r=requests.get(url["planspiel"],verify=False,headers=getHeaders())
	total=len(json.loads(r.content)["msg"]);a=[]
	for x in range(10):
		a.append(json.loads(r.content)["msg"][x]["head"].encode("latin1")) #latin1 preserves bytes #NO +=! .append()!
	return a

def planSpielNews_specific(url,id_msg):
	r=requests.get(url["planspiel_specific"]+"%s.json"%id_msg,verify=False,headers=getHeaders())
	return json.loads(r.content)["text"]

def collectAllNews(url):
	global id_msg
	return googleNews(url),seekingalphaNews(url),boerseNews(url),planSpielNews(url)#,planSpielNews_specific(url,id_msg)

def newsBereich(url):
	root=Tk()
	root.title('Aktuelle Neuigkeiten')
	root.geometry("800x600")
	#root.attributes("-fullscreen", True)
	scrollbar=Scrollbar(root)
	text=Text(root,height=64,width=128)
	scrollbar.pack(side=RIGHT,fill=Y)#.grid(column=2, row = 1)#
	text.grid(column=1, row = 1)#.pack(side=LEFT,fill=Y)
	scrollbar.config(command=text.yview)
	text.config(yscrollcommand=scrollbar.set)
	print "1"
	text.insert(END,collectAllNews(url))
	button = Button(root,text="Switch to Aktienkurs",fg="red",command=root.destroy)#,width=25)
	button.grid(column=1, row = 2)
	print "2"
	root.mainloop()

newsBereich(url)
prepareWhileForFutureThreading()