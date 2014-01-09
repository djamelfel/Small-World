package vue.cellule;

import modele.monde.Case;
import modele.monde.TypeDecors;
import vue.Grille;
import vue.enums.Decor;

import java.awt.*;
import java.awt.event.MouseEvent;


public class CelluleMonde extends Cellule {
    private final Case _case;

    protected Image imageDecors;
    protected Image imageNourriture;

    public CelluleMonde(Case _case, Grille grille) {
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
            imageDecors = Decor.herbe.getGrille();
        else if (_case.getDecors().getType() == TypeDecors.EAU)
            imageDecors = Decor.eau.getGrille();

        g2.drawImage(imageDecors, 0, 0, getSize().width, getSize().height, null);

        if (_case.getNourriture() != null)
            imageNourriture = _case.getNourriture().getGraphics().getGrille();
        else
            imageNourriture = null;
        g2.drawImage(imageNourriture, 0, 0, getSize().width, getSize().height, null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (grille.isAutoriserDeplacement()) {
            grille.setDeplacement(this);
        }
    }
}
