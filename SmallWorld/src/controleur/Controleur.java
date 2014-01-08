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
import modele.nourriture.Nourriture;
import vue.enums.NourrituresEnum;

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
        
        _managerAnimaux.initialiser(rows, cols);
        fenetre.setTailleGrille(_managerAnimaux.getMonde().getMap());
        
        
        ajouterAnimal(Animal.lamasticot, "roger", false,true, new Point(10, 10));
        ajouterNourriture(NourrituresEnum.banane, new Point(11,10));
        
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
    public boolean ajouterAnimal(Animal animal, String nom, boolean sexe, boolean leader, Point position) {
        System.out.println("Animal => " + animal.getNom() + " : " + nom + ", Sexe (male=true) " + sexe + ", " + leader + ", " + position+ ", est Leader : "+ leader);
        Espece tmpAnimal;    
        tmpAnimal = _managerAnimaux.getMonde().ajoutAnimaux(animal, leader, sexe, position.x, position.y);
        fenetre.getGrille().ajouterAnimal(tmpAnimal);
        
        return true;
    }

    // Méthode appelé pour ajouter un décor
    public boolean ajouterDecor(Decor decor, int largeur, int hauteur, Point position) {
        System.out.println("Décor => " + decor.getNom() + " : " + largeur + ", " + hauteur + ", " + position);
		
		int x = (int)position.getX();
		int y = (int)position.getY();
		for(int i = x; i < (x+largeur); i++) {
			for(int j = y; j < (y+hauteur); j++) {
				_managerAnimaux.getMonde().ajoutDecors(decor, i, j);
			} 
		}
        fenetre.getGrille().ajouterDecor();
        
        return true;
    }
    
    public boolean ajouterNourriture(NourrituresEnum nourriture, Point position) {
        Nourriture tmpNourriture;
        tmpNourriture = _managerAnimaux.getMonde().ajoutNourriture(nourriture, position.x, position.y);
        
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
