#include <stdio.h>
#include <stdlib.h>
int fak_iterat(int n){
    int zaehler,nex=1,array[n];
    for(zaehler=0;zaehler<=n;zaehler++){
        array[n-zaehler]=n-zaehler;
        if (array[n-zaehler]!=0)
        nex*=array[n-zaehler];
    }
    return nex;
}
int main()
{
    int n,nex;
    printf("Eingabe:\t");
    scanf("%d",&n);
    nex=fak_iterat(n);
    printf("Ausgabe:\t%u",nex);
    return 0;
}
