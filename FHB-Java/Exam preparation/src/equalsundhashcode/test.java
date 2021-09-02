package equalsundhashcode;

public class test {
    public static void main(String[] args){
        Zahl z1 = new Zahl(0);
        Zahl z2 = new Zahl(0);
        Zahl z3 = new Zahl(1);

        System.out.println(z1.equals(z2)); //is equal
        System.out.println(z2.equals(z3)); //is not equal
    }
}
