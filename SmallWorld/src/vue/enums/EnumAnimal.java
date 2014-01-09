package vue.enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 25/12/13.
 */
public enum EnumAnimal {
    lion("Lion", "Ajouter un lion", new ImageIcon(EnumAnimal.class.getResource("../../images/toolbar/lion.png")),
            new ImageIcon(EnumAnimal.class.getClass().getResource("../../images/animaux/lion.png")).getImage()),
    lamasticot("Lamasticot", "Ajouter un lamasticot ticooot", new ImageIcon(EnumAnimal.class.getResource("../../images/toolbar/lamasticot.png")),
            new ImageIcon(EnumAnimal.class.getClass().getResource("../../images/animaux/lamasticot.png")).getImage());

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;

    EnumAnimal(String nom, String phraseToolbar, ImageIcon toolbar, Image grille) {
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
