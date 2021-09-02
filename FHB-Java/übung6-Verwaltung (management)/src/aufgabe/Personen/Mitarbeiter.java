package aufgabe.Personen;

import java.time.LocalDate;

public class Mitarbeiter extends Angestellter{
    public Mitarbeiter(String name, String surname, LocalDate date, String rolle) {
        super(name, surname, date, rolle);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
