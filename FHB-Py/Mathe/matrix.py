import numpy

a = [[-4,2,1],[2,-1,0],[1,-3,2]]
# a = [[3,0],[6,-1]]
b = [[3,0],[0,-1]]

def add(a,b):
    a = numpy.matrix(a)
    b = numpy.matrix(b)
    c = a+b


def multiply(a,b):
    a = numpy.matrix(a)
    b = numpy.matrix(b)
    d = a*b
    print(d)


def freestyle(a,b):
    a = numpy.matrix(a)
    b = numpy.matrix(b)
    # c = a + (3 * b)
    # c = b + 3 * a
    print(c)

def inverseMatrix(a):
    y = numpy.linalg.inv(a)
    print(f"Inverse:\t{y}")


def determinanteUNDBasisUNDrangUndinvertierbarkeitscheck(a): # von oben nach unten geht aber auch von links nach rechts
    det = numpy.linalg.det(a)
    print(f"Determinante der Matrix:\t{det}")

    # Wenn die Determinante einer Matrix ungleich 0 ist, ist es immer eine Basis des Vektorraumes R^3.
    # Die Vektoren in randomvektor sind linear unabhängig und somit eine Basis des ℝ3
    # Compute the determinant of your matrix and use the fact that a matrix is invertible iff its determinant is nonzero.
    # + nicht quadratische Matrizen sind automatisch nicht invertierbar, da man deren Determinante nicht berechnen kann

    if det != 0:
        print("Es ist eine Basis des Vektorraumes R^3! (Linear unabhängige Vektoren)\nEs ist außerdem invertierbar")
    else:
        print("Keine Basis!(Linear abhängige Vektoren)\nEs ist außerdem NICHT invertierbar")

    print(f"Rang:\t{numpy.linalg.matrix_rank(a)}")



determinanteUNDBasisUNDrangUndinvertierbarkeitscheck(a)

# matrix bei der aufgabe von links nach rechts übernehmen für die unteren (Numpy ist iwie komisch und macht die vektoren von links nach rechts in matrix)

#inverseMatrix(a)
# freestyle(a,b)
# multiply(a,b)

