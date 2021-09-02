#include <stdio.h>
#include <stdlib.h>

int zaehle(int n){
    if(n>=0){
        printf("%i\n",n);
        return zaehle(n-1);
    }
    else{
        return 0;
    }
}

int main()
{
    int n;
    scanf("%i",&n);
    zaehle(n);
    return 0;
}
