"""
3. Rekursion 6 Pkt.
Schreiben Sie ein Python-Programm, das in einer rekursiven Funktion hoch mit den Parametern x
und i in dieser Reihenfolge den Wert xi berechnet. Das Hauptprogramm muss die Eingabe von x und
i vornehmen. Wenn der Parameter x beim Aufruf nicht angegeben wird, soll er mit 2 angenommen
werden.
Sorgen Sie dafür, dass das Programm durch Falscheingaben keine ungewollte Funktionalität aufweist.
Die Lösung ist recht einfach, wenn man die Funktion hoch(i, x) benutzt. Hier sollen Sie überlegen,
wie die Definition von hoch (mit x als erstem Parameter s.o.) aussehen kann, damit der Programmierer/
die Programmiererin sie auch nur mit dem i als Parameter aufrufen kann, und wie der Aufruf
dann aussehen muss.
"""


def hoch(i, x=2):
    if(i == 0):
        return 1
    elif i >= 1:
        return x*hoch(i-1, x)


schalter = True
while schalter:
    try:
        print("Gebe eine Zahl für x ein!")
        x = int(input())
        print("Gebe eine Zahl für i ein!")
        i = int(input())
        print(hoch(i, x))
        print("\n")
    except:
        pass
