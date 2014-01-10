package vue.enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 25/12/13.
 */
public enum Animal {
    lion("Lion", "Ajouter un lion", new ImageIcon(Animal.class.getResource("../../images/toolbar/lion.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/lion.png")).getImage()),
    lamastico("Lamastico", "Ajouter un lamastico ticooo", new ImageIcon(Animal.class.getResource("../../images/toolbar/lamasticot.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/lamasticot.png")).getImage());

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;

    Animal(String nom,  String phraseToolbar, ImageIcon toolbar, Image grille) {
        this.nom = nom;
        this.phraseToolbar = phraseToolbar;
        this.toolbar = toolbar;
        this.grille = grille;
    }

    public String getNom() {
        return nom;
    }
    public String getPhraseToolbar() {
        return phraseToolbar;
    }
    public ImageIcon getToolbar() {
        return toolbar;
    }

    public Image getGrille() {
        return grille;
    }
}
