package modele.nourriture;

import modele.monde.Case;
import org.jdom2.Element;

public class Herbe extends Nourriture {
    
    public Herbe(Case position)
    {
        super(100, position);
    }
	
	@Override
	public void seFaireManger() {
	}
	
	@Override
	public Element sauvegarder() {
		Element nourriture = new org.jdom2.Element("Nourriture");
		
		nourriture.setAttribute("posX",getPosition().getPosX()+"");
		nourriture.setAttribute("posY",getPosition().getPosY()+"");
		nourriture.setAttribute("Mangeable",getMangeable()+"");
		nourriture.setAttribute("EnergieRendue",getEnergieRendue()+"");
		nourriture.setAttribute("Graphics",getGraphics().getNom());
		
		return nourriture;
	}
}