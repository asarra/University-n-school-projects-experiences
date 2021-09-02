package geo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Point a = new Point(1,0);
        Point b = new Point(1,1);
        Point c = new Point(2,0);
        Line line = new Line(a,b);

        CurvedLine cl1 = new CurvedLine(a,b);
        CurvedLine cl2 = new CurvedLine(a,b);
        CurvedLine cl3 = new CurvedLine(a,b);
        CurvedLine cl4 = new CurvedLine(b,c);

        String sym = "Symmetrisch";
        String notSym = "Nicht symmetrisch";
        String trans = "Transitiv";
        String notTrans = "Nicht transitiv";

        // Tests der symmetr. und transitiven Relationen
        System.out.println("\n----------\nAUFGABE 1:\nTest 1:");
        System.out.println((cl1.equals(cl2) &&  cl2.equals(cl1)) ? sym : notSym);
        System.out.println((cl2.equals(cl3) && cl1.equals(cl3)) ? trans : notTrans);

        System.out.println("\nTest 2:");
        System.out.println((cl1.equals(cl4) && cl4.equals(cl1)) ? sym : notSym);
        System.out.println((cl4.equals(cl2) && cl1.equals(cl2)) ? trans : notTrans);

        System.out.println("\nTest 3:");
        System.out.println((cl1.equals(a) && a.equals(cl1)) ? sym : notSym);
        System.out.println((a.equals(cl2) && cl1.equals(cl2)) ? trans : notTrans);

        System.out.println("\nTest 4:");
        System.out.println((line.equals(cl1) && cl1.equals(line)) ? sym : notSym);
        System.out.println((line.equals(cl2) && cl1.equals(cl2)) ? trans : notTrans);

        System.out.println("----------\n\n\n\n----------\nAUFGABE 2:\tSortierbarkeit\n\nHier ist die zufällig generierte und unsortierte Liste von Punkten und Linien:\n");

        List<Object> liste = new ArrayList<Object>();
        Random rand = new Random();
        for (int i = 0; i<10;i++){
            liste.add(new Point(rand.nextInt(51),rand.nextInt(51)));
        }
        for (int i = 0; i<10;i++){
            liste.add(new Line(new Point(rand.nextInt(51), rand.nextInt(51)),new Point(rand.nextInt(51), rand.nextInt(51)) ));
        }
        for (int i = 0; i<10;i++){
            liste.add(new CurvedLine(new Point(rand.nextInt(51), rand.nextInt(51)),new Point(rand.nextInt(51), rand.nextInt(51)) ));
        }

        for (Object test : liste)
            System.out.println(test);

        System.out.println("\n\n\nSortiert! Hier ist die neue sortierte Liste!\n");
        Collections.sort(liste,new Vergleicher());

        for (Object test : liste)
            System.out.println(test);
        System.out.println("----------\n");
    }
}











/*
            if (test instanceof Point){
                System.out.println((Point)test);
            }
            else if (test instanceof Line){
                System.out.println((Line)test);
            }
 */