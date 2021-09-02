#include <stdio.h>
#include <stdlib.h>

int main()
{
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
a = c < b; /* -"- a = 1 */

return 0;
}
