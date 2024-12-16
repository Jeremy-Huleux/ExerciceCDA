package classDiagram.Class;

public class Plat {
    public String nom;
    private long id;

    public Plat(String nom, long id) {
        this.nom = nom;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
