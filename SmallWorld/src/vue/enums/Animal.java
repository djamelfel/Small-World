package vue.enums;

import javax.swing.*;
import java.awt.*;

import static modele.utils.Utils.hex2Rgb;


public enum Animal {
    lion("Lion", "Ajouter un lion", new ImageIcon(Animal.class.getResource("../../images/toolbar/lion.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/lion.png")).getImage(), hex2Rgb("#E8CC06")),
    lamastico("Lamastico", "Ajouter un lamastico ticooo", new ImageIcon(Animal.class.getResource("../../images/toolbar/lamasticot.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/lamasticot.png")).getImage(), hex2Rgb("#3C2000")),
    araignee("Araignee", "Ajouter une araignée volante", new ImageIcon(Animal.class.getResource("../../images/toolbar/araignee.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/araignee.png")).getImage(), hex2Rgb("#080004")),
    elephant("Elephant", "Ajouter une éléphant phpetteur", new ImageIcon(Animal.class.getResource("../../images/toolbar/elephantPhp.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/elephantPhp.png")).getImage(), hex2Rgb("#444739")),
    renard("Renard", "Ajouter un renard chou", new ImageIcon(Animal.class.getResource("../../images/toolbar/renardFirefox2.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/renardFirefox2.png")).getImage(), hex2Rgb("#B83A1B")),
    poissonVolant("PoissonVolant", "Ajouter un poisson terrestre", new ImageIcon(Animal.class.getResource("../../images/toolbar/poissonVolant.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/poissonVolant.png")).getImage(), hex2Rgb("#8FCF3C")),
    schtroumpf("Schtroumpf", "Ajouter un schtroumpf endormi", new ImageIcon(Animal.class.getResource("../../images/toolbar/schtroumpf.png")),
            new ImageIcon(Animal.class.getClass().getResource("../../images/animaux/schtroumpf.png")).getImage(), hex2Rgb("#FF0000"));

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;
    private Color color;

    Animal(String nom, String phraseToolbar, ImageIcon toolbar, Image grille, Color color) {
        this.nom = nom;
        this.phraseToolbar = phraseToolbar;
        this.toolbar = toolbar;
        this.grille = grille;
        this.color = color;
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

    public Color getColor() {
        return color;
    }
}
