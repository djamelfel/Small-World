package modele.nourriture;

import modele.especes.Espece;

public class Cadavre extends Nourriture {
    private Espece _animal;
    private int _tempsDecomposition;

    public Cadavre(Espece animal, int tempsDecomposition) {
        super(5);
        this._animal = animal;
        this._tempsDecomposition = tempsDecomposition;

    }


    public Espece getAnimal() {
        return _animal;
    }

    public int getTempsDecomposition() {
        return _tempsDecomposition;
    }

}