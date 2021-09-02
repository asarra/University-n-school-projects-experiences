package aufgabe2;

import given.Gui;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class CreateFile {

    /**
     * For‑Schleifen, ArrayList und Fehlerbehandlung Punkte: 5
     * • Erstellen Sie eine Textdatei, die pro Zeile fünf Zahlen im Format x,y,r,g,b enthält, wobei
     *      x und y Ganzzahlen sind, die übrigen Gleitkommazahlen im Bereich [0.0, 1.0].
     *      Beispiel: 10,3,0.3,0.25,0.8.
     *      In der ersten Zeile sollen nur drei Zahlen stehen (Anzahl Spalten, Anzahl Zeilen, Delay in
     *      Millisekunden).
     * • Erzeugen Sie die GUI basierend auf Zeile 1.
     * • Lesen Sie alle weiteren Zeilen dieser Datein in eine ArrayList.
     * • Iterieren Sie mit einem for‐each‐Loop über die Liste und malen Sie zu jeder Zeile ein Feld
     *      entsprechend der enthaltenen Werte.
     * • Implementieren Sie auch eine Prüfung der Koordinaten und Farbwerte: Sie müssen alle innerhalb
     *      der angegebenen Dimensionen (Zeile 1) liegen, bzw. im Bereich [0.0, 1.0].
     */


    public void createTextfile(int x,int y,float r, float g, float b, int anzahlSpalten, int anzahlZeilen, int delayMs, String filename){
        try{
            //Erstellen der Textdatei
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.println(anzahlSpalten+","+anzahlZeilen+","+delayMs);
            for (int z=0;z<anzahlZeilen;z++){
                x++;
                writer.println(x+","+y+","+r+","+g+","+b);
                y++;
            }
            writer.close();
        }
        catch (FileNotFoundException|UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFile(String filename, int anzahlSpalten) {
        try {
            File datei = new File("C:\\Users\\els11\\IdeaProjects\\ü5\\" + filename);
            Scanner leser = new Scanner(datei);
            String[] splitline = new String[anzahlSpalten];

            if (leser.hasNextLine()) {
                splitline = leser.nextLine().split(",");
            }

            ArrayList<String> datei_array = new ArrayList<>();
            while (leser.hasNextLine()) {
                datei_array.add(leser.nextLine());
            }
            return datei_array;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>(); //empty
        }
    }

    public void draw(Gui gui, ArrayList<String> datei_array) {
        String[] splitline;
        float red, green, blue;
        int x,y;
        for(String line:datei_array){
            splitline=line.split(",");
            x=Integer.parseInt(splitline[0]);
            y=Integer.parseInt(splitline[1]);
            red=Float.parseFloat(splitline[2]);
            green=Float.parseFloat(splitline[3]);
            blue=Float.parseFloat(splitline[4]);

            //Zeichnen der Elemente & Überprüfung der Einhaltung der Regeln, die in der Aufgabe stehen!
            if((x>=0 & x<gui.getWidth())&&(y>=0 & y<gui.getHeight())){// && ((x >= 0f & x <=1f) && (y >= 0f & y <=1f)) ){
                gui.rectangleAt(x,y, new Color(red,green,blue));
            }
            else {
                System.out.println("FEHLER! Die eingelesenen Daten entsprechen nicht den Regeln!");
            }
        }
    }

    public static void untermain(Gui gui) {
        int x,y;
        float r,g,b;
        final int anzahlSpalten=5;
        int anzahlZeilen=3;
        int delayMs=100;
        r=1;g=0;b=0.5f;
        x=0;y=0;

        //Erstellen
        CreateFile a = new CreateFile();
        String filename = "the-file-name.txt";
        a.createTextfile(x,y,r,g,b,anzahlSpalten,anzahlZeilen,delayMs,filename);

        //Lesen der Textdatei
        ArrayList<String> datei_array = a.readFile(filename,anzahlSpalten);

        //Zeichnen
        a.draw(gui,datei_array);
    }

    public void generate(Gui gui){
        gui.setInitialWaitMs(10);
        gui.setWaitMs(200);

        untermain(gui);
    }

    public static void main(String[] args){
        Gui gui = new Gui(new CreateFile(), 10, 10);
        gui.start();

    }

}