package modele.nourriture;

import modele.especes.Espece;
import modele.monde.Case;

public class Herbe extends Nourriture {
    
    public Herbe(Case position)
    {
        super(100, position);
    }
	
	@Override
	public void seFaireManger() {
	}
    
	@Override
    public String sauvegarder() {
            return "" ;//sauvegarder("Herbe");
    }
    

}