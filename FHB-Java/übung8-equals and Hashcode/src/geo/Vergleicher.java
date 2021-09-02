package geo;

import java.util.Comparator;

public class Vergleicher implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        //Hier wird quasi nur gecheckt, ob die beiden Objekte von kompatiblen Typen sind und die eigentlichen Sortierungen finden in Point.compareTo() statt!
        //Alle Primitiven werden erst nach x und bei gleichen Werten nach y sortiert!
        //Linien werden bei gleichen x und y in den Startpunktwerten nach dem Endpunktwert x und bei gleichen x-Werten nach y-Werten sortiert!

        if(o1 instanceof Point){
            Point objekt1 = (Point)o1;
            if(o2 instanceof Point){        //Wenn o1 == Punkt und o2 Punkt
                Point objekt2 = (Point)o2;
                return objekt1.compareTo(objekt2);
            }
            else if(o2 instanceof Line){    //Wenn o1 == Punkt und o2 Linie
                Line objekt2 = (Line)o2;

                if(objekt1.compareTo(objekt2.getStart())==0){
                    return objekt1.compareTo(objekt2.getEnd());
                }
                else return objekt1.compareTo(objekt2.getStart());
            }
        }
        else if(o1 instanceof Line){
            Line objekt1 = (Line)o1;
            if(o2 instanceof Line){         //Wenn o1 == Linie und o2 Linie
                Line objekt2 = (Line)o2;

                if(objekt1.getStart().compareTo(objekt2.getStart())==0){
                    return objekt1.getEnd().compareTo(objekt2.getEnd());
                }
                else return objekt1.getStart().compareTo(objekt2.getStart());
            }
            else if(o2 instanceof Point){   //Wenn o1 == Linie und o2 Point
                Point objekt2 = (Point)o2;

                if(objekt1.getStart().compareTo(objekt2)==0){
                    return objekt1.getEnd().compareTo(objekt2);
                }
                else return objekt1.getStart().compareTo(objekt2);
            }
        }
        //Wenn keiner der beiden Objekte übereinstimmig sind (durch's Casten, etc.), werden sie "gleichgesetzt" und beim nächsten Durchlauf wird der vorherige Objekt nochmals geprüft
        return 0;
    }
}
