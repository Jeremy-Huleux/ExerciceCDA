package org.example.rh.demo.DAO;

import org.example.rh.demo.Model.Employe;

import java.util.List;

public interface EmployeDAO {
    void ajouterEmploye(Employe employe);
    void supprimerEmploye(long id);
    void modifierEmploye(Employe employe);
    Employe trouverEmployeeParId(long id);
    List<Employe> trouverTousLesEmployes();
}
