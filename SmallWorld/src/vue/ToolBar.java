package vue;

import controleur.Controleur;
import vue.dialog.DialogNouveauAnimal;
import vue.dialog.DialogNouveauMonde;
import vue.enums.Animal;
import vue.enums.Decor;

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
    private JButton addLion;
    private JButton addLamasticot;
    private JButton addTerre;

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
        // Initialisation du premier niveau

        // Ajout monde
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/globe.png"));
        addMonde = new JButton(image);
        addMonde.addActionListener(this);
        addMonde.setToolTipText("Ajouter au monde...");
        add(addMonde);

        // Ajout animal
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/animal.png"));
        addAnimal = new JButton(image);
        addAnimal.addActionListener(this);
        addAnimal.setToolTipText("Ajouter un animal...");
        add(addAnimal);

        // Initialisation du deuxième niveau

        // Ajout lion
        image = Animal.lion.getToolbar();
        addLion = new JButton(image);
        addLion.addActionListener(this);
        addLion.setToolTipText("Ajouter un lion");
        add(addLion);
        addLion.setVisible(false);

        // Ajout lamasticot
        image = Animal.lamasticot.getToolbar();
        addLamasticot = new JButton(image);
        addLamasticot.addActionListener(this);
        addLamasticot.setToolTipText("Ajouter un lamasticot");
        add(addLamasticot);
        addLamasticot.setVisible(false);

        // Ajout herbe
        image = Decor.herbe.getToolbar();
        addHerbe = new JButton(image);
        addHerbe.addActionListener(this);
        addHerbe.setToolTipText("Ajouter de l'herbe");
        add(addHerbe);
        addHerbe.setVisible(false);

        // Ajout terre
        image = Decor.terre.getToolbar();
        addTerre = new JButton(image);
        addTerre.addActionListener(this);
        addTerre.setToolTipText("Ajouter de la terre");
        add(addTerre);
        addTerre.setVisible(false);

        // Retour
        image = new ImageIcon(this.getClass().getResource("../images/toolbar/retour.png"));
        retour = new JButton(image);
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
            addTerre.setVisible(true);
            retour.setVisible(true);

        }
        else if (e.getSource().equals(addAnimal)) {
            addMonde.setVisible(false);
            addAnimal.setVisible(false);
            addLion.setVisible(true);
            addLamasticot.setVisible(true);
            retour.setVisible(true);
        }
        else if (e.getSource().equals(addHerbe)) {
            new DialogNouveauMonde(fenetre, controleur, Decor.herbe);
        }
        else if (e.getSource().equals(addTerre)) {
            new DialogNouveauMonde(fenetre, controleur, Decor.terre);
        }
        else if (e.getSource().equals(addLion)) {
            new DialogNouveauAnimal(fenetre, controleur, Animal.lion);
        }
        else if (e.getSource().equals(addLamasticot)) {
            new DialogNouveauAnimal(fenetre, controleur, Animal.lamasticot);
        }
        else if (e.getSource().equals(retour)) {
            addMonde.setVisible(true);
            addAnimal.setVisible(true);
            addHerbe.setVisible(false);
            addTerre.setVisible(false);
            addLamasticot.setVisible(false);
            addLion.setVisible(false);
            retour.setVisible(false);
        }
    }
}
