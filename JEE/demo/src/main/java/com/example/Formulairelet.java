package com.example;



import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        utilisateurs.forEach(user -> {
            user.getDateInscription();
            user.getDateModif();



            // Convertir LocalDateTime en java.util.Date

            //On verifie si getDate est null si oui on mets la date d'aujourd'hui facon Optional
            LocalDateTime formattedDateInscrLocal = Optional.ofNullable(user)
                                                .map(Utilisateur::getDateInscription)
                                                .orElse(LocalDateTime.now());
            LocalDateTime formattedDateModifLocal = Optional.ofNullable(user)
                                                .map(Utilisateur::getDateModif)
                                                .orElse(LocalDateTime.now());
            Date formattedDateModif = Date.from(formattedDateModifLocal.atZone(ZoneId.systemDefault()).toInstant());
            Date formattedDateInscr = Date.from(formattedDateInscrLocal.atZone(ZoneId.systemDefault()).toInstant());
            //façon ternaire
//            Date formattedDateModif = user.getDateModif() != null ? Date.from(user.getDateModif().atZone(ZoneId.systemDefault()).toInstant()) : new Date();
//            Date formattedDateInscr = user.getDateInscription() != null ? Date.from(user.getDateInscription().atZone(ZoneId.systemDefault()).toInstant()) : new Date();

            // Passer la date à la JSP
            request.setAttribute("formattedDateInscr_"+user.getIdUtilisateur(), formattedDateInscr);
            request.setAttribute("formattedDateModif_"+user.getIdUtilisateur(), formattedDateModif);

        });
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
