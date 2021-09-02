#include <stdio.h>
#include <stdlib.h>

int fib_iter(int n){
    int zaehler,c,c1=0,c2=1;
    for(zaehler=0;zaehler<=n;zaehler++){
    if(zaehler>1){
        //c=(c-1)+(c-2); funktioniert so nicht. Ich muss es splitten.
        //c1=c-1;
        //c2=c-2;
        //c=c1+c2;

        c=c1+c2;
        c1=c2;
        c2=c;
    }
    else{
        c=zaehler;
    }}
return c;
}

int main()
{
    int n;
    scanf("%u",&n);
    printf("\n\t%u",fib_iter(n));
    return 0;
}
