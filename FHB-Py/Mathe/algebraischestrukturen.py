# NEUTRAL: if header and first row and column match, the identity (neutrales) element is the first element # only if headers start with identity (y # e = y AND e # y = y)
# INVERS: wenn in jeder zeile und jeder spalte ein neutrales element existiert, existiert ein inverses element (x # x^-1 = e)
# KOMMUTATIV: wenn verknüfungstafel symmetrisch bei der diagonale, die von oben links nach unten rechts  verläuft, ist, ist es abelian (kommutativ(a # b = b # a))
# Assoziativ: nicht ersichtlich! Bruteforce-Attacke! (a # b) # c = a # (b # c)

# Zur Überprüfung + Assoziativ: https://integral-domain.org/lwilliams/Applets/CayleyTables.html





# WENN keine Tabelle gegeben ist, rechne es selbst.:
# Ist folg. Gruppe (Z, +) kommutativ?

# 0 + 1 = 1
# e = 0
# NEUTRALES ELEMENT!

# 3 + (-3) = 0 = e
# In diesem Beispiel existiert ein inverses Element! Es ist -3!

# (a + b) + c = a + (b + c)
# Wenn das erfüllt ist, gilt Assoziativität!

# a + b = b + a
# Wenn das ..., gilt Kommutativgesetz!




operation = "plus"

grid = []

Set = [0, 1, 2]

if operation == "plus":
    print("|+|0|1|2|", end=" ")
    for x in Set:
        print(f"\n|{x}|", end=' ')
        for y in Set:
            print(x+y, end=' ')

elif operation == "minus":
    print("|-|0|1|2|", end=" ")
    for x in Set:
        print(f"\n|{x}|", end=' ')
        for y in Set:
            print(x-y, end=' ')

elif operation == "multi":
    print("|*|0|1|2|", end=" ")
    for x in Set:
        print(f"\n|{x}|", end=' ')
        for y in Set:
            print(x*y, end=' ')


