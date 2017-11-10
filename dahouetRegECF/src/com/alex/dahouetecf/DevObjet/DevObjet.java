/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.dahouetecf.DevObjet;

import com.alex.dahouetecf.DevObjet.model.Commissaire;
import com.alex.dahouetecf.DevObjet.model.Licencie;
import com.alex.dahouetecf.DevObjet.model.Personne;
import com.alex.dahouetecf.DevObjet.model.Proprietaire;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

/**
 *
 * @author alex
 */
public class DevObjet {
    /**
     * @param args the command line arguments
     */
    static ArrayList<Personne> per;

    public static void main(String[] args) {

        //jeu d'essai avec 2 propriétaires, 3 licenciés et 1 Commissaire.
        Proprietaire p1 = new Proprietaire("Krokro", "Konrad", "konrad@gmail.com", 1995);
        Proprietaire p2 = new Proprietaire("Deniel", "Seb", "seb@gmail.com", 1983);
        Licencie l1 = new Licencie(2341, 56.1, 2012, "Giraud", "Ben", "ben@gmail.com", 1996);
        Licencie l2 = new Licencie(4532, 9.9, 2016, "Bidal", "JC", "jc@gmail.com", 1985);
        Licencie l3 = new Licencie(9867, 21, 2017, "Giraud", "Alex", "alex@gmail.com", 1988);
        Commissaire c1 = new Commissaire("Comité de Bretagne", "Bob", "Leponge", "bobo@gmail.com", 1980);

        //ajout des 6 personnes dans une collection pour l'affichage d'une liste
        per = new ArrayList<>();

        per.add(p1);
        per.add(p2);
        per.add(l1);
        per.add(l2);
        per.add(l3);
        per.add(c1);

        //affichage des personnes de la collection "per"
        for (int i = 0; i < per.size(); i++) {
            System.out.println(per.get(i));
        }

        System.out.println("Moyenne d'age du groupe : " + calculMoyenneAge() + " ans");

        System.out.println("Médiane d'age du groupe : " + medianeAge());

        System.out.println("\n");

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2017);
        try {
            l3.calculPoints(10, c);
            System.out.println("Points de " + l3.getPrenom() + " : " + l3.getPointsFFV() + " points");
        } catch (Exception ex) {
            System.out.println("Points non ajoutés, date non identique. " + l3.getPrenom() + " : " + l3.getPointsFFV() + " points");
        }

    }

    public static double calculMoyenneAge() {

        double age = 0;
        double sommeAge = 0;
        double moyenne = 0;
        for (int i = 0; i < per.size(); i++) {
            age = per.get(i).calculAge();
            sommeAge += age;
        }
        moyenne = sommeAge / per.size();
        return moyenne;
    }

    public static double medianeAge() {

        int tblAges[] = new int[per.size()];

        for (int i = 0; i < per.size(); i++) {
            tblAges[i] = per.get(i).calculAge();
        }

        //classement en ordre croissant
        Arrays.sort(tblAges);
        
        int milieu = tblAges.length / 2;

        if (tblAges.length % 2 == 1) {
            return tblAges[milieu];
        } else {
            return (tblAges[milieu - 1] + tblAges[milieu]) / 2;
        }
    }
}
