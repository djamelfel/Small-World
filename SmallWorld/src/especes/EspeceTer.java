package especes;
public class EspeceTer extends Espece implements Terrestre {

	public EspeceTer() {
		super();
	}

	public EspeceTer(Espece espece) {
		super(espece);
	}

	public EspeceTer(String nom, Boolean nocturne, Boolean sommeil, int vitesse, int force, int energie, Meute meute,
			int vitesseCourse, Boolean sexe, Boolean estLeader, Boolean nage, Boolean estVivant, int champVision, int tempIdeale,
			int nbReproductions, Boolean fuite) {
		super(nom, nocturne, sommeil, vitesse, force, energie, meute, vitesseCourse,
				sexe, estLeader, nage, estVivant, champVision, tempIdeale,
				nbReproductions, fuite);
	}
}