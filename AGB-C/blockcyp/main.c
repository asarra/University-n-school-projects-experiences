#include <stdio.h>
#include <stdlib.h>
int main()
{
    char data[] = {"Ayse ist suess."};
    int cc=strlen(data);
    printf("You have typed in a text of following length: %d\n",cc);
    if (cc==16){printf("Perfekt!\n");}
    else if (cc<=16){printf("\n");int a;for(a=cc;a != 16; a++){printf("%d. Pos.: ",a+1);data[a]='\0';}printf("We added:'%c' for you",data[15]);}
    else if (cc>=16){printf("Zu viel!\n");}else {printf("Etwas ist schief gelaufen!\n");}
    //const char *data[16] = {'F','1','o','d',' ','i','s',' ','a','m','a','z','i','n','g','.',(char) 1};
    printf("\n\n");int x;for(x=0;x<16;x++){printf("%c" ,data[x]);};printf("\n\n");
    const char* ciphrooy[16]={data[0],data[7],data[13],data[6],data[8],data[12],data[5],data[1],
                            data[4],data[3],data[9],data[2],data[10],data[11],data[15],data[14]};
    for(x=0;x<16;x++){printf("%c" ,ciphrooy[x]);};
    return 0;
}
