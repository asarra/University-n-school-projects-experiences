#include <stdio.h>
#include <stdlib.h>
void tausche(float *,float *);
int main()
{
    float x=5.5,y=7.5;
    tausche(&x,&y);
    return 0;
}
void tausche(float *p1,float *p2)
{
    float tmp;
    tmp=*p1;
    *p1=*p2;
    *p2=tmp;
    printf("%.2lf\n",*p1);
    printf("%.2lf\n",*p2);
    printf("%.2lf",tmp);
}
