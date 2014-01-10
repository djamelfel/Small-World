package vue.dialog;

import vue.Grille;
import vue.cellule.CelluleAnimal;
import vue.cellule.CelluleMonde;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Edwin on 26/12/13.
 */
public class MiniGrille extends JPanel implements MouseListener {
    private Grille grille;
    private JDialog dialogNouveau;
    private ArrayList<CelluleAnimal> animalAL;
    private ArrayList<CelluleMonde> mondeAl;
    private Point caseSelectionne;
    private Point coordonnees;

    public MiniGrille(Grille grille, JDialog dialogNouveau) {
        super();

        this.grille = grille;
        this.dialogNouveau = dialogNouveau;

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

        // Si le JDialog est pour ajouter un animal
        // On affiche, les animaux déjà présents.
        if (dialogNouveau instanceof DialogNouveauAnimal) {
            DialogNouveauAnimal dialogNouveauAnimal = (DialogNouveauAnimal) dialogNouveau;

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

            // Affichage de la case sélectionnée
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

        // Si le JDialog est pour ajouter un décor
        if (dialogNouveau instanceof DialogNouveauDecor) {
            DialogNouveauDecor dialogNouveauDecor = (DialogNouveauDecor) dialogNouveau;

            // Affichage des cases sélectionnées
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
                for (i = 0; i < Integer.parseInt(dialogNouveauDecor.getHauteur().getText()); i++) {
                    coordonnees = new Point((x - 1) / wdOfRow, (y - 1) / htOfRow);
                    coordonnees.y += i;
                    if (coordonnees.y == rows - 1) {
                        dialogNouveauDecor.getHauteur().setText(String.valueOf(i + 1));
                        //i = Integer.parseInt(dialogNouveauMonde.getHauteur().getText());
                    }
                    for (int j = 0; j < Integer.parseInt(dialogNouveauDecor.getLargeur().getText()); j++) {
                        coordonnees = new Point((x - 1) / wdOfRow, (y - 1) / htOfRow);
                        coordonnees.x += j;
                        coordonnees.y += i;
                        if (coordonnees.x == cols - 1) {
                            dialogNouveauDecor.getLargeur().setText(String.valueOf(j + 1));
                            j = Integer.parseInt(dialogNouveauDecor.getLargeur().getText());
                        }
                        g2.fillRect(coordonnees.x * wdOfRow + 1, coordonnees.y * htOfRow + 1,
                                wdOfCell - 1, htOfCell - 1);
                    }
                }
                coordonnees = new Point((x - 1) / wdOfRow, (y - 1) / htOfRow);
                dialogNouveauDecor.getPositionDecor().setText("x = " + coordonnees.x + " y = " + coordonnees.y);
            }
            else {
                dialogNouveauDecor.getPositionDecor().setText("Aucune cellule sélectionnée!");
            }
        }
        // Si le JDialog est pour ajouter un animal
        // On affiche, les animaux déjà présents.
        if (dialogNouveau instanceof DialogNouveauNourriture) {
            DialogNouveauNourriture dialogNouveauNourriture = (DialogNouveauNourriture) dialogNouveau;

            // Affichage des différentes cases occupés par les animaux
            mondeAl = grille.getMondeAL();
            g2.setColor(Color.RED);
            for (CelluleMonde monde : mondeAl) {
                if (monde.get_case().getNourriture() != null) {
                    int wdOfCell = wdOfRow;
                    int htOfCell = htOfRow;
                    if (monde.getPosX() == cols - 1)
                        wdOfCell--;
                    if (monde.getPosY() == rows - 1)
                        htOfCell--;
                    g2.fillRect(monde.getPosX() * wdOfRow + 1, monde.getPosY() * htOfRow + 1, wdOfCell - 1,
                            htOfCell - 1);
                }
            }

            // Affichage de la case sélectionnée
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
                dialogNouveauNourriture.getPositionMonde().setText("x = " + coordonnees.x + " y = " + coordonnees.y);
            }
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

    private boolean caseContientNourriture(Point point) {
        int rows = grille.getRows();
        int cols = grille.getCols();
        int width = getSize().width;
        int height = getSize().height;
        int wdOfRow = width / cols;
        int htOfRow = height / rows;
        for (CelluleMonde monde : mondeAl) {
            if (monde.get_case().getNourriture() != null) {
                // Dimensions cellule
                int wdOfCell = wdOfRow;
                int htOfCell = htOfRow;
                if (monde.getPosX() == cols - 1)
                    wdOfCell--;
                if (monde.getPosY() == rows - 1)
                    htOfCell--;
                // Vérification de la case à partir des coordonnées
                if (point.x >= monde.getPosX() * wdOfRow + 1 && point.x <= monde.getPosX() * wdOfRow + wdOfCell) {
                    if (point.y >= monde.getPosY() * htOfRow + 1 && point.y <= monde.getPosY() * htOfRow + htOfCell) {
                        return true;
                    }
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
        // DialogNouveauAnimal
        if (dialogNouveau instanceof DialogNouveauAnimal) {
            if (caseContientAnimal(e.getPoint())) {
                JOptionPane.showMessageDialog(getTopLevelAncestor(), "La cellule sélectionné contient déjà un animal!");
            }
            else {
                caseSelectionne = e.getPoint();
                repaint();
            }
        }
        // DialogNouveauDecor
        else if (dialogNouveau instanceof DialogNouveauDecor) {
            if (!Pattern.matches("\\d*", ((DialogNouveauDecor) dialogNouveau).getLargeur().getText()) ||
                    Integer.parseInt(((DialogNouveauDecor) dialogNouveau).getLargeur().getText()) <= 0) {
                JOptionPane.showMessageDialog(getTopLevelAncestor(), "Veuillez saisir une largeur valide!");
                caseSelectionne = null;
            }
            else if (!Pattern.matches("\\d*", ((DialogNouveauDecor) dialogNouveau).getHauteur().getText()) ||
                    Integer.parseInt(((DialogNouveauDecor) dialogNouveau).getHauteur().getText()) <= 0) {
                JOptionPane.showMessageDialog(getTopLevelAncestor(), "Veuillez saisir une hauteur valide!");
                caseSelectionne = null;
            }
            else {
                caseSelectionne = e.getPoint();
            }
            repaint();
        }
        // DialogNouveauMonde
        if (dialogNouveau instanceof DialogNouveauNourriture) {
            if (caseContientNourriture(e.getPoint())) {
                JOptionPane.showMessageDialog(getTopLevelAncestor(), "La cellule sélectionné contient déjà de la nourriture!");
            }
            else {
                caseSelectionne = e.getPoint();
                repaint();
            }
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
