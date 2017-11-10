/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.dahouetecf.GUI.dao;

import com.alex.dahouetecf.GUI.model.Classe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class ClasseDAO {
    public static List<Classe> findBy(int serie) {
        Connection connection = JDBC.getConnection();

        List<Classe> classes = new ArrayList<>();
        Statement stm;

        try {
            stm = connection.createStatement();

            String sql = "select * from classe cla WHERE cla.id_serie=" + serie;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id_voilier = rs.getInt("id_classe");
                String nom = rs.getString("nom_classe");
                int coefficient = rs.getInt("coefficient");
                int id_serie = rs.getInt("id_serie");
                Classe c = new Classe(id_voilier, nom, coefficient, id_serie);

                classes.add(c);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;

    }

    public static List<Classe> findAllClasse() {

        Connection connection = JDBC.getConnection();

        List<Classe> Classes = new ArrayList<>();
        Statement ctm;
        try {
            ctm = connection.createStatement();

            String sql = "select * from classe";
            ResultSet rs = ctm.executeQuery(sql);

            while (rs.next()) {
                int idClasse = rs.getInt("id_classe");
                String nomClasse = rs.getString("nom_classe");
                int coefficient = rs.getInt("coefficient");
                int idSerie = rs.getInt("id_serie");

                Classe c = new Classe(idClasse, nomClasse, coefficient, idSerie);

                Classes.add(c);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return Classes;

    }
}
