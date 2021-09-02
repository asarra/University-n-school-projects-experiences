package aufgabe;

import aufgabe.Personen.*;
import aufgabe.Termine.Kurs;
import aufgabe.Termine.Veranstaltung;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Verwaltung {

    static ArrayList<Student> Studentenliste = new ArrayList<>();
    static ArrayList<Angestellter> Angestelltenliste = new ArrayList<>();
    static ArrayList<Kurs> Kurse = new ArrayList<>();
    static ArrayList<Veranstaltung> Veranstaltungen = new ArrayList<>();
    static ArrayList<Mitarbeiter> Mitarbeiterliste = new ArrayList<>();
    static ArrayList<Dozent> Dozentenliste = new ArrayList<>();
    static ArrayList<Tutor> Tutorenliste = new ArrayList<>();

    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie lautet der Vorname?:");
        String vorname = sc.nextLine();
        System.out.println("Wie lautet der Nachname?:");
        String nachname = sc.nextLine();
        System.out.println("Wie lautet der Tag des Einstiegdatums? (Integer-Wert");
        int tag = sc.nextInt();
        System.out.println("Wie lautet der Monat des Einstiegdatums? (Integer-Wert");
        int monat = sc.nextInt();
        System.out.println("Wie lautet das Jahr des Einstiegdatums? (Integer-Wert");
        int jahr = sc.nextInt();
        Student student = new Student(vorname,nachname,LocalDate.of(jahr, monat, tag));
        Studentenliste.add(student);
    }

    public static void addDozent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie lautet der Vorname?:");
        String vorname = sc.nextLine();
        System.out.println("Wie lautet der Nachname?:");
        String nachname = sc.nextLine();
        System.out.println("Wie lautet der Tag des Einstiegdatums? (Integer-Wert");
        int tag = sc.nextInt();
        System.out.println("Wie lautet der Monat des Einstiegdatums? (Integer-Wert");
        int monat = sc.nextInt();
        System.out.println("Wie lautet das Jahr des Einstiegdatums? (Integer-Wert");
        int jahr = sc.nextInt();
        Dozent dozent = new Dozent(vorname,nachname,LocalDate.of(jahr, monat, tag),"d");
        Angestelltenliste.add(dozent);
        Dozentenliste.add(dozent);
    }

    public static void addTutor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie lautet der Vorname?:");
        String vorname = sc.nextLine();
        System.out.println("Wie lautet der Nachname?:");
        String nachname = sc.nextLine();
        System.out.println("Wie lautet der Tag des Einstiegdatums? (Integer-Wert");
        int tag = sc.nextInt();
        System.out.println("Wie lautet der Monat des Einstiegdatums? (Integer-Wert");
        int monat = sc.nextInt();
        System.out.println("Wie lautet das Jahr des Einstiegdatums? (Integer-Wert");
        int jahr = sc.nextInt();
        Tutor tutor = new Tutor(vorname,nachname,LocalDate.of(jahr, monat, tag),"t");
        Angestelltenliste.add(tutor);
        Tutorenliste.add(tutor);
    }

    public static void addMitarbeiter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Wie lautet der Vorname?:");
        String vorname = sc.nextLine();
        System.out.println("Wie lautet der Nachname?:");
        String nachname = sc.nextLine();
        System.out.println("Wie lautet der Tag des Einstiegdatums? (Integer-Wert");
        int tag = sc.nextInt();
        System.out.println("Wie lautet der Monat des Einstiegdatums? (Integer-Wert");
        int monat = sc.nextInt();
        System.out.println("Wie lautet das Jahr des Einstiegdatums? (Integer-Wert");
        int jahr = sc.nextInt();
        Mitarbeiter mitarbeiter = new Mitarbeiter(vorname,nachname,LocalDate.of(jahr, monat, tag),"m");
        Angestelltenliste.add(mitarbeiter);
        Mitarbeiterliste.add(mitarbeiter);
    }

    public static void addKurs() {
        if(Angestelltenliste.size()>0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welche notwendigen Vorleistungen benötigt man für dieses Kurs?:");
            String notwendigeVorleistungen = sc.nextLine();
            System.out.println("Wie lautet der Dozentnachname?:");
            String dozentname = sc.nextLine();
            System.out.println("Wie lautet die Kursbezeichnung?:");
            String kursbezeichnung = sc.nextLine();
            System.out.println("In welchem Semester wird es stattfinden?:");
            int semester = sc.nextInt();
            Dozent dozent = null;
            for (int x = 0; x < Angestelltenliste.size(); x++)
                if (Angestelltenliste.get(x).getName()[1].equals(dozentname)) {
                    dozent = (Dozent) Angestelltenliste.get(x);
                    x = Angestelltenliste.size() - 1; //um es zu stoppen
                }
            if (!(dozent == null)) {
                Kurs kurs = new Kurs(notwendigeVorleistungen, semester, kursbezeichnung, dozent);
                Kurse.add(kurs);
            } else {
                System.out.println("Fehler bei der Erstellung des Kurses!");
            }
        }
        else {
            System.out.println("Es wurden noch keine Dozenten erstellt und daher kommen Sie zurück in's Hauptmenü!");
        }
    }

    public static void addVeranstaltung(){
        if(Kurse.size()>0 & Angestelltenliste.size()>0) {
            Scanner sc = new Scanner(System.in);

            //Beginn
            System.out.println("Wie lautet der Tag des Beginndatums? (Integer-Wert");
            int bd = sc.nextInt();
            System.out.println("Wie lautet der Monat des Beginndatums? (Integer-Wert");
            int bm = sc.nextInt();
            System.out.println("Wie lautet das Jahr des Beginndatums? (Integer-Wert");
            int by = sc.nextInt();

            //Ende
            System.out.println("Wie lautet der Tag des Enddatums? (Integer-Wert");
            int ed = sc.nextInt();
            System.out.println("Wie lautet der Monat des Enddatums? (Integer-Wert");
            int em = sc.nextInt();
            System.out.println("Wie lautet das Jahr des Enddatums? (Integer-Wert");
            int ey = sc.nextInt();

            System.out.println("Um welches Kurs handelt es sich? Geben Sie den Kursnamen an!");
            String kursname = sc.nextLine();
            Kurs kurs = null;
            for (int x = 0; x < Kurse.size(); x++) {
                if (Kurse.get(x).getKursbezeichnung().equals(kursname)) {
                    kurs = Kurse.get(x);
                    x = Angestelltenliste.size() - 1; //um es zu stoppen
                }
            }

            System.out.println("Wie viele Semesterwochenstunden?:");
            int sws = sc.nextInt();
            System.out.println("Wie lautet der Dozentnachname?:");
            String dozentname = sc.nextLine();

            Dozent dozent = null;
            for (int x = 0; x < Angestelltenliste.size(); x++) {
                if (Angestelltenliste.get(x).getName()[1].equals(dozentname)) {
                    dozent = (Dozent) Angestelltenliste.get(x);
                    x = Angestelltenliste.size() - 1; //um es zu stoppen
                }
            }
            if (dozent == null || kurs == null) {
                System.out.println("Fehler bei der Erstellung der Veranstaltung!");
            } else {
                Veranstaltung v = new Veranstaltung(dozent, kurs, LocalDate.of(by, bm, bd), LocalDate.of(ey, em, ed), sws);
                Veranstaltungen.add(v);
            }
        }
        else {
            System.out.println("Kurse und/oder Angestelltenliste ist leer! Die Veranstaltung konnte nicht erstellt werden!");
        }
    }

    public static void showStudenten(){
        for(Student s:Studentenliste)
            System.out.println(s.toString());
    }

    public static void showKurse(){
        for(Kurs k:Kurse)
            System.out.println(k.toString());
    }

    public static void showVeranstaltungen(){
        for(Veranstaltung v:Veranstaltungen)
            System.out.println(v.toString());
    }

    public static void showAngestellten(){
        for(Angestellter a:Angestelltenliste)
            System.out.println(a.toString());
    }



    public static void showTutoren(){
        for(Tutor t:Tutorenliste)
            System.out.println(t.toString());
    }
    public static void showMitarbeiter(){
        for(Mitarbeiter m:Mitarbeiterliste)
            System.out.println(m.toString());
    }
    public static void showDozenten(){
        for(Dozent d:Dozentenliste)
            System.out.println(d.toString());
    }




     /**
     * Aufgabe Punkte: 20
     * Überlegen Sie sich eine interaktive Anwendung, die eine Implementierung von obigem/n Sachverhalt
     * und Vorgaben demonstriert (muss beinhalten: Anlegen verschiedener Kurse, Veranstaltungen,
     * Studenten etc. Ausgabe der erzeugten Objekte. Verwendung von Objektvergleichen). Erstellen
     * Sie dazu UML‐Diagramm und zugehörigen Code.
     */

    public static void main(String args[]){
        /*
        Student student = new Student("Lo","La",LocalDate.of(2020, 12, 31));
        System.out.println(student.getMatrikelnummer());
        Studentenliste.add(student);

        Dozent dozent = new Dozent("Adam", "Müller", LocalDate.of(2020, 12, 31), "d");
        System.out.println(dozent.getPersonalnummer());

        Tutor tutor = new Tutor("Lee","Chen",LocalDate.of(2020, 12, 31), "t");
        System.out.println(tutor.getPersonalnummer());

        Mitarbeiter mitarbeiter = new Mitarbeiter("Hashimato","Osaka",LocalDate.of(2020, 12, 31), "m");
        System.out.println(mitarbeiter.getPersonalnummer());

        Angestelltenliste.add(dozent);
        Angestelltenliste.add(tutor);
        Angestelltenliste.add(mitarbeiter);

        Kurs kurs = new Kurs("Mathe",2,"Machine Learning", dozent);
        System.out.println(kurs.getKursbezeichnung());

        Kurs kurs2 = new Kurs("Mathe",2,"Deep Learning", dozent);
        System.out.println(kurs2.getKursbezeichnung());


        Kurse.add(kurs);
        Kurse.add(kurs2);

        Veranstaltung veranstaltung = new Veranstaltung(dozent, kurs, LocalDate.of(2020, 12, 30), LocalDate.of(2020, 12, 31), 10);
        System.out.println(veranstaltung.getBeginndaten());
        */

        boolean schalter=true;
        Scanner sc = new Scanner(System.in);

        while (schalter) {
            System.out.println("___________________________________________________________________________________________________________________________________________________________________________");
            System.out.println("Was möchtest du tun?\n(0=Kurs hinzufügen, 1=Veranstaltung hinzufügen, 2=Student hinzufügen, 3=Dozent hinzufügen, 4=Tutor hinzufügen, 5=Mitarbeiter hinzufügen,");
            System.out.println("6=Kurse zeigen, 7=Veranstaltungen zeigen, 8=Studenten zeigen, 9=Angestellten zeigen, 10=Dozenten zeigen, 11=Tutoren zeigen, 12=Mitarbeiter zeigen, 13=Programm beenden)");
            System.out.println("___________________________________________________________________________________________________________________________________________________________________________");
            int choice = sc.nextInt();
            if(choice>=0 & choice<=13){
                if(choice==0)
                    addKurs();
                else if(choice==1)
                    addVeranstaltung();
                else if(choice==2)
                    addStudent();
                else if(choice==3)
                    addDozent();
                else if(choice==4)
                    addTutor();
                else if(choice==5)
                    addMitarbeiter();
                else if(choice==6)
                    showKurse();
                else if(choice==7)
                    showVeranstaltungen();
                else if(choice==8)
                    showStudenten();
                else if(choice==9)
                    showAngestellten();
                else if(choice==10)
                    showDozenten();
                else if (choice==11)
                    showTutoren();
                else if (choice==12)
                    showMitarbeiter();
                else if(choice==13)
                    schalter = false;
            }
            else {
                System.out.println("Keine gültige Eingabe erkannt! Versuche es nochmal!");
            }
        }

    }
}
