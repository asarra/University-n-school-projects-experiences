package kw51.lib.painting;

import java.awt.*;
import java.util.Arrays;

import kw51.lib.data.Coordinate;

public class FlatDice {
    private final Coordinate position;
    private final int size;
    private final int arc; // rounded corner
    private final Color color;
    private static final double[][] ONE = {{ 0.5, 0.5 }};
    private static final double[][] TWO = {{ 0.3, 0.3 }, { 0.7, 0.7 }};
    private static final double[][] THREE = {{ 0.3, 0.3 }, { 0.5, 0.5 }, { 0.7, 0.7 }};
    private static final double[][] FOUR = {{ 0.3, 0.3 }, { 0.7, 0.3 }, { 0.3, 0.7 }, { 0.7, 0.7 }};
    private static final double[][] FIVE = {{ 0.5, 0.5 }, { 0.3, 0.3 }, { 0.7, 0.3 }, { 0.3, 0.7 }, { 0.7, 0.7 }};
    private static final double[][] SIX = {{ 0.3, 0.3 }, { 0.5, 0.3 }, { 0.7, 0.3 }, { 0.3, 0.7 }, { 0.5, 0.7 }, { 0.7, 0.7 }};

    private int side = 1;

    FlatDice(Color color, Coordinate position, int size) {
        this.position = position;
        this.size = size;
        this.arc = size / 8;
        this.color = color;
    }

    void setSide(int side) {
        this.side = Math.max(1, Math.min(6, side));
    }

    int getSide() {
        return side;
    }

    Coordinate getPosition() {
        return position;
    }

    private double[][] getDots() {
        switch (side) {
            case 1: return ONE;
            case 2: return TWO;
            case 3: return THREE;
            case 4: return FOUR;
            case 5: return FIVE;
            default: return SIX;
        }
    }

    private int dotX(double[] dot) {
        final int x = (int)position.getX();
        return (int)Math.round(x * (1.0 - dot[0]) + (x + size) * dot[0]);
    }

    private int dotY(double[] dot) {
        final int y = (int)position.getY();
        return (int)Math.round(y * (1.0 - dot[1]) + (y + size) * dot[1]);
    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillRoundRect((int)position.getX(), (int)position.getY(), size, size, arc, arc);
        g.setColor(Color.BLACK);
        final int dotRadius = 1;
        Arrays.stream(getDots())
                .forEach(dot -> g.drawOval(dotX(dot)-dotRadius, dotY(dot)-dotRadius, 2*dotRadius, 2*dotRadius));
    }
}
