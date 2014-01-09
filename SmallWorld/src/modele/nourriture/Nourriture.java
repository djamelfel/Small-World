package modele.nourriture;

import modele.monde.Case;
import vue.enums.EnumNourriture;

public class Nourriture {

    private Case _position;
    private int _energieRendue;
    private Boolean _mangeable; // indique si la nourriture a deja ete mangee par un animal et doit donc etre supprimee par le Monde


    private EnumNourriture _graphics; // contient les graphismes

    public Nourriture(int energieRendue, Case position) {
        _energieRendue = energieRendue;
        _mangeable = true;
        _position = position;
    }

    public void seFaireManger() {
        _mangeable = false;
    }

    public void detruire() {
    }

    public String sauvegarder() {
        return null;
    }

    public boolean getMangeable() {
        return _mangeable;
    }

    public void setMeangable(boolean mangeable) {
        _mangeable = mangeable;
    }

    public Case getPosition() {
        return _position;
    }

    public int getEnergieRendue() {
        return _energieRendue;
    }

    public void setPosition(Case position) {
        _position = position;
    }

    public void setGraphics(EnumNourriture nourriture) {
        _graphics = nourriture;
    }

    public EnumNourriture getGraphics() {
        return _graphics;
    }

}