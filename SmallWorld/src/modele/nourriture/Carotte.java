package modele.nourriture;

import modele.monde.Case;

public class Carotte extends Nourriture {
    
    public Carotte(Case position)
    {
        super(100, position);
    }
	
	@Override
	public void seFaireManger() {
		setMangeable(false);
	}
    
	@Override
    public String sauvegarder() {
            return "" ;//sauvegarder("Herbe");
    }
    

}