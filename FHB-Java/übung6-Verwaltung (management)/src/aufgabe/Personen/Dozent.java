package aufgabe.Personen;

import aufgabe.Termine.Veranstaltung;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Dozent extends Angestellter{
    ArrayList<Veranstaltung> veranstaltung = new ArrayList<>();
    Mitarbeiter mitarbeiter;

    public Dozent(String name, String surname, LocalDate date, String rolle) {
        super(name, surname, date, rolle);
    }

    public Dozent(String name, String surname, LocalDate date, String rolle, Mitarbeiter mitarbeiter) {
        super(name, surname, date, rolle);
        this.mitarbeiter=mitarbeiter;
    }

    public void setMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public String[] getNamen(){
        return super.getNamen();
    }

    public Mitarbeiter getMitarbeiter() {
        return mitarbeiter;
    }

    public void fügeVeranstaltungHinzu(Veranstaltung veranstaltung) {
        this.veranstaltung.add(veranstaltung);
    }

    public ArrayList<Veranstaltung> getVeranstaltung() {
        return veranstaltung;
    }

    @Override
    public String toString() {
        return "Dozent{" +
                "veranstaltung=" + veranstaltung +
                ", mitarbeiter=" + mitarbeiter +
                ", einstiegsdatum=" + einstiegsdatum +
                ", namen=" + Arrays.toString(namen) +
                '}';
    }
}
