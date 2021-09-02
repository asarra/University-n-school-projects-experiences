package natürlicheordnung;

public class Zahl implements Comparable{ //für erweiterte Sortierungen benutze Comparator
    private Integer zahl; //int ist primitiv und funktioniert nicht mit compareTo()
    public Zahl(Integer z){zahl=z;}
    public int getZahl() {return zahl;}
    @Override public String toString() {
        return "Zahl{zahl='" + zahl + "'}";
    }

    @Override
    public int compareTo(Object o) {
        Zahl other = (Zahl) o;
        return this.zahl.compareTo(other.zahl);
    }
}