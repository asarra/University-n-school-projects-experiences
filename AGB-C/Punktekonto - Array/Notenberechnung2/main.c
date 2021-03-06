#include <stdio.h>
#include <stdlib.h>

void vergleichErwartungRealitaet(float notenDurschschnittsErwartung, double durchschnitt){
    if (notenDurschschnittsErwartung<durchschnitt){printf("Es ist besser als erwartet\n");}
    else if (notenDurschschnittsErwartung==durchschnitt){printf("Sowohl der reale Notendurchschnittsnote als auch die Erwartete sind identisch\n");}
    else {printf("Die Realitaet sieht leider schlechter aus als erwartet\n");}
}

void zeugnisKommentar(double durchschnitt){
    if (durchschnitt<1.4){printf("Das Zeugnis ist sehr gut\n");}
    else if (durchschnitt<2.4){printf("Das Zeugnis ist gut\n");}
    else if (durchschnitt<3.4){printf("Das Zeugnis ist befriedigend\n");}
    else if (durchschnitt<4.4){printf("Das Zeugnis ist ausreichend\n");}
    else if (durchschnitt<5.4){printf("Das Zeugnis ist mangelhaft\n");}
    else {printf("Das Zeugnis ist ungenuegend\n");}
}

void printDurchschnitt(double durchschnitt){
    printf("Der Notendurchschnitt betraegt %.2lf.\n", durchschnitt);
}

int main()
{
    int notenAnzahl,zaehler;
    float note, notenDurschschnittsErwartung;
    printf("Bitte geben Sie den Notendurchschnitt ein, den Sie am Ende der Berechnung erwarten wuerden.\n");
    printf("Erwarteter Notendurschschnitt: ");
    scanf("%.2f\n", notenDurschschnittsErwartung);
    fflush(stdin);
    printf("Bitte geben Sie die maximale Anzahl an Noten an, deren Durchschnitt es zu berechnen gilt.\n");
    printf("Anzahl an Faechern: ");
    scanf("%d",&notenAnzahl);
    double Noten[notenAnzahl];
    fflush(stdin);
    float notenValue=0;
    for(zaehler=0;zaehler<notenAnzahl;zaehler++){
        printf("Note: ");
        scanf("%f",&note);
        Noten[zaehler]=note;
        notenValue=notenValue+Noten[zaehler];
        fflush(stdin);
    }
    double durchschnitt=notenValue/notenAnzahl;
    printDurchschnitt(durchschnitt);
    zeugnisKommentar(durchschnitt);
    vergleichErwartungRealitaet(notenDurschschnittsErwartung, durchschnitt);
    return 0;
}
