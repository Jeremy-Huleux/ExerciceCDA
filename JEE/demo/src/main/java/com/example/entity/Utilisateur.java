package com.example.entity;

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
    private Long idUtilisateur;

    @Column(name = "nom", length = 50, nullable = true)
    private String nom;

    @Column(name = "prenom", length = 50, nullable = true)
    private String prenom;

    @Column(name = "pseudo", length = 50, nullable = true)
    private String pseudo;

    @Column(name = "mdp", unique = true, length = 150, nullable = true)
    private String mdp;

    @Column(name = "dateModif", unique = true, nullable = true)
    private LocalDateTime dateModif;

    @Column(name = "dateInscription", nullable = true)
    private LocalDateTime dateInscription;

    @Column(name= "jeton", nullable = true)
    private String jeton;

    @Column(name = "bio", nullable = true)
    private String biographie;

    @Column(name = "idPreferenceUtilisateur", nullable = true)
    private Integer idPreferenceUtilisateur;

    @Column(name = "idMedia", nullable = true)
    private Integer idMedia;

    @Column(name = "idRole", nullable = true)
    private Integer idRole;

    @Column(name= "email", nullable = true)
    private String email;


    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long id) {
        this.idUtilisateur = id;
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
                "id=" + (idUtilisateur != null ? idUtilisateur : "null") +
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