package modele.especes.animaux;
import modele.especes.Espece;
import modele.especes.EspeceTer;
import modele.especes.Herbivore;
import utils.Utils;

public class Giraffe extends EspeceTer implements Herbivore {
	

	
	public Giraffe(Espece espece) {
		super(espece);
	}

	public Giraffe() {
		super("Giraffe", 35, 80, 20, 40, 20, Math.random()<0.2, false, 65, 25, Utils.getRand(3));
	}

	@Override
	public void chuteCapacite() {
		if (getSommeil() == true)
			setForce(getForce() - 40);
		else{
			setForce(getForce() - 30);
			setVitesse(getVitesse() - 10);
			setVitesseCourse(getVitesse() - 5);
		}
	}

	@Override
	public void retrouveCapacite() {
		if (getSommeil() == true)
			setForce(getForce() + 40);
		else{
			setForce(getForce() + 30);
			setVitesse(getVitesse() + 10);
			setVitesseCourse(getVitesse() + 5);
		}
	}

	@Override
	public String toString() {
		return "nom - leader - repro - " + getNom() + getEstLeader() + getNbReproductions() + super.toString();
	}
}