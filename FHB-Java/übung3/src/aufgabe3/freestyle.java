package aufgabe3;

import java.util.Scanner;
import java.util.Random;

public class freestyle {
    public static void main(String[] args){

        /*Demonstrieren Sie in einem beliebigen eigenen Programm die Verwendung von Objekten (Klasseninstanzen)
        und Loops (mindestens 3 Klassen).*/

        //mind. eigene 3 Klassen und Objekte
        test test = new test();
        test2 test2 = new test2();
        test3 test3 = new test3();

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        Random random = new Random();
        int z = 1 + random.nextInt(2);

        //3 verschachtelte Loops = Alle Anforderungen erfüllt!
        for(int i=0;i<=z;i++) {
            for (int j=0; j <= z; j++) {
                for (int k=0; k <= z; k++) {
                    System.out.println(x);
                }
            }
        }

    }
}
