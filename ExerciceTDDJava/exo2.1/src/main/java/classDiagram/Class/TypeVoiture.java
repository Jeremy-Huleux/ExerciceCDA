package classDiagram.Class;

public enum TypeVoiture {
    Char("Char d'assault"),
    Camion("RO CAMION"),
    Berline("Berline"),
    Cacahuete("Cacahuete");

    private final String type;

    TypeVoiture(String rep) {
        this.type = rep;
    }

    public String getType() {
        return type;
    }
}
