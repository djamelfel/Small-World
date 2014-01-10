package controleur;

import utilitaires.Charger;
import utilitaires.Sauvegarder;
import vue.Fenetre;
import vue.enums.Decor;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import modele.especes.Espece;
import modele.utils.Utils;

public class Controleur {
    private Fenetre fenetre;
    private ManagerAnimaux _managerAnimaux;

    

    public Controleur() {
        fenetre = new Fenetre(this);
        
        _managerAnimaux = new ManagerAnimaux(this);
    }

    // Méthode appelé lors de la création d'une nouvelle partie
    public boolean creerPartie(String nomJoueur, int rows, int cols) {
        _nomJoueur = nomJoueur;
        
        _managerAnimaux.initialiser(rows, cols);
        fenetre.setTailleGrille(_managerAnimaux.getMonde().getMap());
        
        if(Charger.chargerXML(this))
		System.out.println("partie CHARGEE");
        else
        {
            ajouterAnimal("Lion", "roger", false,false, new Point(Utils.getRand(cols-1), Utils.getRand(rows-1)));
            ajouterAnimal("Lamastico", "roger", false,false, new Point(Utils.getRand(cols-1), Utils.getRand(rows-1)));
            ajouterAnimal("Lamastico", "roger", true,true, new Point(Utils.getRand(cols-1), Utils.getRand(rows-1)));
            ajouterAnimal("PoissonVolant", "roger", false,false, new Point(Utils.getRand(cols-1), Utils.getRand(rows-1)));
            ajouterAnimal("Renard", "roger", false,true, new Point(Utils.getRand(cols-1), Utils.getRand(rows-1)));
            ajouterAnimal("Renard", "roger", true,false, new Point(Utils.getRand(cols-1), Utils.getRand(rows-1)));   

             ajouterAnimal("Araignee", "roger", false,false, new Point(Utils.getRand(cols), Utils.getRand(rows)));    
             ajouterAnimal("Araignee", "roger", true,false, new Point(Utils.getRand(cols), Utils.getRand(rows)));  
              /*       ajouterNourriture("Banane", new Point(21,0));
        ajouterNourriture("Banane", new Point(21,3));
		ajouterNourriture("Banane", new Point(21,6));
		ajouterNourriture("Banane", new Point(21,9));
		ajouterNourriture("Banane", new Point(21,11));
		ajouterNourriture("Banane", new Point(21,13));*/
        
        }
         
        _managerAnimaux.start();
        
        return true;
    }

    // Méthode appelé lors d'une sauvegarde d'une partie
    public boolean sauvegarder(File file) {
        return Sauvegarder.sauvegarderXML(file, _nomJoueur);
    }

    // Méthode appelé lors d'un chargement de partie
    public boolean charger(File file) {
        if (Charger.chargerXML(file,this)) {
            return true;
        }
        return false;
    }

    // Méthode appelé pour ajouter un nouvel animal
    public boolean ajouterAnimal(String animal, String nom, boolean sexe, boolean leader, Point position) {
        System.out.println("Animal => " + animal + " : " + nom + ", Sexe (male=true) " + sexe + ", " + leader + ", " + position+ ", est Leader : "+ leader);
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
    
    public void ajouterNourriture(String nourriture, Point position) {
		_managerAnimaux.getMonde().ajoutNourriture(nourriture, position.x, position.y);
                fenetre.getGrille().ajouterNourriture();
    }
	
	public void supprimerEspece(Espece espece) {
		espece.getPosition().setEspece(null);
		fenetre.getGrille().supprimerAnimal(espece);
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

    
    public ManagerAnimaux getManagerAnimaux() {
        return _managerAnimaux;
    }
    private String _nomJoueur;

    public void setNomJoueur(String _nomJoueur) {
        this._nomJoueur = _nomJoueur;
    }
    
    
}
