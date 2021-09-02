#include <stdio.h>
#include <stdlib.h>

void gibWerteTabelleAus(){
    printf("Wertetabelle fuer f(x)=(-1/48)*x^2+4*x!\n");
    int x = 0;
    while(x!=193){
        double y;
        y=-0.0208333333*(x*x)+4*x;
        printf("x:%d\t",x);
        printf("y:%.2lf\n",y);
        x=x+1;
}}
void getStrahlerhoehen(){
    printf("\n\nStrahlerhoehen!\n");
    int x = 30;
    while(x<=193){
        double y;
        y=-0.0208333333*(x*x)+4*x;
        printf("x:%d\t",x);
        printf("y:%.2lf\n",y);
        x=x+30;
}}
    double berechneStrahlerhoehe(int x){
    printf("\nStrahlerhoehe wird berechnet!\n");
    double y;
    y=-0.0208333333*(x*x)+4*x;
    return y;
}
double getLichterketten()
{
    printf("\n\nLichterkettenlaenge!\n");
    int x = 30;
    int durchlauf = 1;  //musste es erhöhen, da sonst bei der Ausgabe von 0 angefangen wird!
    float xyz[6];
    char string[][10]={"","Erste","Zweite","Dritte","Vierte","Fuenfte","Sechste"}; //10=max. Anzahl an Chars in Strings pro String
    while(x<=193){
        printf("%s Lichterkettenlaenge = ",string[durchlauf]);
        double y;
        y=-0.0208333333*(x*x)+4*x;
        xyz[durchlauf]=y;
        printf("%.2f Meter!\n",xyz[durchlauf]);
        durchlauf=durchlauf + 1;
        x=x+30;
    }
    float summey;
    summey=xyz[1]+xyz[2]+xyz[3]+xyz[4]+xyz[5]+xyz[6]+xyz[7];
    //printf("%.2f Meter!\n",xyz[6]); //Zum Testen
    return summey;
}
int main()
{
    gibWerteTabelleAus();
    getStrahlerhoehen();
    printf("\nBitte geben Sie eine Zahl ein!\n");
    int x;
    scanf("%d",&x);
    double y;
    y=berechneStrahlerhoehe(x);
    printf("x:%d\t",x);
    printf("y:%.2lf\n",y);
    float summey;
    summey=getLichterketten();
    printf("\nEs wird eine Lichterkettenlaenge von %.2fm benoetigt!\n\n",summey);
    //printf("%d %.2lf",x[0],y[0]);
    return 0;
}
/*Formatierung
(Nachkommastellen, Zeichenstellen)
%6.2lf \t
6=insgesamt 6 Zeichen
2=2 Nachkommastellen
\t=Tabulator
*/
/*Übernahme von Berechnungen und Funktionsaufrufen innerhalb printf*/
/*Strahlerbezeichnung*/
/*Einheiten*/
/*=> Algorithmen-Reengineering*/
