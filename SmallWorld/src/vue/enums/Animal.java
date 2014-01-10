package vue.enums;

import javax.swing.*;
import java.awt.*;


public enum Animal {
    lion("Lion", "Ajouter un lion", new ImageIcon(Animal.class.getResource("../../images/toolbar/lion.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/lion.png")).getImage()),
    lamastico("Lamastico", "Ajouter un lamastico ticooo", new ImageIcon(Animal.class.getResource("../../images/toolbar/lamasticot.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/lamasticot.png")).getImage()),
    araignee("Araignee", "Ajouter une araignée volante", new ImageIcon(Animal.class.getResource("../../images/toolbar/araignee.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/araignee.png")).getImage()),
    elephant("Elephant", "Ajouter une éléphant phpetteur", new ImageIcon(Animal.class.getResource("../../images/toolbar/elephantPhp.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/elephantPhp.png")).getImage()),
    renard("Renard", "Ajouter un renard chou", new ImageIcon(Animal.class.getResource("../../images/toolbar/renardFirefox2.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/renardFirefox2.png")).getImage()),
    poissonVolant("PoissonVolant", "Ajouter un poisson terrestre", new ImageIcon(Animal.class.getResource("../../images/toolbar/poissonVolant.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/poissonVolant.png")).getImage()),
    schtroumpf("Schtroumpf", "Ajouter un schtroumpf endormi", new ImageIcon(Animal.class.getResource("../../images/toolbar/schtroumpf.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/schtroumpf.png")).getImage());

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;

    Animal(String nom, String phraseToolbar, ImageIcon toolbar, Image grille) {
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
