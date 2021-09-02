package a;

import java.util.ArrayList;
import java.util.Random;

public class Schwimmen {
    public static void main(String[] args){
        Karten kopie = new Karten();
        ArrayList<String> kartendeck = new ArrayList();
        int x = kopie.getA().length-1;

        for(int i=0;i<=x;i++){
            kartendeck.add(kopie.a[i]);
        }

        Random random = new Random();

        ArrayList<String> mitte = new ArrayList();
        ArrayList<String> hand_m = new ArrayList();
        ArrayList<String> hand_a = new ArrayList();
        ArrayList<String> hand_h = new ArrayList();
        ArrayList<String> hand_b = new ArrayList();

        hand_m.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_m);
        hand_m.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_m);
        hand_m.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_m);

        hand_a.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_a);
        hand_a.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_a);
        hand_a.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_a);

        hand_h.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_h);
        hand_h.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_h);
        hand_h.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_h);

        hand_b.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_b);
        hand_b.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_b);
        hand_b.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(hand_b);

        mitte.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(mitte);
        mitte.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(mitte);
        mitte.add(kartendeck.get(random.nextInt(kartendeck.size()-1)));
        kartendeck.removeAll(mitte);




        Spieler max = new Spieler(hand_m);
        Spieler ali = new Spieler(hand_a);
        Spieler hao = new Spieler(hand_h);
        Spieler becky = new Spieler(hand_b);




        if(3 <= Spieler.getZaehler() & Spieler.getZaehler() <= 5){
            System.out.println("Alles klar. Das Spiel kann beginnen!");

            System.out.println(hand_m.size());
            for(int i=0;i<hand_m.size();i++){
                System.out.println(hand_m.get(i));
            }
            float xyz = kopie.calcPunktzahl(hand_m);
            System.out.println(xyz);
        }
        else {
            System.out.println("Mind. 3 Spieler und max. 5 Personen erlaubt, um zu Spielen!");
        }
    }
}
