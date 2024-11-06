package org.example.rh;

import org.example.rh.Model.Employe;
import org.example.rh.Model.Entreprise;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Entreprise entreprise1 = new Entreprise("ZaeloTech");
        entreprise1.GenereEmploye(5);

        System.out.println(entreprise1.nbEmployee());




    }
}