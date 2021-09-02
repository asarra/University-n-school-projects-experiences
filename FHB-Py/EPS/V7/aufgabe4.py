"""
4. Funktionsparameter in Python 5 Pkt.
Schreiben Sie ein Programm, das fünf Funktionen enthält und aufruft. Demonstrieren Sie dabei
jeweils mit einer Funktion
• Defaultparameter
• Positionsparameter
• benannte Parameter
• die Übergabe von Parametern mit unpacking
• die Übernahme von Parametern mit unpacking
"""


def defaultparameter(i=1, j=2):
    print(i + j)


def positionsparameter(i,j):
    print(i + j)


def benannteParameter(i, j):
    print(i + j)


def übernahmeParameterUnpacking(*args):
    print(args[0][2])


def übergabeParameterUnpacking(arg0, arg1, arg2, arg3, arg4):
    print(arg1 + arg2)


args = ((2, 3), 0, 3, "a", 2)

defaultparameter()
positionsparameter(1, 2)
benannteParameter(i=1, j=2)
übernahmeParameterUnpacking(args)
übergabeParameterUnpacking(*args)
