package vue;

import controleur.Controleur;

import javax.swing.*;

/**
 * Created by Edwin on 17/12/13.
 */
public class Fenetre extends JFrame {
    private Controleur controleur;

    private MenuBar menuBar;

    public Fenetre(Controleur controleur) {
        this.controleur = controleur;

        // Initialisation de la JFrame
        setSize(700, 500);
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

        pack();
        setVisible(true);
    }
}
