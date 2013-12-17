package vue;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Edwin on 17/12/13.
 */
public class Fenetre extends JFrame {
    public Fenetre() {
        // Initialisation de la JFrame
        setSize(700, 500);
        setPreferredSize(new Dimension(700, 500));
        setMinimumSize(getPreferredSize());
        setTitle("Small World - LO43");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        pack();
        setVisible(true);
    }
}
