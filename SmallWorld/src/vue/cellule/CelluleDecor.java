package vue.cellule;

import modele.monde.Case;
import modele.monde.TypeDecors;
import vue.Grille;
import vue.enums.EnumDecor;

import java.awt.*;
import java.awt.event.MouseEvent;


public class CelluleDecor extends Cellule {
    private final Case _case;

    protected Image imageDecors;
    protected Image imageNourriture;

    public CelluleDecor(Case _case, Grille grille) {
        super(grille, _case.getPosX(), _case.getPosY());
        this._case = _case;
    }

    public void update() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (_case.getDecors().getType() == TypeDecors.BASE)
            imageDecors = EnumDecor.herbe.getGrille();
        else if (_case.getDecors().getType() == TypeDecors.EAU)
            imageDecors = EnumDecor.eau.getGrille();

        g2.drawImage(imageDecors, 0, 0, getSize().width, getSize().height, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (grille.isAutoriserDeplacement()) {
            grille.setDeplacement(this);
        }
    }
}
