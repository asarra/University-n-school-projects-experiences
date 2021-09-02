#include <stdio.h>
#include <stdlib.h>
void printDurchschnitt(double durchschnitt){
    printf("Der Notendurchschnitt betraegt %.2lf.\n", durchschnitt);}
int main()
{
    int notenAnzahl,zaehler;
    float note;
    printf("Bitte geben Sie die maximale Anzahl an Noten an, deren Durchschnitt es zu berechnen gilt.: ");
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
    if (durchschnitt<1.4){printf("Das Zeugnis ist sehr gut");}
    else if (durchschnitt<2.4){printf("Das Zeugnis ist gut");}
    else if (durchschnitt<3.4){printf("Das Zeugnis ist befriedigend");}
    else if (durchschnitt<4.4){printf("Das Zeugnis ist ausreichend");}
    else if (durchschnitt<5.4){printf("Das Zeugnis ist mangelhaft");}
    else {printf("Das Zeugnis ist ungenuegend");}
    return 0;
}
