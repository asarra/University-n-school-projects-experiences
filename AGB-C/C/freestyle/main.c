#include <stdio.h>
#include <stdlib.h>

int main()
{
    float Kommazahl1; float Kommazahl2;

    printf("Geben sie die erste Zahl ein!\n");
    scanf("%f", &Kommazahl1);
    fflush(stdin);

    printf("\nGeben sie die zweite Zahl ein!\n");
    scanf("%f", &Kommazahl2);
    fflush(stdin);

    printf("\n\n\nErgebnis\n");
    printf("_________\n\n\n");
    printf("    Addition        : %.1f \n",Kommazahl1 + Kommazahl2);
    printf("    Subtraktion     : %.1f \n",Kommazahl1 - Kommazahl2);
    printf("    Multiplikation  : %.1f \n",Kommazahl1 * Kommazahl2);
    printf("    Division        : %.2f \n",Kommazahl1 / Kommazahl2);        //(-...<0) /0 = -1.#J // (0>+...) / 0 = 1.#J //
    return 0;
}
