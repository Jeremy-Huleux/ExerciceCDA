package org.example.rh.Model;

import java.util.ArrayList;

public class Entreprise {
    private String nom;
    private ArrayList<Employe> listEmploye;

    Employe emp1 = new Employe("Martin", "Alice", "15/03/2018", "Développeur", 35000, "Informatique");
    Employe emp2 = new Employe("Dupont", "Benoît", "22/07/2020", "Analyste", 42000, "Finance");
    Employe emp3 = new Employe("Durand", "Clara", "12/11/2019", "Technicien", 30000, "Support Technique");
    Employe emp4 = new Employe("Petit", "David", "05/06/2017", "Chef de Projet", 50000, "Gestion de Projet");
    Employe emp5 = new Employe("Moreau", "Emma", "18/09/2021", "Responsable RH", 45000, "Ressources Humaines");
    Employe emp6 = new Employe("Rodriguez", "José", "10/05/2003", "Technicien", 10000, "Informatique");

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
