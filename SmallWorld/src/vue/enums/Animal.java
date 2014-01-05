package vue.enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 25/12/13.
 */
public enum Animal {
    lion("Lion", new ImageIcon(Animal.class.getResource("../../images/toolbar/lion.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/lion.png")).getImage()),
    lamasticot("Lamasticot", new ImageIcon(Animal.class.getResource("../../images/toolbar/lamasticot.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/lamasticot.png")).getImage());

    private String nom;
    private ImageIcon toolbar;
    private Image grille;

    Animal(String nom, ImageIcon toolbar, Image grille) {
        this.nom = nom;
        this.toolbar = toolbar;
        this.grille = grille;
    }

    public String getNom() {
        return nom;
    }

    public ImageIcon getToolbar() {
        return toolbar;
    }

    public Image getGrille() {
        return grille;
    }
}
