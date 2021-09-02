#include <stdio.h>
#include <stdlib.h>
int fak_rek(int n){
    if (n>=1){
        printf("\nn:\t%d",n);
        return n*fak_rek(n-1);
    }
    return 1;
}
int main()
{
    int n;
    scanf("%i",&n);
    printf("\nEnde:\t%u",fak_rek(n));   //%u = unsigned
    return 0;
}
