import java.util.Objects;

public class Element implements Comparable<Element>{
    static private int i=0;
    static int bucketSize;
    private final int id;

    public Element(){
        this.id = i;
        i++;
    }

    public int getId(){
        return id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id/bucketSize);
    }

    @Override
    public boolean equals(Object other){
        if(other == this) return true;
        if(other.getClass().equals(this.getClass())){
            return this.id == ((Element) other).getId();
        }
        return false;
    }

    @Override
    public int compareTo(Element other){
        if(this.equals(other)) return 0;
        if(this.id < other.getId()){
            return 1;
        }
        return -1;
    }

}
