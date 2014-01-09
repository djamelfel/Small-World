package modele.monde;

import vue.enums.Decor;

public class Decors {

    private int _type;
    private int _posX;
    private int _posY;

    private Decor _graphics; // contient les graphismes

    public Decors(int type, int posX, int posY) {
        _type = type;
        _posX = posX;
        _posY = posY;
    }

    public String sauvegarder() {
        return "";
    }

    public int getType() {
        return _type;
    }

    void setType(int type) {
        _type = type;
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