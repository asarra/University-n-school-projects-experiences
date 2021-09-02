#include <stdio.h>
#include <stdlib.h>

void printDurchschnitt(int notenAnzahl,double notenValue){
    double durchschnitt=notenValue/notenAnzahl;
    printf("Der Notendurchschnitt betraegt %.2lf.\n", durchschnitt);}
int main()
{
    int notenAnzahl,zaehler;
    float note;
    printf("Bitte geben Sie die maximale Anzahl an Noten an, deren Durchschnitt es zu berechnen gilt.: ");
    scanf("%d",&notenAnzahl);
    double Noten[notenAnzahl];
    fflush(stdin);
    float notenValue;
    for(zaehler=0;zaehler<notenAnzahl;zaehler++){
        printf("Note: ");
        scanf("%f",&note);
        Noten[zaehler]=note;
        notenValue=notenValue+Noten[zaehler];
        fflush(stdin);
    }
    printDurchschnitt(notenAnzahl,notenValue);
    return 0;
}
