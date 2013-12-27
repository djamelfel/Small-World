package vue.cellule;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 23/12/13.
 */
public abstract class Cellule extends JPanel {
    private int posX;
    private int posY;
    protected Image image;

    public Cellule(int posX, int posY) {
        super();

        this.posX = posX;
        this.posY = posY;

        // Initialisation
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, getSize().width, getSize().height, null);
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }
}
