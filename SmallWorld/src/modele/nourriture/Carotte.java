package modele.nourriture;

import modele.monde.Case;
import org.jdom2.Element;

public class Carotte extends Nourriture {
    
    public Carotte(Case position)
    {
        super(100, position);
    }
	
	@Override
	public void seFaireManger() {
            System.out.println("Cette carotte se fait bouffer toute crue");
		setMangeable(false);
	}
    
	@Override
	public Element sauvegarder() {
		Element nourriture = new org.jdom2.Element("Carrote");
		
		nourriture.setAttribute("posX",getPosition().getPosX()+"");
		nourriture.setAttribute("posY",getPosition().getPosY()+"");
		nourriture.setAttribute("Mangeable",getMangeable()+"");
		nourriture.setAttribute("EnergieRendue",getEnergieRendue()+"");
		nourriture.setAttribute("Graphics",getGraphics().getNom());
		
		return nourriture;
	}
    

}