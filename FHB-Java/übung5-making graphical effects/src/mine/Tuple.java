package mine;
import java.awt.Color;
public class Tuple {
    int x;
    int y;
    int iColor;
    Color color;
    int[] ax,ay;

    Tuple(int x, int y,int x_index){
        this.ax[x_index]=x;
        this.ay[x_index]=y;
    }


    Tuple(int x, int y, Color color){
        this.x=x;
        this.y=y;
        this.color=color;
    }
/*
    Tuple(int x, int y, int iColor){
        this.x=x;
        this.y=y;
        this.iColor=iColor;
    }
*/
    public int getiColor() {
        return iColor;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
