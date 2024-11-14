package org.example.rh.demo.DAO;

import org.example.rh.demo.Model.Employe;
import org.example.rh.demo.Model.Service;

import java.util.ArrayList;
import java.util.List;

public interface ServiceDAO {


        //void ajouterService(Service service);
        void ajouterService(String service);

        void supprimerService(long id);
        void modifierService(String service);
        String trouverServiceParId(long id);
        ArrayList<Service> trouverTousLesServices();

}
