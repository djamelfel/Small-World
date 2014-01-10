package vue.enums;

import javax.swing.*;
import java.awt.*;

import static modele.utils.Utils.hex2Rgb;

public enum NourrituresEnum {
    banane("Banane", "Ajouter une banane", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/banane.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/banane.png")).getImage(), hex2Rgb("#D1B606")),
    carotte("Carotte", "Ajouter une carotte", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/carotte.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/carotte.png")).getImage(), hex2Rgb("#F4661B")),
    pomme("Pomme", "Ajouter une pomme", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/pomme.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/pomme.png")).getImage(), hex2Rgb("#34C924")),
    fromage("Fromage", "Ajouter du bon fromage", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/frommage.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/frommage.png")).getImage(), hex2Rgb("#EEEEC6")),
    fraise("Fraise", "Ajouter une fraise", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/fraise.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/fraise.png")).getImage(), hex2Rgb("#BF3030")),
    mure("Mure", "Ajouter une mure", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/mure.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/mure.png")).getImage(), hex2Rgb("#3B0405")),
    raisin("Raisin", "Ajouter du raisin", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/raisin.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/raisin.png")).getImage(), hex2Rgb("#E70739")),
    radis("Radis", "Ajouter un radis", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/radis.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/radis.png")).getImage(), hex2Rgb("#B1221C")),
    poisson("Poisson", "Ajouter du poisson", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/poisson.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/poisson.png")).getImage(), hex2Rgb("#A2B5BF")),
    oeuf("Oeuf", "Ajouter un oeuf", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/oeuf.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/oeuf.png")).getImage(), hex2Rgb("#8FCF3C")),
    cadavre("Cadavre", "Ajouter un cadavre", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/viande.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/viande.png")).getImage(), hex2Rgb("#940602"));

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;
    private Color color;

    NourrituresEnum(String nom, String phraseToolbar, ImageIcon toolbar, Image grille, Color color) {
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
