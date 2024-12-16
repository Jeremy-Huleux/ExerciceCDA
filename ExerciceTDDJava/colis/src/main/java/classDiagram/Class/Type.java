package classDiagram.Class;

public enum Type {
    Urgente("Urgente"),
    Normale("Normale");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
