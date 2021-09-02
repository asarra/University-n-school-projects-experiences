package observer;

public class observer implements Iobserver{
    observable observable;

    observer(observable o){
        this.observable = o;
    }

    public void update(){
        System.out.println("State is updated: "+this.observable.getState());
    }
}
