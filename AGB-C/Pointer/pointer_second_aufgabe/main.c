#include <stdio.h>
#include <stdlib.h>

int main()
{
    ///aufgabe 2
    int x,y,*z;
    x=5;
    z=&x;
    y=*z;
    printf("%i\n",x);//5
    printf("%i\n",y);///5, da der Pointer zur
    printf("%i",z);
    return 0;
}
