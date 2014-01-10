package vue.enums;

import javax.swing.*;

public enum Temps {
    play("Play", new ImageIcon(Temps.class.getResource("../../images/barre_menu/play.png"))),
    pause("Pause", new ImageIcon(Temps.class.getResource("../../images/barre_menu/pause.png"))),
    forward("Accéléré", new ImageIcon(Temps.class.getResource("../../images/barre_menu/forward.png")));

    private String nom;
    private ImageIcon icon;

    Temps(String nom, ImageIcon icon) {
        this.nom = nom;
        this.icon = icon;
    }

    public String getNom() {
        return nom;
    }

    public ImageIcon getIcon() {
        return icon;
    }
}
