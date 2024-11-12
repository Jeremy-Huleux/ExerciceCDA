package org.example.rh.demo.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.rh.demo.DTO.Person;
import org.example.rh.demo.Model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.example.rh.demo.Factory.PersonFactory.createPerson;


public class Agence {
    private String nom;
    private String adresse;
    private String codePostale;
    private String ville;
    private ArrayList<Employe> listEmploye = new ArrayList<>();
    public ObservableList<Person> personnes = FXCollections.observableArrayList();
    private boolean restaurant;
    private List<String> services = Arrays.asList(
            "Informatique", "Ressources Humaines", "Marketing", "Ventes",
            "Finance", "Développement", "Design", "Production",
            "Logistique", "Support Client", "Direction Générale",
            "Communication", "Juridique", "R&D", "Systèmes d'Information",
            "Achats", "Commercial", "Gestion de Projet", "Qualité",
            "Sécurité",
            "Service Machine à Café", "Réparation de Post-it", "Équipe des Chaussettes Perdues",
            "Détente et Bien-être", "Maintenance des Chaises de Bureau", "Coordination des Siestes",
            "Réchauffement de Tasses", "Consultants en Bureau Calme", "Service Antivol de Stylos",
            "Supervision des Cafés", "Gestion des Réunions Inutiles", "Sécurité des Cookies",
            "Optimisation des Pauses Déjeuner", "Développement de Sourires", "Services de Motivation",
            "Nettoyage de l'Espace Conférence", "Responsable de la Cohérence des Plantes"
    );

    public Agence(String nom, boolean restaurant) {
        this.nom = nom;
        this.restaurant= restaurant;
    }
    public void AjoutEmployee(Employe emp){
        this.listEmploye.add(emp);
        this.personnes.add(createPerson(emp, this.nom));
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

    public void supprEmploye(){
        this.listEmploye.remove(listEmploye.size()-1);
        this.personnes.remove(personnes.size()-1);
    }
    public void modifEmploye(){
        //OULAOULAOULAOULAOULAOULAOULAOULA
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

    public List<String> getServices() {
        return services;
    }
}
