#include <stdio.h>
#include <stdlib.h>

int main(){

FILE *f = fopen("file.txt", "w");
if (f == NULL){
        printf("Error opening file!\n");
        exit(1);
}
int counter;
while(1==1){
    char text;
    scanf("%c", &text);
    fprintf(f, "%c\n" , text);
    counter++;
    if(counter==2){
     exit(1);
}}
fclose(f);
return 0;
}
