package geo;

import java.util.ArrayList;
import java.util.Objects;

public class CurvedLine extends Line{
    public CurvedLine(){
        super(new Point(0,0), new Point(0,0));
    }
    private ArrayList<Point> controlPoints = new ArrayList<Point>();
    public CurvedLine(Point from, Point to){
        super(from, to);
    }
    public CurvedLine(Point from, Point to, ArrayList<Point> controlPoints){
        super(from, to);
        this.controlPoints = controlPoints;
    }
    public void addControlPoint(Point controlPoint){
        this.controlPoints.add(controlPoint);
    }

    public ArrayList<Point> getControlPoints() {
        return controlPoints;
    }



    @Override
    public boolean equals(Object other) {
        if (other == this) return true;

        if (other instanceof CurvedLine) {
            CurvedLine otherCurvedLine = (CurvedLine)other;
            return super.equals(otherCurvedLine) && otherCurvedLine.getControlPoints().equals(controlPoints);
        }
        return false;
    }
    @Override
    public int hashCode() {return Objects.hash(this.controlPoints,getStart(),getEnd());}

    @Override
    public String toString() {
        return super.toString()+" CurvedLine";
    }
}
