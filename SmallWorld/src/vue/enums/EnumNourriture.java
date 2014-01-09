package vue.enums;

import modele.nourriture.Nourriture;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 25/12/13.
 */
public enum EnumNourriture {
    banane("Banane", "Ajouter une banane", new ImageIcon(Nourriture.class.getResource("../../images/toolbar/nourriture/banane.png")),
            new ImageIcon(Nourriture.class.getClass().getResource("../../images/nourriture/banane.png")).getImage()),
    carotte("Carotte", "Ajouter une carotte", new ImageIcon(Nourriture.class.getResource("../../images/toolbar/nourriture/carotte.png")),
            new ImageIcon(Nourriture.class.getClass().getResource("../../images/nourriture/carotte.png")).getImage()),;

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;

    EnumNourriture(String nom, String phraseToolbar, ImageIcon toolbar, Image grille) {
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
