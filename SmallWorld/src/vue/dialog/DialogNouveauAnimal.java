package vue.dialog;

import controleur.Controleur;
import vue.Fenetre;
import vue.enums.Animal;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 19/12/13.
 */
public class DialogNouveauAnimal extends JDialog implements ActionListener {
    private Fenetre _fenetre;
    private Controleur _controleur;
    private Animal _animal;

    private JPanel caracteristiques;
    private JPanel boutons;
    private JButton valider;
    private JButton annuler;
    private JTextField nom;
    private JRadioButton male;
    private JRadioButton femelle;
    private JRadioButton leaderOui;
    private JRadioButton leaderNon;
    private MiniGrille position;
    private JLabel positionAnimal;

    public DialogNouveauAnimal(Fenetre fenetre, Controleur controleur, Animal animal) {
        super();

        _fenetre = fenetre;
        _controleur = controleur;
        _animal = animal;

        // Initialisation de la fenêtre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Nouvel Animal - " + _animal);
        setLocation(_fenetre.getLocation());
        setSize(350, 450);
        setPreferredSize(getSize());
        setMinimumSize(getPreferredSize());
        setModal(true);

        // JPanel principal
        caracteristiques = new JPanel();
        LineBorder bordure = new LineBorder(Color.BLACK, 1, true);
        TitledBorder titre = new TitledBorder(bordure, "Caractéristiques animal");
        caracteristiques.setBorder(titre);
        caracteristiques.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Nom
        gbc.gridx = gbc.gridy = 0;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
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
        nom.setText("Roger");
        caracteristiques.add(nom, gbc);

        // Sexe
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 0, 0);
        caracteristiques.add(new JLabel("Sexe :"), gbc);

        male = new JRadioButton("Male");
        femelle = new JRadioButton("Femelle");
        JPanel radio = new JPanel();
        radio.setLayout(new GridLayout(1, 2));
        radio.add(male);
        radio.add(femelle);
        male.setSelected(true);
        male.addActionListener(this);
        femelle.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 15, 0, 10);
        caracteristiques.add(radio, gbc);

        // Leader
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 0, 0);
        caracteristiques.add(new JLabel("Leader :"), gbc);

        leaderOui = new JRadioButton("Oui");
        leaderNon = new JRadioButton("Non");
        JPanel leader = new JPanel();
        leader.setLayout(new GridLayout(1, 2));
        leader.add(leaderOui);
        leader.add(leaderNon);
        leaderNon.setSelected(true);
        leaderOui.addActionListener(this);
        leaderNon.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 15, 0, 10);
        caracteristiques.add(leader, gbc);

        // Position
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 0, 0);
        caracteristiques.add(new JLabel("Position :"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.BASELINE;
        gbc.insets = new Insets(0, 15, 0, 10);
        JPanel panelPosition = new JPanel();
        panelPosition.setLayout(new GridLayout(1, 1));
        positionAnimal = new JLabel("Aucune cellule sélectionnée!");
        panelPosition.add(positionAnimal);
        caracteristiques.add(panelPosition, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 0;
        gbc.gridheight = 1;
        gbc.weightx = gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.BASELINE_LEADING;
        gbc.insets = new Insets(10, 15, 15, 10);
        position = new MiniGrille(_fenetre.getGrille(), this);
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

    public JLabel getPositionAnimal() {
        return positionAnimal;
    }

    public Animal get_animal() {
        return _animal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(valider)) {
            if (nom.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Veuillez saisir un nom!");
                return;
            }
            boolean sexe;
            if (male.isSelected())
                sexe = true;
            else
                sexe = false;
            boolean leader;
            if (leaderOui.isSelected())
                leader = true;
            else
                leader = false;
            if (position.getCoordonnees() == null) {
                JOptionPane.showMessageDialog(this, "Veuillez choisir une cellule valide!");
                return;
            }

            _controleur.ajouterAnimal(_animal.getNom(), nom.getText(), sexe, leader, position.getCoordonnees());
            dispose();
        }
        else if (e.getSource().equals(annuler)) {
            dispose();
        }
        else if (e.getSource().equals(male)) {
            femelle.setSelected(false);
            if (!male.isSelected())
                male.setSelected(true);
        }
        else if (e.getSource().equals(femelle)) {
            male.setSelected(false);
            if (!femelle.isSelected())
                femelle.setSelected(true);
        }
        else if (e.getSource().equals(leaderOui)) {
            leaderNon.setSelected(false);
            if (!leaderOui.isSelected())
                leaderOui.setSelected(true);
        }
        else if (e.getSource().equals(leaderNon)) {
            leaderOui.setSelected(false);
            if (!leaderNon.isSelected())
                leaderNon.setSelected(true);
        }
    }
}
