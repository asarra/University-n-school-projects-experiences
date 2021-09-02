#include <stdio.h>
#include <stdlib.h>

int main()
{
    typedef struct{
    char a[23];
    }TString;

    ///Ausgabe eines direkt Initialisierten Struct-Objektes!
    TString b={"Khudadad, ich laufe!"};
    printf("%s\n",b.a);

    ///Erstellung, Speichern und Ausgabe von Struct-Objekt c!
    TString c;
    scanf("%s",c.a);
    printf("\n%s",c.a);

    ///Es funktioniert!
    return 0;
}
