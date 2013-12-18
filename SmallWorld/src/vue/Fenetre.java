package vue;

import controleur.Controleur;

import javax.swing.*;

/**
 * Created by Edwin on 17/12/13.
 */
public class Fenetre extends JFrame {
    private Controleur controleur;

    private MenuBar menuBar;
    private DrawGrille drawGrille;

    public Fenetre(Controleur controleur) {
        this.controleur = controleur;

        // Initialisation de la JFrame
        setSize(800, 600);
        setPreferredSize(getSize());
        setMinimumSize(getPreferredSize());
        setTitle("Small World - LO43");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Initialisation de la barre de menu
        menuBar = new MenuBar(this, controleur);
        setJMenuBar(menuBar);

        // Initialisation de la zone de jeu
        drawGrille = new DrawGrille(this, controleur);
        drawGrille.setVisible(false);
        add(drawGrille);

        pack();
        setVisible(true);
    }

    // Utiliser un observateur ça serait Tip-Top !
    public void activate() {
        drawGrille.setVisible(true);
        menuBar.activate();
    }
}
