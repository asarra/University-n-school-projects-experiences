#include <stdio.h>
#include <stdlib.h>
#include <math.h>
///Ich benutze math.h in diesem Programm, um mit pow() zu potenzieren.

int main()
{
    const float pi = 3.14159;

    ///Structs
    typedef struct{
        float a;
        float b;
        float c;
    }TTriangle;

    typedef struct{
        float a;
        float b;
    }TSquare;

    typedef struct{
        float radius;
    }TCircle;

    typedef struct{
        float h;
        float radius;
    }TCylinder;



    ///Methoden
    double circumference(TTriangle dreieck){
        return dreieck.a+dreieck.b+dreieck.c;
    }

    double area_square(TSquare viereck){
        return viereck.a*viereck.b;
    }

    double cf_square(TSquare viereck){
        return 2*(viereck.a+viereck.b);
    }

    double area_kreis(TCircle kreis,float pi){
        return pi*pow(kreis.radius,2);
    }

    double cf_kreis(TCircle kreis,float pi){
        return 2*pi*kreis.radius;
    }

    double volume_zylinder(TCylinder zylinder,float pi){
        return pi*pow(zylinder.radius,2)*zylinder.h;
    }

    double oberflaeche_zylinder(TCylinder zylinder,float pi){
        return 2*pi*pow(zylinder.radius,2)+2*pi*zylinder.radius*zylinder.h;
    }



    ///Initialisierungen
    TTriangle dreieck={1.2,2.3,3.4};
    TSquare viereck={1,2};
    TCircle kreis={1};
    TCylinder zylinder={1,2};

    ///Berechnungen
    printf("Umfang vom Dreieck:\t%.2lf\n",circumference(dreieck));
    printf("Flaeche vom Viereck:\t%.2lf\n",area_square(viereck));
    printf("Umfang vom Viereck:\t%.2lf\n",cf_square(viereck));
    printf("Flaeche vom Kreis:\t%.2lf\n",area_kreis(kreis,pi));
    printf("Umfang vom Kreis:\t%.2lf\n",cf_kreis(kreis,pi));
    printf("Volume vom Zylinder:\t%.2lf\n",volume_zylinder(zylinder,pi));
    printf("Oberflaeche vom Zylinder:\t%.2lf",oberflaeche_zylinder(zylinder,pi));
    return 0;
}
