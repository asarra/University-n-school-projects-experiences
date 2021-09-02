#include <stdio.h>
#include <stdlib.h>


double Fahrenheit(double celsius_wert)
{
double fahrenheit_zwischenWert = celsius_wert*1.8+32;
return fahrenheit_zwischenWert;
}

int main()
{
double celsius_wert,fahrenheit_wert;
char frage='y';
    while(frage=='y'){
    scanf("%lf",&celsius_wert);
    fflush(stdin);
    fahrenheit_wert=Fahrenheit(celsius_wert);
    printf("\t%.2lf\n",fahrenheit_wert);
        if(fahrenheit_wert<=40){
            printf("Kaeltewarnung\n");
            }
    printf("Willst du weitermachen y/n\n?");
    scanf("%c",&frage);
    fflush(stdin);
        if(frage=='n'){
            break;
            }
        else{
            printf("OK");
            }
    }
return 0;
}
