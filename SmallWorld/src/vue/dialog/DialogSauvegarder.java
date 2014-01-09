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
public class DialogSauvegarder {
    public DialogSauvegarder(Fenetre fenetre, Controleur controleur) {
        JFileChooser filesave = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("eXtensible Markup Language File (*.xml)", "xml");
        filesave.addChoosableFileFilter(filter);
        filesave.setAcceptAllFileFilterUsed(false);
        filesave.setFileFilter(filter);

        int ret = filesave.showDialog(null, "Enregistrer");

        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = filesave.getSelectedFile();
            if (controleur.sauvegarder(file)) {
                JOptionPane.showMessageDialog(fenetre, "Sauvegarde effectué");
            }
        }
    }
}
