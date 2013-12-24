package vue.dialog;

import controleur.Controleur;
import vue.Fenetre;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

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
    private JTextField rows;
    private JTextField cols;

    public DialogNouveau(Fenetre fenetre, Controleur controleur) {
        this.fenetre = fenetre;
        this.controleur = controleur;

        // Initialisation de la fenêtre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Nouvelle Partie");
        setLocation(fenetre.getLocation());
        setSize(250, 175);
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
        nom.setText("magicedwin");
        caracteristiques.add(nom, gbc);

        // Taille
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        caracteristiques.add(new JLabel("Taille :"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        rows = new JTextField();
        rows.setText("15");
        caracteristiques.add(rows, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        caracteristiques.add(new JLabel("x"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        cols = new JTextField();
        cols.setText("25");
        caracteristiques.add(cols, gbc);

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
            if (nom.getText().equals("") || rows.getText().equals("") || cols.getText().equals("") ||
                    !Pattern.matches("\\d*", rows.getText()) || Integer.parseInt(rows.getText()) < 0 ||
                    !Pattern.matches("\\d*", cols.getText()) || Integer.parseInt(cols.getText()) < 0) {
                JOptionPane.showMessageDialog(fenetre, "Eggs are not supposed to be green.");
                return;
            }
            controleur.creerPartie(nom.getText(), Integer.parseInt(rows.getText()), Integer.parseInt(cols.getText()));
            dispose();
            fenetre.setFocusableWindowState(true);
        }
        else if (e.getSource().equals(annuler)) {
            dispose();
            fenetre.setFocusableWindowState(true);
        }
    }
}
