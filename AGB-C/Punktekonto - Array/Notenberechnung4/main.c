#include <stdio.h>
#include <stdlib.h>

void pruefungsZulassung(int zaehler,int notenAnzahl,double Noten[]){    //UNBEDINGT [] hinter Arraynamen schreiben, wenn du importierst
    int fuenfenZaehler=0;
    for(zaehler=0;zaehler<notenAnzahl;zaehler++){
        if(Noten[zaehler]==5){
            fuenfenZaehler++;
        }
    }
    if (fuenfenZaehler>2){printf("Da Sie %d Fuenfen haben, sind Sie nicht für die Pruefung zugelassen!",fuenfenZaehler);}
    else {printf("Sie sind fuer die Pruefung zugelassen!");}
}
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
    char *faecher[notenAnzahl]; //char * <- faecher[] wird somit zur Bibiothek von Adressen anderer Arrays
    float notenValue=0;
    for(zaehler=0;zaehler<notenAnzahl;zaehler++){
        printf("Fach: ");
        char data[]={};
        scanf("%s",data);
        fflush(stdin);
        faecher[zaehler]=data;
        printf("Note: ");
        scanf("%f",&note);
        Noten[zaehler]=note;
        notenValue=notenValue+Noten[zaehler];
        //printf("%c",faecher[zaehler]);printf("%d",faecher[zaehler]);printf("%f",faecher[zaehler]);
        printf("Sie haben fuer %s eine %.2lf eingegeben\n\n",faecher[zaehler], Noten[zaehler]);
        fflush(stdin);
    }
    //printf("\n\n\n%c\n\n\n",faecher[0]);
    double durchschnitt=notenValue/notenAnzahl;
    printDurchschnitt(durchschnitt);
    zeugnisKommentar(durchschnitt);
    vergleichErwartungRealitaet(notenDurschschnittsErwartung, durchschnitt);
    pruefungsZulassung(zaehler, notenAnzahl, Noten);
    return 0;
}
