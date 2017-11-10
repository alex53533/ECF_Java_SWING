/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alex.dahouetecf.GUI.dao;

import com.alex.dahouetecf.GUI.model.Serie;
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
public class SerieDAO {
     public static Serie findBy(int id) {
        Serie ser = null;
        Connection connection = JDBC.getConnection();
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement("select * from serie WHERE id_serie= ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ser = new Serie(rs.getInt("id_serie"),
                        rs.getString("nom_serie"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return ser;
    }

    public static List<Serie> findAllSerie() {

        Connection connection = JDBC.getConnection();

        List<Serie> series = new ArrayList<>();
        Statement stm;
        try {
            stm = connection.createStatement();

            String sql = "select * from serie";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id_serie = rs.getInt("id_serie");
                String nom_serie = rs.getString("nom_serie");

                Serie ser = new Serie(id_serie, nom_serie);

                series.add(ser);
            }
            rs.close();

        } catch (SQLException e) {
             e.printStackTrace();
            throw new RuntimeException();
        }

        return series;

    }
}
