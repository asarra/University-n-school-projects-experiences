liste = []
speisekarte = {
    "Döner": 3.50,
    "Köfte": 9.99,
    "Sucuk": 1
}
schalter = True


def showSpeisekarte():
    '''a()=showSpeisekarte()'''
    print("_______________________________")
    for x in speisekarte:
        print("%s\t\t\t%s €" % (x, speisekarte[x]))
    print("_______________________________\n")
    ui()


def ui():
    '''z()=ui()'''
    print(
        "a = Speisekarte anzeigen\n" +
        "n = neues Gericht hinzufügen\n" +
        "l = Gericht löschen\n" +
        "e = Programmende\n\n" +
        "(Hinweis: Falls du wieder zurückwillst,\n" +
        "drücke b)" +
        "\n"
        )


def appendList():
    '''n()=appendList()'''
    print("Was soll an Gericht gespeichert werden?\n(Falls das ein Fehler war, kannst du b und Enter drücken!)")
    temp = input()
    if(temp == "b"):
        print("\n")
        ui()
        return
    liste.append(temp)
    print("\n%s wurde der Liste hinzugefügt!\n" % temp)
    ui()


def removeGericht():
    '''lösche ein Gericht aus der Liste'''
    print(
        "Welches Gericht soll gelöscht werden?" +
        "\nGeben Sie eine Zahl ein!" +
        "\n(Falls das ein Fehler war, kannst du b und Enter drücken!)\n"
        )
    i = 0
    print("ID\tName")
    for x in liste:
        print("%s\t%s" % (i, x))
        i += 1
    temp = input()
    if(temp == "b"):
        print("\n")
        ui()
        return
    else:
        temp = int(temp)
    del liste[temp]
    print("\nDas Gericht mit der ID %s wurde aus der Liste entfernt!\n" % temp)
    ui()


def saveList():
    '''e()=saveList()'''
    with open("list.txt", 'w') as datei:
        for x in liste:
            datei.write("%s\n" % x)
    print("Die Datei wurde erstellt und das Programm wird beendet!")


ui()

while schalter:
    try:
        temp = input()
        print("\n")
        if(temp == "a"):
            showSpeisekarte()
        elif((temp == "z") | (temp == "b")):
            ui()
        elif(temp == "e"):
            saveList()
            schalter = False
        elif(temp == "n"):
            appendList()
        elif(temp=="l"):
            removeGericht()
        else:
            print("Falsche Eingabe: Versuche es nochmal!")
            ui()
    except Exception as e:
        print(e)
