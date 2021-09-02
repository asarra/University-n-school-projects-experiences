#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a[]={10,20,30,40};
    int *pa;
    pa=a;
    printf("%i\n",a[0]);
    printf("%i\n",a[1]);
    printf("%i\n",a[2]);
    printf("%i\n",a[3]);
    printf("%i\n",pa);///*(pa+1))=20 btw.
    printf("%i\n",a);
    return 0;
}
