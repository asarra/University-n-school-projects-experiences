package test.game;

import test.cardgame.Card;
import test.cardgame.Stack;
import test.schwimmen.Activity;
import test.schwimmen.Hand;
import java.util.*;

public class Game {
    /**
     * The stack of 32 cards.
     */
    private final Stack stack;

    /**
     * The 3 open cards available for card swaps.
     */
    private Hand openHand;

    /**
     * The players.
     */
    private final Player[] players;

    /**
     *
     */
    private int dealer = 0;

    /**
     * Stops an ongoing round when set
     */
    boolean roundDone = false;

    /**
     * Construct a game for a set amount of players.
     * @param amountOfPlayers
     */
    Game(int amountOfPlayers) {
        stack = new Stack();
        players = new Player[amountOfPlayers];
    }


    /** RECURSIVE
     * @param amountOfPlayers
     * @param z
     */
    private void deal(int amountOfPlayers,int z) {
        Random random = new Random();
        ArrayList<Card> a = new ArrayList<Card>();

        if(z<amountOfPlayers) {
            List b = Arrays.asList(stack.getCards());
            a.addAll(b);
            int index = random.nextInt(this.stack.size()) % a.size();
            Card c = this.stack.getCards()[index];
            a.remove(index);

            index = random.nextInt(this.stack.size()) % a.size();
            Card c1 = this.stack.getCards()[index];
            a.remove(index);

            index = random.nextInt(this.stack.size()) % a.size();
            Card c2 = this.stack.getCards()[index];
            a.remove(index);

            this.stack.setCard(0, a.get(0));
            this.stack.setCard(1, a.get(1));
            this.stack.setCard(2, a.get(2));

            this.stack.removeFromLast(3);
            Hand temp = new Hand(c, c1, c2);

            this.players[z].setHand(temp);
            IO.print("--- Gebe Hand " + players[z].getHand().toString() + " an Spieler " + ((z + 1) % 4));    //MOD4 spielt als Rahmen
            deal(amountOfPlayers,++z);
        }

    }

    public void dealMitte(){
        this.setOpenHand();
        IO.print("--- Gebe Hand " + this.openHand.toString() + " an Mitte.");
    }

    public void setOpenHand() {
        Random random = new Random();

        ArrayList<Card> a = new ArrayList();
        List b = Arrays.asList(stack.getCards());
        a.addAll(b);

        int index = random.nextInt(this.stack.size()) % a.size();
        Card c=this.stack.getCards()[index];

        a.remove(index);

        index = random.nextInt(this.stack.size()) % a.size();
        Card c1=this.stack.getCards()[index];
        a.remove(index);

        index = random.nextInt(this.stack.size()) % a.size();
        Card c2=this.stack.getCards()[index];
        a.remove(index);

        for(int x=0;x<a.size();x++) {
            this.stack.setCard(x,a.get(x));
        }
        this.stack.removeFromLast(3);

        this.openHand = new Hand(c,c1,c2);
    }

    void swap(int playerId){
        Scanner s = new Scanner(System.in);
        IO io = new IO();

        String[] options=new String[1];
        options[0]="0: " + this.openHand.getCards()[0].toString() + ", 1: " + this.openHand.getCards()[1].toString() + ", 2: " + this.openHand.getCards()[2].toString();
        IO.menuSelection("Such dir eine neue Karte aus",options);
        int neueKarte = s.nextInt();

        options[0]="0: " + players[playerId].getHand().getCard(0).toString() + ", 1: " + players[playerId].getHand().getCard(1).toString() + ", 2: " + players[playerId].getHand().getCard(2).toString();
        IO.menuSelection("Suche dir eine Karte zum Weglegen aus",options);
        int alteKarte = s.nextInt();
        Hand temp_hand = new Hand(this.openHand.getCard(0),this.openHand.getCard(1),this.openHand.getCard(2));

        players[playerId].getHand().swapCard(temp_hand, neueKarte,alteKarte);
        this.setOpenHand();
    }


    void swapAll(int playerId){
        players[playerId].setHand(this.openHand);
        this.setOpenHand();
    }

    void swapForTheFirstTime(int playerId){
        players[playerId].selectHand(this.openHand);
        this.setOpenHand();
    }


    boolean lastRound=false;
    int roundCounter=0;
    int skipCounter=0;

    /**
     * @param playerId
     * @param mode
     */
    private void makeMove(int playerId,int mode) {
        //CLOSE-Bereich-Start
        if(this.lastRound){
            this.roundCounter++;
        }
        if(this.roundCounter==players.length-1){
            this.roundDone=true;
        }
        //Ende

        //Aktivitäten
        if(mode==Activity.SWAP_ALL.ordinal()) {
            this.swapAll(playerId);
        }
        else if(mode==Activity.SKIP.ordinal()){
            this.skipCounter+=1;
            if(this.skipCounter==3){
                IO.print("Das offene Blatt wird erneuert");
                this.setOpenHand();
                this.skipCounter=0;
            }
            this.playRound(playerId+1 % players.length);
        }
        else if(mode==Activity.SWAP.ordinal()){
            this.swap(playerId);
        }
        else if(mode==Activity.CLOSE.ordinal()){
            if(!this.lastRound){
                this.lastRound=true;
                IO.menuWithoutHeader(new String[]{"--- Schliesse, sobald Spieler " + (((playerId+(players.length-1))%players.length)+1) + " dran ist."});
            }
            else if(this.lastRound){
                IO.menuWithoutOptions("Inputfehler: Du kannst nicht schliessen, wenn bereits geschlossen wurde!");}
            }

    }


    private void playRound(int current_playerId) {
        int mode;
        Scanner ss = new Scanner(System.in); //NEVER CLOSE SCANNER THAT IS TIED TO SYSTEM.IN! LET THE JVM HANDLE THAT!

        while (!roundDone) {
            current_playerId = current_playerId % 3; //0-2 für Index. Für Sout ID+1
            String[] options = new String[3];
            options[0]="--- Spieler " + (current_playerId+1) + " ist dran.";
            options[1]="--- Offene Hand:\t"+this.openHand;
            options[2]="--- Hand Spieler " + (current_playerId+1) + ":\t"+players[current_playerId].getHand();
            IO.menuWithoutHeader(options);

            String header = "Spieler " + (current_playerId+1) + ", was willst du tun?";
            options = new String[2];
            options[0]="0: " + Activity.SKIP.toString() + ", 1: " + Activity.SWAP.toString() + ", 2: " + Activity.SWAP_ALL.toString() + ", 3: " + Activity.CLOSE.toString();
            options[1]="Auswahl: (def: 0):";
            IO.menuSelection(header,options);

            try {
                mode=ss.nextInt();

                if (mode == Activity.SKIP.ordinal()) {
                    this.makeMove(current_playerId, Activity.SKIP.ordinal());
                } else if (mode == Activity.SWAP.ordinal()) {
                    this.makeMove(current_playerId, Activity.SWAP.ordinal());
                } else if (mode == Activity.SWAP_ALL.ordinal()) {
                    this.makeMove(current_playerId, Activity.SWAP_ALL.ordinal());
                } else if (mode == Activity.CLOSE.ordinal()) {
                    this.makeMove(current_playerId, Activity.CLOSE.ordinal());
                } else {
                    IO.menuWithoutOptions("Falsche Zahleingabe! Versuche es erneut:");
                    this.playRound(current_playerId);
                }
            }
            catch (InputMismatchException e) {
                IO.menuWithoutOptions("Non-integer Zeichen sind verboten. Versuche es erneut:");
                this.playRound(current_playerId);
            }

            if(31>this.players[current_playerId].getScore()&&this.players[0].getScore()>30.5){  //Beendet automatisch das Spiel, wenn es punktemäßig nicht höher gehen kann!
                roundDone=true;
            }
            else if(this.stack.size()<=3){     //Wir wollen keine "/ zero"-Arithmetik-Fehler! Passiert wenn stack[0] leer ist!
                roundDone=true;
            }

            current_playerId = (current_playerId+1) % 4;

        }

        // This would allow for multiple rounds, but it's not necessary to implement those.
        dealer = (dealer + 1) % 3;
    }

    private void printResults() {
        String playersAsString = Arrays.toString(players);
        // remove '[' and ']'
        playersAsString = playersAsString.substring(1, playersAsString.length()-1);
        playersAsString = playersAsString.replaceAll(", Pl", "%nPl");
        System.out.printf(playersAsString + "%n");
    }

    private void printWinner(){
        double temp=0;
        int index=0;
        int z=0;

        for(int i=0;i<this.players.length;i++) {
            if (this.players[i].getScore() > temp)
                temp = this.players[i].getScore();
                index = i;
        }

        for (Player player : this.players)
            if (player.getScore() == temp)
                z++;

        if(z>1)
            IO.menuWithoutOptions("Gleichstand!");
        else
            IO.menuWithoutOptions("Spieler "+(index+1)+" hat mit "+temp+" Punkten gewonnen!");
    }

    public static void main(String[] args) {
        int amountOfPlayers = 3;
        int current_playerId=0;
        Game a = new Game(amountOfPlayers);

        for(int x=0;x<3;x++)
            a.players[x]=new Player(x);

        a.deal(amountOfPlayers,0);
        a.dealMitte();

        IO.print("Spieler " + (current_playerId+1) + " beginnt.");
        a.swapForTheFirstTime(current_playerId);

        a.playRound(current_playerId+1);
        a.printResults();

        //Zusatz
        a.printWinner();
        }
    }