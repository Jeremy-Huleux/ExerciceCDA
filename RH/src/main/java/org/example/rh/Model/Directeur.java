package org.example.rh.Model;

import java.util.ArrayList;

public class Directeur extends Employe{


    public Directeur(String nom, String prenom, String date, String poste, int salaire, String service, ArrayList<Enfant> enfants) {
        super(nom, prenom, date, poste, salaire, service, enfants);
    }

    public Directeur(ArrayList<Enfant> enfants) {
        super(enfants);
    }
}
