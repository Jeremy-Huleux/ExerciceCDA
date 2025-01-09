package com.example;



import java.io.IOException;
import java.util.List;

import com.example.DAO.UtilisateursCRUD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.entity.Utilisateur;



public class Formulairelet extends HttpServlet {

    private EntityManagerFactory emf;
    private EntityManager entityManager;
    private UtilisateursCRUD utilisateursCRUD;

    @Override
    public void init() throws ServletException {
        super.init();
        utilisateursCRUD = new UtilisateursCRUD(); // On init le crud a l'init de la page
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {


        List<Utilisateur> utilisateurs = utilisateursCRUD.findAll();
        request.setAttribute("utilisateurs", utilisateurs);





        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/formulaire.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {


    }

}
