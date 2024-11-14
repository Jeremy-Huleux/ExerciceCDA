package org.example.rh.demo.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.rh.demo.DAO.EmployeDAO;
import org.example.rh.demo.DAO.EmployeDAOImpl;
import org.example.rh.demo.DAO.ServiceDAO;
import org.example.rh.demo.DAO.ServiceDAOImpl;
import org.example.rh.demo.DB.DatabaseConnector;
import org.example.rh.demo.DTO.Person;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.example.rh.demo.Factory.PersonFactory.createPerson;
import static org.example.rh.demo.Factory.PersonsFactory.createPersons;


public class Agence {
    private String nom;
    private String adresse;
    private String codePostale;
    private String ville;
    private ArrayList<Employe> listEmploye = new ArrayList<>();
    public ObservableList<Person> personnes = FXCollections.observableArrayList();
    //public ObservableList<Employe> employes = FXCollections.observableArrayList();
    private boolean restaurant;
    private Employe employerASuppr;
    private ArrayList<Service> services = new ArrayList<>();


    public Agence(String nom, boolean restaurant) {
        this.nom = nom;
        this.restaurant= restaurant;
        this.services = getBddServices();
        this.setListEmploye(this.getListEmploye());
    }
    public void AjoutEmployee(Employe emp){
        ajoutBDD(emp);
        this.listEmploye.add(emp);
        this.personnes.add(createPerson(emp, this.nom));
    }
    public void ajoutBDD(Employe employe){
        try(Connection connection = DatabaseConnector.getConnection()){
            EmployeDAO employeDAO = new EmployeDAOImpl(connection);
            employeDAO.ajouterEmploye(employe);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void GenereEmployes(int nb){
        for(int i=0; i<nb ; i++){
            ArrayList<Enfant> enfants = new ArrayList<>();
            Employe emp = new Employe(enfants);
            AjoutEmployee(emp);
        }
    }
    public Employe GenereEmploye(){
        ArrayList<Enfant> enfants = new ArrayList<>();
        Employe emp = new Employe(enfants);
        AjoutEmployee(emp);
        return emp;
    }

    public void typeRestauration(){
        System.out.println(this.restaurant ? "Restaurant" : "Tickets restaurants");
    }

    @Override
    public String toString() {
        return "Entreprise{" +
                "nom='" + nom + '\'' +
                ", listEmploye=" + listEmploye +
                '}';
    }
//    public ArrayList<String> ajoutServices(){
//        try(Connection connection = DatabaseConnector.getConnection()){
//            ServiceDAO serviceDAO = new ServiceDAOImpl(connection);
//            return serviceDAO.trouverTousLesServices();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
    public void alphaNom(){

        Collections.sort(listEmploye);

    }
    public void alphaService(){

        Collections.sort(listEmploye);

    }
//
//    public void supprEmploye(){
//        this.listEmploye.remove(listEmploye.size()-1);
//        this.personnes.remove(personnes.size()-1);
//
//    }
    public void modifEmploye(Employe emp){
        try(Connection connection = DatabaseConnector.getConnection()){
            EmployeDAO employeDAO = new EmployeDAOImpl(connection);
            employeDAO.modifierEmploye(emp);
        }catch(SQLException e){
            e.printStackTrace();
        }
        this.personnes.clear();
        this.listEmploye.clear();
        this.listEmploye = getListEmploye();
        //this.personnes = FXCollections.observableArrayList(createPersons(this.listEmploye, this.nom));

        this.listEmploye.forEach(employe -> {
            this.personnes.add(createPerson(employe, this.nom));
        });

    }
    public void supprEmployeSelect(Employe emp){
//        AtomicInteger i = new AtomicInteger();
//        this.listEmploye.forEach(employe -> {
//            if(employe.getId() == emp.getId()){
//                employerASuppr = employe;
//                i.set(this.listEmploye.indexOf(employerASuppr));
//            }
//        });
//
//        this.personnes.remove(i.intValue());
//        this.listEmploye.remove(employerASuppr);

        long id = emp.getId();

        try(Connection connection = DatabaseConnector.getConnection()){
            EmployeDAO employeDAO = new EmployeDAOImpl(connection);
            employeDAO.supprimerEmploye(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        //RemoveIf lambda pour supprimer un employé avec l'id demandé
        this.personnes.removeIf(employe -> employe.getId() == id);
        this.listEmploye.removeIf(employe -> employe.getId() == id);


    }


    public int nbEmployee(){
        return listEmploye.size();
    }

    public ArrayList<Employe> getListEmploye() {
        try(Connection connexion = DatabaseConnector.getConnection()){
            EmployeDAO employeDAO = new EmployeDAOImpl(connexion);
            return employeDAO.trouverTousLesEmployes();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void setListEmploye(ArrayList<Employe> listEmploye) {
        this.listEmploye = listEmploye;
        this.personnes = FXCollections.observableArrayList(createPersons(listEmploye, this.nom));
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Service> getServices() {
        return services;
    }
    public ArrayList<Service> getBddServices() {
        try(Connection connection = DatabaseConnector.getConnection()){
            ServiceDAO serviceDAO = new ServiceDAOImpl(connection);
            return serviceDAO.trouverTousLesServices();
        }catch (SQLException e){
            e.printStackTrace();
        }

return null;
    }
}
