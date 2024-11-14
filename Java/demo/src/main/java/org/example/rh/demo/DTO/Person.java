package org.example.rh.demo.DTO;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.example.rh.demo.Model.Agence;
import org.example.rh.demo.Model.Employe;
import org.example.rh.demo.Model.Enfant;

import java.time.LocalDate;
import java.util.ArrayList;

public class Person extends Employe {

    private final SimpleStringProperty name;
    private final SimpleStringProperty prename;
    private final SimpleStringProperty poste;
    private final SimpleStringProperty service;
    private final SimpleIntegerProperty salaire;
    private final SimpleStringProperty agence;

    public Person(long id, String nom, String prenom, LocalDate date, String poste, int salaire, String serviceString, ArrayList<Enfant> enfants, String agence) {
        super(id ,nom, prenom, date, poste, salaire, serviceString, enfants);
        this.name = new SimpleStringProperty(nom);
        this.prename = new SimpleStringProperty(prenom);
        this.poste = new SimpleStringProperty(poste);
        this.service = new SimpleStringProperty(serviceString);
        this.salaire = new SimpleIntegerProperty(salaire);
        this.agence = new SimpleStringProperty(agence);

    }
    public Person(long id, String nom, String prenom, LocalDate date, String poste, int salaire, String serviceString, ArrayList<Enfant> enfants) {
        super(id ,nom, prenom, date, poste, salaire, serviceString, enfants);
        this.name = new SimpleStringProperty(nom);
        this.prename = new SimpleStringProperty(prenom);
        this.poste = new SimpleStringProperty(poste);
        this.service = new SimpleStringProperty(serviceString);
        this.salaire = new SimpleIntegerProperty(salaire);
        this.agence = new SimpleStringProperty("");
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name){
        this.name.set(name);
    }

    public String getPrename() {
        return prename.get();
    }

    public void setPrename(String prename){
        this.prename.set(prename);
    }

    public String getPoste() {
        return poste.get();
    }


    public void setPoste(String poste){
        this.poste.set(poste);
    }

    public String getService() {
        return service.get();
    }

    public void setService(String service){
        this.service.set(service);
    }

    public String getSalaireDTO() {
        return String.valueOf(salaire.get());
    }

    public void setSalaire(int salaire){
        this.salaire.set(salaire);
    }

    public String getAgence() {
        return String.valueOf(agence.get());
    }

    public void setAgence(String agence){
        this.agence.set(agence);
    }

}
