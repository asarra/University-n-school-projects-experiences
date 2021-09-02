#include <stdio.h>
#include <stdlib.h>



typedef struct{

    char  Farbe[20];
    char  Bezeichnung[20];
    char  Kennzeichen[20];
    int   Baujahr;
    char  Preis[20];
    char  Arbeitszeit[20];
    int   Schaden;

}Autos;



int main(){

    int AnzahlAutos;

    printf("Geben sie bitte die Anzahl der Autos ein:   ");                 //Eingabeaufforderunf für die Anzahl der Autos
    scanf("%i",&AnzahlAutos);

    Autos werkstatt[AnzahlAutos];

    int i;
    for (i=1; i<=AnzahlAutos; i++){
    printf("\n");
    printf("Geben sie die Farbe ein:                ");                 //Eingabeaufforderung für die Farbe des Autos
    scanf("%s",werkstatt[i].Farbe);
    fflush(stdin);

    printf("Geben sie die Bezeichnung ein:          ");                 //Eingabeaufforderung für die Bezeichnung des Autos
    scanf("%s",werkstatt[i].Bezeichnung);
    fflush(stdin);

    printf("Geben sie das Kennzeichen ein:          ");                 //Eingabeaufforderung für das Kennzeichen des Autos
    scanf("%s",werkstatt[i].Kennzeichen);
    fflush(stdin);

    printf("Geben sie das Baujahr ein:              ");                 //Eingabeaufforderung für das Baujahr des Autos
    scanf("%i",&werkstatt[i].Baujahr);
    fflush(stdin);

    printf("Geben sie den Preis ein:                ");                 //Eingabeaufforderung für den Preis des Autos
    scanf("%s",werkstatt[i].Preis);
    fflush(stdin);

    printf("Geben sie die Arbeitszeit ein:          ");                 //Eingabeaufforderung für die Arbeitszeit am Auto
    scanf("%s",werkstatt[i].Arbeitszeit);
    fflush(stdin);

    printf("Geben sie den entstandenen Schaden ein: ");                 //Eingabeaufforderung für den entstandenen Schaden am Autos
    scanf("%i",&werkstatt[i].Schaden);
    fflush(stdin);
    printf("%s",stderr);

    }

    int AutoAuswahl;
    printf("\nWaehlen Sie nun ein Auto aus!\n");
    scanf("%i",&AutoAuswahl);

    printf("\n");
    printf("Die Farbe Ihres Autos ist:          %s\n",werkstatt[AutoAuswahl].Farbe);                          //Ausgabe der Farbe vom Auto
    printf("Die Bezeichnung Ihres Autos ist:    %s\n",werkstatt[AutoAuswahl].Bezeichnung);                    //Ausgabe der Bezeichnung/Modell vom Auto
    printf("Das Kennzeichen Ihres Autos lautet: %s\n",werkstatt[AutoAuswahl].Kennzeichen);                    //Ausgabe des Kennzeichens vom Auto
    printf("Das Baujahr Ihres Autos ist:        %i\n",werkstatt[AutoAuswahl].Baujahr);                        //Ausgabe des Baujahres vom Auto
    printf("Der Preisn Ihres Autos ist:         %s Euro\n",werkstatt[AutoAuswahl].Preis);                     //Ausgabe des Preises des Autos
    printf("Die Arbeitszeit an ihrem Autos war: %s Stunden\n",werkstatt[AutoAuswahl].Arbeitszeit);            //Ausgabe der Arbeitszeit am Auto
    printf("Der Schaden an ihrem Auto beträgt:  %i Euro\n",werkstatt[AutoAuswahl].Schaden);                   //Ausgabe des entstandenen Schadens am Auto

return 0;
}
