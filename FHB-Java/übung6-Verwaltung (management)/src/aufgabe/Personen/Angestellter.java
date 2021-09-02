package aufgabe.Personen;

import java.time.LocalDate;

public class Angestellter extends Person{

    static String personalnummer="00000000";//new Random().nextInt(8);
    static String sechsZiffern="000000";
    //ArrayList<Veranstaltungen> veranstaltungen = new ArrayList<>();

    Angestellter(String name, String surname, LocalDate date, String rolle) {
        super(name, surname, date);
        if(rolle.equals("d")|rolle.equals("t")|rolle.equals("m")){
            if(personalnummer.length()==8 & sechsZiffern.length()==6 & !sechsZiffern.equals("111111")){
                sechsZiffern=String.valueOf(Integer.parseInt(sechsZiffern)+1);
                if(sechsZiffern.length()<6){
                    sechsZiffern=String.format("%06d", Integer.parseInt(sechsZiffern));
                }
                personalnummer=surname.charAt(0)+sechsZiffern+rolle.charAt(0);
            }
            else{
                System.out.println("Overflow-Error");
            }
        }
    }

    public String[] getName(){
        return super.getNamen();
    }

    public String getPersonalnummer() {
        return personalnummer;
    }

    public String getSechsZiffern() {
        return sechsZiffern;
    }

    @Override
    public String toString() {
        return super.toString()+"\npersonalnummer="+this.getPersonalnummer();
    }
}
