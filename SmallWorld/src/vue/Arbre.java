package vue;

import vue.cellule.Cellule;
import vue.cellule.CelluleAnimal;
import vue.cellule.CelluleMonde;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

/**
 * Created by Edwin on 19/12/13.
 */
public class Arbre extends JPanel {
    private Grille grille;

    private DefaultTreeModel treeModel;
    private DefaultMutableTreeNode monde;
    private DefaultMutableTreeNode animaux;
    private DefaultMutableTreeNode nourritures;

    private JTree tree;

    public Arbre() {
        super();

        monde = new DefaultMutableTreeNode("Monde");
        animaux = new DefaultMutableTreeNode("Animaux");
        nourritures = new DefaultMutableTreeNode("Nourritures");

        monde.add(animaux);
        monde.add(nourritures);

        treeModel = new DefaultTreeModel(monde);
        tree = new JTree(treeModel);

        setLayout(new BorderLayout());
        add(tree);
    }

    public void setGrille(Grille grille) {
        this.grille = grille;

        animaux.removeAllChildren();
        nourritures.removeAllChildren();

        for (int i = 0; i < grille.getAnimalAL().size(); i++) {
            ajouterNoeud(grille.getAnimalAL().get(i));
        }
        for (int i = 0; i < grille.getMondeAL().size(); i++) {
            if (grille.getMondeAL().get(i).get_case().getNourriture() != null) {
                ajouterNoeud(grille.getMondeAL().get(i));
            }
        }
    }

    public void ajouterNoeud(Cellule cellule) {
        if (cellule instanceof CelluleAnimal) {
            DefaultMutableTreeNode animal = new DefaultMutableTreeNode(cellule);
            animaux.add(animal);
        }
        else if (cellule instanceof CelluleMonde) {
            if (((CelluleMonde) cellule).get_case().getNourriture() != null) {
                DefaultMutableTreeNode nourriture = new DefaultMutableTreeNode(cellule);
                nourritures.add(nourriture);
            }
        }
        tree.updateUI();
    }

    public void supprimerNoeud(Cellule cellule) {
        if (cellule instanceof CelluleAnimal) {
            for (int i = 0; i < grille.getAnimalAL().size(); i++) {
                DefaultMutableTreeNode noeud = (DefaultMutableTreeNode) animaux.getChildAt(i);
                if (noeud.getUserObject().equals(cellule))
                    animaux.remove(i);
            }
        }
        else if (cellule instanceof CelluleMonde) {
            for (int i = 0; i < grille.getMondeAL().size(); i++) {
                if (grille.getMondeAL().get(i).get_case().getNourriture() != null) {
                    DefaultMutableTreeNode noeud = (DefaultMutableTreeNode) monde.getChildAt(i);
                    if (noeud.getUserObject().equals(cellule))
                        nourritures.remove(i);
                }
            }
        }
        tree.updateUI();
    }
}
