package vue.dialog;

import vue.Grille;
import vue.cellule.CelluleAnimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created by Edwin on 26/12/13.
 */
public class MiniGrille extends JPanel implements MouseListener {
    private Grille grille;
    private DialogNouveauAnimal dialogNouveauAnimal;
    private ArrayList<CelluleAnimal> animalAL;
    private Point caseSelectionne;
    private Point coordonnees;

    public MiniGrille(Grille grille, DialogNouveauAnimal dialogNouveauAnimal) {
        super();

        this.grille = grille;
        this.dialogNouveauAnimal = dialogNouveauAnimal;

        // Initialisation
        setLayout(null);
        setBackground(Color.GREEN);
        setSize(300, 200);
        setPreferredSize(getSize());

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Dimensions cellule
        int rows = grille.getRows();
        int cols = grille.getCols();
        int width = getSize().width;
        int height = getSize().height;
        int wdOfRow = width / cols;
        int htOfRow = height / rows;
        setSize(wdOfRow * cols, htOfRow * rows);
        setPreferredSize(getSize());

        int i;
        // Tracage des lignes
        for (i = 0; i <= rows; i++) {
            if (i == rows)
                g2.drawLine(0, i * htOfRow - 1, width, i * htOfRow - 1);
            g2.drawLine(0, i * htOfRow, width, i * htOfRow);

        }
        // Tracage des colonnes
        for (i = 0; i <= cols; i++) {
            if (i == cols)
                g2.drawLine(i * wdOfRow - 1, 0, i * wdOfRow - 1, height);
            g2.drawLine(i * wdOfRow, 0, i * wdOfRow, height);
        }

        // Affichage des différentes cases occupés par les animaux
        animalAL = grille.getAnimalAL();
        g2.setColor(Color.RED);
        for (CelluleAnimal animal : animalAL) {
            int wdOfCell = wdOfRow;
            int htOfCell = htOfRow;
            if (animal.getPosX() == cols - 1)
                wdOfCell--;
            if (animal.getPosY() == rows - 1)
                htOfCell--;
            g2.fillRect(animal.getPosX() * wdOfRow + 1, animal.getPosY() * htOfRow + 1, wdOfCell - 1, htOfCell - 1);
        }

        // Affichage de la case sélectionné
        g2.setColor(Color.BLUE);
        if (caseSelectionne != null) {
            int x = 0;
            for (i = 0; i < cols; i++) {
                x = i * wdOfRow + 1;
                if (x > caseSelectionne.x) {
                    x = (i - 1) * wdOfRow + 1;
                    break;
                }
            }
            int y = 0;
            for (i = 0; i < rows; i++) {
                y = i * htOfRow + 1;
                if (y > caseSelectionne.y) {
                    y = (i - 1) * htOfRow + 1;
                    break;
                }
            }

            int wdOfCell = wdOfRow;
            int htOfCell = htOfRow;
            if ((x - 1) / wdOfRow == cols - 1)
                wdOfCell--;
            if ((y - 1) / htOfRow == rows - 1)
                htOfCell--;
            g2.fillRect(x, y, wdOfCell - 1, htOfCell - 1);

            coordonnees = new Point((x - 1) / wdOfRow, (y - 1) / htOfRow);
            dialogNouveauAnimal.getPositionAnimal().setText("x = " + coordonnees.x + " y = " + coordonnees.y);
        }
    }

    private boolean caseContientAnimal(Point point) {
        int rows = grille.getRows();
        int cols = grille.getCols();
        int width = getSize().width;
        int height = getSize().height;
        int wdOfRow = width / cols;
        int htOfRow = height / rows;
        for (CelluleAnimal animal : animalAL) {
            // Dimensions cellule
            int wdOfCell = wdOfRow;
            int htOfCell = htOfRow;
            if (animal.getPosX() == cols - 1)
                wdOfCell--;
            if (animal.getPosY() == rows - 1)
                htOfCell--;
            // Vérification de la case à partir des coordonnées
            if (point.x >= animal.getPosX() * wdOfRow + 1 && point.x <= animal.getPosX() * wdOfRow + wdOfCell) {
                if (point.y >= animal.getPosY() * htOfRow + 1 && point.y <= animal.getPosY() * htOfRow + htOfCell) {
                    return true;
                }
            }
        }
        return false;
    }

    public Point getCoordonnees() {
        return coordonnees;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (caseContientAnimal(e.getPoint())) {
            JOptionPane.showMessageDialog(getTopLevelAncestor(), "La cellule sélectionné contient déjà un animal!");
        }
        else {
            caseSelectionne = e.getPoint();
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
}
