#include <stdio.h>
/*
//int main(int argc,char *argv[]){if(argc<3){printf("%s\n", argv[0]);}return 0;}
///argc = number of passed arguments
///argv = argument array
*/
/*char a = 0xA; ///0000 1010
char b = 0x6; ///0000 0110
 printf("%i\t%i",a,b);
 a <<= 2; ///0010 1000 = 40 //a*2^[shifting_integer]=10*4=40
 b >>= 2; ///0000 0001 = 1  //b/2^[shifting_integer]=6/4=1.5 (dank char aber nur 1)
 printf("\n%i\t%i",a,b);
*/
///unsigned int a = 0xA;signed int b = 0xB;///1's compliment = flip all existing bits; 2's compliment = 1's compliment+1///used for subtraction of binary numbers///if left most bit is a 1 it is a negative signed number

int main(){
/*union{};struct{};*/
int MAX=20,ddd=0;
while(1){
int *Knoedel=(int *)malloc(MAX*sizeof(int));///*(Knoedel+19)=2;
free(Knoedel);
ddd++;
ddd*ddd;
}
  return 0;
}

