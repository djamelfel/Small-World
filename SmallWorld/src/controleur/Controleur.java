package controleur;

import modele.especes.Giraffe;
import utilitaires.Charger;
import utilitaires.Sauvegarder;
import vue.Fenetre;

import javax.swing.*;
import java.io.File;

public class Controleur {
    private Fenetre fenetre;

    public Controleur() {
        fenetre = new Fenetre(this);
    }

    // Méthode appelé lors de la création d'une nouvelle partie
    public boolean creerPartie(String nomJoueur, int rows, int cols) {
        System.out.println("My name is " + nomJoueur);
        fenetre.activate();
        fenetre.setTailleGrille(rows, cols);
        return true;
    }

    // Méthode appelé lors d'une sauvegarde d'une partie
    public boolean sauvegarder(File file) {
        return Sauvegarder.sauvegarderXML(file);
    }

    // Méthode appelé lors d'un chargement de partie
    public boolean charger(File file) {
        if (Charger.chargerXML(file)) {
            fenetre.activate();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//            System.out.println("test");
//            new Monde();

        System.out.println("-- Espece --");
        for (int i = 0; i < 10; i++)
            System.out.println(new Giraffe());
        System.out.println("==> Giraffe 1 <==");
        Giraffe g1 = new Giraffe();
        for (int i = 0; i < 7; i++) {
            g1.verifierEtatJournee();
            System.out.println(g1 + "==> Giraffe 2");
        }

        Runnable gui = new Runnable() {
            public void run() {
                new Controleur();
            }
        };
        //GUI must start on EventDispatchThread:
        SwingUtilities.invokeLater(gui);
    }
}
