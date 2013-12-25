package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 17/12/13.
 */
public class Fenetre extends JFrame {
    private Controleur controleur;

    private JPanel panelDroit;
    private MenuBar menuBar;
    private Grille grille;
    private JScrollPane scrollPaneGrille;
    private Arbre arbre;
    private JScrollPane scrollPaneArbre;
    private BarreEtat barreEtat;
    private ToolBar toolBar;

    public Fenetre(Controleur controleur) {
        this.controleur = controleur;

        // Initialisation de la JFrame
        setSize(1080, 720);
        setPreferredSize(getSize());
        setMinimumSize(getPreferredSize());
        setTitle("Small World - LO43");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        // Initialisation de la barre de menu
        menuBar = new MenuBar(this, controleur);
        setJMenuBar(menuBar);

        // Initialisation du panel droit contenant la zone de jeu, la toolbar et la barre d'informations
        panelDroit = new JPanel();
        panelDroit.setLayout(new BorderLayout(0, 10));
        add(panelDroit, BorderLayout.CENTER);
        panelDroit.setVisible(false);

        toolBar = new ToolBar();
        panelDroit.add(toolBar, BorderLayout.NORTH);

        grille = new Grille(this, controleur, 15, 25);
        scrollPaneGrille = new JScrollPane(grille);
        scrollPaneGrille.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneGrille.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelDroit.add(scrollPaneGrille);

        barreEtat = new BarreEtat(this, controleur);
        panelDroit.add(barreEtat, BorderLayout.SOUTH);

        // Initialisation du panel gauche contenant l'arbre
        arbre = new Arbre();
        scrollPaneArbre = new JScrollPane(arbre);
        scrollPaneArbre.setSize(150, 0);
        scrollPaneArbre.setPreferredSize(scrollPaneArbre.getSize());
        add(scrollPaneArbre, BorderLayout.WEST);
        scrollPaneArbre.setVisible(false);

        pack();
        setVisible(true);

        // Test grille
        grille.ajouterAnimal("lion", 0, 0);
        grille.ajouterAnimal("lion", 0, 1);
        grille.ajouterAnimal("lion", 1, 0);
        grille.ajouterAnimal("lion", 0, 14);
        grille.ajouterAnimal("lion", 24, 0);
        grille.ajouterAnimal("lion", 24, 14);
        grille.ajouterAnimal("lion", 24, 1);
        grille.ajouterAnimal("lion", 23, 10);
        grille.ajouterAnimal("lion", 22, 9);
    }

    // Utiliser un observateur ça serait Tip-Top !
    public void activate() {
        panelDroit.setVisible(true);
        scrollPaneArbre.setVisible(true);
        menuBar.activate();
    }

    // Modifie la taille de la grille
    public void setTailleGrille(int rows, int cols) {
        grille.setRows(rows);
        grille.setCols(cols);
        grille.repaint();
    }
}
