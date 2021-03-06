package utilitaires;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Edwin on 18/12/13.
 */
public class Sauvegarder {
    public static boolean sauvegarderXML(File file) {
        // Nous allons commencer notre arborescence en créant la racine XML
        Element racine = new Element("Partie");

        // On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
        Document document = new Document(racine);

        // On crée un Attribute nom et on l'ajoute à la racine
        Attribute name = new Attribute("nom", "Joueur");
        racine.setAttribute(name);

        // Création d'une sous-branche
        Element test = new Element("Test");
        racine.addContent(test);

        // Ajout d'élément à la branche test
        for (int i = 0; i < 5; i++) {
            Element tmp = new Element("Elem" + i);
            tmp.setText("Hello");
            test.addContent(tmp);
        }

        // On enregistre le XML dans un fichier
        try {
            //On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

            //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
            //avec en argument le nom du fichier pour effectuer la sérialisation.
            file = new File(file.getPath() + ".xml");
            sortie.output(document, new FileOutputStream(file));
        } catch (java.io.IOException e) {
        }

        return true;
    }
}
