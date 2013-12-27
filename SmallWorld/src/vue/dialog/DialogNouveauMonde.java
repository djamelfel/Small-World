package vue.dialog;

import controleur.Controleur;
import vue.Fenetre;
import vue.enums.Monde;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 26/12/13.
 */
public class DialogNouveauMonde extends JDialog implements ActionListener {
    private Fenetre fenetre;
    private Controleur controleur;
    private Monde monde;

    public DialogNouveauMonde(Fenetre fenetre, Controleur controleur, Monde monde) {
        super();

        this.fenetre = fenetre;
        this.controleur = controleur;
        this.monde = monde;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
