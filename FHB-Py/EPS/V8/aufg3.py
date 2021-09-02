wort = "unverändertes Wort"
zahl = 10
liste = [10, 20, 25, 35]
# bonus
dicte = {"a": "1"}
inner_print = "Innerhalb der Funktion: "
outer_print = "Außerhalb der Funktion: "


def parameteruebergabe(_):
    wort = "verändertes Wort"
    print(f"{inner_print}{wort}")


def parameteruebergabeInt(_):
    zahl = 5
    print(f"{inner_print}{zahl}")


def parameteruebergabeListe(_):
    liste.append(10)
    print(f"{inner_print}{liste}")


def parameteruebergabeDict(_):
    dicte["b"] = "2"
    print(f"{inner_print}{dicte.keys()}, {dicte.values()}")


# call by value
parameteruebergabe(wort)
print(f"{outer_print}{wort}")
parameteruebergabeInt(zahl)
print(f"{outer_print}{zahl}")
# call by reference
parameteruebergabeListe(liste)
print(f"{outer_print}{liste}")  # nur mutable objects können "call by reference"d werden
parameteruebergabeDict(dicte)
print(f"{outer_print}{dicte.keys()}, {dicte.values()}")  # nur mutable objects können "call by reference"d werden
