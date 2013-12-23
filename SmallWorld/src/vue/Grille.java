package vue;

import controleur.Controleur;
import vue.cellule.Cellule;
import vue.cellule.CelluleAnimal;
import vue.cellule.CelluleMonde;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Edwin on 18/12/13.
 */
public class Grille extends JPanel implements ActionListener {
    private Cellule[][] grille;
    private int rows;
    private int cols;
    private ArrayList<CelluleAnimal> animalAL;
    private ArrayList<CelluleMonde> mondeAL;

    private Fenetre fenetre;
    private Controleur controleur;

    public Grille(Fenetre fenetre, Controleur controleur, int rows, int cols) {
        super();

        // Initialisation
        this.fenetre = fenetre;
        this.controleur = controleur;
        this.rows = rows;
        this.cols = cols;
        grille = new Cellule[rows][cols];
        animalAL = new ArrayList<>();
        mondeAL = new ArrayList<>();

        setLayout(null);
    }

    public boolean ajouterAnimal(String type, int posX, int posY) {
        CelluleAnimal tmp = new CelluleAnimal(type, posX, posY);
        animalAL.add(tmp);
        add(tmp);

        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Dimensions cellule
        double width = getSize().width;
        double height = getSize().height;
        double htOfRow = height / rows;
        double wdOfRow = width / cols;

        // Affichage des animaux
        for (CelluleAnimal celluleAnimal : animalAL) {
            celluleAnimal.setBounds((int) (celluleAnimal.getPosX() * width) + 1,
                    (int) (celluleAnimal.getPosY() * height) + 1, (int) wdOfRow - 1, (int) htOfRow - 1);
            celluleAnimal.setSize(celluleAnimal.getBounds().width, celluleAnimal.getBounds().height);
            celluleAnimal.setPreferredSize(celluleAnimal.getSize());
            celluleAnimal.repaint();
            System.out.println(celluleAnimal.getBounds());
        }

        int k;

        for (k = 0; k <= rows; k++)
            g.drawLine(0, (int) (k * htOfRow), (int) width, (int) (k * htOfRow));

        for (k = 0; k < cols; k++)
            g.drawLine((int) (k * wdOfRow), 0, (int) (k * wdOfRow), (int) height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
