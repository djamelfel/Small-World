package vue.cellule;

import vue.enums.Monde;

/**
 * Created by Edwin on 19/12/13.
 */
public class CelluleMonde extends Cellule {
    private Monde monde;

    public CelluleMonde(Monde monde, int posX, int posY) {
        super(posX, posY);
    }
}