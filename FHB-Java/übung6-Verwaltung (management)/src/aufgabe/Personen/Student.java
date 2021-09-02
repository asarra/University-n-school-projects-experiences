package aufgabe.Personen;

import aufgabe.Termine.Veranstaltung;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student extends Person{


    static String matrikelnummer="00000000";//new Random().nextInt(8);
    ArrayList<Veranstaltung> veranstaltung = new ArrayList<>();

    public Student(String name, String surname, LocalDate date) {
        super(name, surname, date);
        if(matrikelnummer.length()==8 && !matrikelnummer.equals("11111111")){
            matrikelnummer=String.valueOf(Integer.parseInt(matrikelnummer)+1);
            if(matrikelnummer.length()<8){
                matrikelnummer=String.format("%08d", Integer.parseInt(matrikelnummer));
            }
        }
        else{
            System.out.println("Overflow-Error");
        }
    }

    public void setVeranstaltungen(ArrayList<Veranstaltung> veranstaltung) {
        this.veranstaltung = veranstaltung;
    }

    public ArrayList<Veranstaltung> getVeranstaltungen() {
        return veranstaltung;
    }

    public String getMatrikelnummer() {
        return matrikelnummer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "veranstaltungen=" + veranstaltung +
                "\nmatrikelnummer=" + this.getMatrikelnummer() +
                "\nname=" + super.getNamen()[0] +
                "\nnachname=" + super.getNamen()[1] +
                '}';
    }
}
