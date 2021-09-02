#include <stdio.h>
#include <stdlib.h>

int fib(int n){
    if(n>1){
        return fib(n-1)+fib(n-2);
    }
    else{
        return 1;
    }
}

int main()
{
    int n;
    scanf("%i",&n);
    printf("%i",fib(n));
    return 0;
}
