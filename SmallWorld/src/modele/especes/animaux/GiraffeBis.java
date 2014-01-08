package modele.especes.animaux;

import java.util.ArrayList;
import modele.especes.Espece;
import modele.especes.EspeceTer;
import modele.especes.Herbivore;
import modele.monde.Case;
import modele.monde.Monde;
import modele.monde.Temps;
import modele.monde.TypeDecors;
import modele.utils.Utils;

public class GiraffeBis extends EspeceTer implements Herbivore {


    public GiraffeBis(Espece espece) {
        super(espece);
    }

    public GiraffeBis(boolean estLeader, boolean sexe) {
        super("GiraffeBis", 35, 80, 20, 40, 20, estLeader, false, 65, 25, Utils.getRand(3), sexe);
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
        if (Temps.getJeux() % 20 == 0) {										//temps à comfirmer
            setEnergie(getEnergie() - 5);										//baisse d'énergie à confimer
            setFaim(getFaim() - 20);											//baisse de faim à confirmer
        }
        if (getEnergie() <= 0 || getFaim() < -20)
            tuer();
		else{
			if (getFuite() == true)	{											//si animal en fuite
				if ( Math.abs(getPosition().getPosX() - getDanger().getPosition().getPosX()) < 7 && Math.abs(getPosition().getPosY() - getDanger().getPosition().getPosY()) < 7)//si danger persiste (stocké un pointeur de l'animal dangereux ?)
					fuir(getDanger());											//fuire
				else{
					setDanger(null);											//sinon ne plus fuire
					setFuite(false);
				}
				System.out.println("en fuite");
			}
			else {
				//System.out.println(getPosition().getDecors() + " ou "+ TypeDecors.EAU);
				//if (getPosition().getDecors().getType() == TypeDecors.EAU) {	//sinon si zone inadapter
						//s'échappe
				//}
					/*else*/ if (getPosition().getEspece() != null && getPosition().getEspece() != this)	{						//sinon si case animal
					if ( getCourse() )											//si doit se battre
{
						combattre();											//combatre
System.out.println("combat");}
					else
{						
						seReproduire();											//faire des bébés
											
System.out.println("bébé");}
				}
				else if (getPosition().getNourriture() != null)	{				//sinon si case nourriture
					if ( aFaim() )
{
						manger();
System.out.println("mange");}
				}	
				else {															//gestion des autres cas	
					ArrayList<Case> vision;
					int i = 0;
					setCourse(false);
					boolean finAction = false;
					vision = Monde.getVoisins(getPosition(), getChampVision(), getSens() );	//recupere champs vision dans tempObj
					if ( vision.isEmpty() ) {									//se deplace rien apperçu
							finAction = true;
							seDeplacer();
					}
					while(finAction == false && i < vision.size() ){
						if ( vision.get(i).getEspece() != null ) {				//si apperçoit animal
// TODO : VOIR SI ANIMAL EN QUESTION EST DANGEREUX POUR MES FESSES
								if ( false ) {										//si animal dangereux
								setFuite(true);
								setDanger(vision.get(i).getEspece() );
								fuir(getDanger() );
								finAction = true;
System.out.println("DANGER");
							}
							else if ( vision.get(i).getEspece().getClass().isInstance(Giraffe.class) ) {				//sinon si animal convoiter
								setCourse(true);
								seDeplacer(vision.get(i).getEspece().getPosition().getPosX(), vision.get(i).getEspece().getPosition().getPosY());
								finAction = true;
System.out.println("à la chasse");
							}
							else if ( vision.get(i).getEspece() instanceof GiraffeBis ) {	//sinon si animal même espece
System.out.println("other");
								if (vision.get(i).getEspece().getEstLeader() == true && getEstLeader() == true)	{	//si animal leader et moi leader
									seDeplacer(vision.get(i).getEspece().getPosition().getPosX(), vision.get(i).getEspece().getPosition().getPosY());
									finAction = true;
System.out.println("go bataille");
								}
								else if (vision.get(i).getEspece().getEstLeader() == true && getMeute() == null)	//sinon si adversaire leader et moi sans meute
									vision.get(i).getEspece().getMeute().rejoindre(this);						//adhérer
								else if (vision.get(i).getEspece().getEstLeader() == true && getMeute() != null)	//sinon si adversaire leader et moi meute
									appelLeader();											//appeler leader
								else if (vision.get(i).getEspece().getSexe() == true && vision.get(i).getEspece().getNbReproductions() > 0 && getNbReproductions() > 0) {//sinon si male, si il peut s'accoupler et moi aussi et moi femmelle
									seDeplacer(vision.get(i).getEspece().getPosition().getPosX(), vision.get(i).getEspece().getPosition().getPosY());
									finAction = true;
System.out.println("direction accouplement");
								}
							}
						}
						if ( vision.get(i).getNourriture() != null ) {			//si nourriture
							if ( aFaim() ) {									//si faim
								seDeplacer(vision.get(i).getEspece().getPosition().getPosX(), vision.get(i).getEspece().getPosition().getPosY()) ;
								finAction = true;
								System.out.println("faim");
							}
						}
						i++;
					}
					if (finAction == false)									//se deplace si aucun autre deplacement a été effectué
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