package modele.especes.animaux;

import java.util.ArrayList;
import modele.especes.Espece;
import modele.especes.EspeceTer;
import modele.especes.Herbivore;
import modele.monde.Case;
import modele.monde.Monde;
import modele.monde.Temps;
import modele.utils.Utils;

public class Giraffe extends EspeceTer implements Herbivore {


    public Giraffe(Espece espece) {
        super(espece);
    }

    public Giraffe() {
        super("Giraffe", 35, 80, 20, 40, 20, Math.random() < 0.2, false, 65, 25, Utils.getRand(3));
    }

    @Override
    public void chuteCapacite() {
        if (getSommeil() == true)
            setForce(getForce() - 40);
        else {
            setForce(getForce() - 30);
            setVitesse(getVitesse() - 10);
            setVitesseCourse(getVitesse() - 5);
        }
    }

    @Override
    public void retrouveCapacite() {
        if (getSommeil() == true)
            setForce(getForce() + 40);
        else {
            setForce(getForce() + 30);
            setVitesse(getVitesse() + 10);
            setVitesseCourse(getVitesse() + 5);
        }
    }
	
	@Override
	public void activite() {
			System.out.println("activite()");
        if (Temps.getJeux() % 20 == 0) {                //temps à comfirmer
            setEnergie(getEnergie() - 5);                //baisse d'énergie à confimer
            setFaim(getFaim() - 20);                    //baisse de faim à confirmer
        }
        if (getEnergie() <= 0 || getFaim() < -20)
            tuer();
		else{
			if (getFuite() == true)	{	//si animal en fuite
				if ( Math.abs(getPosition().getPosX() - getDanger().getPosition().getPosX()) < 7 && Math.abs(getPosition().getPosY() - getDanger().getPosition().getPosY()) < 7)//si danger persiste (stocké un pointeur de l'animal dangereux ?)
					fuir(getDanger());							//fuire
				else{
					setDanger(null);						//sinon ne plus fuire
					setFuite(false);
				}
			}
			else {
				if (getPosition().getDecors().getType() == 1) {						//sinon si zone inadapter
					//s'échappe
				}
				else if (getPosition().getEspece() != null)	{						//sinon si case animal
					if ( getCourse() )											//si doit se battre
						combattre();											//combatre
					else
						seReproduire();											//faire des bébés
				}
				else if (getPosition().getNourriture() != null)	{					//sinon si case nourriture
					if ( aFaim() )
						manger();
				}	
				else {															//gestion des autres cas	
					ArrayList<Case> vision;
					int i = 0;
					setCourse(false);
					boolean finAction = false;
					vision = Monde.getVoisins(getPosition(), getChampVision(), getSens() );	//recupere champs vision dans tempObj
					
					do{
						if ( vision.get(i).getEspece() != null ) {				//si apperçoit animal
							if ( vision.get(i).getEspece() ) {					//si animal dangereux
								setFuite(true);
								setDanger(vision.get(i).getEspece() );
								fuir(getDanger() );
								finAction = true;
							}
							else if ( vision.get(i).getEspece() ) {				//sinon si animal convoiter
								setCourse(true);
								seDeplacer(vision.get(i).getEspece().getPosition().getPosX(), vision.get(i).getEspece().getPosition().getPosY());
								finAction = true;
							}
/*VERIFIER INSTANCE*/		else if ( this.getClass().isInstance(vision.get(i).getEspece().getClass()) ) {										//sinon si animal même espece
								if (vision.get(i).getEspece().getEstLeader() == true && getEstLeader() == true)	{	//si animal leader et moi leader
									seDeplacer(vision.get(i).getEspece().getPosition().getPosX(), vision.get(i).getEspece().getPosition().getPosY());
									finAction = true;
								}
								else if (vision.get(i).getEspece().getEstLeader() == true && getMeute() == null)	//sinon si adversaire leader et moi sans meute
									vision.get(i).getEspece().getMeute().rejoindre(this);						//adhérer
								else if (vision.get(i).getEspece().getEstLeader() == true && getMeute() != null)	//sinon si adversaire leader et moi meute
									appelLeader();											//appeler leader
								else if (vision.get(i).getEspece().getSexe() == true && vision.get(i).getEspece().getNbReproductions() > 0 && getNbReproductions() > 0) {//sinon si male, si il peut s'accoupler et moi aussi et moi femmelle
									seDeplacer(vision.get(i).getEspece().getPosition().getPosX(), vision.get(i).getEspece().getPosition().getPosY());
									finAction = true;
								}
							}
						}
						if ( vision.get(i).getNourriture() != null ) {			//si nourriture
							if ( aFaim() ) {									//si faim
								seDeplacer(vision.get(i).getEspece().getPosition().getPosX(), vision.get(i).getEspece().getPosition().getPosY()) ;
								finAction = true;
							}
						}
						i++;
					}while(finAction == false || i < vision.size());
					
					if (finAction == false)
						seDeplacer();
				}
			}
		}
	}
	
    @Override
    public String toString() {
        return "nom - leader - repro - " + getNom() + getEstLeader() + getNbReproductions() + super.toString();
    }
}