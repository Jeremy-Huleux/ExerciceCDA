package org.example.rh.demo.Model;

import java.util.ArrayList;

public class Directeur extends Employe{


    public Directeur(String nom, String prenom, String date, String poste, int salaire, String service, ArrayList<Enfant> enfants) {
        super(nom, prenom, date, poste, salaire, service, enfants);
    }

    public Directeur(ArrayList<Enfant> enfants) {
        super(enfants);
    }
    @Override
    public double primeAnnuel(){
        return super.primeAnnuel() + 0.07*super.getSalaire();
    }
    @Override
    public double primeAnciennete(){
        return super.primeAnciennete() + 0.03*super.getSalaire();
    }

}
