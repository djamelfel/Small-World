package modele.monde;

import vue.enums.Decor;

public class Decors {

    private int _posX;
    private int _posY;
    private Decor _graphics; // contient les graphismes

    public Decors(int posX, int posY) {
        _posX = posX;
        _posY = posY;
        _graphics = Decor.herbe;
    }

    public String sauvegarder() {
        return "";
    }

    public int getPosX() {
        return _posX;
    }

    public int getPosY() {
        return _posY;
    }

    public void setGraphics(Decor decor) {
        _graphics = decor;
    }

    public Decor getGraphics() {
        return _graphics;
    }


}