package vue;

import controleur.Controleur;
import modele.monde.Map;

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

        toolBar = new ToolBar(this, controleur);
        panelDroit.add(toolBar, BorderLayout.NORTH);

        scrollPaneGrille = new JScrollPane();
        scrollPaneGrille.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPaneGrille.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPaneGrille.getVerticalScrollBar().setUnitIncrement(15);
        scrollPaneGrille.getHorizontalScrollBar().setUnitIncrement(15);
        panelDroit.add(scrollPaneGrille);

        barreEtat = new BarreEtat(this, controleur);
        barreEtat.setSize(0, 40);
        barreEtat.setPreferredSize(barreEtat.getSize());
        panelDroit.add(barreEtat, BorderLayout.SOUTH);


        // Initialisation du panel gauche contenant l'arbre
        arbre = new Arbre();
        scrollPaneArbre = new JScrollPane(arbre);
        scrollPaneArbre.setSize(230, 0);
        scrollPaneArbre.setPreferredSize(scrollPaneArbre.getSize());
        add(scrollPaneArbre, BorderLayout.WEST);
        scrollPaneArbre.setVisible(false);

        pack();
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);

    }

    // Utiliser un observateur ça serait Tip-Top !
    private void activate() {
        panelDroit.setVisible(true);
        scrollPaneArbre.setVisible(true);
        menuBar.activate();
    }

    // Modifie la taille de la grille
    public void setTailleGrille(Map map) {
        grille = new Grille(this, controleur, map);
        arbre.setGrille(grille);
        scrollPaneGrille.setViewportView(grille);
        activate();

    }

    public Grille getGrille() {
        return grille;
    }

    public Arbre getArbre() {
        return arbre;
    }

    public BarreEtat getBarreEtat() {
        return barreEtat;
    }
}
