package modele.nourriture;

import modele.especes.Espece;
import modele.monde.Case;

public class Cadavre extends Nourriture {
	private int _tempsDecomposition;
        
    public Cadavre(int energie, Case position)
    {
		super(energie, position);
        _tempsDecomposition = 100;    
    }
	
	@Override
	public void seFaireManger() {
		setMeangable(false);
	}
	
	public void setTempsDecomposition(int tempsDecomposition) {
		_tempsDecomposition = tempsDecomposition;
	}

    public int getTempsDecomposition() {
        return _tempsDecomposition;
    }
    
    public String sauvegarder() {
         return "" ; //sauvegarder("Cadavre");
     }

}