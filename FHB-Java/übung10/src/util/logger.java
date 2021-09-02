package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class logger {
    private static logger instance;

    private logger(){}

    public static logger getInstance() {
        if (instance == null) {
            instance = new logger();
        }
        return instance;
    }

    public void log(String msg){
        File logfile = new File("logfile.txt");
        try {
            logfile.createNewFile();
        }
        catch (IOException e){
            System.out.println("Fehler bei der Dateierstellung!\t"+e);
        }

        try {
            FileWriter fw = new FileWriter(logfile.getName(), true);
            fw.write(msg+"\n");
            fw.close();
        }
        catch (IOException e){
            System.out.println("Fehler beim Beschreiben!\t"+e);
        }

    }
}
