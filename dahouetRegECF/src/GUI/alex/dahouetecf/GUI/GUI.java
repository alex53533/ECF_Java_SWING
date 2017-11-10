/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.alex.dahouetecf.GUI;

import com.alex.dahouetecf.GUI.model.MainWindow;

/**
 *
 * @author alex
 */
public class GUI {
    public static void main(String[] args) {

        MainWindow mainwindow = new MainWindow();
        mainwindow.setVisible(true);
        mainwindow.setTitle("Formulaire d'ajout d'un voilier");
        mainwindow.setLocationRelativeTo(null);

    }
}
