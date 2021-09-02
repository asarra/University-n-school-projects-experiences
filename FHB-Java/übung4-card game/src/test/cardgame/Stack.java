package test.cardgame;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Stack {
    final static private int STACK_SIZE = 32;

    /**
     * The actual stack of cards.
     */
    Card[] cards = new Card[STACK_SIZE];

    /**
     * The topmost card of this stack.
     */
    int top=0;

    public Stack(){
        generateCardsAndShuffle();
    }

    public Card[] getCards() {
        return cards;
    }

    public Card getCard(int x){
        return this.cards[x];
    }

    public void removeFromLast(int x){
        this.cards=Arrays.copyOf(this.cards, this.cards.length-x);
    }

    public void setCard(int i,Card c){
        this.cards[i]=c;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }


    /**
     * Generates the stack of cards recursively.
     *
     * The generated stack consists of an ordered set of {@link #STACK_SIZE} cards,
     * i.e. every possible combination of {@link CardColor} and {@link CardValue}.
     *
     * @param color
     * @param value
     */

    private void generateCards(int color, int value) {
        if (this.top == Stack.STACK_SIZE)
            return;

        if(color < CardColor.values().length){
            if(value < CardValue.values().length) {
                this.cards[this.top] = new Card(CardColor.values()[color], CardValue.values()[value]);
                this.top++;
                generateCards(color,value+1);
            }
            generateCards(color+1,0);
        }
    }

    private void generateCardsAndShuffle() {
        generateCards(0,0);
        shuffle();
    }

    /**
     * Shuffles the stack of cards.
     */
    public void shuffle() {
        List<Card> c = Arrays.asList(this.cards);
        Collections.shuffle(c);
        c.toArray(this.cards);
    }

    /**
     * Get the amount of cards remaining in this stack.
     *
     * @return {@link #top}
     */
    public int size() {
        return this.top;
    }

    public int getTop() {
        return this.top;
    }

    /**
     * Get the topmost card from this stack.
     *
     * @return
     */
    public Card reveal() {
        top--;
        return cards[this.top];

    }


}
