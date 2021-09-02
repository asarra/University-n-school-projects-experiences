package enum_test;

public enum CardValue {
    SEVEN(7), EIGHT(8), NINE(9), TEN(10), KING(10), JACK(10), QUEEN(10), ACE(11);

    int i;
    CardValue(int i) {
        this.i=i;
    }

    public int getCardValue(){
        return this.i;
    }
}
