package decorator;

public class test {
    public static void main(String[] args){
        concreteDecoratorA SportCar = new concreteDecoratorA(new concreteDecoratorB(new concreteComponent()));
        System.out.println("Der Preis vom Auto mit allen Ausstattungen beträgt "+SportCar.getPreis());
        concreteComponent normalcar = new concreteComponent();
        System.out.println("Der Preis vom Auto ohne allen Ausstattungen beträgt "+normalcar.getPreis());
    }
}