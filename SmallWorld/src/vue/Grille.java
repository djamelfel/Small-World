package vue;

import controleur.Controleur;
import vue.cellule.Cellule;
import vue.cellule.CelluleAnimal;
import vue.cellule.CelluleMonde;
import vue.enums.Animal;

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
        setBackground(Color.GREEN);
    }

    public boolean ajouterAnimal(Animal animal, int posX, int posY) {
        CelluleAnimal tmp = new CelluleAnimal(animal, posX, posY);
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
        width = 1280;
        height = 720;
        int wdOfRow = (int) (width / cols);
        int htOfRow = (int) (height / rows);
        setSize(wdOfRow * cols, htOfRow * rows);
        setPreferredSize(getSize());

        // Affichage des animaux
        for (CelluleAnimal celluleAnimal : animalAL) {
            // Optimiser l'affichage des cases pour éviter de superposer une ligne ou une colonne
            double wdOfCell = wdOfRow;
            double htOfCell = htOfRow;
            if (celluleAnimal.getPosX() == cols - 1)
                wdOfCell--;
            if (celluleAnimal.getPosY() == rows - 1)
                htOfCell--;
            celluleAnimal.setBounds(celluleAnimal.getPosX() * wdOfRow + 1, celluleAnimal.getPosY() * htOfRow + 1,
                    (int) wdOfCell - 1, (int) htOfCell - 1);
            celluleAnimal.setSize(celluleAnimal.getBounds().width, celluleAnimal.getBounds().height);
            celluleAnimal.setPreferredSize(celluleAnimal.getSize());
            celluleAnimal.repaint();
        }

        int i;
        Shape line; // Permet de tracer des lignes à partir de coordonnées Double =)
        // Tracage des lignes
        for (i = 0; i <= rows; i++) {
            if (i == rows)
                g2.drawLine(0, i * htOfRow - 1, (int) width, i * htOfRow - 1);
            g2.drawLine(0, i * htOfRow, (int) width, i * htOfRow);
            /*if (i == rows)
                line = new Line2D.Double(0, i * htOfRow - 1, width, i * htOfRow - 1);
            else
                line = new Line2D.Double(0, i * htOfRow, width, i * htOfRow);
            g2.draw(line);*/

        }
        // Tracage des colonnes
        for (i = 0; i <= cols; i++) {
            if (i == cols)
                g2.drawLine(i * wdOfRow - 1, 0, i * wdOfRow - 1, (int) height);
            g2.drawLine(i * wdOfRow, 0, i * wdOfRow, (int) height);
            /*if (i == cols)
                line = new Line2D.Double(i * wdOfRow - 1, 0, i * wdOfRow - 1, height);
            else
                line = new Line2D.Double(i * wdOfRow, 0, i * wdOfRow, height);
            g2.draw(line);*/
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public ArrayList<CelluleAnimal> getAnimalAL() {
        return animalAL;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
