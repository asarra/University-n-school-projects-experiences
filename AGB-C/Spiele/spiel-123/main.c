#include <stdio.h>
#include <stdlib.h>
/*
int npc(int npc_nimmtKnoedel,int npc_totalKnoedel,int MAX,spieler_nimmtKnoedel,spieler_totalKnoedel){
    if(spieler_nimmtKnoedel,spieler_totalKnoedel){
            npc_totalKnoedel+=npc_nimmtKnoedel;
            MAX-=npc_nimmtKnoedel;
            return npc_nimmtKnoedel,npc_totalKnoedel, MAX;
    }
}
*/
int spieler2(int spieler2_nimmtKnoedel,int spieler2_totalKnoedel,int MAX){
    scanf("%i",&spieler2_nimmtKnoedel);
    fflush(stdin);
    if(spieler2_nimmtKnoedel<=3&&spieler2_nimmtKnoedel>=1){
            spieler2_totalKnoedel+=spieler2_nimmtKnoedel;
            MAX-=spieler2_nimmtKnoedel;
            return spieler2_nimmtKnoedel,spieler2_totalKnoedel, MAX;
    }
    else{
        printf("Du hast eine illegale Zahl an Knoedel genommen! Waehle erneut!\n");
        return spieler2(spieler2_nimmtKnoedel,spieler2_totalKnoedel, MAX);
    }
}

int spieler(int spieler_nimmtKnoedel,int spieler_totalKnoedel,int MAX){
    scanf("%i",&spieler_nimmtKnoedel);
    fflush(stdin);
    if(spieler_nimmtKnoedel<=3&&spieler_nimmtKnoedel>=1){
            spieler_totalKnoedel+=spieler_nimmtKnoedel;
            return spieler_nimmtKnoedel,spieler_totalKnoedel, (MAX-spieler_nimmtKnoedel);
    }
    else{
        printf("Du hast eine illegale Zahl an Knoedel genommen! Waehle erneut!\n");
        return spieler(spieler_nimmtKnoedel,spieler_totalKnoedel, MAX);
    }
}

int main()
{
    int MAX=20;
    ///*(Knoedel+19)=2;int *Knoedel=(int *)calloc(MAX,sizeof(int));
    int spieler2_nimmtKnoedel,spieler2_totalKnoedel=0,spieler_nimmtKnoedel,spieler_totalKnoedel=0;
    while(1<=MAX&&MAX>=1){
        printf("Es wird mit %i Knoedel gespielt!\nSpieler2 ist dran! Bitte nur 1 bis 3 Knoedel nehmen!\n", MAX);
        spieler2_nimmtKnoedel,spieler2_totalKnoedel, MAX=spieler2(spieler2_nimmtKnoedel,spieler2_totalKnoedel, MAX);
        printf("Es verbleiben %i Knoedel!\nSpieler ist dran! Bitte nur 1 bis 3 Knoedel nehmen!\n", MAX);
        spieler_nimmtKnoedel,spieler_totalKnoedel, MAX=spieler(spieler_nimmtKnoedel,spieler_totalKnoedel, MAX);
    }
    if(spieler2_totalKnoedel>spieler_totalKnoedel)
        printf("Spieler 2 hat gewonnen!");
    else if(spieler_totalKnoedel>spieler2_totalKnoedel)
        printf("Spieler 1 hat gewonnen!");
    else if(spieler2_totalKnoedel==spieler_totalKnoedel)
        printf("Unentschieden!");
    return 0;
}
