package org.example.rh.demo.Model;
import org.example.rh.demo.Model.*;

import java.util.ArrayList;
import java.util.Collections;


public class Agence {
    private String nom;
    private String adresse;
    private String codePostale;
    private String ville;
    private ArrayList<Employe> listEmploye = new ArrayList<>();
    private boolean restaurant;

    public Agence(String nom, boolean restaurant) {
        this.nom = nom;
        this.restaurant= restaurant;
    }
    public void AjoutEmployee(Employe emp){
        this.listEmploye.add(emp);
    }
    public void GenereEmploye(int nb){
        for(int i=0; i<nb ; i++){
            ArrayList<Enfant> enfants = new ArrayList<>();
            Employe emp = new Employe(enfants);
            AjoutEmployee(emp);
        }
    }

    public void typeRestauration(){
        System.out.println(this.restaurant ? "Restaurant" : "Tickets restaurants");
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "nom='" + nom + '\'' +
                ", listEmploye=" + listEmploye +
                '}';
    }

    public void alphaNom(){

        Collections.sort(listEmploye);

    }
    public void alphaService(){

        Collections.sort(listEmploye);

    }

    public int nbEmployee(){
        return listEmploye.size();
    }

    public ArrayList<Employe> getListEmploye() {
        return listEmploye;
    }

    public void setListEmploye(ArrayList<Employe> listEmploye) {
        this.listEmploye = listEmploye;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

/*





--------------
9 Un directeur est un employé comme un autre qui bénéficie d’un statut particulier. Chaque année, le
directeur reçoit une prime calculée sur le salaire annuel (7% du brut) et sur l’ancienneté (3% du brut
pour chaque année d’ancienneté). Cette prime est versée au 30/11 de chaque année. Créer la classe
Directeur et gérer le calcul de la prime et le versement pour celui-ci.
 */
}
