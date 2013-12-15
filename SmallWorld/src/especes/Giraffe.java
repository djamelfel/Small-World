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
			if(super.getEnergie()==0)
				tuer();
			seDeplacer();
		}	
		else
			if (super.getSommeil()==true)
				super.dormir();
	}

	public void chuteCapacite() {
		if (super.getSommeil()==true)
			super.setForce(super.getForce()-40);
		else{
			super.setForce(super.getForce()-30);
			super.setVitesse(super.getVitesse()-10);
			super.setVitesseCourse(super.getVitesse()-5);
		}
	}

	public void retrouveCapacite() {
		if (super.getSommeil()==true)
			super.setForce(super.getForce()+40);
		else{
			super.setForce(super.getForce()+30);
			super.setVitesse(super.getVitesse()+10);
			super.setVitesseCourse(super.getVitesse()+5);
		}
	}

	public void seDeplacer() {
		
	}
	
	public void rejoindreMeute(Meute meute) {
		// TODO Auto-generated method stub
		super.rejoindreMeute(meute);
	}

	@Override
	public void fuir(Espece espece) {
		// TODO Auto-generated method stub
		super.fuir(espece);
	}

	@Override
	public void appelLeader() {
		// TODO Auto-generated method stub
		super.appelLeader();
	}

	@Override
	public void chasser(Espece espece) {
		// TODO Auto-generated method stub
		super.chasser(espece);
	}

	@Override
	public void seReproduire(Espece espece) {
		// TODO Auto-generated method stub
		super.seReproduire(espece);
	}

	@Override
	public Boolean aFaim() {
		// TODO Auto-generated method stub
		return super.aFaim();
	}

	@Override
	public void combattre(Espece espece) {
		// TODO Auto-generated method stub
		super.combattre(espece);
	}

	@Override
	public void manger(Nourriture nour) {
		// TODO Auto-generated method stub
		super.manger(nour);
	}

	@Override
	public String sauvegarder() {
		// TODO Auto-generated method stub
		return super.sauvegarder();
	}
}