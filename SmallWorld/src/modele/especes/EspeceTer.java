package modele.especes;

import modele.especes.type.Terrestre;

public class EspeceTer extends Espece implements Terrestre {

	public EspeceTer(String nom,int sommeilDeb, int sommeilFin, int vitesse, int force, int vitesseCourse, boolean estLeader, boolean nage, int champVison, int tempIdeal, int nbReproductions){
		super(nom, sommeilDeb, sommeilFin, vitesse, force, vitesseCourse, estLeader, nage, champVison, tempIdeal, nbReproductions);
	}

	public EspeceTer(Espece espece) {
		super(espece);
	}
	
}