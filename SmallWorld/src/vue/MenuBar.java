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
    private JMenu aide;

    private JMenuItem nouveau;
    private JMenuItem sauvegarder;
    private JMenuItem charger;
    private JMenuItem quitter;
    private JMenuItem aPropos;

    public MenuBar(Fenetre fenetre, Controleur controleur) {
        this.fenetre = fenetre;
        this.controleur = controleur;

        // Menu fichier
        fichier = new JMenu("Fichier");
        nouveau = new JMenuItem("Nouvelle Partie...");
        sauvegarder = new JMenuItem("Sauvegarder...");
        charger = new JMenuItem("Charger...");
        quitter = new JMenuItem("Quitter");

        nouveau.setMnemonic('n');
        sauvegarder.setMnemonic('s');
        charger.setMnemonic('c');
        quitter.setMnemonic('q');

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

        // Menu aide
        aide = new JMenu("Aide");
        aPropos = new JMenuItem("À propos");

        aPropos.setMnemonic('a');

        aPropos.addActionListener(this);

        aide.add(aPropos);

        add(aide);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(nouveau)) {
            new DialogNouveau(fenetre, controleur);
        }
        else if (e.getSource().equals(sauvegarder)) {
            new DialogSauvegarder(fenetre, controleur);
        }
        else if (e.getSource().equals(charger)) {
            new DialogCharger(fenetre, controleur);
        }
        else if (e.getSource().equals(quitter)) {
            fenetre.dispose();
        }
        else if (e.getSource().equals(aPropos)) {
            JOptionPane.showMessageDialog(fenetre, "Projet réalisé par Djamel Fellah, Benjamin Descamps, Edwin Damy et Mélanie Taboyan.");
        }
    }

    public void activate() {
        sauvegarder.setEnabled(true);
    }
}
