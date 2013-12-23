package vue.cellule;

import javax.swing.*;

/**
 * Created by Edwin on 19/12/13.
 */
public class CelluleAnimal extends Cellule {
    public CelluleAnimal(String type, int posX, int posY) {
        super(type, posX, posY);

        if (type.equals("lion")) {
            image = new ImageIcon(this.getClass().getResource("../../images/animaux/lion.png")).getImage();
        }
    }
}
