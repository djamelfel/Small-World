package vue.dialog;

import controleur.Controleur;
import vue.Fenetre;
import vue.enums.NourrituresEnum;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 26/12/13.
 */
public class DialogNouveauNourriture extends JDialog implements ActionListener {
    private Fenetre _fenetre;
    private Controleur _controleur;
    private NourrituresEnum _nourriture;

    private JPanel caracteristiques;
    private JPanel boutons;
    private JButton valider;
    private JButton annuler;
    private MiniGrille position;
    private JLabel positionMonde;

    public DialogNouveauNourriture(Fenetre fenetre, Controleur controleur, NourrituresEnum nourriture) {
        super();

        _fenetre = fenetre;
        _controleur = controleur;
        _nourriture = nourriture;

        // Initialisation de la fenêtre
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Nouvelle nourriture - " + _nourriture);
        setLocation(_fenetre.getLocation());
        setSize(350, 450);
        setPreferredSize(getSize());
        setMinimumSize(getPreferredSize());
        setModal(true);

        // JPanel principal
        caracteristiques = new JPanel();
        LineBorder bordure = new LineBorder(Color.BLACK, 1, true);
        TitledBorder titre = new TitledBorder(bordure, "Caractéristiques nourriture");
        caracteristiques.setBorder(titre);
        caracteristiques.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

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

    public JLabel getPositionMonde() {
        return positionMonde;
    }

    public NourrituresEnum get_nourriture() {
        return _nourriture;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(valider)) {
            if (position.getCoordonnees() == null) {
                JOptionPane.showMessageDialog(this, "Veuillez choisir une cellule valide!");
                return;
            }
            _controleur.ajouterNourriture(_nourriture.getNom(), position.getCoordonnees());
            dispose();
        }
        else if (e.getSource().equals(annuler)) {
            dispose();
        }
    }
}
