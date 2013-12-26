package vue;

import controleur.Controleur;
import vue.dialog.DialogNouveauAnimal;
import vue.enums.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 19/12/13.
 */
public class ToolBar extends JToolBar implements ActionListener {
    private Fenetre fenetre;
    private Controleur controleur;

    private JButton addMonde;
    private JButton addAnimal;
    private JButton addHerbe;
    private JButton retour;

    private JButton test;

    public ToolBar(Fenetre fenetre, Controleur controleur) {
        super();

        this.fenetre = fenetre;
        this.controleur = controleur;

        // Initialisation de la toolbar
        setFloatable(false);
        setOpaque(false);
        setBackground(Color.DARK_GRAY);
        setSize(0, 25);
        setPreferredSize(getSize());

        ImageIcon image;
        // Initialisation du 1er niveau

        // Bouton test
        test = new JButton("Test");
        test.addActionListener(this);
        add(test);

        // Ajout monde
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/globe.png"));
        addMonde = new JButton(image);
        addMonde.addActionListener(this);
        addMonde.setToolTipText("Ajouter au monde...");
        add(addMonde);

        // Ajout animal
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/lamasticot.png"));
        addAnimal = new JButton(image);
        addAnimal.addActionListener(this);
        addAnimal.setToolTipText("Ajouter un animal...");
        add(addAnimal);

        // Ajout herbe
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/herbe.png"));
        addHerbe = new JButton(image);
        addHerbe.addActionListener(this);
        addHerbe.setToolTipText("Ajouter de l'herbe");
        add(addHerbe);
        addHerbe.setVisible(false);

        // Retour
        retour = new JButton("Retour");
        retour.addActionListener(this);
        retour.setToolTipText("Retour...");
        add(retour);
        retour.setVisible(false);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(getBackground());
        g2.fillRect(0, 0, getSize().width, getSize().height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(addMonde)) {
            addMonde.setVisible(false);
            addAnimal.setVisible(false);
            addHerbe.setVisible(true);
            retour.setVisible(true);

        }
        else if (e.getSource().equals(addAnimal)) {
            addMonde.setVisible(false);
            addAnimal.setVisible(false);
            retour.setVisible(true);
        }
        else if (e.getSource().equals(addHerbe)) {

        }
        else if (e.getSource().equals(retour)) {
            addMonde.setVisible(true);
            addAnimal.setVisible(true);
            addHerbe.setVisible(false);
            retour.setVisible(false);
        }
        else if (e.getSource().equals(test)) {
            new DialogNouveauAnimal(fenetre, controleur, Animal.lion);
        }
    }
}
