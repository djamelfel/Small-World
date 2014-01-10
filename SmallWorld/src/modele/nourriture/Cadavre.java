package modele.nourriture;

import modele.especes.Espece;
import modele.monde.Case;
import org.jdom2.Element;

public class Cadavre extends Nourriture {
	private int _tempsDecomposition;
        
    public Cadavre(int energie, Case position)
    {
		super(energie, position);
        _tempsDecomposition = 100;    
    }
	
	@Override
	public void seFaireManger() {
            System.out.println("Ce cadavre se fait bouffer tout crue");
		setMangeable(false);
	}
	
	public void setTempsDecomposition(int tempsDecomposition) {
		_tempsDecomposition = tempsDecomposition;
               // System.out.println("Decomposition cadavre : "+_tempsDecomposition);
	}

    public int getTempsDecomposition() {
        return _tempsDecomposition;
    }
    
    @Override
	public Element sauvegarder() {
		Element nourriture = new org.jdom2.Element("Cadavre");
		
		nourriture.setAttribute("posX",getPosition().getPosX()+"");
		nourriture.setAttribute("posY",getPosition().getPosY()+"");
		nourriture.setAttribute("Mangeable",getMangeable()+"");
		nourriture.setAttribute("EnergieRendue",getEnergieRendue()+"");
		nourriture.setAttribute("Graphics",getGraphics().getNom());
		nourriture.setAttribute("TempsDecomposition", getTempsDecomposition()+"");
		
		return nourriture;
	}

}