package modele.especes;

import modele.especes.type.Terrestre;
import modele.especes.type.Volant;

public class Oiseau extends Espece implements Terrestre, Volant {
    
     public Oiseau(String nom,int sommeilDeb, int sommeilFin, int vitesse, int force, int vitesseCourse, boolean estLeader, boolean nage, int champVison, int tempIdeal, int nbReproductions, boolean sexe){
		super(nom, sommeilDeb, sommeilFin, vitesse, force, vitesseCourse, estLeader, nage, champVison, tempIdeal, nbReproductions, sexe);
	}

	public Oiseau(String nom, int sommeilDeb, int sommeilFin, int champVision, int tempsIdeal, boolean course, int dateNaissance, int energie, boolean estLeader, int faim, int force, boolean sexe, boolean fuite, boolean nage, int nbReproductions, int sens, boolean sommeil, int vitesse, int vitesseCourse){
		super(nom, sommeilDeb, sommeilFin, champVision, tempsIdeal, course, dateNaissance, energie, estLeader, faim, force, sexe, fuite, nage, nbReproductions, sens, sommeil, vitesse, vitesseCourse);
	}
}