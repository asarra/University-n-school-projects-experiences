#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i=2,a[]={10,20,30,40},*pa;
    pa=a;
    a[i]=5;
    *(pa+i)=5; ///wird hier nicht die selbe Stelle von a[i] überschrieben?!
    printf("%i\n",a[0]);
    printf("%i\n",a[1]);
    printf("%i\n",a[2]);
    printf("%i\n",a[3]);
    printf("%i\n",*pa);
    printf("%i",a);
    return 0;
}
