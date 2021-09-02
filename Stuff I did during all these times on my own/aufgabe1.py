def calc(x,y):
	if x != 0 || y != 0:
		while y!=0:
			z=y;y=x%y;x=z
		print x
	else:
		print "Fehler:\tX oder Y sind nicht über 0!"

calc(7134,753)
calc(4535,3243)