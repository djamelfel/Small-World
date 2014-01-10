package vue.enums;

import javax.swing.*;
import java.awt.*;

import static modele.utils.Utils.hex2Rgb;

public enum Decor {
    herbe("Herbe", "Ajouter de l'herbe", new ImageIcon(Decor.class.getResource("../../images/toolbar/herbe.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/herbe.png")).getImage(), hex2Rgb("#8FCF3C")),
    terre("Terre", "Ajouter de la terre", new ImageIcon(Decor.class.getResource("../../images/toolbar/terre.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/terre.png")).getImage(), hex2Rgb("#663E10")),
    eau("Eau", "Ajouter de l'eau", new ImageIcon(Decor.class.getResource("../../images/toolbar/eau.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/eau.png")).getImage(), hex2Rgb("#375D81")),
    sable("Sable", "Ajouter du sable", new ImageIcon(Decor.class.getResource("../../images/toolbar/sable.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/sable.png")).getImage(), hex2Rgb("#FFF168")),
    coquilot("Coquelicots", "Ajouter des coquelicots", new ImageIcon(Decor.class.getResource("../../images/toolbar/coquilot.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/coquilot.png")).getImage(), hex2Rgb("#FF5B2B")),
    terreSechee("TerreSechee", "Ajouter de la terre séchée", new ImageIcon(Decor.class.getResource("../../images/toolbar/terreSecher.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/terreSecher.png")).getImage(), hex2Rgb("#BD8D46")),
    tournesol("Tournesol", "Ajouter de magnifiques tournesols", new ImageIcon(Decor.class.getResource("../../images/toolbar/tournesol.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/tournesol.png")).getImage(), hex2Rgb("#E8CC06")),
    lavande("Lavande", "Ajouter de la lavande qui sent bon", new ImageIcon(Decor.class.getResource("../../images/toolbar/lavande.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/lavande.png")).getImage(), hex2Rgb("#FFB6B8"));

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;
    private Color color;

    Decor(String nom, String phraseToolbar, ImageIcon toolbar, Image grille, Color color) {
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
