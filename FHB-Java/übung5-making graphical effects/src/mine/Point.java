package mine;

import java.awt.*;

public class Point {
    int x;
    int y;
    Color color;

    Point(int x, int y, Color color){
        this.x=x;
        this.y=y;
        this.color=color;
    }

    Point(Color color){
        this.color=color;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Color getColor() {
        return color;
    }
}
