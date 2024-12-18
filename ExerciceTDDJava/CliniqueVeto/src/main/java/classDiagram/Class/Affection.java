package classDiagram.Class;

import java.util.ArrayList;

public class Affection {
    public String nom;
    public String nomScientifique;
    public ArrayList<Informations> info;

    public Affection(String nom, String nomScientifique, ArrayList<Informations> info) {
        this.nom = nom;
        this.nomScientifique = nomScientifique;
        this.info = info;
    }


}
