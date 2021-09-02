#include <stdio.h>
#include <stdlib.h>

int main()
{
int i = 3, j = 5, k = 10;
int m;
float r = 3., s = 5.;
float u;

m = i + j + k; /* 18 */
printf("%.1d \n",m);
m = k - j - i; /* 2 */
printf("%.1d \n",m);
m = i - k; /* -7 */
printf("%.1d \n",m);
m = k / i; /* 3 */
printf("%.1d \n",m);
m = k / i + j; /* 8 */
printf("%.1d \n",m);
m = k / (i + j); /* 1 */
printf("%.1d \n",m);
m = k * i + j; /* 35 */
printf("%.1d \n",m);
m = k * (i + j); /* 80 */
printf("%.1d \n",m);
m = k % i; /* 1 */
printf("%.1d \n\n",m);
u = s + r; /* 8. */
printf("%f \n",u);
u = s / r; /* 1.666... */
printf("%f \n",u);
u = s * r; /*15. */
printf("%f \n",u);
u = k / r; /* 3.333... */
printf("%f \n",u);
u = k / r + s / r; /* 5. */
printf("%f \n",u);
u = k / i + s / i; /* 4.666... */
printf("%f \n",u);
//u = k % r; /* nicht erlaubt */ - Es geht nur mit ganzen Zahlen
return 0;
}
