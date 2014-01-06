package vue.enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 26/12/13.
 */
public enum Decor {
    herbe("Herbe", "Ajouter de l'herbe", new ImageIcon(Decor.class.getResource("../../images/toolbar/herbe.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/herbe.png")).getImage()),
    terre("Terre", "Ajouter de la terre", new ImageIcon(Decor.class.getResource("../../images/toolbar/terre.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/terre.png")).getImage()),
    eau("Eau", "Ajouter de l'eau", new ImageIcon(Decor.class.getResource("../../images/toolbar/eau.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/eau.png")).getImage()),
    sable("Sable", "Ajouter du sable", new ImageIcon(Decor.class.getResource("../../images/toolbar/sable.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/sable.png")).getImage()),
    coquilot("Coquelicots", "Ajouter des coquelicots", new ImageIcon(Decor.class.getResource("../../images/toolbar/coquilot.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/coquilot.png")).getImage()),
    terreSechee("TerreSechee", "Ajouter de la terre séchée", new ImageIcon(Decor.class.getResource("../../images/toolbar/terreSecher.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/terreSecher.png")).getImage()),
    tournesol("Tournesol", "Ajouter de magnifiques tournesols", new ImageIcon(Decor.class.getResource("../../images/toolbar/tournesol.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/tournesol.png")).getImage()),
    lavande("Lavande", "Ajouter de la lavande qui sent bon", new ImageIcon(Decor.class.getResource("../../images/toolbar/lavande.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/lavande.png")).getImage());

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;

    Decor(String nom, String phraseToolbar, ImageIcon toolbar, Image grille) {
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
