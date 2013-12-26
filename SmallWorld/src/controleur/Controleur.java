package controleur;

import utilitaires.Charger;
import utilitaires.Sauvegarder;
import vue.Fenetre;
import vue.enums.Animal;

import javax.swing.*;
import java.awt.*;
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

    // Méthode appelé pour ajouter un nouvel animal
    public boolean ajouterAnimal(Animal animal, String nom, char sexe, char leader, Point position) {
        System.out.println("Animal => " + animal.getNom() + " : " + nom + ", " + sexe + ", " + leader + ", " + position);
        return true;
    }

    public static void main(String[] args) {
        Runnable gui = new Runnable() {
            public void run() {
                new Controleur();
            }
        };
        //GUI must start on EventDispatchThread:
        SwingUtilities.invokeLater(gui);
    }
}