package org.example.rh.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Employe {
    private String nom;
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
        } catch (ParseException e) {
            this.dateEmbauche = new Date();
        }
        this.poste = poste;
        this.salaire = salaire;
        this.service = service;
    }

    public Employe(String date){
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
    }
    public Employe(int salaire){
        this.salaire = salaire;
    }
    public Employe(int salaire, String date){
        this.salaire = salaire;
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
/*
primeAnnuel = salaire annuel + 5%
primeAnciennete = salaire annuel + (2*nbAnneeAnciennete)%

prime versée le 30/11



Chaque année, l’employé reçoit une prime calculée sur le salaire annuel (5% du brut) et sur l’ancienneté
(2% du brut pour chaque année d’ancienneté). Cette prime est versée au 30/11 de chaque année. Dans la classe
Employe, écrire le(s) méthode(s) permettant de déduire le montant de cette prime et de donner l’ordre de transfert
à la banque le jour du versement. L’ordre de transfert à la banque sera juste un message écrit dans la console
spécifiant que l’ordre de transfert a été envoyé à la banque avec mention du montant.
Afin de tester les éléments ci-dessus, créer au minimum 5 objets Employe avec des informations sensiblement
différentes. Ecrire dans le programme principal l’affichage du montant des primes de chaque employé.
La date du versement de la prime doit également être vérifiée. Pour tester, fixer cette date à la date du jour,
faire les conditions nécessaires dans le code et tester en changeant de date afin de voir si le message voulu s’affiche.

 */