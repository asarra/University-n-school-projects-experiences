package geo;

import java.util.Objects;

public class Line {
    private final Point startPoint;
    private final Point endPoint;

    public Line(Point startPoint, Point endPoint){
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStart() {
        return startPoint;
    }

    public Point getEnd() {
        return endPoint;
    }




    @Override
    public boolean equals(Object other) {
        if(other== this) return true;
        if(other instanceof CurvedLine){
            CurvedLine otherCurvedLine = (CurvedLine)other;
            if(otherCurvedLine.getControlPoints().size() > 0){
                return false;
            }
        }
        if(other instanceof Line) {
            Line otherline = (Line)other;
            return otherline.getStart().equals(startPoint) && otherline.getEnd().equals(endPoint);
        }
        return false;
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.startPoint, this.endPoint);
    }

    @Override
    public String toString() {
        return "{" + "startPoint= " + startPoint + ", endPoint=" + endPoint + "}Line";
    }
}
