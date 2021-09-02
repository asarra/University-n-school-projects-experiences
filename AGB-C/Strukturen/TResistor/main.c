#include <stdio.h>
#include <stdlib.h>

int main()
{
    ///Deklarisierungen und eine Initialisierung
    int AnzahlResistor,AnzahlSchaltungen,x=0,y;
    float max_Dauerstromstaerke,max_Dauerspannung,p_Ohm_gesamt,r_Ohm_gesamt,gesamt_Ohm;
    char entscheidung,schaltungsArt;

    typedef struct{
        float min_Ohm,avg_Ohm,max_Ohm,max_Dauerstromstaerke,max_Dauerspannung;
    }TResistor;


    ///Strom vs Spannung Teil 1
    ///Fortsetzung folgt weiter unten, da Widerstandsnetzwerke zuerst berechnet werden müssen!
    printf("\nBitte geben Sie entweder die Dauerstromstaerke(I) oder die Dauerspannung(V) an!\n");
    scanf("%c",&entscheidung);
    fflush(stdin);
    if (entscheidung=='I'){
        printf("Bitte geben Sie das passende Wert dazu ein!");
        scanf("%f",&max_Dauerstromstaerke);
        fflush(stdin);
    }
    else if(entscheidung=='V'){
        printf("Bitte geben Sie das passende Wert dazu ein!");
        scanf("%f",&max_Dauerspannung);
        fflush(stdin);
    }

    ///variable name checks out. Self-explanatory, if you could check out line 34. Hint: It can be found 2 lines below ;)
    printf("\nWie viele einzelne Schaltungen existieren in der Gesamtschaltung?\t");
    scanf("%i",&AnzahlSchaltungen);
    fflush(stdin);

    ///Schaltungsschleife
    while(x<AnzahlSchaltungen){
        printf("Um was fuer eine Schaltung handelt es sich?\nP/R:\t");
        scanf("%c",&schaltungsArt);
        fflush(stdin);
        printf("Wie viele Widerstaende existieren in der Schaltung?");
            if (schaltungsArt=='P'||schaltungsArt=='p')
            {
                scanf("%i",&AnzahlResistor);
                fflush(stdin);
                TResistor resistor[AnzahlResistor];
                ///Widerstandsschleife (speziell für Parallelschaltungen)
                for(y=0;y<AnzahlResistor;y++){
                    printf("\nWas ist der minimale Ohmwert von Widerstand-Nr. %i?\t",y+1);
                    scanf("%f",&resistor[y].min_Ohm);
                    fflush(stdin);
                    printf("\nWas ist der maximale Ohmwert von Widerstand-Nr. %i?\t",y+1);
                    scanf("%f",&resistor[y].max_Ohm);
                    fflush(stdin);
                    resistor[y].avg_Ohm=(resistor[y].min_Ohm+resistor[y].max_Ohm)/2;
                    p_Ohm_gesamt=p_Ohm_gesamt+(1/resistor[y].avg_Ohm);
                }
            ///Am Ende, jedoch noch innerhalb der Parallelschaltungsektion, wird die Summe für jedes einzelne invertierte Parallelwiderstand noch einmal invertiert.
            p_Ohm_gesamt=1/p_Ohm_gesamt;
            }
            else if(schaltungsArt=='R'||schaltungsArt=='r')
            {
                scanf("%i",&AnzahlResistor);
                fflush(stdin);
                TResistor resistor[AnzahlResistor];
                ///Widerstandsschleife (speziell für Reihenschaltungen)
                for(y=0;y<AnzahlResistor;y++){
                    printf("\nWas ist der minimale Ohmwert von Widerstand-Nr. %i?\t",y+1);
                    scanf("%f",&resistor[y].min_Ohm);
                    fflush(stdin);
                    printf("\nWas ist der maximale Ohmwert von Widerstand-Nr. %i?\t",y+1);
                    scanf("%f",&resistor[y].max_Ohm);
                    fflush(stdin);
                    resistor[y].avg_Ohm=(resistor[y].min_Ohm+resistor[y].max_Ohm)/2;
                    r_Ohm_gesamt=r_Ohm_gesamt+resistor[y].avg_Ohm;
                }
            }
        ///Inkrementieren von x und Neutralisieren von AnzahlResistor
        x++;
        AnzahlResistor=0;
    }

    ///Die Widerstaende der Parallelschaltungen und die Widerstaende der Reihenschaltungen werden hier zusammenaddiert!
    gesamt_Ohm=r_Ohm_gesamt+p_Ohm_gesamt;

    ///Strom vs Spannung Teil 2
    if (entscheidung=='I'){
        max_Dauerspannung=gesamt_Ohm*max_Dauerstromstaerke;
    }
    else if(entscheidung=='V'){
        max_Dauerstromstaerke=max_Dauerspannung/gesamt_Ohm;
    }

    ///Ausgabe von Endresultaten
    printf("\nReihenwiderstand:\t%.2f\n\nParallelwiderstand:\t%.2f\n",r_Ohm_gesamt,p_Ohm_gesamt);
    printf("\nGesamtwiderstand:\t%.2f\nmax_Dauerstromstaerke:\t%.2f\nmax_Dauerspannung:\t%.2f",gesamt_Ohm,max_Dauerstromstaerke,max_Dauerspannung);
    return 0;
}
