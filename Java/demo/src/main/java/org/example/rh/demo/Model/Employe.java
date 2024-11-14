package org.example.rh.demo.Model;

import org.example.rh.demo.DAO.EmployeDAO;
import org.example.rh.demo.DAO.EmployeDAOImpl;
import org.example.rh.demo.DAO.ServiceDAO;
import org.example.rh.demo.DAO.ServiceDAOImpl;
import org.example.rh.demo.DB.DatabaseConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class Employe implements Comparable<Employe>{
    private long id;
    private String nom;
    private boolean cheques;
    private ArrayList<Enfant> enfants;
    private String prenom;
    private LocalDate dateEmbauche;
    private String poste;
    private int salaire; //(en k € brut annuel)
    private String serviceString;
    //public SimpleDateFormat formatDateFR = new SimpleDateFormat("dd/MM/yyyy");
    public Date aujourdhui = new Date();
    public LocalDate jourDePrime = LocalDate.of(recupAnnee(aujourdhui), 11, 30);
    public LocalDate localdateEmbauche;
    public int anneeAncienneteAuPrime;
    public long serviceId;
    private Service service;

    public Employe(String name, String prename, LocalDate date, String poste, int salaire, String service, ArrayList<Enfant> enfants) {
        this.id = genereId();
        this.nom = name;
        this.prenom = prename;
        // Convertir LocalDate en Date
        this.dateEmbauche = date;
        this.localdateEmbauche = date;
        this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        this.poste = poste;
        this.salaire = salaire;
        this.serviceString = service;

        this.chequeOrNot();
        this.enfants = enfants != null ? enfants : new ArrayList<Enfant>();
    }

    public Employe(long id, String name, String prename, LocalDate date, String poste, int salaire, String service, ArrayList<Enfant> enfants) {
        this.id = id;
        this.nom = name;
        this.prenom = prename;
        // Convertir LocalDate en Date
        this.dateEmbauche = date;
        this.localdateEmbauche = date;
        this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        this.poste = poste;
        this.salaire = salaire;
        this.serviceString = service;

        this.chequeOrNot();
        this.enfants = enfants != null ? enfants : new ArrayList<Enfant>();
    }

    public Employe(String name, String prename, LocalDate date, String poste, int salaire, String service) {
        this.id = genereId();
        this.nom = name;
        this.prenom = prename;
        // Convertir LocalDate en Date
        this.dateEmbauche = date;
        this.localdateEmbauche = date;
        this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        this.poste = poste;
        this.salaire = salaire;
        this.serviceString = service;

        this.chequeOrNot();
        this.enfants = enfants != null ? enfants : new ArrayList<Enfant>();
    }
    public Employe(long id, String name, String prename, LocalDate date, String poste, int salaire, String service) {
        this.id = id;
        this.nom = name;
        this.prenom = prename;
        // Convertir LocalDate en Date
        this.dateEmbauche = date;
        this.localdateEmbauche = date;
        this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        this.poste = poste;
        this.salaire = salaire;
        this.serviceString = service;

        this.chequeOrNot();
        this.enfants = enfants != null ? enfants : new ArrayList<Enfant>();
    }
    public Employe(long id, String name, String prename, LocalDate date, String poste, int salaire, Long service) {
        this.id = id;
        this.nom = name;
        this.prenom = prename;
        // Convertir LocalDate en Date
        this.dateEmbauche = date;
        this.localdateEmbauche = date;
        this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        this.poste = poste;
        this.salaire = salaire;
        this.serviceId = service; //TODO : Récupérer le service dans la BDD
        this.serviceString = getServiceStringBdd();
        this.chequeOrNot();
        this.enfants = enfants != null ? enfants : new ArrayList<Enfant>();
    }
    public Employe(String name, String prename, LocalDate date, String poste, int salaire, Long service) {
        this.nom = name;
        this.prenom = prename;
        // Convertir LocalDate en Date
        this.dateEmbauche = date;
        this.localdateEmbauche = date;
        this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        this.poste = poste;
        this.salaire = salaire;
        this.serviceId = service;
        this.serviceString = getServiceStringBdd();
        this.chequeOrNot();
        this.enfants = enfants != null ? enfants : new ArrayList<Enfant>();
    }


    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

//    public void setDateEmbauche(Date dateEmbauche) {
//        this.dateEmbauche = dateEmbauche;
//    }

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

    public String getServiceStringBdd() {
        try(Connection connection = DatabaseConnector.getConnection()){
            ServiceDAO serviceDAO = new ServiceDAOImpl(connection);
            return serviceDAO.trouverServiceParId(this.serviceId);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public String getServiceString(){
        return serviceString;
    }
    public void setService(Service service) {
        this.service = service;
    }


    public Employe(ArrayList<Enfant> enfants) {
        this.id = genereId();
        this.nom = generationNom();
        this.enfants = enfants != null ? enfants : new ArrayList<Enfant>();
        this.prenom = generationPrenom();
        this.dateEmbauche = generationDateEmbauche();
        this.localdateEmbauche = dateEmbauche; // Convertit en LocalDate
        this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        this.poste = generationPoste();
        this.salaire = generationSalaire();
        this.serviceString = generationService();
        this.chequeOrNot();
        //this.nbEnfant = generationNbEnfants();
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

    public String generationPrenom(){
        // Fonction pour choisir un nom aléatoirement dans une liste
        // Créer une liste de noms

        List<String> prenoms = Arrays.asList(
                "Alice", "Benoît", "Clara", "David", "Élise", "Marc", "Sophie", "Pierre", "Julien", "Nathalie",
                "Antoine", "Charlotte", "Lucas", "Emma", "Paul", "Caroline", "Vincent", "Laurie", "Thomas",
                "Julie", "Pierre-Alexandre", "Gabriel", "Mélanie", "Léo", "Louise", "Catherine", "François",
                "Laure", "Georges", "Juliette", "Antonia", "Bernadette", "Chloé", "Olivier", "Marion",
                "Hugo", "Adèle", "Léa", "Thierry", "Amélie", "Mathieu", "Clément", "Victor", "Valérie",
                "Amandine", "Édouard", "Michel", "Véronique", "Thérèse", "Geoffrey", "Cécile", "Louis", "Violette"
        );

        Random random = new Random();  // Création de l'objet Random
        int index = random.nextInt(prenoms.size());  // Choisir un index aléatoire dans la liste
        return prenoms.get(index);  // Retourner le nom correspondant à cet index
    }
    public LocalDate generationDateEmbauche(){
        Random random = new Random();
        // Créer une date de base : ici, nous utilisons la date actuelle
        LocalDate today = LocalDate.now();
        // Générer un nombre de jours aléatoire dans le passé, par exemple, entre 1 et 10 ans
        long yearsBack = random.nextInt(35);  // Choisit un nombre d'années aléatoire (entre 0 et 9 ans)
        // Calculer la date aléatoire en reculant dans le temps
        LocalDate randomPastDate = today.minusYears(yearsBack);
        // Pour plus de précision on réduis au niveau des mois ou des jours
        long daysBack = random.nextInt(365);  // Générer des jours aléatoires pour l'année choisie
        randomPastDate = randomPastDate.minusDays(daysBack);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");//on regenere un formatteur car le format locadate a besoin d'un formateur DateTimeFormatter
        return randomPastDate;
    }
    public long genereId(){
        Random random = new Random();
        return random.nextLong(999999999999999999L);  // Choisit un nombre aléatoire (entre 0 et 999999999999999999)
    }
    public String generationPoste(){

        // Liste des postes occupés
        List<String> postes = Arrays.asList(
                "Directeur Général", "Chef de Projet", "Développeur Logiciel", "Responsable Marketing",
                "Analyste de Données", "Consultant en Management", "Chef de Produit", "Ingénieur en Logiciel",
                "Responsable Ressources Humaines", "Chargé de Communication", "Directeur des Opérations",
                "Responsable Qualité", "Architecte Cloud", "Chef de Secteur", "Responsable Développement",
                "Consultant en Transformation Digitale", "Data Scientist", "Responsable de la Stratégie",
                "Coordinateur Logistique", "Responsable Financier",
                "Super Héros en Chef", "Génie de la Machine à Café", "Maître Jedi de l'Informatique",
                "Spécialiste en Sieste Efficace", "Directeur des Rires et des Sourires", "Conseiller en Pause Déjeuner",
                "Capitaine du Bureau", "Mordeur de Tasse", "Sorcier des Claviers", "Expert en Lecture de Mails",
                "Architecte de Gâteau d'Anniversaire", "Seigneur des Post-it", "Vérificateur de Correcteur Orthographique",
                "Maître des Dossiers Perdus", "Chasseur de Réunions Inutiles", "Consultant en Détente au Bureau",
                "Responsable des Couches de Café", "Jardinier de la Boîte à Outils", "Conseiller en Évasion du Bureau",
                "Garde du Corps de la Machine à Café"
        );

        Random random = new Random();  // Création de l'objet Random
        int index = random.nextInt(postes.size());  // Choisir un index aléatoire dans la liste
        return postes.get(index);  // Retourner le nom correspondant à cet index
    }
    public String generationService(){
        // Liste des postes occupés
        List<String> services = Arrays.asList(
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
        Random random = new Random();  // Création de l'objet Random
        int index = random.nextInt(services.size());  // Choisir un index aléatoire dans la liste
        return services.get(index);  // Retourner le nom correspondant à cet index
    }
    public int generationSalaire(){
        return 10000 + (int)(Math.random() * (1000000000 - 10000));
    }

    public int generationNbEnfants(){
        Random random = new Random();
        return random.nextInt(20);
    }

    public String combienAnneeTravailtoString() {
        return "l'Employé" +
                "à travailler " + combienAnneeTravail() +
                "ans dans notre merveilleuse entreprise" ;
    }

    public int combienAnneeTravail() {
        int anneeAujourdhui = recupAnnee(aujourdhui);//java.util.Date.from(dateEmbauche.atStartOfDay(ZoneId.systemDefault()).toInstant());
        int anneeEmbauche = recupAnnee(java.util.Date.from(dateEmbauche.atStartOfDay(ZoneId.systemDefault()).toInstant()));

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


    @Override
    public int compareTo(Employe emp){
        int r = this.serviceString.compareTo(emp.serviceString);

        if(r==0) return this.serviceString.compareTo(emp.serviceString);

        return r;

    }
    public void chequeOrNot(){
        this.cheques = combienAnneeTravail() > 1 ?  true : false;
    }

    public int prixChequeNoel(){
        AtomicInteger prixCheque = new AtomicInteger();
        if (this.enfants.size() != 0){
            this.enfants.forEach(enfant -> {
                prixCheque.addAndGet(enfant.getAge() <= 10 ? 20 :
                        (enfant.getAge() > 10 && enfant.getAge() <= 15) ? 30 :
                                (enfant.getAge() > 15 && enfant.getAge() <= 18) ? 50 : 0);
            });
        }
        return prixCheque.get();
    }

    public boolean isCheques() {
        return cheques;
    }

    public void setCheques(boolean cheques) {
        this.cheques = cheques;
    }

    public ArrayList<Enfant> getEnfants() {
        return enfants;
    }

    public void setEnfants(ArrayList<Enfant> enfants) {
        this.enfants = enfants;
    }

    public Employe modifEmploye(Employe emp){
        this.nom = emp.getNom();
        this.prenom = emp.getPrenom();
        this.dateEmbauche = emp.getDateEmbauche();
        this.localdateEmbauche = emp.localdateEmbauche;
        this.anneeAncienneteAuPrime = Period.between(localdateEmbauche, jourDePrime).getYears();
        this.poste = emp.getPoste();
        this.salaire = emp.getSalaire();
        this.service = emp.getServiceObj();
        this.serviceString = emp.getServiceString();
        this.chequeOrNot();
        this.enfants = enfants != null ? enfants : new ArrayList<Enfant>();

        return emp;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "service='" + service + '\'' +
                ", salaire=" + salaire +
                ", poste='" + poste + '\'' +
                ", dateEmbauche=" + dateEmbauche +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", Cheque Vacance ? ='" + cheques + '\'' +
                ", Cheque Noêl ? ='" + (prixChequeNoel() != 0 ? prixChequeNoel() : "aucun").toString() + '\'' +
                ", combien de enfant ? ='" + enfants.size() + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }


    public Service getServiceObj() {
        return this.service = service;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }
}
       /*
Chaque année, des chèques Noël sont distribués aux enfants des employés. Le montant du chèque
Noël dépend de l’âge des enfants :
 20 euros pour les enfants de 0 à 10 ans
 30 euros pour les enfants de 11 à 15 ans.
 50 euros pour les enfants de 16 à 18 ans.
Modifier le programme afin de gérer l’attribution des chèques Noël aux enfants des salariés. Afficher
dans la console si l’employé a le droit d’avoir des chèques Noël (Oui/Non). Pour ce faire, établir les
conditions nécessaires dans le programme. Et si la réponse est Oui, afficher dans la console combien
de chèques de chaque montant sera distribué à l’employé. Si aucun chèque n’est distribué pour une
tranche d’âge, ne pas afficher dans la console.
*/