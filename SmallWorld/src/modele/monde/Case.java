package modele.monde;

import modele.especes.Espece;
import modele.nourriture.Nourriture;


public class Case {
    private int _posX;
    private int _posY;
    private Decors _decors;
    private Espece _espece;
    private Nourriture _nourriture;


    public Case(int posX, int posY) {
        _posX = posX;
        _posY = posY;
        _espece = null;
        _nourriture = null;
        _decors = new Decors(posX, posY);
    }

    public Boolean estVide() {

        return _espece == null && _nourriture == null;
    }

    public String toString() {
        return "[Case : posX : " + _posX + " , posY : " + _posY + " ]";
    }

    public int getPosX() {
        return _posX;
    }

    public int getPosY() {
        return _posY;
    }

    public Decors getDecors() {
        return _decors;
    }

    public void setDecors(Decors element) {
        _decors = element;
    }

    public Espece getEspece() {
        return _espece;
    }

    public void setEspece(Espece espece) {
        _espece = espece;
    }

    public Nourriture getNourriture() {
        return _nourriture;
    }

    public void setNourriture(Nourriture nourriture) {
        _nourriture = nourriture;
    }
}