package aufgabe.Personen;

import java.time.LocalDate;

public class Tutor extends Angestellter{
    private Student student;

    public Tutor(String name, String surname, LocalDate date, String rolle) {
        super(name, surname, date, rolle);
    }

    public Tutor(String name, String surname, LocalDate date, String rolle, Student student) {
        super(name, surname, date, rolle);
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "student=" + student +
                "\nname=" + super.namen[0] +
                "\nnachnamen=" + super.namen[1] +
                '}';
    }
}
