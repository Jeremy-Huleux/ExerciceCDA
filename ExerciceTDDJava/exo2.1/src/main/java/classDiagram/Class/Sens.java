package classDiagram.Class;

public enum Sens {
    ALLER("aller"),
    RETOUR("retour");

    private final String sens;

    Sens(String sens) {
        this.sens = sens;
    }

    public String getSens() {
        return sens;
    }
}
