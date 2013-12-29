package vue.dialog;

import controleur.Controleur;
import vue.Fenetre;
import vue.enums.Decor;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * Created by Edwin on 26/12/13.
 */
public class DialogNouveauMonde extends JDialog implements ActionListener {
    private Fenetre fenetre;
    private Controleur controleur;
    private Decor monde;

    private JPanel caracteristiques;
    private JPanel boutons;
    private JTextField largeur;
    private JTextField hauteur;
    private JButton valider;
    private JButton annuler;
    private MiniGrille position;
    private JLabel positionMonde;

    public DialogNouveauMonde(Fenetre fenetre, Controleur controleur, Decor monde) {
        super();

        this.fenetre = fenetre;
        this.controleur = controleur;
        this.monde = monde;

        // Initialisation de la fenêtre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Nouveau décor - " + monde.getNom());
        setLocation(fenetre.getLocation());
        setSize(350, 450);
        setPreferredSize(getSize());
        setMinimumSize(getPreferredSize());
        setModal(true);

        // JPanel principal
        caracteristiques = new JPanel();
        LineBorder bordure = new LineBorder(Color.BLACK, 1, true);
        TitledBorder titre = new TitledBorder(bordure, "Caractéristiques décor");
        caracteristiques.setBorder(titre);
        caracteristiques.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Largeur
        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 0, 0);
        caracteristiques.add(new JLabel("Largeur (cases) :"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 15, 0, 10);
        largeur = new JTextField();
        largeur.setText("5");
        caracteristiques.add(largeur, gbc);

        // Hauteur
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 0, 0);
        caracteristiques.add(new JLabel("Hauteur (cases) :"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 15, 0, 10);
        hauteur = new JTextField();
        hauteur.setText("5");
        caracteristiques.add(hauteur, gbc);

        // Position
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 0, 0);
        caracteristiques.add(new JLabel("Position :"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 15, 0, 10);
        JPanel panelPosition = new JPanel();
        panelPosition.setLayout(new GridLayout(1, 1));
        positionMonde = new JLabel("Aucune cellule sélectionnée!");
        panelPosition.add(positionMonde);
        caracteristiques.add(panelPosition, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 0;
        gbc.gridheight = 1;
        gbc.weightx = gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 15, 10);
        position = new MiniGrille(fenetre.getGrille(), this);
        gbc.ipadx = (int) position.getSize().getWidth();
        gbc.ipady = (int) position.getSize().getHeight();
        caracteristiques.add(position, gbc);

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

    public JTextField getLargeur() {
        return largeur;
    }

    public JTextField getHauteur() {
        return hauteur;
    }

    public JLabel getPositionMonde() {
        return positionMonde;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(valider)) {
            if (largeur.getText().equals("") || !Pattern.matches("\\d*", largeur.getText()) ||
                    Integer.parseInt(largeur.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir une largeur valide!");
                return;
            }
            if (hauteur.getText().equals("") || !Pattern.matches("\\d*", hauteur.getText()) ||
                    Integer.parseInt(hauteur.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir une hauteur valide!");
                return;
            }
            if (position.getCoordonnees() == null) {
                JOptionPane.showMessageDialog(this, "Veuillez choisir une cellule valide!");
                return;
            }

            controleur.ajouterMonde(monde, Integer.parseInt(largeur.getText()), Integer.parseInt(hauteur.getText()),
                    position.getCoordonnees());
            dispose();
        }
        else if (e.getSource().equals(annuler)) {
            dispose();
        }
    }
}
