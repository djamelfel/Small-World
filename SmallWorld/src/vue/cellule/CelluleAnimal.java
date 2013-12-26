package vue.cellule;

import vue.enums.Animal;

/**
 * Created by Edwin on 19/12/13.
 */
public class CelluleAnimal extends Cellule {
    public CelluleAnimal(Animal animal, int posX, int posY) {
        super(posX, posY);

        image = animal.getGrille();
    }
}
