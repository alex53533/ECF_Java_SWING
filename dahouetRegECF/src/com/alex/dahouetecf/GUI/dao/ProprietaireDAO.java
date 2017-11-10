/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.dahouetecf.GUI.dao;

import com.alex.dahouetecf.GUI.model.Proprietaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class ProprietaireDAO {
     public static Proprietaire findBy(int id) {
        Proprietaire p = null;
        Connection connection = JDBC.getConnection();
        PreparedStatement ptm;
        try {
            ptm = connection.prepareStatement("select * from proprietaire pro INNER JOIN personne per ON pro.id_personne=per.id_personne WHERE per.id_personne= ?");
            ptm.setInt(1, id);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                p = new Proprietaire(rs.getInt("id"),
                        rs.getInt("per.id_personne"),
                        rs.getString("per.nom_personne"),
                        rs.getString("per.prenom_personne"),
                        rs.getString("per.email_personne"),
                        rs.getInt("per.num_licence"),
                        rs.getInt("per.annee_licence"),
                        rs.getString("per.nom_club"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return p;
    }

    public static List<Proprietaire> findAllProprietaire() {

        Connection connection = JDBC.getConnection();

        List<Proprietaire> Proprietaires = new ArrayList<>();
        Statement ptm;
        try {
            ptm = connection.createStatement();

            String sql = "select * from proprietaire pro INNER JOIN personne per ON pro.id_personne=per.id_personne";
            ResultSet rs = ptm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id_proprietaire");
                int idPersonne = rs.getInt("per.id_personne");
                String nomPersonne = rs.getString("per.nom_personne");
                String prenomPersonne = rs.getString("per.prenom_personne");
                String emailPersonne = rs.getString("per.email_personne");
                int numLicence = rs.getInt("per.num_licence");
                int anneeLicence = rs.getInt("per.annee_licence");
                String nomClub = rs.getString("per.nom_club");
                Proprietaire p = new Proprietaire(id, idPersonne, nomPersonne, prenomPersonne, emailPersonne, numLicence, anneeLicence, nomClub);

                Proprietaires.add(p);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return Proprietaires;

    }

    public static void insertProprietaire(Proprietaire p) throws Exception {
        Connection connection = JDBC.getConnection();

        PreparedStatement stmCreateProprietaire;
        PreparedStatement stmCreatePersonne;
        try {
            stmCreatePersonne = connection.prepareStatement("INSERT INTO personne (nom_personne, prenom_personne, email_personne, num_licence, annee_licence, nom_club ) VALUES(?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            stmCreatePersonne.setString(1, p.getNom_personne());
            stmCreatePersonne.setString(2, p.getPrenom_personne());
            stmCreatePersonne.setString(3, p.getEmail_personne());
            stmCreatePersonne.setInt(4, p.getNum_licence());
            stmCreatePersonne.setInt(5, p.getAnnee_licence());
            stmCreatePersonne.setString(6, p.getNom_club());

            stmCreatePersonne.execute();

            ResultSet rs = stmCreatePersonne.getGeneratedKeys();
            if (!rs.next()) {
                throw new Exception("cannot get generated id personne");
            }
            p.setId_Personne(rs.getInt(1));

            stmCreateProprietaire = connection.prepareStatement("INSERT INTO proprietaire (id_personne)VALUES(?);", Statement.RETURN_GENERATED_KEYS);
            stmCreateProprietaire.setInt(1, p.getId_Personne());
            stmCreateProprietaire.execute();

            stmCreatePersonne.close();
            stmCreateProprietaire.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur création propriétaire");
            throw new Exception("erreur création propriétaire " + e.getMessage());
        }

    }

}
