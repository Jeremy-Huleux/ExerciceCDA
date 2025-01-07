package com.exemple.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "prenom", length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String prenom;

    @Column(name = "pseudo", length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String pseudo;

    @Column(name = "nom", length = 50)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String nom;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}