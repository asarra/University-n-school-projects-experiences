package aufgabe1;

public class main {//aufgabe1

    public boolean AndAnd(int temperatur, boolean esRegnet){
        if(temperatur>30&&esRegnet){ //false und true
            System.out.println("Hier wird überprüft in welcher Relation der linke Teil von && zum rechten Teil steht.\n" +
                    "Danach wird überprüft, ob es Sinn ergibt die gesamte Überprüfung schon nach\n" +
                    "der ersten Überprüfung zu beenden, um schneller zum Ziel zu kommen.\n" +
                    "Wenn man alle Elemente auswerten will, muss man das && als & schreiben." +
                    "Das gilt auch für das untere ||.\n");
            return true;
        }
        else {
            return false;
        }
    }

    public boolean OrOr(int temperatur, boolean esRegnet){
        esRegnet = false;
        if(temperatur>30||esRegnet){//false und false
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        main abc = new main();
        int temperatur = 29;
        boolean esRegnet = true;
        System.out.printf("&&\t->\t%s\n",abc.AndAnd(temperatur,esRegnet));
        System.out.printf("||\t->\t%s",abc.OrOr(temperatur,esRegnet));
    }
}
