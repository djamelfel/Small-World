package vue.dialog;

import controleur.Controleur;
import vue.Fenetre;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by Edwin on 18/12/13.
 */
public class DialogCharger {
    public DialogCharger(Fenetre fenetre, Controleur controleur) {
        JFileChooser fileopen = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("eXtensible Markup Language File (*.xml)", "xml");
        fileopen.addChoosableFileFilter(filter);
        fileopen.setAcceptAllFileFilterUsed(false);
        fileopen.setFileFilter(filter);

        int ret = fileopen.showDialog(null, "Ouvrir");

        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileopen.getSelectedFile();
            if (controleur.charger(file)) {
                JOptionPane.showMessageDialog(fenetre, "Chargement effectué");
            }
        }
    }
}
