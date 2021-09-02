#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Hello world!\n");
    int counter;
    while(counter==2){
        printf("Hey");
        counter++;
    }
    if(counter==3){
        printf("Counter increment has been stopped and the program shuts down now");
    }
    counter++;
    printf("%i", counter);
    return 0;
}
