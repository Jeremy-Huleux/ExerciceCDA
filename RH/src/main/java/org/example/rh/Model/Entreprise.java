package org.example.rh.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Entreprise {
    private String nom;
    private ArrayList<Employe> listEmploye = new ArrayList<>();

    public Entreprise(String nom) {
        this.nom = nom;
    }
    public void AjoutEmployee(Employe emp){
        this.listEmploye.add(emp);
    }
    public void GenereEmploye(int nb){
        for(int i=0; i<nb ; i++){
            Employe emp = new Employe();
            AjoutEmployee(emp);
        }
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "nom='" + nom + '\'' +
                ", listEmploye=" + listEmploye +
                '}';
    }

    public ArrayList<Employe> alpha(){
        ArrayList<Employe> alpha = new ArrayList<Employe>();
        Collections.sort(listEmploye);
        return alpha;
    }

    public int nbEmployee(){
        return listEmploye.size();
    }

//    public ArrayList<String> generationNomPrenom(){
//
//    }




/*
Afin de créer un reporting d’informations sur les employés de l’entreprise,
établir une liste (array) d’employés en y ajoutant les 5 objets que vous venez de créer.
Ensuite, utiliser les méthodes prévues dans les listes pour :
 afficher le nombre d’employés de l’entreprise,
 afficher toutes les informations des employés par ordre alphabétique sur le nom et le prénom,
 afficher toutes les informations des employés par ordre alphabétique de service, nom et prénom
 afficher le montant total du coût que représentent tous les salariés (masse salariale) calculé à partir des salaire et des primes.
 */
}
