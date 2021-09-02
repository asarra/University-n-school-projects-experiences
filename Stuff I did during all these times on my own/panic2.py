from urllib2 import Request

for i in xrange(1,28+1,1):
	print i
	url="https://de.wikiversity.org/api/rest_v1/page/pdf/Kurs%3AMathematik_f%C3%BCr_Anwender_%28Osnabr%C3%BCck_2019-2020%29%2FTeil_I%2FVorlesung_%s"%i

	response = Request.urlopen(url)
	print(response.url)
	data = response.read()
	with open("%s.pdf"%i,"wb+") as f:
		f.write(data)

