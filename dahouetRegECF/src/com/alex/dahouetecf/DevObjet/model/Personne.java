/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.dahouetecf.DevObjet.model;

import java.util.Calendar;

/**
 *
 * @author alex
 */
public class Personne {
    String nom;
    String prenom;
    String email;
    int anneeDeNaissance;

    public Personne(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public Personne(String nom, String prenom, String email, int anneeDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeDeNaissance = anneeDeNaissance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAnneeDeNaissance() {
        return anneeDeNaissance;
    }

    public void setAnneeDeNaissance(int anneeDeNaissance) {
        this.anneeDeNaissance = anneeDeNaissance;
    }

    public int calculAge() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int age = year - this.getAnneeDeNaissance();
        return age;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", Prénom : " + prenom + ", Mail : " + email + ", Age : " + calculAge() + " ans";
    }
}
