package vue;

import controleur.Controleur;
import vue.draw.Cellule;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 18/12/13.
 */
public class Grid extends JPanel implements ActionListener {
    Cellule[][] grille;
    int rows;
    int cols;
    private Fenetre fenetre;
    private Controleur controleur;

    public Grid(Fenetre fenetre, Controleur controleur, int rows, int cols) {
        super();

        this.fenetre = fenetre;
        this.controleur = controleur;
        this.rows = rows;
        this.cols = cols;

        setLayout(null);

        grille = new Cellule[rows][cols];
    }

    @Override
    public void paintComponent(Graphics g) {
        int k;

        double width = getSize().width;
        double height = getSize().height;

        double htOfRow = height / (rows);
        for (k = 0; k < rows; k++)
            g.drawLine(0, (int) (k * htOfRow), (int) width, (int) (k * htOfRow));

        double wdOfRow = width / (cols);
        for (k = 0; k < cols; k++)
            g.drawLine((int) (k * wdOfRow), 0, (int) (k * wdOfRow), (int) height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
