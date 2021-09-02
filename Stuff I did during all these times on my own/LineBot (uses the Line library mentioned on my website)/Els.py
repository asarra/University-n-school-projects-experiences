# -*- coding: utf-8 -*-
try:
	from thriftos.base import Basos
	#Basos().login("mail", "pw")
	from thriftos.pollos import Pollos as client
	from thriftos.solos import Solos as receiver
	import time, sys, livejson,requests,json,os,random,pyimgflip
	from bs4 import BeautifulSoup
	from pyquery import PyQuery as pq
	from methods import *
except ImportError as e:
	print e
#no need to type in authToken anywhere.
#Just use "Basos().login(mail,pw)" once to get your token and certificate
#If you have your token already, you can save it in z.txt, certificate = a.txt

botname = "Els"
protection = True
cancel_on = False
auto_join = True
chat_on = False
#lurk = False
botdetect = False

meeeh= os.path.dirname(os.getcwd())
try:
	live = livejson.File("%s/members/hierarchy.json"%meeeh)			#friendlybots,settings,banlist
	#live["ownerName"] = "ownerId"
	squad = livejson.File("%s/members/squad.json"%meeeh)
	admins = livejson.File("%s/members/admins.json"%meeeh)
	staff = livejson.File("%s/members/staff.json"%meeeh)
except Exception as e:
	print e
	pass
print "A"


while True:
	operation=[]
	try:
		for op in client.operation():
			operation.append(op)#makes it all just appear once instead of repeating the messages
			#print op
		for op in operation:
			#print op
			to=op.message.to
			sender=op.message._from
			message=op.message
			msg = message.text
			operation = op
			#msg=op.message.text
			#print receiver
			#toanalyze: print op, and to analyze just the message: print op.message
			#print msg
			#print op
			if protection:
				 if operation is not None:
				  if operation.type == 19:											#DER UNTERE TEIL FUNKTIONIERT!		PROBLEM: ICH KANN KEINE COMMANDS BENUTZEN, ka wieso -> OT DARF NICHT ALLEINE AM STAMM BLEIBEN
					param1 = operation.param1	#group						#PLUS, KEINE NEUE DEKLARIERUNGEN AUßERHALB VON IF
					param2 = operation.param2	#user
					param3 = operation.param3	#msg

					print param1
					print param2
					print param3
					groupId=param3
					print groupId
					if (param2 in squad.values() or param2 in admins.values()):
						continue
					else:
						try: client.kickoutFromGroup(0, param1, [param2])
						except Exception as e:
							print e
					#try: client.inviteIntoGroup(param1, contacts=[admin])
					#except Exception as e:
					#	print e
			if auto_join:
				is_autojoin(operation)
			if botdetect:
				try:
				 if operation is not None:
					import time
					if operation.type == 13:
						start = time.time()
						if operation.type == 17:
							end = time.time()
							diff = int(end - start)
							if diff <= 1:
								print(str(operation.param2))
								if (param2 in squad.values() or param2 in admins.values() or param2 in staff.values()):
									continue
								else:
									try: client.kickoutFromGroup(0, param1, [param2])
									except Exception as e:
										print e
				except Exception as e:
					print e
			if cancel_on:
				is_cancel_on(operation)
			if msg==botname+" help":help(to,botname)
			elif all(x in msg for x in (botname,"ses")):ses(to)
			elif all(x in msg for x in (botname,"insult")):insult(to)
			elif all(x in msg for x in (botname,"rap")):rap(to)
			elif all(x in msg for x in (botname,"explain")):explain(to)
			elif "Responsename" in msg:Responsename(to,botname)
			elif all(x in msg for x in (botname,"spam")):spam(to)
			elif all(x in msg for x in (botname,"send")) and sender.id in live.values():send(to)
			elif all(x in msg for x in (botname,"protection:on")) and sender.id in live.values():protection_on(to)
			elif all(x in msg for x in (botname,"protection:off")) and sender.id in live.values():protection_off(to)
			elif all(x in msg for x in (botname,"cancel:on")) and sender.id in live.values():cancel_on(to)
			elif all(x in msg for x in (botname,"cancel:off")) and sender.id in live.values():cancel_off(to)
			elif all(x in msg for x in (botname,"autojoin:on")) and sender.id in live.values():autojoin_on(to)
			elif all(x in msg for x in (botname,"autojoin:off")) and sender.id in live.values():autojoin_off(to)
			elif all(x in msg for x in (botname,"check")):check(to)#########################################################################
			elif all(x in msg for x in (botname,"groups")):groups(to)
			elif all(x in msg for x in (botname,"members")):members(to)
			elif "Squad" in msg:Squad(to)
			elif all(x in msg for x in (botname,"copy")) and sender.id in live.values():copy(to)
			elif all(x in msg for x in (botname,"status")):status(to)
			elif all(x in msg for x in (botname,"accept")) and sender.id in live.values():accept(to)
			elif all(x in msg for x in (botname,"myid")):myid(to)
			elif all(x in msg for x in (botname,"gid")):gid(to)
			elif all(x in msg for x in (botname,"say")):say(to)
			elif all(x in msg for x in (botname,"template")):template(to)
			elif all(x in msg for x in (botname,"leave")) and (sender.id in live.values() or sender.id in squad.values() or sender.id in admins.values()):leave(to)
			elif all(x in msg for x in (botname,"kick")) and (sender.id in live.values() or sender.id in staff.values() or sender.id in squad.values() or sender.id in admins.values()):kick(to)
			elif all(x in msg for x in (botname,"clean")) and (sender.id in live.values()):clean(to)
			elif all(x in msg for x in (botname,"su")):su(to)
			elif all(x in msg for x in (botname,"urban")):urban(to)
			elif all(x in msg for x in (botname,"stfu")) and sender.id in live.values():stfu(to)
			elif all(x in msg for x in (botname,"reboot")) and sender.id in live.values():reboot(to)
			elif all(x in msg for x in (botname,"details")) and sender.id in live.values():details(to)
			elif all(x in msg for x in (botname,"chat")) and sender.id in live.values():chat(to)
			elif all(x in msg for x in (botname,"meme")):meme(to)
			elif all(x in msg for x in (botname+"6")):six(to)
			elif all(x in msg for x in (botname,"squad")):squad(to)		
			elif all(x in msg for x in (botname,"admins")):admins(to)
			elif all(x in msg for x in (botname,"staff")):staff(to)
			elif all(x in msg for x in (botname,"owner")):owner(to)
			elif all(x in msg for x in (botname,"now")):now(to)
			elif all(x in msg for x in (botname,"troll")) and sender in squad.values():troll(to)
			elif all(x in msg for x in (botname,"heavytroll")) and sender in squad.values():heavytroll(to)
			elif all(x in msg for x in (botname,"chat:on")) and sender.id in squad.values():chat_on(to)
			elif all(x in msg for x in (botname,"chat:off")):chat_off(to)
			elif all(x in msg for x in (botname,"detect:on")) and sender.id in squad.values():detect_on(to)
			elif all(x in msg for x in (botname,"detect:off")) and sender.id in squad.values():detect_off(to)
			elif all(x in msg for x in (botname,"speed")):speed(to)
			elif "check chat" in msg:check_chat(to)
			elif chat_on:is_chat_on(to)
			else:print "See nothing else";pass
		else:pass
	except Exception as e:print e;pass