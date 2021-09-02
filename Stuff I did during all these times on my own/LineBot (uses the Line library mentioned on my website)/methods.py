# -*- coding: utf-8 -*-
try:
	from thriftos.base import Basos
	#Basos().login("mail", "pw")
	from thriftos.pollos import Pollos as client
	from thriftos.solos import Solos as receiver
	import time, sys, livejson,requests,json,os,random,pyimgflip
	from bs4 import BeautifulSoup
	from pyquery import PyQuery as pq
except ImportError as e:
	print e

#def is_protection(): #not doable because of "continue"
def is_autojoin(operation):
	if operation is not None:
		print("auto")
		if operation.type == 13:
			if (operation.param2 in squad.values() or operation.param2 in admins.values() or operation.param2 in staff.values()):
				try:
					client.acceptGroupInvitation(0, operation.param1)
				except Exception as e:
					print e
		else:
			pass

#def is_botdetect(): continue-error
def is_cancel_on(operation):
	if operation is not None:
		print("cancel")
		if operation.type == 13:
			if operation.param2 in squad.values(to):
				pass
			else:
				try:	
					splittedparam3 = operation.param3.split('\x1e')
					print splittedparam3
					client._client.cancelGroupInvitation(0, operation.param1, splittedparam3)
				except Exception as e:
					print e

###operations up/msgs down###

def help(to,botname):
	f=open("help.txt")
	content=f.read()
	f.close()
	receiver.sendMessage(to,str(
	"""
	\<\ ≤v≥  />/

	''I'm %s.
	  I'm smart.
	  Probably smarter than you.''

	  %s
	"""% (botname, content)))

def ses(to):
	receiver.sendMessage(to,".oa!")

def insult(to):
	r = requests.get('https://insult.mattbas.org/api/insult.json')
	a = json.loads(r.text)
	text = a['insult']
	receiver.sendMessage(to,str(text))

def rap(to):
	#session = dryscrape.Session()
	#session.visit('http://www.rhymebuster.com/rapgenerator?http')
	#response = session.body()
	#receiver.sendMessage(to,str(response))
	#soup = BeautifulSoup(response)
	#receiver.sendMessage(to,str(soup.find(id="songCol")))
	pass

def explain(to):
	f=open("explain.txt")
	content=f.read()
	f.close()
	receiver.sendMessage(to,content)

def Responsename(to,botname):
	receiver.sendMessage(to,botname)

def spam(to):
	for x in range(10):
		receiver.sendMessage(to,"x")

def send(to):
	a = msg.replace(botname and "send ","")
	for x in client.groups:
		x.sendMessage(to, a)

def protection_on(to):
	global protection
	protection = True
	receiver.sendMessage(to,"PROTECTION:ON")

def protection_off(to):
	protection = False
	receiver.sendMessage(to,"PROTECTION:OFF")

def cancel_on(to):
	global cancel_on
	cancel_on = True
	receiver.sendMessage(to,"CANCEL:ON")

def cancel_off(to):
	cancel_on = False
	receiver.sendMessage(to,"CANCEL:OFF")

def autojoin_on(to):
	global auto_join
	auto_join = True
	receiver.sendMessage(to,"AUTOJOIN:ON")

def autojoin_off(to):
	auto_join = False
	receiver.sendMessage(to,"AUTOJOIN:OFF")

def check(to):
	a=str(protection)
	receiver.sendMessage(to,a)

def groups(to):
	client.refreshGroups()
	#groups = str(list(enumerate(client.groups,1))).replace("[","").replace("<LineGroup ","").replace(">,","\n").replace("]","").replace(">","").replace("#","- ").replace("(1","1").replace(", (","\n").replace(", ",": ").replace(")):",")").replace("): ","\n").replace("(invited)","*invited*").replace(")","")
	groups = str(list(enumerate(client.groups,1))).replace("[","").replace("<LineGroup ","").replace(">,","\n").replace("]","").replace("#","- ").replace("(1","1").replace(", (","\n").replace(", ",": ").replace(")):",")").replace("): ","\n").replace("(invited)","*invited*").replace(")","").replace(">\n","\n")
	groups = str(groups[:-1])
	if "invited" in groups:
		groupsz=groups
		receiver.sendMessage(to,"New group invitation!")
	else:	groupsz=groups
	receiver.sendMessage(to,groupsz)

def members(to):
	amembers = str(list(enumerate(receiver.members,1))).replace("[","").replace("<LineContact ","")
	if ">>" in amembers:
		members = amembers.replace("]","").replace("(","").replace("),","\n").replace(","," -").replace(")","").replace(">>","12344321").replace(">","").replace("12344321",">")
		members = str(" " + members)
		receiver.sendMessage(to,members)
	else:
		members = amembers.replace(">,","\n").replace("]","").replace(">","").replace("(","").replace("),","\n").replace(","," -").replace(")","")
		members = str(" " + members)
		receiver.sendMessage(to,members)

def Squad(to):
	receiver.sendMessage(to,"<v>")

def copy(to):
	with open('/home/bot/Desktop/output.txt', 'w') as f1, open('/home/bot/Desktop/' + botname + '.py', 'r') as src:
		receiver.sendMessage(to,"Processing...")
		src = src.readlines()
		for line in src:
			f1.write(line)
		receiver.sendMessage(to,"Processed")
		###################################################need to add a switch that stops the bot from future executing commands when in talkmode###################
		#################################need to add a models.py where I pick up only a few functions out of it###################

def status(to):
	receiver.sendMessage(to,"UP!")

def accept(to):
	receiver.sendMessage(to,"Processing...")
	client.refreshGroups()
	for group in client.groups:
		 if "invited" in str(group):
			group.acceptGroupInvitation()
			client.refreshGroups()
	     		group.sendMessage(to,"Hey!")
	receiver.sendMessage(to,"Processed")

def myid(to):
	receiver.sendMessage(to,sender.id.replace("[","").replace("]",""))

def gid(to):
	receiver.sendMessage(to,receiver.id.replace("[","").replace("]",""))

def say(to):
	tesxt = msg.replace(botname and "say ","")
	receiver.sendMessage(to,tesxt)

def template(to):
	api = pyimgflip.Imgflip(username='name', password='pw')
	memes = api.get_memes()
	meme = random.choice(memes)
	receiver.sendMessage(to,"Generating a template: " + meme.name)
	result = api.caption_image(meme, " ", " ")
	receiver.sendMessage(to,"Meme template available at URL: " + result['url'])

def leave(to):
	group = receiver
	room = receiver
	group.sendMessage(to,"Cya ;)")
	client.leaveGroup(group)
	client.leaveRoom(room)

def kick(to):
	members = receiver.members
	groupId = receiver.id
	enemy = msg.replace(botname and "kick @","")
	for mem in members:
		a = str(mem).replace("<LineContact ","").replace(">,","\n").replace(">","")
		if enemy == a:
		 if (mem.id in squad.values() or mem.id in admins.values()):
			continue
		 else:
			client.kickoutFromGroup(0, groupId, [mem.id])
		elif ">" in enemy:											#replace that with delete last character
			a = a and ">"
			if enemy in a:														#don't forget to remove _ after @ in chat
				client.kickoutFromGroup(0, groupId, [mem.id])
		else:
			pass
def clean(to):
	receiver.sendMessage(to,"Processing...")
	members = receiver.members
	groupId = receiver.id
	for mem in members:
		if mem.id in squad.values(to):
			continue
		else:
			client.kickoutFromGroup(0, groupId, [mem.id])
	receiver.sendMessage(to,"Processed")

def su(to):
	receiver.sendMessage(to,"SHUT UP!")

def urban(to):
	msg = msg.replace(botname and "urban ","")
	receiver.sendMessage(to,msg)
	r = requests.get('http://www.urbandictionary.com/define.php', params={"term":msg}, headers = {'User-Agent': 'Mozilla/42.0'})
	receiver.sendMessage(to,pq(r.text)('div.meaning').text())

def stfu(to):
	receiver.sendMessage(to,"I hate you")
	os.system("shutdown now -h")
	receiver.sendMessage(to,"Test")

def reboot(to):
	receiver.sendMessage(to,"I hate you")
	os.system("reboot")

def details(to):
	print "sender = %s" % (sender)
	print "receiver = %s" % (to)
	print "message.text = %s" % (message.text)

def chat(to):
	receiver.sendMessage(to,"Processing...")
	if True:
		try:
			op_list = []
			for op in client.longPoll(to):
				op_list.append(op)
			for op in op_list:
			        sender   = op[0]
			        receiver
			        message
				msg = message.text
				if all(x in msg for x in (botname,"chat")):
					receiver.sendMessage(to,"Activated")
				else:
					receiver.sendMessage(to,"Deactivated")
					pass
		except:
			pass

def meme(to):
	folder = './memes/'
	b = os.listdir(folder)
	c = random.choice(b)
	a = folder + c
	receiver.sendImage(str(a))

def six(to):
	receiver.sendMessage(to,random.choice(["Yes!","No!","Maybe...","Perhaps...","Definitely!","Exactly!","Hell no!","Are you kidding me?","C'mon... What's this for a question?","Be more intelligent...","Are you serious?"]))

def squad(to):
	receiver.sendMessage(to,str(squad.keys()).replace("u","").replace("'","").replace("[","").replace("]","").replace(", ","\n"))

def admins(to):
	receiver.sendMessage(to,str(admins.keys()).replace("u","").replace("'","").replace("[","").replace("]","").replace(", ","\n"))

def staff(to):
	receiver.sendMessage(to,str(staff.keys()).replace("u","").replace("'","").replace("[","").replace("]","").replace(", ","\n"))

def owner(to):
	receiver.sendMessage(to,str(live.keys()).replace("u","").replace("'","").replace("[","").replace("]","").replace(", ","\n"))

def now(to):
	for x in receiver.members:
		target = x.statusMessage
		receiver.sendMessage(to,target)

def troll(to):
	receiver.sendMessage(to,"1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.‌1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01")

def heavytroll(to):
 	for x in range(3):
 		receiver.sendMessage(to,"1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.‌1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01.1.01")
	f=open("f.txt")
	content=f.read()
	f.close()
	receiver.sendMessage(to,content[:4095])
	receiver.sendMessage(to,content[4096:])

	#elif client.is_joined: - own function
	#	try:
	#		client.leaveGroup()
	#	except Exception('You didn't join')

def chat_on(to):
	chat_on = True
	receiver.sendMessage(to," chat:on")

def chat_off(to):
	chat_on = False
	receiver.sendMessage(to,"chat:off")

def detect_on(to):
	botdetect = True
	receiver.sendMessage(to,"ANTIBOT:on")

def detect_off(to):
	botdetect = False
	receiver.sendMessage(to,"ANTIBOT:off")

def speed(to):
	try:
		import timeit
		#import gc
		#gc.collect() 
		#time = timeit.timeit("receiver.sendMessage(to,'T.12')","from __main__ import receiver,to",number=1)
		start=timeit.timeit()
		receiver.sendMessage(to, "T.12")
		end=timeit.timeit()
		receiver.sendMessage(to, str(start-end))
	except Exception as e:
		print e
		pass

def check_chat(to):
	receiver.sendMessage(to,chat_on)

def is_chat_on(to):
	if botname in msg:
		key = "CC33w8zgnAADZvBpuFhkVcgtlDA"
		cs = "MXYxCTh2MQlBdldYQTFNNU1VSzEJMUZ2MTQ5OTEwNzAyNwk2NGlZb3UuCQ=="
		website = "https://www.cleverbot.com/getreply?key=%s&input=%s&cs=%s"%(key,str(msg),cs)
		jsonob = requests.get(str(website), headers = {'User-Agent': 'Mozilla/42.0'}).text
		try:receiver.sendMessage(to,str(json.loads(jsonob)['clever_output']))
		except Exception as e:print e
		if all(x in msg for x in (botname,"chat:off")):
			chat = False
			receiver.sendMessage(to,"if chat:off")


			#if operation.type == 17:			#if operation.type nur mit variable davor
			# try:
			#	welcomemsg="Welcome"
			#	receiver.sendMessage(to,welcomemsg)
			# except Exception as e:
			# 	print e
			#if operation.type == 18:
			# try:
			#	welcomemsg="RIP!"
			#	receiver.sendMessage(to,welcomemsg)
			# except Exception as e:
			# 	print e
			#if operation.type == 19:
			# if operation.param2 is None:
			#  try:
			#	welcomemsg="Finally... :D"
			#	receiver.sendMessage(to,welcomemsg)
			#  except Exception as e:
			# 	print e
			#if operation.type == 19:
			# if operation.param2 is not None:
			#  try:
			#	welcomemsg="Good job, mate"
			#	receiver.sendMessage(to,welcomemsg)
			#  except Exception as e:
			# 	print e
			
			#if lurk:
			#	if operation:
			#		add = {}
			#		for x in operation.param2:
			#			add[x]#=[x.name]	#del[x]
			#		print ("Done")
			#if lurk == False:
			#	receiver.sendMessage(to,str(add.keys()))