#include <stdio.h>
#include <stdlib.h>
int main()
{
    char data[] = {"Pseudotext_text!"};
    int dataLength=strlen(data);
    printf("You have typed in a text of following length: %d\n",dataLength);
    if (dataLength==16){printf("Perfect!\n");}
    else if (dataLength<=16){printf("\n");int a;for(a=dataLength;a != 16; a++){printf("%dth,\n",a+1);data[a]='\0';}printf("We added:'%c'",data[15]);}
    else if (dataLength>=16){printf("Too much!\n");}else {printf("Something else!\n");}
    //const char *data[16] = {'F','1','o','d',' ','i','s',' ','a','m','a','z','i','n','g','.',(char) 1};
    printf("\n");int x;for(x=0;x<16;x++){printf("\n%c\t" ,data[x]); /**/ printf("%d",data[x]);}printf("\n\n");
    //diffusion
    char *dataKey_var=&data;
    char keyOne[]=
    {
        dataKey_var[1],dataKey_var[2],dataKey_var[3],dataKey_var[4],dataKey_var[5],dataKey_var[6],dataKey_var[7],dataKey_var[8],dataKey_var[9],
        dataKey_var[10],dataKey_var[11],dataKey_var[12],dataKey_var[13],dataKey_var[14],dataKey_var[15],dataKey_var[0]
    };
    /**while(keySum!=16)
    {
        da = &key[keySum];
        int keyInt = 0;
        while(keyInt!=16){
        printf("%c",da[keyInt]);
        keyInt++;
        }
        keySum++;
        printf("\n");
    }**/
    char * da = &keyOne;
    char keyTwo[]={da[1],da[2],da[3],da[4],da[5],da[6],da[7],da[8],da[9],da[10],da[11],da[12],da[13],da[14],da[15],da[0]};
    char keyThree[]={keyTwo[1],keyTwo[2],keyTwo[3],keyTwo[4],keyTwo[5],keyTwo[6],keyTwo[7],keyTwo[8],keyTwo[9],keyTwo[10],keyTwo[11],keyTwo[12],keyTwo[13],keyTwo[14],keyTwo[15],keyTwo[0]};
    char keyFour[]={keyThree[1],keyThree[2],keyThree[3],keyThree[4],keyThree[5],keyThree[6],keyThree[7],keyThree[8],keyThree[9],keyThree[10],keyThree[11],keyThree[12],keyThree[13],keyThree[14],keyThree[15],keyThree[0]};
    char keyFive[]={keyFour[1],keyFour[2],keyFour[3],keyFour[4],keyFour[5],keyFour[6],keyFour[7],keyFour[8],keyFour[9],keyFour[10],keyFour[11],keyFour[12],keyFour[13],keyFour[14],keyFour[15],keyFour[0]};
    char keySix[]={keyFive[1],keyFive[2],keyFive[3],keyFive[4],keyFive[5],keyFive[6],keyFive[7],keyFive[8],keyFive[9],keyFive[10],keyFive[11],keyFive[12],keyFive[13],keyFive[14],keyFive[15],keyFive[0]};
    char keySeven[]={keySix[1],keySix[2],keySix[3],keySix[4],keySix[5],keySix[6],keySix[7],keySix[8],keySix[9],keySix[10],keySix[11],keySix[12],keySix[13],keySix[14],keySix[15],keySix[0]};
    char keyEight[]={keySeven[1],keySeven[2],keySeven[3],keySeven[4],keySeven[5],keySeven[6],keySeven[7],keySeven[8],keySeven[9],keySeven[10],keySeven[11],keySeven[12],keySeven[13],keySeven[14],keySeven[15],keySeven[0]};
    char keyNine[]={keyEight[1],keyEight[2],keyEight[3],keyEight[4],keyEight[5],keyEight[6],keyEight[7],keyEight[8],keyEight[9],keyEight[10],keyEight[11],keyEight[12],keyEight[13],keyEight[14],keyEight[15],keyEight[0]};
    char keyTen[]={keyNine[1],keyNine[2],keyNine[3],keyNine[4],keyNine[5],keyNine[6],keyNine[7],keyNine[8],keyNine[9],keyNine[10],keyNine[11],keyNine[12],keyNine[13],keyNine[14],keyNine[15],keyNine[0]};
    char keyEleven[]={keyTen[1],keyTen[2],keyTen[3],keyTen[4],keyTen[5],keyTen[6],keyTen[7],keyTen[8],keyTen[9],keyTen[10],keyTen[11],keyTen[12],keyTen[13],keyTen[14],keyTen[15],keyTen[0]};
    char keyTwelve[]={keyEleven[1],keyEleven[2],keyEleven[3],keyEleven[4],keyEleven[5],keyEleven[6],keyEleven[7],keyEleven[8],keyEleven[9],keyEleven[10],keyEleven[11],keyEleven[12],keyEleven[13],keyEleven[14],keyEleven[15],keyEleven[0]};
    char keyThirteen[]={keyTwelve[1],keyTwelve[2],keyTwelve[3],keyTwelve[4],keyTwelve[5],keyTwelve[6],keyTwelve[7],keyTwelve[8],keyTwelve[9],keyTwelve[10],keyTwelve[11],keyTwelve[12],keyTwelve[13],keyTwelve[14],keyTwelve[15],keyTwelve[0]};
    char keyFourteen[]={keyThirteen[1],keyThirteen[2],keyThirteen[3],keyThirteen[4],keyThirteen[5],keyThirteen[6],keyThirteen[7],keyThirteen[8],keyThirteen[9],keyThirteen[10],keyThirteen[11],keyThirteen[12],keyThirteen[13],keyThirteen[14],keyThirteen[15],keyThirteen[0]};
    char keyFifteen[]={keyFourteen[1],keyFourteen[2],keyFourteen[3],keyFourteen[4],keyFourteen[5],keyFourteen[6],keyFourteen[7],keyFourteen[8],keyFourteen[9],keyFourteen[10],keyFourteen[11],keyFourteen[12],keyFourteen[13],keyFourteen[14],keyFourteen[15],keyFourteen[0]};


    printf("\n%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c\n",da[0],da[1],da[2],da[3],da[4],da[5],da[6],da[7],da[8],da[9],da[10],da[11],da[12],da[13],da[14],da[15]);
    printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c\n",keyTwo[0],keyTwo[1],keyTwo[2],keyTwo[3],keyTwo[4],keyTwo[5],keyTwo[6],keyTwo[7],keyTwo[8],keyTwo[9],keyTwo[10],keyTwo[11],keyTwo[12],keyTwo[13],keyTwo[14],keyTwo[15]);
    printf("%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c\n\n",keyFifteen[0],keyFifteen[1],keyFifteen[2],keyFifteen[3],keyFifteen[4],keyFifteen[5],keyFifteen[6],keyFifteen[7],keyFifteen[8],keyFifteen[9],keyFifteen[10],keyFifteen[11],keyFifteen[12],keyFifteen[13],keyFifteen[14],keyFifteen[15]);

    static const Rcon[] = {
    0x01, 0x02, 0x04, 0x08, 0x10, 0x20,
    0x40, 0x80, 0x1B, 0x36 };

    int i;
    char roundOne[16];
    for(i=0;i<16;i++){
    char temp = data[i] ^ keyOne[i];
    roundOne[i]=temp;
    }
    printf("%s",roundOne);
//    printf("%c",da[keyint]);
    //confusion
    //fixed table - fpk
 /**   const char* ciphrooy[16]={data[0],data[7],data[13],data[6],data[8],data[12],data[5],data[1],
                            data[4],data[3],data[9],data[2],data[10],data[11],data[15],data[14]};
    for(x=0;x<16;x++){printf("%c" ,ciphrooy[x]);}
 **/   return 0;
}
