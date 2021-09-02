#include <stdio.h>
#include <stdlib.h>

int main()
{
    int AnzahlResistor,x,p=0,r=0,min_Ohm=0;
    float max_Dauerstromstaerke,max_Dauerspannung,p_Ohm_gesamt=0, r_Ohm_gesamt=0,gesamt_Ohm;
    char entscheidung,next_widerstand;

    typedef struct{
        int min_Ohm;
        float max_Ohm,max_Dauerstromstaerke,max_Dauerspannung;
        char schaltung;
    }TResistor;

    printf("Wie viele Widerstaende existieren in der Gesamtschaltung?");
    scanf("%i",&AnzahlResistor);
    fflush(stdin);

    TResistor resistor[AnzahlResistor];

    ///Strom vs Spannung Teil 1
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

    ///Initialisierung jedes Widerstandes
    for(x=0;x<AnzahlResistor;x++){
        printf("\nUm welche Art von Schaltung handelt es sich beim Widerstand-Nr. %i?\nR/P:\t",x+1);
        scanf("%c",&next_widerstand);
        fflush(stdin);

        ///Schaltungsart beim aktuellen Widerstand bestimmen!
        if (next_widerstand=='R'){///Reihenschaltung
            resistor[x].schaltung='R';
        }
        else if (next_widerstand=='P'){///Parallelschaltung
            resistor[x].schaltung='P';
        }

        ///Widerstandswert eintippen!
        printf("Widerstandswert:");
        scanf("%f",&resistor[x].max_Ohm);
        fflush(stdin);

        ///min. Ohm initialisieren!
        resistor[x].min_Ohm=min_Ohm;
    }

    ///Zaehlen von Wiederholtem Auftreten von p und r!
    for(x=0;x<AnzahlResistor;x++){
        if (resistor[x].schaltung=='P'){
            p++;
            p_Ohm_gesamt=p_Ohm_gesamt+1/resistor[x].max_Ohm;///p errechnet!
        }
        else if (resistor[x].schaltung=='R'){
            r++;
            r_Ohm_gesamt=r_Ohm_gesamt+resistor[x].max_Ohm;  ///r errechnet!
        }
    }

    p_Ohm_gesamt=1/p_Ohm_gesamt;
    gesamt_Ohm=r_Ohm_gesamt+p_Ohm_gesamt;

    ///Strom vs Spannung Teil 2
    if (entscheidung=='I'){
        max_Dauerspannung=gesamt_Ohm*max_Dauerstromstaerke;
    }
    else if(entscheidung=='V'){
        max_Dauerstromstaerke=max_Dauerspannung/gesamt_Ohm;
    }

    printf("\nReihenwiderstand:\t%.2f\n\nParallelwiderstand:\t%.2f\n",r_Ohm_gesamt,p_Ohm_gesamt);
    printf("\nGesamtwiderstand:\t%.2f\nmax_Dauerstromstaerke:\t%.2f\nmax_Dauerspannung:\t%.2f",gesamt_Ohm,max_Dauerstromstaerke,max_Dauerspannung);
    return 0;
}
