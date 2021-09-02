public class Eigeninitiative {

    public static void main(String[] args){
        Klasse abc = new Klasse(); //Objekt/Instanz
        String test = abc.getString();
        String ergebnis = !(args[0].equals("")) ? args[0]+test+"!" : "Es wurden keine Argumente eingegeben!"; //ternärer Kontrollstruktur
        System.out.println(ergebnis);

        float i=0;
        while(i<=1){
            System.out.println(i);
            i+=.1;
        }
    }
}
