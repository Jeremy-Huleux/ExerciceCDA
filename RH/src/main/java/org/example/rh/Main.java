package org.example.rh;

import org.example.rh.Model.Employe;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        //Employee emp1 = new Employe("tintin", "Merlin", new SimpleDateFormat("01*01/2024"), String poste, long salaire, String service)
        System.out.println("Hello world!");
        Employe emp1 = new Employe(18000, "05/02/2020");
        Employe emp2 = new Employe(10500, "15/10/2000");
        Employe emp3 = new Employe(25000, "02/01/2013");
        Employe emp4 = new Employe(9000, "08/07/2024");
        Employe emp5 = new Employe(356000, "09/07/2010");
        System.out.println(emp1.primeAnnuel());
        System.out.println(emp1.primeAnciennete());
        System.out.println(emp2.primeAnnuel());
        System.out.println(emp2.primeAnciennete());
        System.out.println(emp3.primeAnnuel());
        System.out.println(emp3.primeAnciennete());
        System.out.println(emp4.primeAnnuel());
        System.out.println(emp4.primeAnciennete());
        System.out.println(emp5.primeAnnuel());
        System.out.println(emp5.primeAnciennete());
        System.out.println("--------------");
        System.out.println(emp1.affichageBanque());

    }
}