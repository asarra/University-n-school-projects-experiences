#include <stdio.h>
#include <stdlib.h>

int main()
{
    float a,b,*pa;
    pa=&a;
    *pa=12;
    *pa+=5.5;
    b=*pa+5;
    printf("%.2lf\n",a);
    printf("%.2lf\n",b);
    printf("%i",pa);
    return 0;
}
