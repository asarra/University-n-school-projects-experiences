#include <stdio.h>
#define max 5

int Liste1[6] = { 4, 13, 1, 88, 3, 12 };
int Liste2[6];

void merging(int low, int mid, int high) {
   int list1, list2, iLaufvar, zahl1=0;

   for(list1 = low, list2 = mid + 1, iLaufvar = low; list1 <= mid && list2 <= high; iLaufvar++) {
      if(Liste1[list1] <= Liste1[list2])
         Liste2[iLaufvar] = Liste1[list1++];
      else
         Liste2[iLaufvar] = Liste1[list2++];
   }

   while(list1 <= mid)
      Liste2[iLaufvar++] = Liste1[list1++];

   while(list2 <= high)
      Liste2[iLaufvar++] = Liste1[list2++];

   for(iLaufvar = low; iLaufvar <= high; iLaufvar++)
      Liste1[iLaufvar] = Liste2[iLaufvar];
}

void sort(int low, int high) {
   int mid, zahl2=0;

   if(low < high) {
      mid = (low + high) / 2;
      sort(low, mid);
      sort(mid+1, high);
      merging(low, mid, high);
   } else {
      return;
   }
}

int main() {
   int zaehler, zahl3=0;

   printf("Liste vor dem Sortieren\n");

   for(zaehler = 0; zaehler <= max; zaehler++)
      printf("%d ", Liste1[zaehler]);

   sort(0, max);

   printf("\nListe nach dem Sortieren\n");

   for(zaehler = 0; zaehler <= max; zaehler++)
      printf("%d ", Liste1[zaehler]);
}
