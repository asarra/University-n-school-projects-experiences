#include <stdio.h>
#include <stdlib.h>

//#define UP 72

int main()
{
    printf("Willkommen zum Startmenue\n\n");
    printf("Es gibt folgende Moeglichkeiten:\n");
    printf("1 = Addition von int und char: Ausgabe als integer\n");
    printf("2 = Addition von int und char: Ausgabe als character\n");
    printf("3 = Datenueberlauf bei der int-Variable\n");
    printf("4 = Division durch 0\n");
    printf("5 = Ausgabe einer float-Variablen als Integer\n\n");
    printf("Bitte betaetigen Sie eine Tastaturangabe zwischen 1-5\n\n\n");
    int aendern; scanf("%i",&aendern);


switch(aendern) {

    char Buchstabe;
    int Zahl;

    char m; //Zum Wiederholen des ganzen Programms

    /*int *zeigerZahl;
    zeigerZahl = &Zahl;*/



	case 1: fflush(stdin);
            printf("\n\nAddition von int und char");
            printf("\n... Ausgabe als integer\n");
            printf("Bitte geben Sie erst einen Buchstaben\n");
            printf("Ihre Eingabe: ");
            scanf("%c",&Buchstabe);
            printf("\nUnd jetzt eine Zahl\n");
            printf("Ihre Eingabe: ");
            scanf("%i",&Zahl);
            printf("\nErgebnis:\n");
            printf("%c+%i=%i"/*Front-End*/,Buchstabe,Zahl,Buchstabe+Zahl/*Back-End*/);
            printf("\n");
            // Iein Buchstabe(36)+ Zahl (2) = 38        - nur bei vorher bestimmten Variable a und 2
            // richtig: a+1=98; a+2=99; b+10=108
            fflush(stdin);
            printf("\nDruecken Sie auf 'm', um zum Menue zu gelangen.\n");
            scanf("%c",&m);
            printf("\n\n\n\n");
            if (m == 'm'){
            exit(main());
            }
            break;

	case 2: fflush(stdin);
            printf("\n\nAddition von int und char");
            printf("\n... Ausgabe als character\n");
            printf("Bitte geben Sie erst eine Zahl an\n");
            printf("Ihre Eingabe: ");
            scanf("%i",&Zahl);
            printf("\nUnd jetzt einen Buchstaben\n");
            fflush(stdin);                                  //aber warum 2x?; warum lösche ich den RAM, wenn ich den wert von var Zahl brauche? Es funktioniert jedoch trotzdem
            printf("Ihre Eingabe: ");
            //fgets("%c",&Buchstabe, stdin);                //does it work?
            scanf("%c",&Buchstabe);
            printf("\nErgebnis:\n");
            printf("%c+%i=%c",Buchstabe,Zahl,Buchstabe+Zahl);
            printf("\n");
            //Iein Buchstabe(Dollarzeichen) + Zahl 2 = &
            fflush(stdin);
            printf("\nDruecken Sie auf 'm', um zum Menue zu gelangen.\n");
            scanf("%c",&m);
            printf("\n\n\n\n");
            if (m == 'm'){
            exit(main());   //richtig: a+1=b;b+1=c;z+1={
            }
            break;

	case 3: fflush(stdin);
            printf("\n\nDatenueberlauf bei der int-Variable\n");
            printf("Bitte geben Sie eine Zahl an\n");
            printf("Ihre Eingabe: ");
            scanf("%i",&Zahl);
            printf("\nErgebnis:\n");
            printf("%i+%i=%i",2147483647,Zahl,2147483647+Zahl);
            printf("\n");
            //es wechselt seinen Vorzeichen zum Minus und addiert ungestört weiter
            fflush(stdin);
            printf("\nDruecken Sie auf 'm', um zum Menue zu gelangen.\n");
            scanf("%c",&m);
            printf("\n\n\n\n");
            if (m == 'm'){
            exit(main());       //richtg:2147483647+1=-2147483648
            }
            break;

    case 4: fflush(stdin);
            printf("\n\nDivision durch 0\n");
            printf("Bitte geben Sie eine Zahl an\n");
            printf("Ihre Eingabe: ");
            scanf("%i",&Zahl);
            printf("\nErgebnis:\n");
            printf("%i/%i=%i",0,Zahl,0/Zahl);
            printf("\n");
            //Ergebnis:0
            fflush(stdin);
            printf("\nDruecken Sie auf 'm', um zum Menue zu gelangen.\n");
            scanf("%c",&m);
            printf("\n\n\n\n");
            if (m == 'm'){
            exit(main());          //  0/2=0
            }
            break;

    case 5: fflush(stdin);
            printf("\n\nAusgabe einer float-Variablen als Integer\n");
            float KommaZahl/* = 1.125 = 0 als int*/;
            printf("Bitte geben Sie eine Komma-Zahl an\n");
            printf("Ihre Eingabe: ");
            scanf("%f",&KommaZahl);
            printf("\nErgebnis:\n");
            printf("%f",KommaZahl);
            printf("\n");
            //wenn man eine float als integer schreibt und die float-Zahl kleiner als 1.125 ist, ist dessen Vorzeichen ein Minus. float(1.125) ist int(0)
            fflush(stdin);
            printf("\nDruecken Sie auf 'm', um zum Menue zu gelangen.\n");
            scanf("%c",&m);
            printf("\n\n\n\n");
            if (m == 'm'){
            exit(main());       // 2.5(float) = 2.500000; 1.125 = 1.125000
            }
            break;

	default: printf("\n\nProgrammende\n");  break;                      //case 6:fflush(stdin); printf("Z");exit(main()); break;

    return 0;
}

if (aendern > 5){
    printf("\nProgramm ist fehlerhaft");
    printf("\nCase: ");
    printf("%i",aendern);
    printf("\n\n");
    printf("\nAuthor: Mehmet-Ali Asar");
} else {
    printf("\nAlles ist im gruenen Bereich");
    printf("\nCase: ");
    printf("%i",aendern);
    printf("\n\n");
    printf("\nAuthor: Mehmet-Ali Asar");
    return 0;
    }
/*if (UP == '72'){
    printf("Hey!");}*/
    /*hier kommt der code für den manuellen Shutdown hin*/
return 0;
}
