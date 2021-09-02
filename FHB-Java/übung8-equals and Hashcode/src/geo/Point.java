package geo;

import java.util.Objects;

public class Point implements Comparable<Point>{

    private final int x ; // evtl protected??
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(){
        this(0,0);
    }

    @Override
    public boolean equals(Object other){
        if(other== this) return true;

        if(other instanceof Point) {
            Point otherPoint = (Point)other;
            return otherPoint.getX()== this.x && otherPoint.getY() == this.y;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.x , this.y);
    }

    @Override
    public String toString() {
        return "{" + "x=" + x + ", y=" + y + "}Point";
    }

    @Override
    public int compareTo(Point other) {
        //-1 signalisiert dem Vergleicher, dass unser Objekt kleiner ist
        //0 ... , dass unser Objekt gleich groß ist
        //1 ... , dass unser Objekt größer ist
        if(this.getX()<other.getX()){
            return -1;
        }
        else if(other.getX() == this.getX()){
            if(this.getY()<other.getY()){
                return -1;
            }
            else if(other.getY() == this.getY()){   //Beide x und y von beiden Objekten sind gleich
                return 0;
            }
            //Bei den beiden unteren return 1, verzichte ich auf Vergleiche, da es keine anderen Fälle außer "Unser Objekt > other Objekt" geben kann
            return 1;
        }
        return 1;
    }
}
