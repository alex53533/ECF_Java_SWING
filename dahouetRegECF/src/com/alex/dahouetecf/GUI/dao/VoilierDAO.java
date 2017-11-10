/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.dahouetecf.GUI.dao;

import com.alex.dahouetecf.GUI.model.Voilier;
import com.alex.dahouetecf.GUI.model.Proprietaire;
import com.alex.dahouetecf.GUI.model.Classe;
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
public class VoilierDAO {
    
    public static void insert(Voilier v) throws Exception{
        
        Connection connection = JDBC.getConnection();
        PreparedStatement vtInsert;
            try {
                connection.setAutoCommit(false);
                
                vtInsert = connection.prepareStatement("INSERT INTO voilier (id_voilier, nom_voilier, num_voilier, id_proprietaire, id_classe) VALUES(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
                    
                vtInsert.setInt(1, v.getId_voilier());
                vtInsert.setString(2, v.getNom_voilier());
                vtInsert.setInt(3, v.getNum_voilier());
                vtInsert.setInt(4, v.getProprietaire().getId_proprietaire());
                vtInsert.setInt(5, v.getClasse().getId_classe());
                
                vtInsert.execute();
                
                connection.commit();
                
                vtInsert.close();
                
            } catch(SQLException e){ 
            e.printStackTrace();
        }
    }
    
    public static List<Voilier> findAllVoilier(){
        Connection connection = JDBC.getConnection();

        List<Voilier> Voiliers = new ArrayList<>();
        Statement vt;
        try {
            vt = connection.createStatement();

            String sql = "select pro.id_proprietaire, per.id_personne, nom_voilier, num_voilier, per.nom_personne, per.prenom_personne, per.email_personne, per.num_licence, per.annee_licence, per.nom_club, cla.nom_classe from voilier v INNER JOIN proprietaire pro ON v.id_proprietaire=pro.id_proprietaire INNER JOIN classe cla ON v.id_classe=cla.id_classe INNER JOIN personne per ON pro.id_personne=per.id_personne";
            ResultSet rs = vt.executeQuery(sql);

            while (rs.next()) {
                String nom_voilier = rs.getString("nom_voilier");
                int num_voilier = rs.getInt("num_voilier");
                Proprietaire proprietaire = new Proprietaire(rs.getInt("pro.id_proprietaire"), rs.getInt("per.id_personne"), rs.getString("per.nom_personne"), rs.getString("per.prenom_personne"), rs.getString("per.email_personne"), rs.getInt("per.num_licence"), rs.getInt("per.annee_licence"), rs.getString("per.nom_club"));
                Classe classe = new Classe(rs.getString("cla.nom_classe"));
                Voilier v = new Voilier(nom_voilier, num_voilier, proprietaire, classe);
                Voiliers.add(v);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Voiliers;
    }
}
