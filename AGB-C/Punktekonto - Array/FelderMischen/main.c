#include <stdio.h>
#include <stdlib.h>

int main()
{
    /*DEKLARISIERUNGEN UND INITIALISIERUNGEN VON VARIABLEN*/
    double menge1 [] = {1.0,3.0,5.0,6.0,9.0},menge2 [] = {2.0,3.0,5.0,7.0,8.0,9.0,9.0};
    double tempMenge1[5], tempMenge2[5], summe[11];
    const int b=1;
    int zaehler,zaehler2, z=0, a=0, maxIndexSumme;
    int maxIndexMenge1 = (sizeof(menge1)-1)/sizeof(double),maxIndexMenge2 = (sizeof(menge2)-1)/sizeof(double);

    /*AUSGABE VON MENGE1*/
    printf("menge1:\t");
    for (zaehler=0;zaehler<=maxIndexMenge1;zaehler++){
            printf("%.0lf", menge1[zaehler]);
    }

    /*AUSGABE VON MENGE2*/
    printf("\nmenge2:\t");
    for(zaehler2=0;zaehler2<=maxIndexMenge2;zaehler2++){
            printf("%.0lf", menge2[zaehler2]);
    }

    /*OPERATION*/
    zaehler=0;zaehler2=0;
    while(z<=(sizeof(tempMenge2)/sizeof(double))){
    //printf("XX%d|%dXX\t",((sizeof(menge1)/sizeof(double))-z),((sizeof(menge2)/sizeof(double))-z));
    if(((sizeof(menge1)/sizeof(double))-z)==0){
                    tempMenge1[z]=menge2[zaehler2];
                    tempMenge2[z]=menge2[zaehler2+1];
    }
    else{
        if (menge1[zaehler]<=menge2[zaehler2]){
                    tempMenge2[z]=menge2[zaehler2];
                    tempMenge1[z]=menge1[zaehler];
                    }
        else if (menge2[zaehler2]<=menge1[zaehler]){
                    tempMenge2[z]=menge1[zaehler];
                    tempMenge1[z]=menge2[zaehler2];
                    }}
    //printf("%.0lf", tempMenge1[z]);    printf("|%.0lf ", tempMenge2[z]);
    zaehler2++;
    zaehler++;
    z++;
    }
    for(z=0;z<=(sizeof(tempMenge2)/sizeof(double));z++){
        summe[z+z]=tempMenge1[z];
        summe[a+b+z]=tempMenge2[z];
        a++;
    }
    maxIndexSumme=(sizeof(summe)/sizeof(double));

    /*AUSGABE VOM ENDERGEBNIS*/
    printf("\nDie sortierte und aufsteigende Menge im 1 dimensionalem Array:\t");
    for(z=0;z<=maxIndexSumme;z++){
        printf("%.0lf", summe[z]);
    }
    return 0;
}
