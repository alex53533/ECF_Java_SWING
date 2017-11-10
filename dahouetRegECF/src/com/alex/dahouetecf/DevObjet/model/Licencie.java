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
public class Licencie extends Personne {
    int numLicence;
    double pointsFFV;
    int anneeLicence;

    public Licencie(int numLicence, double pointsFFV, int anneeLicence, String nom, String prenom, String email) {
        super(nom, prenom, email);
        this.numLicence = numLicence;
        this.pointsFFV = pointsFFV;
        this.anneeLicence = anneeLicence;
    }

    public Licencie(int numLicence, double pointsFFV, int anneeLicence, String nom, String prenom, String email, int anneeDeNaissance) {
        super(nom, prenom, email, anneeDeNaissance);
        this.numLicence = numLicence;
        this.pointsFFV = pointsFFV;
        this.anneeLicence = anneeLicence;
    }

    public int getNumLicence() {
        return numLicence;
    }

    public void setNumLicence(int numLicence) {
        this.numLicence = numLicence;
    }

    public double getPointsFFV() {
        return pointsFFV;
    }

    public void setPointsFFV(double pointsFFV) {
        this.pointsFFV = pointsFFV;
    }

    public int getAnneeLicence() {
        return anneeLicence;
    }

    public void setAnneeLicence(int anneeLicence) {
        this.anneeLicence = anneeLicence;
    }

    public void calculPoints(double pts, Calendar annee) throws Exception {

        if (this.getAnneeLicence() == annee.get(Calendar.YEAR)) {
            pointsFFV = pointsFFV + pts;
        } else {
            throw new Exception("ERREUR");
        }

    }

    @Override
    public String toString() {
        return "Licencié : " + super.toString() + ", Numéro de licence : " + numLicence + ", Points FFV : " + pointsFFV + ", Année de licence : " + anneeLicence;
    }

}
