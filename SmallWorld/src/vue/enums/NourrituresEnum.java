package vue.enums;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 25/12/13.
 */
public enum NourrituresEnum {
    banane("Banane", "Ajouter une banane", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/banane.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/banane.png")).getImage()),
    carotte("Carotte", "Ajouter une carotte", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/carotte.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/carotte.png")).getImage()),
    pomme("Pomme", "Ajouter une pomme", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/pomme.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/pomme.png")).getImage()),
    fromage("Fromage", "Ajouter du bon fromage", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/frommage.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/frommage.png")).getImage()),
    fraise("Fraise", "Ajouter une fraise", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/fraise.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/fraise.png")).getImage()),
    mure("Mure", "Ajouter une mure", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/mure.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/mure.png")).getImage()),
    raisin("Raisin", "Ajouter du raisin", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/raisin.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/raisin.png")).getImage()),
    radis("Radis", "Ajouter un radis", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/radis.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/radis.png")).getImage()),
    poisson("Poisson", "Ajouter du poisson", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/poisson.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/poisson.png")).getImage()),
    oeuf("Oeuf", "Ajouter un oeuf", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/oeuf.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/oeuf.png")).getImage()),
    cadavre("Cadavre", "Ajouter un cadavre", new ImageIcon(NourrituresEnum.class.getResource("../../images/toolbar/nourriture/viande.png")),
            new ImageIcon(NourrituresEnum.class.getClass().getResource("../../images/nourriture/viande.png")).getImage());

    private String nom;
    private String phraseToolbar;
    private ImageIcon toolbar;
    private Image grille;

    NourrituresEnum(String nom, String phraseToolbar, ImageIcon toolbar, Image grille) {
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
