package diceWarsLib.interfacesImplementations;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public final class MenuHandler implements diceWarsLib.interfaces.MenuHandler {
    JFileChooser a = new JFileChooser(".");
    String filename = "spiel.txt";
    int response;

    public void onMenuItemLoadGame(Component parent) {
        File file;
        Scanner leser;
        JFileChooser chooser = new JFileChooser(".");

        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try {
                leser = new Scanner(file);
                if(file.isFile()){

                    while(leser.hasNextLine()){
                        String line = leser.nextLine();  //Was soll gelesen werden?
                        System.out.println(line); // parent
                    }
                }
                else{
                    System.out.println("Das war keine Datei");
                }
                leser.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
        /*
        try {
            //myFile = a.getSelectedFile().getPath();
            //a.addChoosableFileFilter(new PNGSaveFilter());
            File datei = new File("C:\\Users\\els11\\IdeaProjects\\ü7\\" + filename);
            Scanner leser = new Scanner(datei);

            if (leser.hasNextLine()) {
                System.out.println(leser.nextLine().split(","));
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        */



    public void onMenuItemSaveGame(Component parent) {
        File file;
        Scanner fileIn;
        JFileChooser chooser = new JFileChooser(".");

        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try {
                fileIn = new Scanner(file);
                if(file.isFile()){

                    while(fileIn.hasNextLine()){
                        String line = fileIn.nextLine();
                        //Was soll gespeichert werden?
                    }
                }
                else{
                    System.out.println("Das war keine Datei");
                }
                fileIn.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        try {
            //Erstellen der Textdatei
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            writer.println(parent.getX());
            writer.close();
        }
        catch (FileNotFoundException|UnsupportedEncodingException e){
            e.printStackTrace();
        }

        */


    public void onMenuItemNewGame(Component parent) {
        File file;
        Scanner fileIn;
        JFileChooser chooser = new JFileChooser(".");

        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            try {
                fileIn = new Scanner(file);
                if(file.isFile()){

                    while(fileIn.hasNextLine()){
                        String line = fileIn.nextLine();
                        //Die Datei muss überschrieben werden. Muss noch implementiert werden
                    }
                }
                else{
                    System.out.println("Das war keine Datei");
                }
                fileIn.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}