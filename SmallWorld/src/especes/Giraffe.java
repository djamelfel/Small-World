package especes;
import monde.Temps;
import nourriture.Nourriture;

public class Giraffe extends EspeceTer implements Herbivore {

	public Giraffe(Espece espece) {
		super();
	}

	public Giraffe() {
		super("Giraffe", false, 20, 40, 100, 20, Math.random()<0.2, false, 65, 25, 2);
	}

	public void verifierEtatJournee() {
		if (Temps.getJournee() > 35 && Temps.getJournee() < 80){
			if(getSommeil() == true)
				reveiller();
			if(getEnergie() == 0)
				tuer();
			seDeplacer();
		}	
		else
			if (getSommeil() == true)
				dormir();
	}

	public void chuteCapacite() {
		if (getSommeil() == true)
			setForce(getForce() - 40);
		else{
			setForce(getForce() - 30);
			setVitesse(getVitesse() - 10);
			setVitesseCourse(getVitesse() - 5);
		}
	}

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
	public void fuir(Espece espece) {
		// TODO Auto-generated method stub
		super.fuir(espece);
	}

	public String sauvegarder() {
		// TODO Auto-generated method stub
		return super.sauvegarder();
	}
}