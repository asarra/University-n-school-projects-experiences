package test.test;

import test.cardgame.Card;
import test.schwimmen.Hand;

public class TestHandValues implements Testrunner {

    @Override
    public String testname() {
        return "Test der Punkteberechnung";
    }

    @Override
    public void run() {
        System.out.println("Bitte manuell pruefen, ob die berechnete Punktzahl stimmt!");
        TestHandValues thv = new TestHandValues();
        for (int i = 0; i < 10; i++) {
            Hand hand = Generator.generateHand();
            System.out.printf("%55s => %.1f%n", hand, hand.value());
        }
    }
}
