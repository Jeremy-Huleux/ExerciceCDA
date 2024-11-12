package org.example.rh.demo.Factory;

import org.example.rh.demo.DTO.Person;
import org.example.rh.demo.Model.Agence;
import org.example.rh.demo.Model.Employe;

import java.util.ArrayList;

public class PersonFactory {

    public static ArrayList<Person> createPerson(Agence agence) {
        ArrayList<Person> listesPersonnes = new ArrayList<Person>();
        String nomAgence = agence.getNom();
        agence.getListEmploye().forEach(employe -> {
            listesPersonnes.add(
                    new Person(
                            employe.getNom(),
                            employe.getPrenom(),
                            employe.getPoste(),
                            employe.getService(),
                            employe.getSalaire(),
                            employe.getService(),
                            employe.getEnfants(),
                            nomAgence
                    )
            );
        });
        return listesPersonnes;
    }
}
