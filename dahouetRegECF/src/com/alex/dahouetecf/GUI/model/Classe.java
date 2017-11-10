/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.dahouetecf.GUI.model;

/**
 *
 * @author alex
 */
public class Classe {
    int id_classe;
    String nom_classe;
    int coefficient;
    int id_serie;

    public Classe(int id_classe, String nom_classe, int coefficient, int id_serie) {
        this.id_classe = id_classe;
        this.nom_classe = nom_classe;
        this.coefficient = coefficient;
        this.id_serie = id_serie;
    }

    public Classe(int id_classe, String nom_classe) {
        this.id_classe = id_classe;
        this.nom_classe = nom_classe;
    }

    public Classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public int getId_classe() {
        return id_classe;
    }

    public void setId_classe(int id_classe) {
        this.id_classe = id_classe;
    }

    public String getNom_classe() {
        return nom_classe;
    }

    public void setNom_classe(String nom_classe) {
        this.nom_classe = nom_classe;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public int getId_serie() {
        return id_serie;
    }

    public void setId_serie(int id_serie) {
        this.id_serie = id_serie;
    }

    @Override
    public String toString() {
        return nom_classe;
    }
}
