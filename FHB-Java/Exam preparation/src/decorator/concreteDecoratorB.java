package decorator;

public class concreteDecoratorB extends decorator{

    public concreteDecoratorB(component c) { //Wir übergeben Interface nicht die Implementierung des Interfaces!
        super(c);
    }
    public int getPreis(){
        return super.getPreis()+10000;
    }
}
