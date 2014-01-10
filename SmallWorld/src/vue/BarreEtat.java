package vue;

import controleur.Controleur;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 19/12/13.
 */
public class BarreEtat extends JPanel {
    private static String str;

    private Fenetre fenetre;
    private Controleur controleur;

    private JLabel info;

    public BarreEtat(Fenetre fenetre, Controleur controleur) {
        super();

        this.fenetre = fenetre;
        this.controleur = controleur;

        this.setLayout(new GridLayout(1, 0));
        this.setBackground(Color.DARK_GRAY);

        info = new JLabel();
        info.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        info.setForeground(Color.WHITE);
        str = "aaa";
        info.setText(str);

        this.add(info);
    }

    public void update(String data) {
        str = data;
        info.setText(str);
    }
}
