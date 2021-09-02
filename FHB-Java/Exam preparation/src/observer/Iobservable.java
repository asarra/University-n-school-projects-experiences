package observer;

public interface Iobservable {
    void add(observer o);
    void remove(observer o);
    void notifyy();
    void setState(int state);
    int getState();
}
