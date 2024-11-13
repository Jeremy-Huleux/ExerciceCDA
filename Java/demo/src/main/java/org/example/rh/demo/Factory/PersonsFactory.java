package org.example.rh.demo.Factory;

import org.example.rh.demo.DTO.Person;
import org.example.rh.demo.Model.Agence;
import org.example.rh.demo.Model.Employe;

import java.util.ArrayList;

import static org.example.rh.demo.Factory.PersonFactory.createPerson;

public class PersonsFactory {

    public static ArrayList<Person> createPersons(Agence agence) {
        ArrayList<Person> listesPersonnes = new ArrayList<Person>();
        agence.getListEmploye().forEach(employe -> {
            listesPersonnes.add(createPerson(employe, agence.getNom()));
        });
        return listesPersonnes;
    }
    public static ArrayList<Person> createPersons(ArrayList<Employe> employes) {
        ArrayList<Person> listesPersonnes = new ArrayList<Person>();
        employes.forEach(employe -> {
            listesPersonnes.add(createPerson(employe));
        });
        return listesPersonnes;
    }
    public static ArrayList<Person> createPersons(ArrayList<Employe> employes, String nomAgence) {
        ArrayList<Person> listesPersonnes = new ArrayList<Person>();
        employes.forEach(employe -> {
            listesPersonnes.add(createPerson(employe, nomAgence));
        });
        return listesPersonnes;
    }
}
