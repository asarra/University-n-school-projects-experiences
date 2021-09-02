#include <stdio.h>
#include <stdlib.h>
#define MAX 5
int spielfeld[MAX][MAX]={0}; ///2=leer;1=leben;0=tot
int count();
void printSpielfeld();
int countUmgebendeLebendeZellen();

int main()
{
    spielfeld[2][1]=1;spielfeld[2][2]=1;spielfeld[2][3]=1;//spielfeld[3][2]=1;spielfeld[3][3]=1;
    while(1){
        printSpielfeld(spielfeld);
        countUmgebendeLebendeZellen(spielfeld);
    }
    return 0;
}




int countUmgebendeLebendeZellen(int spielfeld[MAX][MAX]){
    int zaehler,zaehler2,lebendeZellenInUmgebung=0,lebendeZellen,toteZellen=count(spielfeld),proZelle[lebendeZellen],zelleAnzahl=0;
    int proToteZelle[toteZellen],tot_zelleAnzahl=0,tot_lebendeZellenInUmgebung=0;
    for(zaehler=0;zaehler<=MAX;zaehler++){
        for(zaehler2=0;zaehler2<=MAX;zaehler2++){
            if(spielfeld[zaehler][zaehler2]==1){
                lebendeZellenInUmgebung=0;
                zelleAnzahl=zelleAnzahl+1;
                ///oben
                if (spielfeld[zaehler-1][zaehler2]==1){
                    lebendeZellenInUmgebung++;
                }///unten
                if (spielfeld[zaehler+1][zaehler2]==1){
                    lebendeZellenInUmgebung++;
                }
                ///links
                if (spielfeld[zaehler-1][zaehler2-1]==1){
                    lebendeZellenInUmgebung++;
                }
                if (spielfeld[zaehler][zaehler2-1]==1){
                    lebendeZellenInUmgebung++;
                }
                if (spielfeld[zaehler+1][zaehler2-1]==1){
                    lebendeZellenInUmgebung++;
                }
                ///rechts
                if (spielfeld[zaehler-1][zaehler2+1]==1){
                    lebendeZellenInUmgebung++;
                }
                if (spielfeld[zaehler][zaehler2+1]==1){
                    lebendeZellenInUmgebung++;
                }
                if (spielfeld[zaehler+1][zaehler2+1]==1){
                    lebendeZellenInUmgebung++;
                }
                proZelle[zelleAnzahl]=lebendeZellenInUmgebung;
                        printf("Bei der %i. Zelle wurden %i lebende Nachbarzellen gefunden!\n",zelleAnzahl,proZelle[zelleAnzahl]);}


                ///Und das selbe nun fuer tote Zellen
                if(spielfeld[zaehler][zaehler2]==0){
                tot_lebendeZellenInUmgebung=0;
                tot_zelleAnzahl=tot_zelleAnzahl+1;
                ///oben
                if (spielfeld[zaehler-1][zaehler2]==1){
                    tot_lebendeZellenInUmgebung++;
                }///unten
                if (spielfeld[zaehler+1][zaehler2]==1){
                    tot_lebendeZellenInUmgebung++;
                }
                ///links
                if (spielfeld[zaehler-1][zaehler2-1]==1){
                    tot_lebendeZellenInUmgebung++;
                }
                if (spielfeld[zaehler][zaehler2-1]==1){
                    tot_lebendeZellenInUmgebung++;
                }
                if (spielfeld[zaehler+1][zaehler2-1]==1){
                    tot_lebendeZellenInUmgebung++;
                }
                ///rechts
                if (spielfeld[zaehler-1][zaehler2+1]==1){
                    tot_lebendeZellenInUmgebung++;
                }
                if (spielfeld[zaehler][zaehler2+1]==1){
                    tot_lebendeZellenInUmgebung++;
                }
                if (spielfeld[zaehler+1][zaehler2+1]==1){
                    tot_lebendeZellenInUmgebung++;
                }
                proToteZelle[tot_zelleAnzahl]=tot_lebendeZellenInUmgebung;
        }
        }}


    int zaehler3=0;
    for(zaehler=0;zaehler<=MAX;zaehler++){
        for(zaehler2=0;zaehler2<=MAX;zaehler2++){
            if(spielfeld[zaehler][zaehler2]==1){
                if(proZelle[zaehler3]<2){
                    spielfeld[zaehler][zaehler2]=0;
                }

                if(proZelle[zaehler3]==2 || proZelle[zaehler3]==3){
                    spielfeld[zaehler][zaehler2]=1; ///bleibt am Leben
                }
                if(proZelle[zaehler3]>3){
                    spielfeld[zaehler][zaehler2]=0; ///stirbt
                }
            zaehler3++;
            }
        }
    }
///int proToteZelle[toteZellen],tot_zelleAnzahl=0,tot_lebendeZellenInUmgebung=0;

    zaehler3=0;
    for(zaehler=0;zaehler<=MAX;zaehler++){
        for(zaehler2=0;zaehler2<=MAX;zaehler2++){
            if(spielfeld[zaehler][zaehler2]==0){
                if(proToteZelle[zaehler3]==3){
                    spielfeld[zaehler][zaehler2]=1;
                }
            zaehler3++;
            }
        }
    }


return spielfeld[0][0];
}

int count(int spielfeld[MAX][MAX]){
    int zelleTotal=0,tot_zelleTotal=0;
    int zaehler,zaehler2;
    for(zaehler=0;zaehler<=MAX;zaehler++){
        for(zaehler2=0;zaehler2<=MAX;zaehler2++){
            if(spielfeld[zaehler][zaehler2]==1){
                zelleTotal++;
            }if(spielfeld[zaehler][zaehler2]==0){
                tot_zelleTotal++;
            }
        }
    }
    printf("Lebenden Zellen:\t%i\n",zelleTotal);
    return zelleTotal,tot_zelleTotal;
}

void printSpielfeld(int spielfeld[MAX][MAX])
{
    int zaehler,zaehler2;
    for(zaehler=0;zaehler<=MAX;zaehler++){
            for(zaehler2=0;zaehler2<=MAX;zaehler2++){
                if(spielfeld[zaehler][zaehler2]==1){
                    printf("%c",219);printf("%c",219);
                }
                else if(spielfeld[zaehler][zaehler2]==0){
                    printf("%c",176);printf("%c",176);
                }
        }
        printf("\n");
    }
}
