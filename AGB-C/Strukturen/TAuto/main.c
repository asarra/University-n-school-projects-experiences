#include <stdio.h>
#include <stdlib.h>

int main()
{
    typedef struct{
        char Farbe[10];        ///char array[] verwenden oder Pointer erstellen und später malloc() anwenden!
        char Bezeichnung[20];   ///Anders ist es nicht zu lösen!
        int Baujahr;
        int Preis;          ///Da man Autos nicht auf den Cent genau verkauft :)
        double Arbeitszeit;///in Stunden
        int Schaden;        /*Gilt als Boolean zu sehen! Nicht jedes Auto, das in der Werkstatt behandelt wird,
        hat auch wirklich einen Schaden. Es könnte auch nur ein einfacher Reifenwechsel stattfinden,
        das sicherlich nicht unbedingt in einer Relation zu einem Autoschaden steht!*/
        }TAuto;


    ///Anzahl an Autos werden hier gezählt!
    printf("Wie viele Autos wollen Sie zaehlen?\t");
    int AnzahlAutos;
    scanf("%i",&AnzahlAutos);

    ///Deklarisierungen
    int x;
    char jaOderNein;
    TAuto y[AnzahlAutos];

    ///AutoInitialisierungs-Schleife
    for(x=0;x<AnzahlAutos;x++){
        printf("\nAuto-Nr. %i\n",x+1);

        printf("Farbe:\t\t");
        scanf("%s",y[x].Farbe);
        fflush(stdin);

        printf("Bezeichnung:\t");
        scanf("%s",y[x].Bezeichnung);
        fflush(stdin);

        printf("Baujahr:\t");
        scanf("%i",&y[x].Baujahr);
        fflush(stdin);

        printf("Preis:\t\t");
        scanf("%i",&y[x].Preis);
        fflush(stdin);

        printf("Arbeitszeit:\t");
        scanf("%lf",&y[x].Arbeitszeit);
        fflush(stdin);

        printf("Liegt beim Fahrzeug ein Schaden vor?\nj/n:\t\t");
        scanf("%c",&jaOderNein);
        fflush(stdin);

        ///Wenn es einen Schaden am Wagen gibt, wird es hier per Usereingabe registriert!
        if (jaOderNein=='j'){
            y[x].Schaden=1;
        }
        else if (jaOderNein=='n'){
            y[x].Schaden=0;
        }
        else{
            printf("Irgendetwas hat beim Boolean-Check nicht funktioniert!");
        }

        ///Erneute, jedoch komplette Ausgabe jeder Eigenschaft jedes einzelnen Autos pro Initialisierungsrunde
        printf("\nFarbe: %s, Bezeichnung: %s, Baujahr: %i, Preis: %i, Arbeitszeit: %.2lf, Schaden: %i\n",y[x].Farbe,y[x].Bezeichnung,y[x].Baujahr,y[x].Preis,y[x].Arbeitszeit,y[x].Schaden);
    }

    ///AutoAuswahl-Bereich nach der Initialisierung von verschiedenen Fahrzeugen
    int AutoAuswahl;
    printf("\nWaehlen Sie nun ein Auto aus!\n");
    scanf("%i",&AutoAuswahl);

    ///Notwendig, da der Benutzer sonst nie das erste Auto auswählen kann!
    AutoAuswahl=AutoAuswahl-1;

    ///Ausgabe der Eigenschaften des ausgewählten Autos!
    printf("\nIhr ausgewaehltes Auto besitzt folgende Eigenschaften:\nFarbe: %s, Bezeichnung: %s, Baujahr: %i, Preis: %i, Arbeitszeit: %.2lf, Schaden: %i\n",
           y[AutoAuswahl].Farbe,y[AutoAuswahl].Bezeichnung,y[AutoAuswahl].Baujahr,y[AutoAuswahl].Preis,y[AutoAuswahl].Arbeitszeit,y[AutoAuswahl].Schaden);

    /*Aus Fehlern gemachte Erfahrungen und allgemeine Tipps:
    char array[beliebigeZahl] oder char *array im struct erstellen und außerhalb von struct *array mit malloc() Speicher zuweisen!
    "%63s" als erster Parameter bedeutet, dass es nur die ersten 63 Byte aus der Usereingabe speichern soll. Sinnvoll, wenn man sichergehen will, dass der 64. Byte nicht überschrieben wird. Wenn da kein \0 Char stehen würde, wäre es kein String mehr! Fatal!
    %[^\n] = bis zum Enter. Als Fallback und Erweiterung für %s zu sehen!
    Kein "%.2" und "\n" in scanfs benutzen!
    Bei Pointerinitialisierungen per scanf() niemals & im 2. Parameter benutzen.
    */

    return 0;
}
