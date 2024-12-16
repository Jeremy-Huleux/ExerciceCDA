package classDiagram.Class;

public class Animal {
    private long id;
    private String nom;
    private Race race;

    public Animal(long id, String nom, Race race) {
        this.id = id;
        this.nom = nom;
        this.race = race;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
