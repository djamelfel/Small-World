package utilitaires;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Edwin on 18/12/13.
 */
public class Charger {
    public static boolean chargerXML(File file) {
        Document document;
        //On crée une instance de SAXBuilder
        SAXBuilder sxb = new SAXBuilder();
        try {
            //On crée un nouveau document JDOM avec en argument le fichier XML
            //Le parsing est terminé ;)
            document = sxb.build(file);
        } catch (Exception e) {
            return false;
        }

        Element racine = document.getRootElement();
        System.out.println(racine.getName() + " " + racine.getAttribute("nom"));

        //On crée une List contenant tous les noeuds composants de l'Element racine
        List list = racine.getChildren();

        //On crée un Iterator sur notre liste
        Iterator i1 = list.iterator();
        Element courant, courant2;
        while (i1.hasNext()) {
            courant = (Element) i1.next();
            System.out.println(courant.getName());

            List list2 = courant.getChildren();
            Iterator i2 = list2.iterator();
            while (i2.hasNext()) {
                courant2 = (Element) i2.next();
                System.out.println(courant2.getName() + " " + courant2.getText());
            }
        }

        return true;
    }
}
