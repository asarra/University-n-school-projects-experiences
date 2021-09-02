package createfile;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        int x=0; final int anzahlZeilen=5;

        //Erstellen
        CreateFile a = new CreateFile();
        String filename = "the-file-name.txt";
        a.createTextfile(x,anzahlZeilen,filename);

        //Lesen der Textdatei
        ArrayList<String> datei_array = a.readFile(filename,anzahlZeilen);
        a.parseAfterReading(datei_array);
    }
}
