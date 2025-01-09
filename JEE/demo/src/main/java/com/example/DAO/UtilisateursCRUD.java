package com.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import com.example.entity.Utilisateur;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class UtilisateursCRUD {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public UtilisateursCRUD() {
        emf = Persistence.createEntityManagerFactory("persistenceJerem");
        entityManager = emf.createEntityManager();
    }

    //Prendre tous les utilisateurs
    public List<Utilisateur> findAll(){
        //On créer un query typé par la class Utilisateur (entity)                      //Requete personnalisé
        TypedQuery<Utilisateur> query = entityManager.createQuery("SELECT u FROM Utilisateur u", Utilisateur.class);
        //Remplace preparestatement etc... cela retourne directement une List en resultat et typé en Utilisateur, car TypedQuery
        return query.getResultList();
    }

}
