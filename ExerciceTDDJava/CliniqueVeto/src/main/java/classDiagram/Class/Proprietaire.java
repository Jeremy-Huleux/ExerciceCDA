package classDiagram.Class;

import java.util.ArrayList;

public class Proprietaire {
    private long id;
    private String nom;
    private String prenom;
    private String adresse;
    private int tel;
    private ArrayList<Animal> animauxPossede; //nullable

    public Proprietaire(long id, String nom, String prenom, String adresse, int tel, ArrayList<Animal> animauxPossede) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.tel = tel;
        this.animauxPossede = animauxPossede;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
