package modele.monde;

import vue.enums.Decor;

public class Decors {

    private int _type;
    private int _posX;
    private int _posY;
    private int _largeur;
    private int _hauteur;
    
    private Decor _graphics; // contient les graphismes

    public Decors(int type, int posX, int posY, int largeur, int hauteur) {
        this._type = type;
        this._posX = posX;
        this._posY = posY;
        this._largeur = largeur;
        this._hauteur = hauteur;
    }

    public String sauvegarder() {
        return "";
    }

    public int getType() {
        return _type;
    }

    public int getPosX() {
        return _posX;
    }

    public int getPosY() {
        return _posY;
    }

    public int getLargeur() {
        return _largeur;
    }

    public int getHauteur() {
        return _hauteur;
    }
    
    
    public void setGraphics(Decor decor) {
        _graphics = decor;
    }
    
    public Decor getGraphics() {
        return _graphics;
    }


}