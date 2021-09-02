def pow(n, times):
    constantN = n
    for _ in range(1, times):
        for __ in range(1, constantN):
            n = n+n
    return n


def pseudo(n):
    if isinstance(n, int) and n > 0:
        return 3*pow(n, 3) + pow(n, 2) + 3
    else:
        print("Gebe einen Integer an!")
        return None


n = 2
a = pseudo(n)
print(a)
