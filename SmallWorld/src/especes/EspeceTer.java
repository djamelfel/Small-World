package especes;
public class EspeceTer extends Espece implements Terrestre {

	EspeceTer(String nom, boolean sommeil, int vitesse, int force, int vitesseCourse, boolean estLeader, boolean nage, int champVison, int tempIdeal, int nbReproductions){
		super(nom, sommeil, vitesse, force, vitesseCourse, estLeader, nage, champVison, tempIdeal, nbReproductions);
	}

	EspeceTer(Espece espece) {
		super(espece);
	}
	
}