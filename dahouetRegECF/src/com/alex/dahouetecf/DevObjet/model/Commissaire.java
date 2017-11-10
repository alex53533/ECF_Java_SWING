/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.dahouetecf.DevObjet.model;

/**
 *
 * @author alex
 */
public class Commissaire extends Personne {
     String comite;

    public Commissaire(String comite, String nom, String prenom, String email) {
        super(nom, prenom, email);
        this.comite = comite;
    }

    public Commissaire(String comite, String nom, String prenom, String email, int anneeDeNaissance) {
        super(nom, prenom, email, anneeDeNaissance);
        this.comite = comite;
    }

    public String getCommite() {
        return comite;
    }

    public void setCommite(String commite) {
        this.comite = commite;
    }

    @Override
    public String toString() {
        return "Commissaire : " + super.toString() + ", Comité : " + comite;
    }
}
