package classDiagram.Class;

import java.sql.Date;
import java.util.ArrayList;

public class RendezVous {
    private Date date;
    private ArrayList<Affection> affections;
    private Medecin medecinResponsable;
    private Proprietaire proprio;
    private Animal animalConcerner;

    public RendezVous(Date date, Medecin medecinResponsable) {
        this.date = date;
        this.affections = affections;
        this.medecinResponsable = medecinResponsable;
        this.proprio = proprio;
        this.animalConcerner = animalConcerner;
    }

    public RendezVous(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<Affection> getAffections() {
        return affections;
    }

    public void setAffections(ArrayList<Affection> affections) {
        this.affections = affections;
    }

    public Medecin getMedecinResponsable() {
        return medecinResponsable;
    }

    public void setMedecinResponsable(Medecin medecinResponsable) {
        this.medecinResponsable = medecinResponsable;
    }

    public Proprietaire getProprio() {
        return proprio;
    }

    public void setProprio(Proprietaire proprio) {
        this.proprio = proprio;
    }

    public Animal getAnimalConcerner() {
        return animalConcerner;
    }

    public void setAnimalConcerner(Animal animalConcerner) {
        this.animalConcerner = animalConcerner;
    }
}
