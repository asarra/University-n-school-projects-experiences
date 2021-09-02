package aufgabe.Personen;

import java.time.LocalDate;

public class Person {
    LocalDate einstiegsdatum;
    String[] namen = new String[2]; //0=vor- & 1=nachname


    Person(String name, String surname, LocalDate date) {
        this.namen[0] = name;
        this.namen[1] = surname;
        this.einstiegsdatum = date;
    }


    public LocalDate getEinstiegsdatum() {
        return einstiegsdatum;
    }

    public String[] getNamen() {
        return namen;
    }

    public void setEinstiegsdatum(LocalDate einstiegsdatum) {
        this.einstiegsdatum = einstiegsdatum;
    }

    public void setNamen(String[] namen) {
        this.namen = namen;
    }
}

