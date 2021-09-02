#include <stdio.h>
#include <stdlib.h>

int main()
{
    int eingabe[5],zaehler,summe=0,zahlenSchloss[]={9,5,6,1,2,1};
    for(zaehler=0;zaehler<=5;zaehler++){
        printf("Nur Zahlen von 1 bis 10 eingeben!");
        scanf("%i",&eingabe[zaehler]);
        fflush(stdin);
        if(1<=eingabe[zaehler]||eingabe[zaehler]>=10){
            printf("\n%i\n",eingabe[zaehler]);
            printf("Sie haben eine Zahl im richtigen Feld eingegeben");
            if(eingabe[zaehler]==zahlenSchloss[zaehler]){
                printf("\nRichtig!\n");
                summe++;
            }
            else{
                printf("\nFalsch!\n");
            }}
        else{
            printf("Falscher Zahl||Charakter wurde eingegeben");
        }
        }
    if(summe==6){
        printf("\nSchloss wurde geknackt!");
    }
    else{
        printf("\nSchloss wurde nicht geknackt!");
    }
    return 0;
}
