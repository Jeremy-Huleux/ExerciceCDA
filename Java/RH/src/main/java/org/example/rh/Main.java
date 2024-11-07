package org.example.rh;

import org.example.rh.Model.Agence;
import org.example.rh.Model.Directeur;
import org.example.rh.Model.Employe;
import org.example.rh.Model.Enfant;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Agence agence1 = new Agence("ZaeloTech", true);
        agence1.GenereEmploye(4);
        Enfant enf1 = new Enfant("nom", "prenom", 10);
        Enfant enf3 = new Enfant("nom", "prenom", 18);
        Enfant enf2 = new Enfant("nom", "prenom", 15);
        ArrayList<Enfant> enfants = new ArrayList<Enfant>();
        enfants.add(enf1);
        enfants.add(enf2);
        enfants.add(enf3);

        Directeur dir1 = new Directeur("String nom", "String prenom", "15/02/2020", "poste", 15000, "test", enfants);
        Employe emp1 = new Employe("String nom", "String prenom", "15/02/2020", "poste", 15000, "test", enfants);


        System.out.println(emp1.primeAnciennete());
        System.out.println(dir1.primeAnciennete());


//        agence1.AjoutEmployee(emp1);
//        Employe emp1 = new Employe();
//        Employe emp2 = new Employe();
//        ArrayList<Employe> emps = new ArrayList<>();
//        emps.add(emp1);
//        emps.add(emp2);
//        agence1.alphaNom();
//
//        agence1.getListEmploye().forEach(emp -> {
//            System.out.println(emp);
//        });
//
//        agence1.typeRestauration();



    }
}