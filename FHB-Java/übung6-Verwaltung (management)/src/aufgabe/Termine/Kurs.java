package aufgabe.Termine;

import aufgabe.Personen.Dozent;

public class Kurs {
    /**
     * - notwendigen Vorleistungen
     * - Semester
     * - Kursbezeichnung
     */

    private String notwendigeVorleistungen;
    private int semester;
    private String kursbezeichnung;
    private Dozent dozent;

    public Kurs(String notwendigeVorleistungen, int semester, String kursbezeichnung, Dozent dozent){
        this.notwendigeVorleistungen=notwendigeVorleistungen;
        this.semester=semester;
        this.kursbezeichnung=kursbezeichnung;
        this.dozent=dozent;
    }

    public Dozent getDozent() {
        return dozent;
    }

    public int getSemester() {
        return semester;
    }

    public String getKursbezeichnung() {
        return kursbezeichnung;
    }

    public String getNotwendigeVorleistungen() {
        return notwendigeVorleistungen;
    }

    @Override
    public String toString() {
        return "Kurs{" +
                "notwendigeVorleistungen='" + notwendigeVorleistungen + '\'' +
                ", semester=" + semester +
                ", kursbezeichnung='" + kursbezeichnung + '\'' +
                ", dozent=" + dozent +
                '}';
    }
}
