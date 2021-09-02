package test.cardgame;

import java.util.Arrays;

public class Hand {
    private final test.cardgame.Card[] cards;

    public Hand(int cardCount) {
        this.cards = new Card[cardCount];

    }

    public Card[] getCards() {
        return cards;
    }

    public void setHand(Card c0, Card c1, Card c2){
        this.cards[0]=c0;
        this.cards[1]=c1;
        this.cards[2]=c2;
    }

    /**
     * Swap a card from this hand with a card from another hand.
     * Both indices must point to valid indices, which is not checked.
     * @param otherHand
     * @param cardIndexOther
     * @param cardIndexThis
     */
    public void swapCard(Hand otherHand, int cardIndexOther, int cardIndexThis) {
        Card[] temp_cards = this.cards;
        this.cards[cardIndexThis]=otherHand.cards[cardIndexOther];
        otherHand.cards[cardIndexOther]=temp_cards[cardIndexThis];
    }

    public void swapAll(Hand other, int z){
        if(z<other.getCards().length) {
            Card temp = other.cards[z];
            other.cards[z] = this.cards[z];
            this.cards[z] = temp;
            this.swapAll(other, z++);
        }
        else {
            return;
        }
    }

    /**
     * Swap the cards of two hands.
     * Both hands must hold the same amount of cards, which is not checked.
     *
     * @param other
     */
    public void swap(Hand other) {
        Card[] temp_cards = this.cards;
        this.setHand(other.getCards()[0],other.getCards()[1],other.getCards()[2]);
        other.setHand(temp_cards[0],temp_cards[1],temp_cards[2]);
    }

    @Override
    public String toString() {
        return Arrays.asList(cards).toString();
    }

    /**
     * Get a representation of the held cards as an array of strings.
     * @return
     */
    public String[] toStringArray() {
        String arr = Arrays.asList(cards).toString();
        return arr.substring(1, arr.length() - 1).split(",");
    }
}
