package classDiagram.Class;

public class Voiture {
    public int places;
    public int placeDispo;
    public TypeVoiture type;
    public boolean fumeur;

    public Voiture(int places, int placeDispo, TypeVoiture type, boolean fumeur) {
        this.places = places;
        this.placeDispo = placeDispo;
        this.type = type;
        this.fumeur = fumeur;
    }
}
