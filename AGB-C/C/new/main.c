#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main()
{
    //Deklaration einer Variable
    int ganzzahl;

    printf("Bitte tippen Sie etwas ein\n\n\t");
    scanf("%i", &ganzzahl);     //& nur beim Speichern und ohne & nur beim Ausgeben
    printf("\n");
    printf("Sie haben %i eingegeben.\n\n", ganzzahl);
//    MessageBox("Willkommen","Um zu schlie�en, muessen Sie eine Eingabe an Ihrer Tastatur bet�tigen.\n\n\n\n", 0);
    getchar();


    int test;
    scanf("%i",&test);
    printf("%i", test);
    return 0;
}
