package vue;

import controleur.Controleur;
import vue.enums.Temps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Edwin on 19/12/13.
 */
public class BarreEtat extends JPanel implements ActionListener {
    private static String str;

    private Fenetre fenetre;
    private Controleur controleur;

    private JLabel info;

    private JButton accelere;
    private JButton normal;
    private JButton pause;

    public BarreEtat(Fenetre fenetre, Controleur controleur) {
        super();

        this.fenetre = fenetre;
        this.controleur = controleur;

        this.setLayout(new GridLayout(1, 4));
        this.setBackground(Color.DARK_GRAY);

        info = new JLabel();
        info.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 5));
        info.setForeground(Color.WHITE);
        str = "Temps : 0";
        info.setText(str);

        normal = new JButton(Temps.play.getIcon());
        normal.addActionListener(this);
        normal.setToolTipText(Temps.play.getNom());
        add(normal);

        pause = new JButton(Temps.pause.getIcon());
        pause.addActionListener(this);
        pause.setToolTipText(Temps.pause.getNom());
        add(pause);

        accelere = new JButton(Temps.forward.getIcon());
        accelere.addActionListener(this);
        accelere.setToolTipText(Temps.forward.getNom());
        add(accelere);

        this.add(info);
    }

    public void update(String data) {
        str = data;
        info.setText(str);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(normal)) {
           controleur.getManagerAnimaux().setDuree(500);
        }
        else if (e.getSource().equals(pause)) {
           controleur.getManagerAnimaux().setPause(!controleur.getManagerAnimaux().isPause());
        }
        else if (e.getSource().equals(accelere)) {
            controleur.getManagerAnimaux().setDuree(100);
        }
    }
}
