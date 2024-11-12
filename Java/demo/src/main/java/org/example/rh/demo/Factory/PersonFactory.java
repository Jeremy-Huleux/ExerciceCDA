package org.example.rh.demo.Factory;

import org.example.rh.demo.DTO.Person;
import org.example.rh.demo.Model.Agence;
import org.example.rh.demo.Model.Employe;

import java.util.ArrayList;

public class PersonFactory {

    public static Person createPerson(Employe employe, String agence) {
        return  new Person(
                            employe.getNom(),
                            employe.getPrenom(),
                            employe.getDateEmbauche(),
                            employe.getPoste(),
                            employe.getSalaire(),
                            employe.getService(),
                            employe.getEnfants(),
                            agence
                    );
    }
}
