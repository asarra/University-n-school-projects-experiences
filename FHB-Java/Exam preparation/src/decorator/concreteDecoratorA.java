package decorator;

public class concreteDecoratorA extends decorator{

    public concreteDecoratorA(component c) { //Wir übergeben Interface nicht die Implementierung des Interfaces!
        super(c);
    }
    public int getPreis(){
        return super.getPreis()+20000;
    }
}
