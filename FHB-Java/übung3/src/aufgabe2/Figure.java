package aufgabe2;

public enum Figure {//aufgabe2
    // KONSTANTE("Wert")
    //STONE("Stone"), SCISSOR("Scissor"), PAPER("Paper");
    STEIN("Stein"), SCHERE("Schere"), PAPIER("Papier");

    private String value;

    Figure(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

}