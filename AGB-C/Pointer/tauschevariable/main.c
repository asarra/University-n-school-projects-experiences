#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a=1,b=2;
    a=a+b;
    b=a-b;
    a=a-b;
    printf("%i\n",a);
    printf("%i",b);
    return 0;
}
