#include <stdio.h>
#include <stdlib.h>

double for(){
//e x=29 ist 12,23  stimmt nicht

}

double storebaeltStahlseilBerechnen(int x)
{
    double mittig = 0.0002684486*(x*x)-0.4359605911*x+254;
    double m = 0.0002684486*(x*x) + 77;
    printf("m=%.2lf\n",m);
    return mittig;
}

int main()
{
    int x;
    double y;
    scanf("%d",&x);
    y=storebaeltStahlseilBerechnen(x);
    printf("%.2lf",y);
    return 0;
}
