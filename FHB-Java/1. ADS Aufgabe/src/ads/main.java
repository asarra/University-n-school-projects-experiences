package ads;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class main {

    public static void maxTeilsumme(ArrayList<Integer> list){
        int n = list.size();
        int maxsumme = Integer.MIN_VALUE;
        int sumcount = 0;
        int von = 0, bis = von;
        double startTime = System.currentTimeMillis() / 1000.0;
        int summe, i, j, k;
        for(i = 1; i<=n; i++){
            for (j = i; j<=n; j++){
                summe = 0;
                for (k = i; k<=j; k++){
                    summe += list.get(k-1);
                    sumcount ++;
                }
                if (summe > maxsumme){
                    maxsumme = summe;
                    von = i;
                    bis = j;
                }
            }

        }
        System.out.println("max. Teilsumme: " + maxsumme);
        System.out.println("erster Index: " + von);
        System.out.println("letzter Index: " + bis);
        System.out.println("Anzahl der Additionen: " + sumcount);
        System.out.println("Dauer für die Hauptschleife: " + ((System.currentTimeMillis() / 1000.0) - startTime) + " Sekunden");
    }

    public static void main(String[] args){
        try {
            System.out.println("Wählen Sie eine Datei aus!");
            JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                String content = new String(Files.readAllBytes(Paths.get(chooser.getSelectedFile().getAbsolutePath())));

                if (content.length() == 0)
                    System.out.println("Leere Datei!");

                String[] temp_list = content.split(",");
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (String a:temp_list) {
                    list.add(Integer.parseInt(a));
                }

                maxTeilsumme(list);
            }
            else System.out.println("Nichts gewählt!");

        } catch (IOException e) {
            System.out.println("Datei nicht gefunden!");
        }
    }
}
