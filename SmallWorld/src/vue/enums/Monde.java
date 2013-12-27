package vue.enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 26/12/13.
 */
public enum Monde {
    herbe("Herbe", new ImageIcon(Monde.class.getResource("../../images/toolbar/herbe.png")),
            new ImageIcon(Monde.class.getClass().getResource("../../images/carte/herbe.png")).getImage());

    private String nom;
    private ImageIcon toolbar;
    private Image grille;

    Monde(String nom, ImageIcon toolbar, Image grille) {
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
