package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 18/12/13.
 */
public class DrawGrille extends JPanel {
    private Fenetre fenetre;
    private Controleur controleur;

    public DrawGrille(Fenetre fenetre, Controleur controleur) {
        super();

        this.fenetre = fenetre;
        this.controleur = controleur;

        setBackground(Color.BLUE);
    }
}
