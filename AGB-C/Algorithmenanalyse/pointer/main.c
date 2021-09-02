#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
        char *p = 0x0;
//And access the value as you wish:

char fist_byte = p[0];
char second_byte = p[1];
        printf("\t%c\t%c\t%c",p,p[0],p[1]);
        /*
        char *p0='A';
        //int *p0;
        printf("XXXp0=%iXXX\t",p0);
        printf("XXXp0=%xXXX\t",p0);
        printf("XXXp0=%dXXX\t",p0);
        printf("XXXp0=%cXXX\t",p0);
        printf("XXXp0=%sXXX\t",p0);

        ++*p0;
        printf("OOOOOOOO");
        printf("XXXp0=%iXXX\t",p0);
        printf("XXXp0=%xXXX\t",p0);
        printf("XXXp0=%dXXX\t",p0);
        printf("XXXp0=%cXXX\t",p0);
        printf("XXXp0=%sXXX\t",p0);*/

        //char p1[5];
        //char *p2[5];
        //char (*p3)[5];


/*        int *p=+5;
        printf("XXX%iXXX\t",p);
        while(*p != 0){
            *p--;
            printf("XXX%iXXX\t",p);
        }






*/
        return 0;
}
