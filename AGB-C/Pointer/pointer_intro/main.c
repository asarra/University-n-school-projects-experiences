#include <stdio.h>
#include <stdlib.h>

void a(){
    int zahl=7,*zeiger=&zahl;
    printf("Zeiger-Wert:\t%d\n",*zeiger);//%d?%i?
}

void b(){
    int zahl=7,*zeiger=NULL;
    if(zeiger != NULL){printf("Versuch 1, Zeiger-Wert:\t%d\n",*zeiger);}
    zeiger=&zahl;
    if(zeiger != NULL){printf("Versuch 2, Zeiger-Wert:\t%d\n",*zeiger);}
}

int main()
{
    a();
    b();
    return 0;
}
