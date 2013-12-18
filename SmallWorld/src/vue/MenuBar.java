package vue;

import controleur.Controleur;
import vue.dialog.DialogCharger;
import vue.dialog.DialogNouveau;
import vue.dialog.DialogSauvegarder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 17/12/13.
 */
public class MenuBar extends JMenuBar implements ActionListener {
    private Fenetre fenetre;
    private Controleur controleur;

    private JMenu fichier;

    private JMenuItem nouveau;
    private JMenuItem sauvegarder;
    private JMenuItem charger;
    private JMenuItem quitter;

    public MenuBar(Fenetre fenetre, Controleur controleur) {
        this.fenetre = fenetre;
        this.controleur = controleur;

        // Menu fichier
        fichier = new JMenu("Fichier");
        nouveau = new JMenuItem("Nouvelle Partie...");
        sauvegarder = new JMenuItem("Sauvegarder...");
        charger = new JMenuItem("Charger...");
        quitter = new JMenuItem("Quitter");

        nouveau.addActionListener(this);
        sauvegarder.addActionListener(this);
        charger.addActionListener(this);
        quitter.addActionListener(this);

        fichier.add(nouveau);
        fichier.addSeparator();
        fichier.add(sauvegarder);
        fichier.add(charger);
        fichier.addSeparator();
        fichier.add(quitter);

        sauvegarder.setEnabled(false);

        add(fichier);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nouveau)) {
            new DialogNouveau(fenetre, controleur);
        } else if (e.getSource().equals(sauvegarder)) {
            new DialogSauvegarder(fenetre, controleur);
        } else if (e.getSource().equals(charger)) {
            new DialogCharger(fenetre, controleur);
        } else if (e.getSource().equals(quitter)) {
            fenetre.dispose();
        }
    }

    public void activate() {
        sauvegarder.setEnabled(true);
    }
}
