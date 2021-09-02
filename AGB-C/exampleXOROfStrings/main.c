#include <stdio.h>
#include <string.h>

int main(){
  int i;
  char str[]   =  "Hello";
  char str2[]  =  "World";
  char output[6];

  for (i=0; i<strlen(str); i++)
  {
    char temp = str[i] ^ str2[i];
    output[i] = temp;
  }

  output[i] = '\0';
  printf("%s", output);

  return 0;
}
