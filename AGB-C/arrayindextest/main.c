#include <stdio.h>
#include <stdlib.h>

int main()
{
    double a[100];
    a[0]=2;
    a[0]++;
    printf("Wert: %.2lf\n\t",a[0]);
    //double a_a=* a;
    printf("%.2lf",* a);
    return 0;
}
