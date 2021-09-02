package diceWarsLib;

import diceWarsLib.data.RGB;
import diceWarsLib.game.DiceWars;
import diceWarsLib.interfaces.DiceWar;
import diceWarsLib.interfacesImplementations.MenuHandler;
import diceWarsLib.interfacesImplementations.Spielfeld;

import java.security.SecurityPermission;

/*
        Tile[][] board = new Tile[][]{{new Tile(0,0), new Tile(0,1)}, {new Tile(1,0), new Tile(1,1)}};
        RGB[] rgb = new RGB[]{new RGB(20,20,20),new RGB(20,20,20),new RGB(20,20,20),new RGB(20,20,20), new RGB(20,20,20)};
        DiceWars diceWars = new DiceWars();
        diceWars.reset(board, rgb);
 */

public class main {
    public static void main(String[] args){
        DiceWars dw = new DiceWars();
        /**
         * Registrieren Sie einen Handler für die Menü‐Events (Implementierung von MenuHandler
         * und Registrierung via setMenuHandler). Stellen Sie erstmal sicher, das ihr Handler aufgerufen
         * wird. Zum Laden/Speichern einer Datei informieren Sie sich über den JFileChooser
         */
        MenuHandler mh = new MenuHandler();
        dw.setMenuHandler(mh);
        int anzahlSpieler = 2;
        Spielfeld sf = new Spielfeld(anzahlSpieler, 5, 20);
        RGB[] colors = new RGB[anzahlSpieler];
        for(int i=0; i<anzahlSpieler; i++){
            colors[i] = new RGB(255-i, 255-i, 255-i);
        }
        dw.reset(sf, colors);
    }
}
