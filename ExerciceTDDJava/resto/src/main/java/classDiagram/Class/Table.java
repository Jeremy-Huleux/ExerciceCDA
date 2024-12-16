package classDiagram.Class;

public class Table {
    private long id;
    public int nbPlaces;

    public Table(long id, int nbPlaces) {
        this.id = id;
        this.nbPlaces = nbPlaces;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
