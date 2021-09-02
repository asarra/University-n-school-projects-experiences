"""
Schreiben Sie ein Pythonprogramm das mit Hilfe von verschachtelten Schleifen folgendes Muster auf der Konsole ausgibt:

1

1 2

1 2 3

1 2 3 4

1 2 3 4 5

(Hinweis: Mit print( ... , end='') verhindern Sie, das die Ausgabe automatisch umgebrochen wird.)
"""

for x in range(1,6):
    for j in range(1,x+1):
        print(j,end="")
    print()
