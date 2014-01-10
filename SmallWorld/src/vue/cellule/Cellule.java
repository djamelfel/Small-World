package vue.cellule;

import vue.Grille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public abstract class Cellule extends JComponent implements MouseListener {
    protected Grille grille;
    private int posX;
    private int posY;
    protected Image image;

    public Cellule(Grille grille, int posX, int posY) {
        super();

        this.grille = grille;
        this.posX = posX;
        this.posY = posY;

        // Initialisation
        setOpaque(false);
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (image != null)
            g2.drawImage(image, 0, 0, getSize().width, getSize().height, null);
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public abstract String toString();
}
