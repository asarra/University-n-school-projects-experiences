# Funktionen scopes, do_local, do_nonlocal und do_global
word = "wort"
print(f"im Hauptprogramm: test {word}")


def scopes():
    word = "scopes wort"  # word
    print(f"in {scopes.__name__}: {word}")

    def do_local():
        word = "local wort"
        print(f"in {do_local.__name__}: {word}")
    do_local()
    print(f"in {scopes.__name__}: {word}")

    def do_nonlocal():
        nonlocal word
        word = "nonlocal wort"
        print(f"in {do_nonlocal.__name__}: {word}")
    do_nonlocal()
    print(f"in {scopes.__name__}: {word}")

    def do_global():
        global word
        word = "global wort"
        print(f"in {do_global.__name__}: {word}")
    do_global()
    print(f"in {scopes.__name__}: {word}")


scopes()
print(f"im Hauptprogramm: {word}")
