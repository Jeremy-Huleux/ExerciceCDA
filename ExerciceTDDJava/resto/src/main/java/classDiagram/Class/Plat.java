package classDiagram.Class;

import java.util.ArrayList;

public class Plat {
    public String nom;
    private long id;
    private ArrayList<Quantite_Ingredient> ingredients;

    public Plat(String nom, long id, ArrayList<Quantite_Ingredient> ingredients) {
        this.nom = nom;
        this.id = id;
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
