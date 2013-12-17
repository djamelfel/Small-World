package modele.monde;

import modele.especes.Espece;
import modele.nourriture.Nourriture;


public class Case {
    private int _posX;
    private int _posY;
    private Decors decors;
    private Espece espece;
    private Nourriture nourriture;


    public Case(int posX, int posY) {
        _posX = posX;
        _posY = posY;
    }

    public Boolean estVide() {

        return espece == null && nourriture == null;
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

    public Decors getDecorst() {
        return decors;
    }

    public void setDecors(Decors element) {
        this.decors = element;
    }

    public Espece getEspece() {
        return espece;
    }

    public void setEspece(Espece espece) {
        this.espece = espece;
    }

    public Nourriture getNourriture() {
        return nourriture;
    }

    public void setNourriture(Nourriture nourriture) {
        this.nourriture = nourriture;
    }

    public void setPosX(int posX) {
        _posX = posX;
    }

    public void setPosY(int posY) {
        _posY = posY;
    }
}