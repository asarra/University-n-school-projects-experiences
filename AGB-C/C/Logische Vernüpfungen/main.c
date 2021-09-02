#include <stdio.h>
#include <stdlib.h>


int main()
{
//Vergleichsoperatoren
int a = 5;
int b = 12;
int c = 7;
a < b; /* WAHR */
b < c; /* FALSCH */
a + c <= b; /* WAHR */
b - a >= c; /* WAHR */
a == b; /* FALSCH */
a + c == b; /* WAHR */
a != b; /* WAHR */
a = b < c; /* möglich: a = 0 */
printf("%i", a);
a = c < b; /* -"- a = 1 */
printf("%i", a);
//original
int d = 2;


if (a < b && (d = (a + b) != c)){
    printf("Hey!");
}
if ((d = (a + b)) != c && a < b){
     printf("Buddy!");
}
//zusätzlich
if (d != c){
     printf("\n sup? \n\n");
}
    return 0;
}
