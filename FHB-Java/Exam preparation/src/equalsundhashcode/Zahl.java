package equalsundhashcode;

import java.util.Objects;

public class Zahl {
    private int id=0;
    public Zahl(int id){this.id=id;}
    public int getId() {
        return id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object other){
        if(other == this) return true;
        if(other.getClass().equals(this.getClass())){ //we do this extended version if we have a subclass that we wanna upcast and check for equality
            return this.id == ((Zahl) other).getId();
        }
        return false;
    }
}