package a;

import java.util.ArrayList;

public class Spieler {

    private static int zaehler;
    float punktzahl;
    ArrayList<String> karten = new ArrayList<>();

    Spieler(ArrayList<String> karten){
        this.karten.addAll(karten);
//        this.punktzahl=
        zaehler++;
    }

    static int getZaehler(){
        return zaehler;
    }


}
