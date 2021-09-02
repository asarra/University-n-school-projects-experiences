#include <stdio.h>
#include <stdlib.h>

void ausgabe(double brutto){
    printf("\nBrutto = %.2lf in Euro", brutto);
    printf("\nBrutto = %.2lf in US_Dollar", brutto*1.1871);
    printf("\nBrutto = %.2lf in Renminbi", brutto*7.8157);
    printf("\nBrutto = %.2lf in Schweizer Franken", brutto*1.1543);
}

void nettoBerechnung(const double mwst_satz, double netto){
    printf("Sie haben %.2lf eingegeben!", netto);
    double brutto= netto + (netto*mwst_satz);
    ausgabe(brutto);
    }

int main()
{
    double netto, nettoPreis;
    const double mwst_satz = 0.19;
    printf("Bitte geben Sie eine Netto-Zahl ein!\n");
    scanf("%lf",&netto);
    nettoBerechnung(mwst_satz,netto);
return 0;
}
