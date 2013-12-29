package vue.cellule;

import vue.Grille;
import vue.enums.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created by Edwin on 19/12/13.
 */
public class CelluleAnimal extends Cellule implements ActionListener {
    JPopupMenu menu;
    JMenuItem deplacer;
    JMenuItem combattre;
    JMenuItem modifier;
    JMenuItem supprimer;

    public CelluleAnimal(Animal animal, Grille grille, int posX, int posY) {
        super(grille, posX, posY);

        // Initialisation
        menu = new JPopupMenu();
        deplacer = new JMenuItem("Déplacer");
        combattre = new JMenuItem("Combattre");
        modifier = new JMenuItem("Modifier");
        supprimer = new JMenuItem("Supprimer");
        menu.add(deplacer);
        menu.add(combattre);
        menu.addSeparator();
        menu.add(modifier);
        menu.addSeparator();
        menu.add(supprimer);
        deplacer.addActionListener(this);
        combattre.addActionListener(this);
        modifier.addActionListener(this);
        supprimer.addActionListener(this);
        setComponentPopupMenu(menu);
        image = animal.getGrille();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(deplacer)) {
            System.out.println("Déplacer!");
            grille.deplacer(this);
        }
        else if (e.getSource().equals(combattre)) {
            System.out.println("Combattre");
        }
        else if (e.getSource().equals(modifier)) {
            System.out.println("Modifier!");
        }
        else if (e.getSource().equals(supprimer)) {
            System.out.println("Supprimer!");
        }
    }
}
