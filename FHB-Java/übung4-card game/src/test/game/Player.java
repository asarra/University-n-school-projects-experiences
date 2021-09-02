package test.game;

import test.schwimmen.Hand;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private Hand hand;

    int id;
    Player(int temp){
        this.id=temp+1;

    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }



    /**
     * Prompts the user to select a hand for this player.
     *
     * Both the open hand and the currently held hand of this player are printed.
     * The user is then expected to select either of both hands by responding with 0 or 1.
     * If the openHand is selected, that becomes the players hand and his prior hand is returned.
     * Else, the openHand is returned.
     *
     * @param openHand is a hand not already assigned to this player.
     * @return the hand not selected for this player.
     */
    public Hand selectHand(Hand openHand) {
        final String header = "Mit welchem Blatt willst du spielen?";
        IO io = new IO();
        String[] options = new String[3];

        options[0]="0:\t"+openHand;
        options[1]="1:\t"+this.hand;
        options[2]="Auswahl: (def: 0):";
        io.menuSelection(header,options);

        Scanner s = new Scanner(System.in);
        try {
            int thisOrThat=s.nextInt();
            if (thisOrThat== 0) {
                Hand temp = this.hand;
                this.hand = openHand;
                return temp;
            } else if (thisOrThat == 1) {
                return openHand;
            }
        }
        catch (InputMismatchException e){
            IO.menuWithoutOptions("Eingabefehler! Versuche es erneut:");
            selectHand(openHand);
        }
        return openHand; //Fallback Default 0
    }




    /**
     * Accesses the hand currently held by this player.
     * @return the hand held.
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Accesses the id of this player.
     * @return
     */
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Player " + getId() + ": " + hand;
    }

    public double getScore(){
        return this.hand.value();
    }

}
