import math
from fractions import Fraction
# do not use verbindungsvektor for subtractions (the order asked in the task might not be the same as in the verbindungsvektor)
vektora = (3,-2,-1,4)
vektorb = (-1,-6,3,0)

skalarprodukt = 0

lengthofvektorb = len(vektorb)
lengthofvektora = len(vektora)
pointer = 0
summeforbetragvektora = 0
summeforbetragvektorb = 0

try:  # r is experimental (if you have leading 0s it will fail)
    if vektorb[0] == 0:
        r = vektorb[0]/vektora[0]
        way = "usual"
    elif vektora[0] == 0:
        r = vektora[0]/vektorb[0]
        way = "unusual"
    elif vektora[0] == 0 and vektorb[0] == 0:
        pass
    else:
        r = vektorb[0]/vektora[0]
        way = "usual"
except Exception:
    pass

verbindungsvektor = []  # no tuple, because they are immutable
einheitsvektora = []  # same
einheitsvektorb = []  # same
flaechenvektor = []  # same # falls in der aufgabe bereits ein vektor gegeben ist, scrolle ganz nach unten und entklammer das vektor zum manuellen bearbeiten

if lengthofvektora == lengthofvektorb:
    for x in vektora:
        skalarprodukt += x * vektorb[pointer]
        summeforbetragvektora += x**2
        summeforbetragvektorb += vektorb[pointer]**2
        verbindungsvektor.append(x - vektorb[pointer])
        flaechenvektor.append(x * vektorb[pointer])

        try:
            if way == "usual":
                temp_r = vektorb[pointer]/x
                if temp_r == r:
                    r == temp_r
                else:
                    r = None
            elif way == "unusual":
                temp_r = x/vektorb[pointer]
                if temp_r == r:
                    r == temp_r
                else:
                    r = None
            elif vektora[0] == 0 and vektorb[0] == 0:
                pass
        except Exception:
            pass

        if pointer < lengthofvektorb:
            pointer += 1

    # Basic
    print("Basics")
    print(f"Verbindungsvektor BA:\t{verbindungsvektor}")
    print(f"Skalarprodukt:\t{skalarprodukt}")

    # ####### Advanced
    print("\nAdvanced!:")

    abstand = 0
    for x in verbindungsvektor:
        abstand += x**2
    abstand = math.sqrt(abstand)  # abstand zweier punkte

    betragvektora = math.sqrt(summeforbetragvektora)  # länge
    betragvektorb = math.sqrt(summeforbetragvektorb)  # länge

    for x in vektora:
        einheitsvektora.append(str(Fraction((1/betragvektora) * x).limit_denominator()))
    for x in vektorb:
        einheitsvektorb.append(str(Fraction((1/betragvektorb) * x).limit_denominator()))

    cos_g = skalarprodukt/(betragvektora*betragvektorb)
    cos_g = str(Fraction(cos_g).limit_denominator())  # with fraction

    print(f"EinheitsvektorA:\t{einheitsvektora}\nEinheitsvektorB:\t{einheitsvektorb}")
    print(f"Abstand zweier Vektoren:\t{abstand}")
    print(f"BetragvektorA:\t{betragvektora}\nBetragvektorB:\t{betragvektorb}\nCosinus Gamma Winkel:\t{cos_g}")

    # ################################ Vektorgleichheit
    print("\nVektorgleichheitscheck!")
    point = 0

    if betragvektora == betragvektorb:
        print("Gleiche Länge")
        point += 1
    else:
        print("Nicht gleiche Länge")

    if r:
        print(f"Gleiche Richtung. Skalar = {r}")
        point += 1
    else:
        print("Nicht gleiche Richtung.")

    if r and r > 0:
        print("Gleiche Orientierung.")
        point += 1
    else:
        print("Nicht gleiche Orientierung")

    if point == 3:
        print("Vektoren sind gleich")
    else:
        print("Vektoren sind nicht gleich")

    # #### more advanced stuff
    print("\nMORE ADVANCED:")
    flaeche = 0
    flaechenvektor = [3,-2,2]  # nur entklammern wenn vektor bereits in der aufgabe gegeben ist
    for x in flaechenvektor:
        flaeche += x**2
    print(f"Wurzel({flaeche})")
    flaeche = math.sqrt(flaeche)  # Fläche eines zwischen zwei Vektoren aufgespannten Parallelogramms
    print(f"Fläche:\t{flaeche}")

    # Kreuzprodukt
    # vektora x vektorb = (a1;a2;a3) x (b1;b2;b3) = (a2b3-a3b2;a3b1-a1b3;a1b2-a2b1)
    import numpy as np
    a = np.array(vektora)
    b = np.array(vektorb)
    print(f"Kreuzprodukt{np.cross(a, b)}")

    # VektorA normieren!
    temp_vektora = []
    normierer = 1/betragvektora
    for x in vektora:
        temp_vektora.append(normierer*x)
    print(f"VektorA normiert:\t{temp_vektora}")

else:
    print("Vektoren haben nicht selbe Länge. Bitte korrigieren!")
