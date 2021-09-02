#include <stdlib.h>
#include <stdio.h>

int main(){
//pointer = frame of memory
//variable = memory = value

//when creating a c variable, you also create the pointer automatically
//the variable automatically gets the type of the pointer
char *c=malloc(10*sizeof(char));
c="Hey";
printf("%s", c);
int *number = 0;
float num=2;
printf("%d", number);
////const int b;
//const int * const int b;
printf("\n%x",c);
printf("\n%x",number);
float *numb;
numb = &num;
printf("\njnjmjiini:\t%.2f",*numb);
return 0;
}
