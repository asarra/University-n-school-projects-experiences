package kw51.lib.painting;

import java.awt.*;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicBoolean;

import kw51.lib.data.Coordinate;

public class DiceWarDisplay {
    private final Coordinate position;
    private final int diceSize = 20;
//    private Color attacker = null;
//    private Color defender = null;
    private AtomicBoolean hide = new AtomicBoolean(true);
    private Vector<FlatDice> attackerDices = new Vector<>();
    private Vector<FlatDice> defenderDices = new Vector<>();

    DiceWarDisplay(Coordinate position) {
        this.position = position;
    }

    void reinit(Color attacker, Color defender, int attackerDices, int defenderDices) {
//        this.attacker = attacker;
//        this.defender = defender;
        this.attackerDices.setSize(attackerDices);
        this.defenderDices.setSize(defenderDices);
        final int diceDistance = diceSize + 1;
        double y = position.getY();
        for (int i = 0; i < attackerDices; i++) {
            final double x = position.getX() + i * diceDistance;
            Coordinate dicePosition = new Coordinate(x, y);
            this.attackerDices.set(i, new FlatDice(attacker, dicePosition, diceSize));
        }
        y = position.getY() + diceDistance;
        for (int i = 0; i < defenderDices; i++) {
            final double x = position.getX() + i * diceDistance;
            Coordinate dicePosition = new Coordinate(x, y);
            this.defenderDices.set(i, new FlatDice(defender, dicePosition, diceSize));
        }
        hide.set(false);
    }

    void hide() {
        hide.set(true);
    }

    void update(int[] attacker, int[] defender) {
        for (int i = 0; i < attacker.length; i++) attackerDices.get(i).setSide(attacker[i]);
        for (int i = 0; i < defender.length; i++) defenderDices.get(i).setSide(defender[i]);
    }

    void draw(Graphics g) {
        if (hide.get()) return;
        if (attackerDices.isEmpty() || defenderDices.isEmpty()) return;

        attackerDices.forEach(ad -> ad.draw(g));
        defenderDices.forEach(ad -> ad.draw(g));

        int attackerResult = attackerDices.stream()
                .map(FlatDice::getSide).reduce(Integer::sum).get();
        int defenderResult = defenderDices.stream()
                .map(FlatDice::getSide).reduce(Integer::sum).get();

        FlatDice lastDice = attackerDices.lastElement();
        int x = (int)(lastDice.getPosition().getX() + diceSize * 1.2);
        int y = (int)(lastDice.getPosition().getY() + diceSize);
        g.drawString(" " + attackerResult, x, y);

        lastDice = defenderDices.lastElement();
        x = (int)(lastDice.getPosition().getX() + diceSize * 1.2);
        y = (int)(lastDice.getPosition().getY() + diceSize);
        g.drawString(" " + defenderResult, x, y);
    }
}
