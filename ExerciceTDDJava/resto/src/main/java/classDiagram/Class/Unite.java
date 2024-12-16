package classDiagram.Class;

public enum Unite {
    Litre("Litre"),
    Gramme("Gramme"),
    Metre("Mètre"),
    Unite("Pièce");

    private final String unite;

    Unite(String unite) {
        this.unite = unite;
    }

    public String getUnite() {
        return unite;
    }
}
