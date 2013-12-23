package vue.dialog;

import controleur.Controleur;
import vue.Fenetre;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 17/12/13.
 */
public class DialogNouveau extends JFrame implements ActionListener {
    private Fenetre fenetre;
    private Controleur controleur;

    private JPanel caracteristiques;
    private JPanel boutons;
    private JButton valider;
    private JButton annuler;
    private JTextField nom;

    public DialogNouveau(Fenetre fenetre, Controleur controleur) {
        this.fenetre = fenetre;
        this.controleur = controleur;

        // Initialisation de la fenêtre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Nouvelle Partie");
        setLocation(fenetre.getLocation());
        setSize(275, 135);
        setPreferredSize(getSize());
        setMinimumSize(getPreferredSize());

        // JPanel principal
        caracteristiques = new JPanel();
        LineBorder bordure = new LineBorder(Color.BLACK, 1, true);
        TitledBorder titre = new TitledBorder(bordure, "Caractéristiques joueur");
        caracteristiques.setBorder(titre);
        caracteristiques.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Nom
        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 0, 0);
        caracteristiques.add(new JLabel("Nom :"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 15, 0, 10);
        nom = new JTextField();
        caracteristiques.add(nom, gbc);

        // Boutons
        boutons = new JPanel();

        valider = new JButton("Valider");
        valider.addActionListener(this);
        boutons.add(valider);

        annuler = new JButton("Annuler");
        annuler.addActionListener(this);
        boutons.add(annuler);

        // Ajout des différents JPanel
        add(caracteristiques);
        add(boutons, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(valider)) {
            if (nom.getText().equals("")) {
                JOptionPane.showMessageDialog(fenetre, "Eggs are not supposed to be green.");
                return;
            }
            controleur.creerPartie(nom.getText());
            dispose();
        }
        else if (e.getSource().equals(annuler)) {
            dispose();
        }
    }
}
