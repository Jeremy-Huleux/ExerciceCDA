package classDiagram.Class;

public class Voyage {
    private Sens sens;

    public Voyage(Sens sens) {
        this.sens = sens;
    }

    public Sens getSens() {
        return sens;
    }

    public void setSens(Sens sens) {
        this.sens = sens;
    }
}
