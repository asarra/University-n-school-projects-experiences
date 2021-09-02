package createfile;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateFile {
    public void createTextfile(int x, int anzahlZeilen, String filename){
        try{
            //Erstellen der Textdatei
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.println(anzahlZeilen);
            for (int z=0;z<anzahlZeilen;z++){
                writer.println(x);
            }
            writer.close();
        }
        catch (FileNotFoundException|UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFile(String filename, int anzahlZeilen) {
        try {
            File datei = new File("C:\\Users\\els11\\IdeaProjects\\ü5\\" + filename);
            Scanner leser = new Scanner(datei);
            String[] splitline = new String[anzahlZeilen];

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

    public void parseAfterReading(ArrayList<String> datei_array) {
        String[] splitline;
        int x;
        for(String line:datei_array){
            splitline=line.split(",");
            x=Integer.parseInt(splitline[0]);
        }
    }
}