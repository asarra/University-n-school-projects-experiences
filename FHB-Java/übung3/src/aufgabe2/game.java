package aufgabe2;

import java.util.Scanner;
import java.util.Random;
import aufgabe2.Figure;

public class game {
    static Scanner scanner;
    static Random wuerfel;
    static Figure[] figureValues = Figure.values(); //macht eine Kopie aller Figurewerte. Static weil ich es sonst jedes Mal erneut eine Kopie machen müsste


    static String methodUsingScanner() {
        return scanner.nextLine().toUpperCase();
    }

    static String methodUsingRandomizer(Figure[] figureValues){
        return figureValues[wuerfel.nextInt(3)].toString().toUpperCase();
    }

    static String compare(String[] array, String level){
        String player1 = array[0];
        String pc = array[1];

        String first=figureValues[0].toString().toUpperCase();
        String second=figureValues[1].toString().toUpperCase();
        String third=figureValues[2].toString().toUpperCase();
        //figureValues[0] = Stone/Stein/...
        //figureValues[1] = Scissor/Schere/...
        //figureValues[2] = Paper/Papier/...

        if(level.equals("demo")){
            if(player1.equals(pc)){
                return "Unentschieden";
            }
        }


        if(player1.equals(first)&pc.equals(second)){
            return "Spieler1 hat gewonnen!";
        }
        else if(player1.equals(first)&pc.equals(third)){
            return "Spieler1 hat verloren!";
        }
        else if(player1.equals(third)&pc.equals(first)){
            return "Spieler1 hat gewonnen!";
        }
        else if(player1.equals(third)&pc.equals(second)){
            return "Spieler1 hat verloren!";
        }
        else if(player1.equals(second)&pc.equals(third)){
            return "Spieler1 hat gewonnen!";
        }
        else if(player1.equals(second)&pc.equals(first)){
            return "Spieler1 hat verloren!";
        }
        else {
            if(level.equals("real"))
                return simulation("real");
            else if(level.equals("botvsbot")){
                return simulation("botvsbot");
            }
            else if(level.equals("demo")){
                return "";
            }
            else{
                return simulation("");
            }
        }
    }

    static String[] setPlayer1AndPC(){
        String array[] = new String[2];

        System.out.println("Spieler 1, mache deinen Zug! (Stone, Scissor, Paper)");
        array[0] = methodUsingScanner();
        System.out.println("PC, mache deinen Zug!");
        array[1] = methodUsingRandomizer(figureValues);
        System.out.println(array[1]);
        System.out.println("\n");

        return array;
    }

    static String[] setPCAndPC2(){
        String array[] = new String[2];

        System.out.println("PC1, mache deinen Zug!");
        array[0] = methodUsingRandomizer(figureValues);
        System.out.println(array[0]);

        System.out.println("PC2, mache deinen Zug!");
        array[1] = methodUsingRandomizer(figureValues);
        System.out.println(array[1]);

        System.out.println("\n");

        return array;
    }

    static String[] setPlayer1AndPlayer2(){
        String array[] = new String[2];

        System.out.println("Spieler1, mache deinen Zug! (Stone, Scissor, Paper)");
        array[0] = methodUsingScanner();
        System.out.println("Spieler2, mache deinen Zug! (Stone, Scissor, Paper)");
        array[1] = methodUsingScanner();
        System.out.println("\n");

        return array;
    }

    static String simulation(String level){
        String array[];

        if(level.equals("real")) {
            array = setPlayer1AndPlayer2();
        }
        else if(level.equals("botvsbot")){
            array = setPCAndPC2();
        }
        else{
            array = setPlayer1AndPC();
        }


        if(array[0].equals(array[1])){
            System.out.println("Nächste Runde!");

            if(level.equals("real")) {
                array = setPlayer1AndPlayer2();
            }
            else if(level.equals("botvsbot")){
                array = setPCAndPC2();
            }
            else{
                array = setPlayer1AndPC();
            }

            return compare(array,level);
        }

        else {
            String status = compare(array,level);
            return status;
        }
    }


    static void demonstration(){
        String array[] = new String[2];
        String level = "demo";
        array[0]=figureValues[0].toString().toUpperCase();//Stone vs Stone
        array[1]=figureValues[0].toString().toUpperCase();
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));
        array[1]=figureValues[1].toString().toUpperCase();//Stone vs Scissor
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));
        array[1]=figureValues[2].toString().toUpperCase();//Stone vs Paper
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));

        array[0]=figureValues[1].toString().toUpperCase();//Scissor vs Stone
        array[1]=figureValues[0].toString().toUpperCase();
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));
        array[1]=figureValues[1].toString().toUpperCase();//Scissor vs Scissor
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));
        array[1]=figureValues[2].toString().toUpperCase();//Scissor vs Paper
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));

        array[0]=figureValues[2].toString().toUpperCase();//Paper vs Stone
        array[1]=figureValues[0].toString().toUpperCase();
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));
        array[1]=figureValues[1].toString().toUpperCase();//Paper vs Scissor
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));
        array[1]=figureValues[2].toString().toUpperCase();//Paper vs Paper
        System.out.println(array[0] + "\tvs.\t" + array[1] + "\t=\t" + compare(array,level));
    }


    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        wuerfel = new Random();
/*
        System.out.println("Spieler vs Bot:");
        System.out.println(simulation(""));//Gegen PC
*/
        System.out.println("Spieler vs Spieler:");
        System.out.println(simulation("real"));//Gegen Spieler
/*
        System.out.println("Bot vs Bot:");
        System.out.println(simulation("botvsbot"));//PC vs PC //Hatte Lust darauf

        System.out.println("Wir gehen jetzt automatisch alle möglichen Kombinationen durch:");
        demonstration();//Zusatzpunkt bei Aufgabe 2
*/
        scanner.close(); // end of aufgabe2.main
    }
}
