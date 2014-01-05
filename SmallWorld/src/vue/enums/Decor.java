package vue.enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 26/12/13.
 */
public enum Decor {
    herbe("Herbe", new ImageIcon(Decor.class.getResource("../../images/toolbar/herbe.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/herbe.png")).getImage()),
    terre("Terre", new ImageIcon(Decor.class.getResource("../../images/toolbar/terre.png")),
            new ImageIcon(Decor.class.getClass().getResource("../../images/carte/terre.png")).getImage());

    private String nom;
    private ImageIcon toolbar;
    private Image grille;

    Decor(String nom, ImageIcon toolbar, Image grille) {
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
