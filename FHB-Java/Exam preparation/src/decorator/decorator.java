package decorator;

public class decorator implements component{ //Extra aka Beilagen aka Austattungen aka ...

    protected component car;
    public decorator(component c){
        this.car=c;
    }

    public int getPreis() {
        return this.car.getPreis();
    }
}

