package org.example.rh.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.*;

public class Employe {
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Date dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    private String prenom;
    private Date dateEmbauche;
    private String poste;
    private int salaire; //(en k € brut annuel)
    private String service;
    public SimpleDateFormat formatDateFR = new SimpleDateFormat("dd/MM/yyyy");
    public Date aujourdhui = new Date();
    public LocalDate jourDePrime = LocalDate.of(recupAnnee(aujourdhui), 11, 30);
    public LocalDate localdateEmbauche;
    public int anneeAncienneteAuPrime;

    public Employe(String nom, String prenom, String date, String poste, int salaire, String service) {
        this.nom = nom;
        this.prenom = prenom;
        try{
            this.dateEmbauche = formatDateFR.parse(date);
            this.localdateEmbauche = dateEmbauche
                    .toInstant() // Convertit Date en Instant
                    .atZone(ZoneId.systemDefault()) // Obtient le fuseau horaire par défaut
                    .toLocalDate(); // Convertit en LocalDate
            this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        } catch (ParseException e) {
            this.dateEmbauche = new Date();
        }
        this.poste = poste;
        this.salaire = salaire;
        this.service = service;
    }
    public Employe() {
        this.nom = generationNom();
        this.prenom = generationPrenom();
        try{
            this.dateEmbauche = formatDateFR.parse(generationDateEmbauche());
            this.localdateEmbauche = dateEmbauche
                    .toInstant() // Convertit Date en Instant
                    .atZone(ZoneId.systemDefault()) // Obtient le fuseau horaire par défaut
                    .toLocalDate(); // Convertit en LocalDate
            this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        } catch (ParseException e) {
            this.dateEmbauche = new Date();
        }
        this.poste = generationPoste();
        this.salaire = generationSalaire();
        this.service = generationService();
    }

    public String generationNom(){
        // Fonction pour choisir un nom aléatoirement dans une liste
        // Créer une liste de noms

        List<String> noms = Arrays.asList(
                "Tartempion", "Bricoleur", "Trucmuche", "Duroc", "Lapinou", "Foufou", "Biscotte", "Gouzi-Gouzi",
                "Gribouille", "Pommier", "Boule-de-Gomme", "Tigrou", "Pistache", "Gâteau-de-Lune", "Zézette",
                "Roudoudou", "Chocolatine", "Chouquette", "Pépette", "Cacahuète", "Poil-de-Carotte", "Ficelle",
                "Pouet-Pouet", "Papillon", "Brindille", "Boulot-Tordu", "Bouchon-de-Dinde", "Poulet-Frit",
                "Boudin-Noir", "Lollipop", "Paprika", "Carambar", "Gloubiboulga", "Ravioli", "Maracudja", "Bananes-en-Mousse",
                "Saucisson", "Moustache", "Fleur-de-Lys", "Chaussette", "Pastèque", "Bananito", "Clafoutis", "Barbapapa",
                "Souricette", "Moufette", "Bazar", "Nénuphar", "Oursin", "Framboise", "Crêpe-Suzette"
        );

            Random random = new Random();  // Création de l'objet Random
            int index = random.nextInt(noms.size());  // Choisir un index aléatoire dans la liste
            return noms.get(index);  // Retourner le nom correspondant à cet index
    }

    @Override
    public String toString() {
        return "Employe{" +
                "dateEmbauche=" + formatDateFR.format(dateEmbauche) +
                '}';
    }


    public String combienAnneeTravailtoString() {
        return "l'Employé" +
                "à travailler " + combienAnneeTravail() +
                "ans dans notre merveilleuse entreprise" ;
    }

    public int combienAnneeTravail() {
        int anneeAujourdhui = recupAnnee(aujourdhui);
        int anneeEmbauche = recupAnnee(dateEmbauche);

        return anneeAujourdhui - anneeEmbauche;
}

    public int recupAnnee(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public double primeAnnuel(){
        return salaire*0.02;
    }
    public double primeAnciennete(){
        return (salaire * (2 * anneeAncienneteAuPrime)) /100;
    }

    public String affichageBanque(){
        return "Le salarié touché le : 30/11/" + recupAnnee(aujourdhui) +
                "\n la somme de : " + primeAnnuel() + "€ de prime annuel\n" +
                " la somme de : " + primeAnciennete() + "€ de prime d'ancienneté\n" +
                " la somme de : " + salaire/12 + "€ de salaire mensuel\n" +
                " pour un total de  : " + ((salaire/12)+primeAnciennete()+primeAnnuel()) + "€ de salaire\n";
    }
}
