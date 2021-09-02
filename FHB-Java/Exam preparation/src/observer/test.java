package observer;

public class test {
    public static void main(String[] args){
        observable observable = new observable();
        observer observer = new observer(observable);
        observer observer2 = new observer(observable);
        observer observer3 = new observer(observable);
        observable.add(observer);
        observable.add(observer2);
        observable.remove(observer2);
        observable.add(observer3);
        observable.setState(20);
        observable.add(observer2);
        observable.setState(100);
    }
}
