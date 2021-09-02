package test.schwimmen;

import test.cardgame.Card;
import test.cardgame.CardColor;
import test.cardgame.CardValue;

public class Hand {
    public static final int CARDS_PER_HAND = 3;
    public static final double THIRTY_AND_HALF = 30.5;

    private test.cardgame.Hand hand;

    public Hand(Card card1, Card card2, Card card3) {
        this.hand = new test.cardgame.Hand(3);
        this.hand.setHand(card1, card2, card3);
    }

    public Card getCard(int i) {
        return this.hand.getCards()[i];
    }

    public Card[] getCards(){
        return this.hand.getCards();
    }

    /**
     * Swap a card from this hand with a card on another hand.
     *
     * Both indices must be in range [0, {@link #CARDS_PER_HAND}).
     *
     * @param other
     * @param fromOtherHand is the index of the card from the other hand.
     * @param fromThisHand is the index of the card from this hand.
     */
    public void swapCard(Hand other, int fromOtherHand, int fromThisHand) {
        this.hand.getCards()[fromThisHand]=other.hand.getCards()[fromOtherHand];
    }

    /**
     * Swap all cards from two hands.
     * @param other
     * @see test.cardgame.Hand#swap
     */
    public void swapHand(Hand other) {
        test.cardgame.Hand temp = this.hand;
        this.hand=other.hand;
        other.hand=temp;
    }


    public String[] toStringArray() {
        return new String[]{};
    }


    /**
     * @return
     */
    private boolean isThirtyAndHalf() {
        return this.getCard(0)==this.getCard(1)&&this.getCard(0)==this.getCard(2);
    }

    /**
     * Calculates the value of the hand, according to the rules of Schwimmen.
     *
     * If every card has the same {@link test.cardgame.CardValue}, the result is {@link #THIRTY_AND_HALF}.
     * Else, the result is calculated as the maximum of the sum of values for each color, where:
     * 7, 8, 9, 10 count as depicted;
     * Jack, Queen and King count ten;
     * Ace counts 11.
     * Therefore, the maximum achievable value is 31, the minimum 8 (as three 7 would be 30.5).
     *
     * @return the nominal value of this hand.
     */
    public double value() {

        double sum=0;
        double a=0;
        double b=0;
        double c=0;

        if (isThirtyAndHalf()) {
            return THIRTY_AND_HALF;
        }
        //Alle haben dieselbe Farbe aber keine selbe Zahl?
        else if(this.getCard(0).getColor()==this.getCard(1).getColor()&&this.getCard(0).getColor()==this.getCard(2).getColor()){
            sum=this.getCard(0).getValue().getCardValue()+this.getCard(1).getValue().getCardValue()+this.getCard(2).getValue().getCardValue();
        }
        else{
            //Karte 1 und Karte 2 selbe Farbe?
            if(this.getCard(0).getColor()==this.getCard(1).getColor()){
                a=this.getCard(0).getValue().getCardValue();
                b=this.getCard(1).getValue().getCardValue();
                sum=a+b;
            }
            //Karte 1 und Karte 3 selbe Farbe?
            if(this.getCard(0).getColor()==this.getCard(2).getColor()){
                a=this.getCard(0).getValue().getCardValue();
                c=this.getCard(2).getValue().getCardValue();
                sum=a+c;
            }
            //Karte 2 und Karte 3 selbe Farbe?
            if(this.getCard(1).getColor()==this.getCard(2).getColor()){
                b=this.getCard(1).getValue().getCardValue();
                c=this.getCard(2).getValue().getCardValue();
                sum=b+c;
            }
            //Sonst kommt es zum Überlauf! Max. 31 Punkte!
            if(sum>31){
                return 31;
            }
        }
        return sum;
    }

    @Override
    public String toString() {
        return hand != null? hand.toString() + " (" + value() + ")" : "";
    }
}
