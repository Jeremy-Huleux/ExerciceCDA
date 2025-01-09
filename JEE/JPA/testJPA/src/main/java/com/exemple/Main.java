package com.exemple;

import com.exemple.entity.Utilisateur;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceJerem");

		EntityManager entityManager = emf.createEntityManager();

		Utilisateur utilisateur = entityManager.find(Utilisateur.class, 1);

        System.out.println(utilisateur);
    }
}