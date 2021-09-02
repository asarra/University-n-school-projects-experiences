package observer;

import java.util.ArrayList;

public class observable implements Iobservable{
    ArrayList<observer> observers = new ArrayList<>();
    int state;

    public observable(){}

    public void add(observer o) {
        observers.add(o);
    }

    public void remove(observer o) {
        observers.remove(o);
    }

    public void notifyy() {
        for(observer o:observers){
            o.update();
        }
    }

    public void setState(int state) {
        this.state=state;
        this.notifyy();
    }

    public int getState() {
        return this.state;
    }
}
