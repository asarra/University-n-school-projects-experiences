#include <stdio.h>
#include <stdlib.h>
int main(){
int a[2][2];
a[0][0]=1;
a[0][1]=2;
a[0][2]=3;
printf("\n%d %d %d",
       a[0][0],
       a[0][1],
       a[0][2]);
a[1][0]=1;
a[1][1]=2;
a[1][2]=3;
printf("\n%d %d %d",
       a[1][0],
       a[1][1],
       a[1][2]);
a[2][0]=1;
a[2][1]=2;
a[2][2]=3;
printf("\n%d %d %d",
       a[2][0],
       a[2][1],
       a[2][2]);
/*
char a[2][2];
a[0][1]='X';    // '' nur bei einzelnen Chars! "" nur bei Strings!
a[1][0]="O";
a[0][1]="O";
a[2][2]="O";
printf("%c %c %c %c",
       a[0][1],
       a[1][0],
       a[0][1],
       a[2][2]);
*/
return 0;
}
