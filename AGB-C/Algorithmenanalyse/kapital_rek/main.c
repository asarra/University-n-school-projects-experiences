#include <stdio.h>
#include <stdlib.h>

float kapital(float n){
    ///kapital(0)=1000
    printf("%.2lf\t",n);
    if(n!=0)
        //int c=kapital(n-1); wäre cool gewesen
        return kapital(n-1)+0.05*kapital(n-1);
    else
        return n;
}

int main()
{
    float n;
    scanf("%.2lf",&n);
    kapital(n);
    //printf("%i",kapital(n));
    return 0;
}
