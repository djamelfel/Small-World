package vue;

import controleur.Controleur;
import vue.cellule.CelluleAnimal;
import vue.cellule.CelluleMonde;
import vue.enums.Animal;
import vue.enums.Decor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import modele.especes.Espece;

/**
 * Created by Edwin on 18/12/13.
 */
public class Grille extends JPanel {
    //private Cellule[][] grille;
    private int rows;
    private int cols;
    private ArrayList<CelluleAnimal> animalAL;
    private ArrayList<CelluleMonde> mondeAL;

    private Fenetre fenetre;
    private Controleur controleur;

    private boolean autoriserDeplacement;
    private CelluleMonde deplacement;
    private CelluleAnimal aDeplacer;

    public Grille(Fenetre fenetre, Controleur controleur, int rows, int cols) {
        super();

        // Initialisation
        this.fenetre = fenetre;
        this.controleur = controleur;
        this.rows = rows;
        this.cols = cols;
        //grille = new Cellule[rows][cols];
        animalAL = new ArrayList<>();
        mondeAL = new ArrayList<>();
        initMonde();

        setLayout(null);
        setBackground(Color.BLACK);
    }

    public boolean initMonde() {
        CelluleMonde tmp;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                tmp = new CelluleMonde(Decor.herbe, this, j, i);
                mondeAL.add(tmp);
                add(tmp);
            }
        }
        return true;
    }

    public boolean ajouterAnimal(Espece instanceEspece) {
        CelluleAnimal tmp = new CelluleAnimal(instanceEspece, this);
        animalAL.add(tmp);
        add(tmp);
        repaint(); // refresh la grille
        return true;
    }

    public boolean ajouterDecor(Decor decor, int posX, int posY) {
        CelluleMonde tmp = new CelluleMonde(decor, this, posX, posY);
        mondeAL.add(tmp);
        add(tmp);
        repaint();// refresh la grille
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

        double wdOfCell;
        double htOfCell;

        // Affichage du monde
        for (CelluleMonde celluleMonde : mondeAL) {
            // Optimiser l'affichage des cases pour éviter de superposer une ligne ou une colonne
            wdOfCell = wdOfRow;
            htOfCell = htOfRow;
            if (celluleMonde.getPosX() == cols - 1)
                wdOfCell--;
            if (celluleMonde.getPosY() == rows - 1)
                htOfCell--;
            celluleMonde.setBounds(celluleMonde.getPosX() * wdOfRow + 1, celluleMonde.getPosY() * htOfRow + 1,
                    (int) wdOfCell - 1, (int) htOfCell - 1);
            celluleMonde.setSize(celluleMonde.getBounds().width, celluleMonde.getBounds().height);
            celluleMonde.setPreferredSize(celluleMonde.getSize());
            setComponentZOrder(celluleMonde, 1);
            //celluleMonde.repaint();
        }

        // Affichage des animaux
        for (CelluleAnimal celluleAnimal : animalAL) {
            // Optimiser l'affichage des cases pour éviter de superposer une ligne ou une colonne
            wdOfCell = wdOfRow;
            htOfCell = htOfRow;
            if (celluleAnimal.getPosX() == cols - 1)
                wdOfCell--;
            if (celluleAnimal.getPosY() == rows - 1)
                htOfCell--;
            celluleAnimal.setBounds(celluleAnimal.getPosX() * wdOfRow + 1, celluleAnimal.getPosY() * htOfRow + 1,
                    (int) wdOfCell - 1, (int) htOfCell - 1);
            celluleAnimal.setSize(celluleAnimal.getBounds().width, celluleAnimal.getBounds().height);
            celluleAnimal.setPreferredSize(celluleAnimal.getSize());
            setComponentZOrder(celluleAnimal, 0);
            //celluleAnimal.repaint();
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

    public ArrayList<CelluleAnimal> getAnimalAL() {
        return animalAL;
    }

    // En cours de réalisation
    // Une idée de génie arrive
    public boolean deplacer(CelluleAnimal celluleAnimal) {
        deplacement = null;
        autoriserDeplacement = true;
        Iterator<CelluleAnimal> it = animalAL.iterator();
        while (it.hasNext()) {
            aDeplacer = it.next();
            if (aDeplacer.equals(celluleAnimal))
                break;
        }
        Deplacement run = new Deplacement();
        Thread thread = new Thread(run);
        thread.start();
        return true;
    }

    private class Deplacement implements Runnable {
        @Override
        public void run() {
            while (deplacement == null) {

            }
            aDeplacer.setPosX(deplacement.getPosX());
            aDeplacer.setPosY(deplacement.getPosY());
            autoriserDeplacement = false;
            repaint();
        }
    }

    public boolean isAutoriserDeplacement() {
        return autoriserDeplacement;
    }

    public void setDeplacement(CelluleMonde deplacement) {
        this.deplacement = deplacement;
    }
}
