package vue.enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 26/12/13.
 */
public enum EnumDecor {
    herbe("Herbe", "Ajouter de l'herbe", new ImageIcon(EnumDecor.class.getResource("../../images/toolbar/herbe.png")),
            new ImageIcon(EnumDecor.class.getClass().getResource("../../images/carte/herbe.png")).getImage()),
    terre("Terre", "Ajouter de la terre", new ImageIcon(EnumDecor.class.getResource("../../images/toolbar/terre.png")),
            new ImageIcon(EnumDecor.class.getClass().getResource("../../images/carte/terre.png")).getImage()),
    eau("Eau", "Ajouter de l'eau", new ImageIcon(EnumDecor.class.getResource("../../images/toolbar/eau.png")),
            new ImageIcon(EnumDecor.class.getClass().getResource("../../images/carte/eau.png")).getImage()),
    sable("Sable", "Ajouter du sable", new ImageIcon(EnumDecor.class.getResource("../../images/toolbar/sable.png")),
            new ImageIcon(EnumDecor.class.getClass().getResource("../../images/carte/sable.png")).getImage()),
    coquilot("Coquelicots", "Ajouter des coquelicots", new ImageIcon(EnumDecor.class.getResource("../../images/toolbar/coquilot.png")),
            new ImageIcon(EnumDecor.class.getClass().getResource("../../images/carte/coquilot.png")).getImage()),
    terreSechee("TerreSechee", "Ajouter de la terre séchée", new ImageIcon(EnumDecor.class.getResource("../../images/toolbar/terreSecher.png")),
            new ImageIcon(EnumDecor.class.getClass().getResource("../../images/carte/terreSecher.png")).getImage()),
    tournesol("Tournesol", "Ajouter de magnifiques tournesols", new ImageIcon(EnumDecor.class.getResource("../../images/toolbar/tournesol.png")),
            new ImageIcon(EnumDecor.class.getClass().getResource("../../images/carte/tournesol.png")).getImage()),
    lavande("Lavande", "Ajouter de la lavande qui sent bon", new ImageIcon(EnumDecor.class.getResource("../../images/toolbar/lavande.png")),
            new ImageIcon(EnumDecor.class.getClass().getResource("../../images/carte/lavande.png")).getImage());

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;

    EnumDecor(String nom, String phraseToolbar, ImageIcon toolbar, Image grille) {
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
