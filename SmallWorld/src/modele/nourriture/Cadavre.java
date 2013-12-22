package modele.nourriture;

import modele.especes.Espece;
import modele.nourriture.Nourriture;

public class Cadavre extends Nourriture {
	private Espece _animal;
	private int _tempsDecomposition;
        
    public Cadavre(Espece animal, int tempsDecomposition)
    {
        super(5);
        _animal = animal;
        _tempsDecomposition = tempsDecomposition;    
    }
    
    
    public Espece getAnimal() {
        return _animal;
    }

    public int getTempsDecomposition() {
        return _tempsDecomposition;
    }

}