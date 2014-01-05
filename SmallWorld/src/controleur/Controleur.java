package controleur;

import utilitaires.Charger;
import utilitaires.Sauvegarder;
import vue.Fenetre;
import vue.enums.Animal;
import vue.enums.Decor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import modele.especes.Espece;

public class Controleur {
    private Fenetre fenetre;
    private ManagerAnimaux _managerAnimaux;

    public Controleur() {
        fenetre = new Fenetre(this);
        
        _managerAnimaux = new ManagerAnimaux(this);
    }

    // Méthode appelé lors de la création d'une nouvelle partie
    public boolean creerPartie(String nomJoueur, int rows, int cols) {
        System.out.println("My name is " + nomJoueur);
        fenetre.setTailleGrille(rows, cols);
        _managerAnimaux.initialiser(rows, cols);
        
        
        
        ajouterAnimal(Animal.lamasticot, "roger", 'F','O', new Point(10, 10));
        
      /*  ajouterAnimal(Animal.lamasticot, "roger", 'F','O', new Point(16, 4));
        ajouterAnimal(Animal.lion, "roger", 'F','O', new Point(5, 10));
        ajouterAnimal(Animal.lion, "roger", 'F','O', new Point(10, 3));*/
        
        
        _managerAnimaux.start();
        return true;
    }

    // Méthode appelé lors d'une sauvegarde d'une partie
    public boolean sauvegarder(File file) {
        return Sauvegarder.sauvegarderXML(file);
    }

    // Méthode appelé lors d'un chargement de partie
    public boolean charger(File file) {
        if (Charger.chargerXML(file)) {
            return true;
        }
        return false;
    }

    // Méthode appelé pour ajouter un nouvel animal
    public boolean ajouterAnimal(Animal animal, String nom, char sexe, char leader, Point position) {
        System.out.println("Animal => " + animal.getNom() + " : " + nom + ", " + sexe + ", " + leader + ", " + position);
        Espece tmpAnimal;    
        tmpAnimal = _managerAnimaux.getMonde().ajoutAnimaux(animal, position.x, position.y);
        fenetre.getGrille().ajouterAnimal(tmpAnimal);
        
        return true;
    }

    // Méthode appelé pour ajouter un décor
    public boolean ajouterMonde(Decor monde, int largeur, int hauteur, Point position) {
        System.out.println("Décor => " + monde.getNom() + " : " + largeur + ", " + hauteur + ", " + position);
        return true;
    }
    
    
    public Fenetre getFenetre() {
        return fenetre;
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
