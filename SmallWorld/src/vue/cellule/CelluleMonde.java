package vue.cellule;

import vue.Grille;
import vue.enums.Decor;

import java.awt.event.MouseEvent;

/**
 * Created by Edwin on 19/12/13.
 */
public class CelluleMonde extends Cellule {
    public CelluleMonde(Decor monde, Grille grille, int posX, int posY) {
        super(grille, posX, posY);

        image = monde.getGrille();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        if (grille.isAutoriserDeplacement()) {
            grille.setDeplacement(this);
        }
    }
}
