#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n=10,laufvar,var;float array[100];
    printf("\n\nBerechnete(r) Array(s) werden aufgelistet:\n");
        for(laufvar=0;laufvar<n;laufvar++){
            printf("Runde \"%d\" von \"%d\"\n",laufvar+1,n);
            for(var=0;var<=100;var++){
                array[var]=pow(var,2);
                printf("%.0f\t",array[var]);
            }
            printf("\n\n");
        }
    return 0;
}
