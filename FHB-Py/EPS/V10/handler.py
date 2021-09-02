from speisekarte import Speisekarte


class Handler():
    def __init__(self):
        self.speisekarte = Speisekarte()
        self.liste = self.speisekarte.liste
        self.schalter = True
        self.path = self.speisekarte.path
        self.speisekarte.ui()

    def handle(self):
        try:
            self.liste, self.dateiname = self.speisekarte.loadFile(self.path, self.liste)
        except Exception:
            print("Konnte keine Speisekarte laden!")
            self.liste = []
            self.dateiname = None

        while self.schalter:
            try:
                temp = input()
                print("\n")
                if(temp == "a"):
                    self.speisekarte.showSpeisekarte(self.liste)
                elif((temp == "z") | (temp == "b")):
                    self.speisekarte.ui()
                elif(temp == "e"):
                    self.speisekarte.saveList(self.path, self.dateiname)
                    self.schalter = False
                elif(temp == "n"):
                    self.speisekarte.appendList(self.liste)
                elif(temp == "l"):
                    self.speisekarte.removeGericht()
                elif(temp == "k"):
                    self.liste = self.speisekarte.changeCategory(self.liste)
                else:
                    print("Falsche Eingabe: Versuche es nochmal!")
                    self.speisekarte.ui()
            except Exception as e:
                print(e)
