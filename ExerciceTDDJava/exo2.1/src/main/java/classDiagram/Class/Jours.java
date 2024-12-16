package classDiagram.Class;

public enum Jours {
    Lundi("Lundi"),
    Mardi("Mardi"),
    Mercredi("Mercredi"),
    Jeudi("Jeudi"),
    Vendredi("Vendredi"),
    Samedi("Samedi");

    private final String jour;

    Jours(String jour) {
        this.jour = jour;
    }

    public String getJour() {
        return jour;
    }
}
