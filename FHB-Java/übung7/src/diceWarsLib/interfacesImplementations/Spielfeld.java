package diceWarsLib.interfacesImplementations;

import diceWarsLib.data.Tile;
import diceWarsLib.game.FieldGenerator;

import java.util.Random;

public class Spielfeld extends FieldGenerator {

    diceWarsLib.data.Tile[][] Tile;
    int Players;
    int dicesPerPlayer;
    int fieldsPerPlayer;

    public Spielfeld(int players, int fieldsPerPlayer, int dicesPerPlayer) {
        super(players, fieldsPerPlayer, dicesPerPlayer);

        if (players > 1 && players < 5) {
            this.Players = players;
            this.dicesPerPlayer = dicesPerPlayer;
            this.fieldsPerPlayer = fieldsPerPlayer;
        } else {
            System.out.println("Spieleranzahl: min. 2 & max. 4");
        }
    }

    @Override
    public Tile[][] generate() {
        Tile[][] SF = null;
        switch (this.Players) {
            case 2:

                if (this.fieldsPerPlayer < 5) {
                    SF = felderstellen(3);
                } else {
                    SF = felderstellen(4);
                }

                break;
            case 3:

                if (this.fieldsPerPlayer < 4) {
                    SF = felderstellen(3);
                } else if (this.fieldsPerPlayer < 6) {
                    SF = felderstellen(4);
                } else {
                    SF = felderstellen(5);
                }
                break;
            case 4:

                if (this.fieldsPerPlayer < 5) {
                    SF = felderstellen(4);

                } else {
                    SF = felderstellen(5);

                }
                break;
            default:
                System.out.println("Spieleranzahl = ungenügend!");
                break;
        }
        setTileS(SF);

        return SF;
    }

    public Tile[][] felderstellen(int feldgr) {

        int spieler1 = 0;  // spieler1 felder
        int spieler2 = 0;
        int spieler3 = 0;
        int spieler4 = 0;
        int wuerfelStapelSpieler1[] = new int[this.fieldsPerPlayer];
        int wuerfelStapelSpieler2[] = new int[this.fieldsPerPlayer];
        int wuerfelStapelSpieler3[] = new int[this.fieldsPerPlayer];
        int wuerfelStapelSpieler4[] = new int[this.fieldsPerPlayer];
        int zufälligerWuerfelWertSpieler1 = 0;
        int zufälligerWuerfelWertSpieler2 = 0;
        int zufälligerWuerfelWertSpieler3 = 0;
        int zufälligerWuerfelWertSpieler4 = 0;
        int wuerfelStapelIndexSpieler1 = 0;
        int wuerfelStapelIndexSpieler2 = 0;
        int wuerfelStapelIndexSpieler3 = 0;
        int wuerfelStapelIndexSpieler4 = 0;
        Random random = new Random();

        for (int i = 0; i < this.fieldsPerPlayer; i++) {  // Gleichmäßiges Verteilen der Würfel

            int wuerfelWert = (random.nextInt(3) + 3);
            wuerfelStapelSpieler1[i] = wuerfelWert;

            if (zufälligerWuerfelWertSpieler1 > this.dicesPerPlayer) { //Wenn
                wuerfelStapelSpieler1[i] = zufälligerWuerfelWertSpieler1 - this.dicesPerPlayer;
            } else if (zufälligerWuerfelWertSpieler1 < this.dicesPerPlayer && i == this.fieldsPerPlayer - 1) {
                wuerfelStapelSpieler1[i] = this.dicesPerPlayer - zufälligerWuerfelWertSpieler1;
            }
            zufälligerWuerfelWertSpieler1 += wuerfelWert;

            wuerfelWert = (random.nextInt(3) + 3);
            wuerfelStapelSpieler2[i] = wuerfelWert;

            if (zufälligerWuerfelWertSpieler2 > this.dicesPerPlayer) {
                wuerfelStapelSpieler2[i] = zufälligerWuerfelWertSpieler2 - this.dicesPerPlayer;
            } else if (zufälligerWuerfelWertSpieler2 < this.dicesPerPlayer && i == this.fieldsPerPlayer - 1) {
                wuerfelStapelSpieler2[i] = this.dicesPerPlayer - zufälligerWuerfelWertSpieler2;
            }
            zufälligerWuerfelWertSpieler2 += wuerfelWert;
            wuerfelWert = (random.nextInt(3) + 3);
            wuerfelStapelSpieler3[i] = wuerfelWert;

            if (zufälligerWuerfelWertSpieler3 > this.dicesPerPlayer) {
                wuerfelStapelSpieler3[i] = zufälligerWuerfelWertSpieler3 - this.dicesPerPlayer;
            } else if (zufälligerWuerfelWertSpieler3 < this.dicesPerPlayer && i == this.fieldsPerPlayer - 1) {
                wuerfelStapelSpieler3[i] = this.dicesPerPlayer - zufälligerWuerfelWertSpieler3;
            }
            zufälligerWuerfelWertSpieler3 += wuerfelWert;

            wuerfelWert = (random.nextInt(3) + 3);
            wuerfelStapelSpieler4[i] = wuerfelWert;

            if (zufälligerWuerfelWertSpieler4 > this.dicesPerPlayer) {
                wuerfelStapelSpieler4[i] = zufälligerWuerfelWertSpieler4 - this.dicesPerPlayer;
            } else if (zufälligerWuerfelWertSpieler4 < this.dicesPerPlayer && i == this.fieldsPerPlayer - 1) {
                wuerfelStapelSpieler4[i] = this.dicesPerPlayer - zufälligerWuerfelWertSpieler4;
            }
            wuerfelWert = (random.nextInt(3) + 3);
            zufälligerWuerfelWertSpieler4 += wuerfelWert;

        }


        Tile[][] SF = new Tile[feldgr][feldgr];

        spieler1 = this.fieldsPerPlayer;
        spieler2 = spieler1;

        if (this.Players == 3) { //Um "Tile player out of range." zu vermeiden
            spieler3 = spieler2;

        }
        if (this.Players == 4) {
            spieler3 = spieler2;
            spieler4 = spieler3;

        }

        for (int i = 0; i < feldgr; i++) { //Erstellen des Spielfeldes
            for (int j = 0; j < feldgr; j++) {
                    SF[i][j] = new Tile(i, j);

                    if (spieler1 > 0) {
                        SF[i][j].setPlayer(0);
                        SF[i][j].setDices(wuerfelStapelSpieler1[wuerfelStapelIndexSpieler1]);
                        spieler1--;
                        wuerfelStapelIndexSpieler1++;

                    } else if (spieler2 > 0) {
                        SF[i][j].setPlayer(1);
                        SF[i][j].setDices(wuerfelStapelSpieler2[wuerfelStapelIndexSpieler2]);
                        spieler2--;
                        wuerfelStapelIndexSpieler2++;

                    } else if (spieler3 > 0) {
                        SF[i][j].setPlayer(2);
                        SF[i][j].setDices(wuerfelStapelSpieler3[wuerfelStapelIndexSpieler3]);
                        spieler3--;
                        wuerfelStapelIndexSpieler3++;

                    } else if (spieler4 > 0) {
                        SF[i][j].setPlayer(3);
                        SF[i][j].setDices(wuerfelStapelSpieler4[wuerfelStapelIndexSpieler4]);
                        spieler4--;
                        wuerfelStapelIndexSpieler4++;
                    }

            }
        }

        return SF;
    }

    public void setTileS(Tile[][] tile) {
        this.Tile = tile;
    }

}
