package aufgabe.Termine;

import aufgabe.Personen.Dozent;

import java.time.LocalDate;
import java.util.ArrayList;

public class Veranstaltung {

    //private ArrayList<Kurs> kurs = new ArrayList<>();
    //private ArrayList<LocalDate> beginndaten = new ArrayList<>();
    //private ArrayList<LocalDate> enddaten = new ArrayList<>();
    private LocalDate beginndatum;
    private LocalDate enddatum;
    private Dozent dozent;
    private Kurs kurs;
    private int sws;
    private String veranstaltungsname;


    public Veranstaltung(Dozent dozent,Kurs kurs, LocalDate bd, LocalDate ed, int sws) {
        this.beginndatum=bd;
        this.enddatum=ed;
        this.kurs=kurs;
        veranstaltungsname = kurs.getKursbezeichnung();
        if (dozent == kurs.getDozent()){
            this.dozent = dozent;
        }else {
            System.out.println("Der Dozent ist nicht für diesen Kurs verfügbar");
        }
    }

    public Kurs getKurs() {
        return kurs;
    }

    public LocalDate getBeginndatum() {
        return beginndatum;
    }

    public LocalDate getEnddatum() {
        return enddatum;
    }

    public int getSws() {
        return sws;
    }

    public String toString() {
        return "Veranstaltungsname: " + veranstaltungsname + " | von " + this.beginndatum.toString() + " bis "
                + this.enddatum.toString() + " | Verantwortlich: " + dozent.getNamen()[0] + " " + dozent.getNamen()[1]
                + ", Personalnummer: " + dozent.getPersonalnummer();
    }
}

