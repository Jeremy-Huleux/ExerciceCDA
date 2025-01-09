package com.exemple.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUtilisateur", nullable = false)
    private Long id;

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "pseudo", length = 50)
    private String pseudo;

    @Column(name = "mdp", unique = true, length = 150)
    private String mdp;

    @Column(name = "dateModif", unique = true)
    private LocalDateTime dateModif;

    @Column(name = "dateInscription")
    private LocalDateTime dateInscription;

    @Column(name= "jeton")
    private String jeton;

    @Column(name = "bio")
    private String biographie;

    @Column(name = "idPreferenceUtilisateur")
    private int idPreferenceUtilisateur;

    @Column(name = "idMedia")
    private int idMedia;

    @Column(name = "idRole")
    private int idRole;

    @Column(name= "email")
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public LocalDateTime getDateModif() {
        return dateModif;
    }

    public void setDateModif(LocalDateTime dateModif) {
        this.dateModif = dateModif;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDateTime dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getJeton() {
        return jeton;
    }

    public void setJeton(String jeton) {
        this.jeton = jeton;
    }

    public String getBiographie() {
        return biographie;
    }

    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public int getIdPreferenceUtilisateur() {
        return idPreferenceUtilisateur;
    }

    public void setIdPreferenceUtilisateur(int idPreferenceUtilisateur) {
        this.idPreferenceUtilisateur = idPreferenceUtilisateur;
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }


    public String getPseudo() {
        return pseudo;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + (id != null ? id : "null") +
                ", nom='" + (nom != null ? nom : "null") + '\'' +
                ", prenom='" + (prenom != null ? prenom : "null") + '\'' +
                ", pseudo='" + (pseudo != null ? pseudo : "null") + '\'' +
                ", mdp='" + (mdp != null ? mdp : "null") + '\'' +
                ", dateModif=" + (dateModif != null ? dateModif : "null") +
                ", dateInscription=" + (dateInscription != null ? dateInscription : "null") +
                ", jeton='" + (jeton != null ? jeton : "null") + '\'' +
                ", biographie='" + (biographie != null ? biographie : "null") + '\'' +
                ", idPreferenceUtilisateur=" + idPreferenceUtilisateur +
                ", idMedia=" + idMedia +
                ", idRole=" + idRole +
                ", email='" + (email != null ? email : "null") + '\'' +
                '}';
    }

}