import os
schalter = True
path = os.path.join(os.path.dirname(__file__), "speisekarten")


def showSpeisekarte(speisekarte):
    '''a()=showSpeisekarte()'''
    print("_______________________________")
    print("Name\tPreis\tKategorie")
    for x in speisekarte:
        if "#" in x:
            print(f"{x.split('#')[0]}\t{x.split('#')[1]}")
        else:
            print(x)
    print("_______________________________\n")
    ui()


def ui():
    '''z()=ui()'''
    print(
        "a = Speisekarte anzeigen\n" +
        "n = neues Gericht hinzufügen\n" +
        "k = Kategorie einer Speise ändern\n"
        "l = Gericht löschen\n" +
        "e = Programmende\n\n" +
        "(Hinweis: Falls du wieder zurückwillst,\n" +
        "drücke b)" +
        "\n"
        )


def appendList(liste):
    '''n()=appendList()'''
    print("Was soll an Gericht gespeichert werden?\n(Falls das ein Fehler war, kannst du b und Enter drücken!)")
    temp = input()
    print("Was ist der Preis?")
    temp = f"{temp}:\t{input()}€"
    if(temp == "b"):
        print("\n")
        ui()
        return
    print(type(liste))
    print(type(temp))
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


def saveList(path, dateiname):
    '''e()=saveList()'''
    if dateiname is None:
        print("Wie wollen Sie die neue Datei benennen?")
        dateiname = f"{input()}.txt"

    with open(os.path.join(path, dateiname), 'w') as datei:
        for y in liste:
            # print(x)
            if ":" in y:
                datei.write("%s\n" % y)
            elif y == "\n" or y == "['']" or y == '':
                pass
    print(liste)
    print("Die Datei wurde erstellt und das Programm wird beendet!")


def loadFile(path, liste):
    print("Welche Speisekarte soll geladen werden?")
    print("Gebe den Namen der Datei an!")
    os.system(f"cd {path} & ls")
    temp = f"{input()}.txt"
    print("\n")
    with open(os.path.join(path, temp), "r") as f:
        x = f.read().split("\n")
        for y in x:
            if ":" in y:
                liste.append(y)
            elif y == "\'\' " or y == "\n" or y == "['']" or y == '':
                pass
    return liste, temp


def changeCategory(liste):
    print("Von welcher Speise soll die Kategorie geändert werden?\n" +
          "Zur Auswahl stehen: Vorspeise, Hauptspeise, Nachspeise oder Getränk\n" +
          "(Falls das ein Fehler war, kannst du b und Enter drücken!)"
          )

    i = 0
    print("ID\tSpeise")
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
    print("Welche Kategorie soll für diese Auswahl gespeichert werden?")
    temp_cat = str(input())
    t = liste[temp]
    if "#" in t:
        ts = t.split("#")[1]
        if len(ts) > 0:
            t = t.replace(ts, "")
    else:
        t = f"{t}#"
    liste[temp] = f"{t}{temp_cat}"
    print("\nDas Gericht mit der ID %s wurde mit der Kategorie %s assoziiert!\n" % (temp, temp_cat))

    ui()
    return liste


liste = []
try:
    liste, dateiname = loadFile(path, liste)
except Exception:
    print("Konnte keine Speisekarte laden!")
    liste = []
    dateiname = None

ui()

while schalter:
    try:
        temp = input()
        print("\n")
        if(temp == "a"):
            showSpeisekarte(liste)
        elif((temp == "z") | (temp == "b")):
            ui()
        elif(temp == "e"):
            saveList(path, dateiname)
            schalter = False
        elif(temp == "n"):
            appendList(liste)
        elif(temp == "l"):
            removeGericht()
        elif(temp == "k"):
            liste = changeCategory(liste)
        else:
            print("Falsche Eingabe: Versuche es nochmal!")
            ui()
    except Exception as e:
        print(e)
