package utilitaires;

import controleur.Controleur;
import modele.especes.Espece;
import modele.especes.animaux.*;
import modele.nourriture.Cadavre;
import modele.nourriture.Nourriture;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import vue.enums.Animal;
import vue.enums.Decor;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Charger {
    public static boolean chargerXML(File file, Controleur controleur) {
        Document document;
        //On crée une instance de SAXBuilder
        SAXBuilder sxb = new SAXBuilder();
        try {
            //On crée un nouveau document JDOM avec en argument le fichier XML
            document = sxb.build(file);
        } catch (Exception e) {
            return false;
        }

        Element element = document.getRootElement();
        controleur.setNomJoueur(element.getAttribute("nom") + "");

        //On crée une List contenant tous les noeuds composants de l'Element racine
        List list = element.getChildren();
        //On crée un Iterator sur notre liste
        Iterator itterator = list.iterator();
        //On récupere le premier noeuds de notre element
        element = (Element) itterator.next();

        //descente dans le noeud Map
        list = element.getChildren();
        itterator = list.iterator();
        element = (Element) itterator.next();

        //initialisation de la map
        try {
            controleur.getManagerAnimaux().initialiser(Integer.parseInt(element.getAttributeValue("Hauteur")),
                    Integer.parseInt(element.getAttributeValue("Largeur")));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        controleur.getFenetre().setTailleGrille(controleur.getManagerAnimaux().getMonde().getMap());

        //descente dans le noeud Decors si n'est pas vide
        if (!(element.getChildren().isEmpty())) {
            list = element.getChildren();
            itterator = list.iterator();
            while (itterator.hasNext()) {                                            //parcours champs Decors
                element = (Element) itterator.next();
                try {
                    if (element.getAttributeValue("Decors").equals("Herbe"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.herbe);
                    if (element.getAttributeValue("Decors").equals("Terre"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.terre);
                    if (element.getAttributeValue("Decors").equals("Eau"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.eau);
                    if (element.getAttributeValue("Decors").equals("Sable"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.sable);
                    if (element.getAttributeValue("Decors").equals("Coquelicots"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.coquilot);
                    if (element.getAttributeValue("Decors").equals("TerreSechee"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.terreSechee);
                    if (element.getAttributeValue("Decors").equals("Tournesol"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.tournesol);
                    if (element.getAttributeValue("Decors").equals("Lavande"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.lavande);
                } catch (Exception e) {
                    return false;
                }
            }

            //remonte dans le noeud supérieur et passe jusqu'au monde
            element = element.getParentElement();
            element = element.getParentElement();
            list = element.getChildren();
            itterator = list.iterator();
            element = (Element) itterator.next();
            element = (Element) itterator.next();
        }
        else
            element = (Element) itterator.next();

        //initialisation du monde
        try {
            controleur.getManagerAnimaux().getMonde().setTemperature(Integer.parseInt(element.getAttributeValue("Temperature")));
        } catch (Exception e) {
            return false;
        }

        //descente dans le noeud Animaux
        list = element.getChildren();
        itterator = list.iterator();
        element = (Element) itterator.next();

        if (!(element.getChildren().isEmpty())) {
            if (element.getName().equals("Animaux")) {
                //descente dans le noeud Espece
                list = element.getChildren();
                itterator = list.iterator();
                while (itterator.hasNext()) {    //parcours champs Espece
                    element = (Element) itterator.next();
                    try {
                        System.out.println(element.getAttributeValue("nom"));
                        if (element.getAttributeValue("nom").equals("Lamastico")) {
                            Espece temp = new Lamastico(Boolean.parseBoolean(element.getAttributeValue("course")),
                                    Integer.parseInt(element.getAttributeValue("dateNaissance")), Integer.parseInt(element.getAttributeValue("energie")),
                                    Boolean.parseBoolean(element.getAttributeValue("estLeader")), Integer.parseInt(element.getAttributeValue("faim")),
                                    Integer.parseInt(element.getAttributeValue("force")), Boolean.parseBoolean(element.getAttributeValue("sexe")),
                                    Boolean.parseBoolean(element.getAttributeValue("fuite")), Boolean.parseBoolean(element.getAttributeValue("nage")),
                                    Integer.parseInt(element.getAttributeValue("nbReproductions")), Integer.parseInt(element.getAttributeValue("sens")),
                                    Boolean.parseBoolean(element.getAttributeValue("sommeil")), Integer.parseInt(element.getAttributeValue("vitesse")),
                                    Integer.parseInt(element.getAttributeValue("vitesseCourse")));
                            controleur.getManagerAnimaux().getMonde().getListeAnimaux().add(temp);
                            temp.setGraphics(Animal.lamastico);
                            temp.setPosition(controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("positionX")),
                                    Integer.parseInt(element.getAttributeValue("positionY"))));
                            controleur.getFenetre().getGrille().ajouterAnimal(temp);
                        }
                        else if (element.getAttributeValue("nom").equals("Araignee")) {
                            Espece temp = new Araignee(Boolean.parseBoolean(element.getAttributeValue("course")),
                                    Integer.parseInt(element.getAttributeValue("dateNaissance")), Integer.parseInt(element.getAttributeValue("energie")),
                                    Boolean.parseBoolean(element.getAttributeValue("estLeader")), Integer.parseInt(element.getAttributeValue("faim")),
                                    Integer.parseInt(element.getAttributeValue("force")), Boolean.parseBoolean(element.getAttributeValue("sexe")),
                                    Boolean.parseBoolean(element.getAttributeValue("fuite")), Boolean.parseBoolean(element.getAttributeValue("nage")),
                                    Integer.parseInt(element.getAttributeValue("nbReproductions")), Integer.parseInt(element.getAttributeValue("sens")),
                                    Boolean.parseBoolean(element.getAttributeValue("sommeil")), Integer.parseInt(element.getAttributeValue("vitesse")),
                                    Integer.parseInt(element.getAttributeValue("vitesseCourse")));
                            controleur.getManagerAnimaux().getMonde().getListeAnimaux().add(temp);
                            temp.setGraphics(Animal.araignee);
                            temp.setPosition(controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("positionX")),
                                    Integer.parseInt(element.getAttributeValue("positionY"))));
                            controleur.getFenetre().getGrille().ajouterAnimal(temp);
                        }
                        else if (element.getAttributeValue("nom").equals("Elephant")) {
                            Espece temp = new Elephant(Boolean.parseBoolean(element.getAttributeValue("course")),
                                    Integer.parseInt(element.getAttributeValue("dateNaissance")), Integer.parseInt(element.getAttributeValue("energie")),
                                    Boolean.parseBoolean(element.getAttributeValue("estLeader")), Integer.parseInt(element.getAttributeValue("faim")),
                                    Integer.parseInt(element.getAttributeValue("force")), Boolean.parseBoolean(element.getAttributeValue("sexe")),
                                    Boolean.parseBoolean(element.getAttributeValue("fuite")), Boolean.parseBoolean(element.getAttributeValue("nage")),
                                    Integer.parseInt(element.getAttributeValue("nbReproductions")), Integer.parseInt(element.getAttributeValue("sens")),
                                    Boolean.parseBoolean(element.getAttributeValue("sommeil")), Integer.parseInt(element.getAttributeValue("vitesse")),
                                    Integer.parseInt(element.getAttributeValue("vitesseCourse")));
                            controleur.getManagerAnimaux().getMonde().getListeAnimaux().add(temp);
                            temp.setGraphics(Animal.elephant);
                            temp.setPosition(controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("positionX")),
                                    Integer.parseInt(element.getAttributeValue("positionY"))));
                            controleur.getFenetre().getGrille().ajouterAnimal(temp);
                        }
                        else if (element.getAttributeValue("nom").equals("Lion")) {
                            Espece temp = new Lion(Boolean.parseBoolean(element.getAttributeValue("course")),
                                    Integer.parseInt(element.getAttributeValue("dateNaissance")), Integer.parseInt(element.getAttributeValue("energie")),
                                    Boolean.parseBoolean(element.getAttributeValue("estLeader")), Integer.parseInt(element.getAttributeValue("faim")),
                                    Integer.parseInt(element.getAttributeValue("force")), Boolean.parseBoolean(element.getAttributeValue("sexe")),
                                    Boolean.parseBoolean(element.getAttributeValue("fuite")), Boolean.parseBoolean(element.getAttributeValue("nage")),
                                    Integer.parseInt(element.getAttributeValue("nbReproductions")), Integer.parseInt(element.getAttributeValue("sens")),
                                    Boolean.parseBoolean(element.getAttributeValue("sommeil")), Integer.parseInt(element.getAttributeValue("vitesse")),
                                    Integer.parseInt(element.getAttributeValue("vitesseCourse")));
                            controleur.getManagerAnimaux().getMonde().getListeAnimaux().add(temp);
                            temp.setGraphics(Animal.lion);
                            temp.setPosition(controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("positionX")),
                                    Integer.parseInt(element.getAttributeValue("positionY"))));
                            controleur.getFenetre().getGrille().ajouterAnimal(temp);
                        }
                        else if (element.getAttributeValue("nom").equals("PoissonVolant")) {
                            Espece temp = new PoissonVolant(Boolean.parseBoolean(element.getAttributeValue("course")),
                                    Integer.parseInt(element.getAttributeValue("dateNaissance")), Integer.parseInt(element.getAttributeValue("energie")),
                                    Boolean.parseBoolean(element.getAttributeValue("estLeader")), Integer.parseInt(element.getAttributeValue("faim")),
                                    Integer.parseInt(element.getAttributeValue("force")), Boolean.parseBoolean(element.getAttributeValue("sexe")),
                                    Boolean.parseBoolean(element.getAttributeValue("fuite")), Boolean.parseBoolean(element.getAttributeValue("nage")),
                                    Integer.parseInt(element.getAttributeValue("nbReproductions")), Integer.parseInt(element.getAttributeValue("sens")),
                                    Boolean.parseBoolean(element.getAttributeValue("sommeil")), Integer.parseInt(element.getAttributeValue("vitesse")),
                                    Integer.parseInt(element.getAttributeValue("vitesseCourse")));
                            controleur.getManagerAnimaux().getMonde().getListeAnimaux().add(temp);
                            temp.setGraphics(Animal.poissonVolant);
                            temp.setPosition(controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("positionX")),
                                    Integer.parseInt(element.getAttributeValue("positionY"))));
                            controleur.getFenetre().getGrille().ajouterAnimal(temp);
                        }
                        else if (element.getAttributeValue("nom").equals("Renard")) {
                            Espece temp = new Renard(Boolean.parseBoolean(element.getAttributeValue("course")),
                                    Integer.parseInt(element.getAttributeValue("dateNaissance")), Integer.parseInt(element.getAttributeValue("energie")),
                                    Boolean.parseBoolean(element.getAttributeValue("estLeader")), Integer.parseInt(element.getAttributeValue("faim")),
                                    Integer.parseInt(element.getAttributeValue("force")), Boolean.parseBoolean(element.getAttributeValue("sexe")),
                                    Boolean.parseBoolean(element.getAttributeValue("fuite")), Boolean.parseBoolean(element.getAttributeValue("nage")),
                                    Integer.parseInt(element.getAttributeValue("nbReproductions")), Integer.parseInt(element.getAttributeValue("sens")),
                                    Boolean.parseBoolean(element.getAttributeValue("sommeil")), Integer.parseInt(element.getAttributeValue("vitesse")),
                                    Integer.parseInt(element.getAttributeValue("vitesseCourse")));
                            controleur.getManagerAnimaux().getMonde().getListeAnimaux().add(temp);
                            temp.setGraphics(Animal.renard);
                            temp.setPosition(controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("positionX")),
                                    Integer.parseInt(element.getAttributeValue("positionY"))));
                            controleur.getFenetre().getGrille().ajouterAnimal(temp);
                        }
                        else if (element.getAttributeValue("nom").equals("Schtroumpf")) {
                            Espece temp = new Schtroumpf(Boolean.parseBoolean(element.getAttributeValue("course")),
                                    Integer.parseInt(element.getAttributeValue("dateNaissance")), Integer.parseInt(element.getAttributeValue("energie")),
                                    Boolean.parseBoolean(element.getAttributeValue("estLeader")), Integer.parseInt(element.getAttributeValue("faim")),
                                    Integer.parseInt(element.getAttributeValue("force")), Boolean.parseBoolean(element.getAttributeValue("sexe")),
                                    Boolean.parseBoolean(element.getAttributeValue("fuite")), Boolean.parseBoolean(element.getAttributeValue("nage")),
                                    Integer.parseInt(element.getAttributeValue("nbReproductions")), Integer.parseInt(element.getAttributeValue("sens")),
                                    Boolean.parseBoolean(element.getAttributeValue("sommeil")), Integer.parseInt(element.getAttributeValue("vitesse")),
                                    Integer.parseInt(element.getAttributeValue("vitesseCourse")));
                            controleur.getManagerAnimaux().getMonde().getListeAnimaux().add(temp);
                            temp.setGraphics(Animal.schtroumpf);
                            temp.setPosition(controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("positionX")),
                                    Integer.parseInt(element.getAttributeValue("positionY"))));
                            controleur.getFenetre().getGrille().ajouterAnimal(temp);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("error");

                        return false;
                    }
                }


                //remonte dans le noeud supérieur et passe jusqu'a la Nourriture
                element = element.getParentElement();
                element = element.getParentElement();
                list = element.getChildren();
                itterator = list.iterator();
                element = (Element) itterator.next();
                if (!(element.getChildren().isEmpty()))
                    element = (Element) itterator.next();
            }
            if (element.getName().equals("Nourriture")) {
                //descente dans le noeud Nourriture
                list = element.getChildren();
                itterator = list.iterator();
                while (itterator.hasNext()) {    //parcours champs Nourriture
                    element = (Element) itterator.next();
                    try {

                        System.out.println("ajout : " + element.getAttributeValue("Graphics"));
                        Nourriture tmpNourriture = controleur.getManagerAnimaux().getMonde().ajoutNourriture(element.getAttributeValue("Graphics"), Integer.parseInt(element.getAttributeValue("posX")), Integer.parseInt(element.getAttributeValue("posY")));
                        if (tmpNourriture != null && tmpNourriture instanceof Cadavre) { // update du temps de décomposition des cadavres
                            try {
                                ((Cadavre) tmpNourriture).setTempsDecomposition(Integer.parseInt(element.getAttributeValue("TempsDecomposition")));
                            } catch (Exception e) {
                                e.printStackTrace();
                                return false;
                            }

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            }
        }

        controleur.getManagerAnimaux().start();

        return true;
    }

    public static boolean chargerXML(Controleur controleur) {
        Document document;

        // File file = new File(getClass().getResource("init.xml"));

        //On crée une instance de SAXBuilder
        SAXBuilder sxb = new SAXBuilder();
        try {
            //On crée un nouveau document JDOM avec en argument le fichier XML
            document = sxb.build("file");
        } catch (Exception e) {
            return false;
        }

        Element element = document.getRootElement();

        //On crée une List contenant tous les noeuds composants de l'Element racine
        List list = element.getChildren();
        //On crée un Iterator sur notre liste
        Iterator itterator = list.iterator();
        //On récupere le premier noeuds de notre element
        element = (Element) itterator.next();

        //descente dans le noeud Map
        list = element.getChildren();
        itterator = list.iterator();
        element = (Element) itterator.next();
        System.out.println("Allo");
        //descente dans le noeud Decors si n'est pas vide
        if (!(element.getChildren().isEmpty())) {
            list = element.getChildren();
            itterator = list.iterator();
            while (itterator.hasNext()) {                                            //parcours champs Decors
                element = (Element) itterator.next();
                try {
                    if (element.getAttributeValue("Decors").equals("Herbe"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.herbe);
                    if (element.getAttributeValue("Decors").equals("Terre"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.terre);
                    if (element.getAttributeValue("Decors").equals("Eau"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.eau);
                    if (element.getAttributeValue("Decors").equals("Sable"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.sable);
                    if (element.getAttributeValue("Decors").equals("Coquelicots"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.coquilot);
                    if (element.getAttributeValue("Decors").equals("TerreSechee"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.terreSechee);
                    if (element.getAttributeValue("Decors").equals("Tournesol"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.tournesol);
                    if (element.getAttributeValue("Decors").equals("Lavande"))
                        controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("posX")),
                                Integer.parseInt(element.getAttributeValue("posY"))).getDecors().setGraphics(Decor.lavande);
                } catch (Exception e) {
                    return false;
                }
            }

            //remonte dans le noeud supérieur et passe jusqu'au monde
            element = element.getParentElement();
            element = element.getParentElement();
            list = element.getChildren();
            itterator = list.iterator();
            element = (Element) itterator.next();
            element = (Element) itterator.next();
        }
        else
            element = (Element) itterator.next();

        //initialisation du monde
        try {
            controleur.getManagerAnimaux().getMonde().setTemperature(Integer.parseInt(element.getAttributeValue("Temperature")));
        } catch (Exception e) {
            return false;
        }

        //descente dans le noeud Animaux
        list = element.getChildren();
        itterator = list.iterator();
        element = (Element) itterator.next();

        if (!(element.getChildren().isEmpty())) {
            if (element.getName().equals("Animaux")) {
                //descente dans le noeud Espece
                list = element.getChildren();
                itterator = list.iterator();
                while (itterator.hasNext()) {    //parcours champs Espece
                    element = (Element) itterator.next();
                    try {
                        if (element.getAttributeValue("nom").equals("Lamastico")) {
                            Espece temp = new Lamastico(Boolean.parseBoolean(element.getAttributeValue("course")),
                                    Integer.parseInt(element.getAttributeValue("dateNaissance")), Integer.parseInt(element.getAttributeValue("energie")),
                                    Boolean.parseBoolean(element.getAttributeValue("estLeader")), Integer.parseInt(element.getAttributeValue("faim")),
                                    Integer.parseInt(element.getAttributeValue("force")), Boolean.parseBoolean(element.getAttributeValue("sexe")),
                                    Boolean.parseBoolean(element.getAttributeValue("fuite")), Boolean.parseBoolean(element.getAttributeValue("nage")),
                                    Integer.parseInt(element.getAttributeValue("nbReproductions")), Integer.parseInt(element.getAttributeValue("sens")),
                                    Boolean.parseBoolean(element.getAttributeValue("sommeil")), Integer.parseInt(element.getAttributeValue("vitesse")),
                                    Integer.parseInt(element.getAttributeValue("vitesseCourse")));
                            controleur.getManagerAnimaux().getMonde().getListeAnimaux().add(temp);
                            temp.setGraphics(Animal.lamastico);
                            temp.setPosition(controleur.getManagerAnimaux().getMonde().getMap().getCase(Integer.parseInt(element.getAttributeValue("positionX")),
                                    Integer.parseInt(element.getAttributeValue("positionY"))));
                            controleur.getFenetre().getGrille().ajouterAnimal(temp);
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }


                //remonte dans le noeud supérieur et passe jusqu'a la Nourriture
                element = element.getParentElement();
                element = element.getParentElement();
                list = element.getChildren();
                itterator = list.iterator();
                element = (Element) itterator.next();
                if (!(element.getChildren().isEmpty()))
                    element = (Element) itterator.next();
            }
            if (element.getName().equals("Nourriture")) {
                //descente dans le noeud Nourriture
                list = element.getChildren();
                itterator = list.iterator();
                while (itterator.hasNext()) {    //parcours champs Nourriture
                    element = (Element) itterator.next();
                    try {
                        if (element.getAttributeValue("Graphics").equals("Viande")) {
                            System.out.println("créer cadavre");
                        }
                        else {
                            controleur.getManagerAnimaux().getMonde().ajoutNourriture(element.getAttributeValue("Graphics"), Integer.parseInt(element.getAttributeValue("posX")), Integer.parseInt(element.getAttributeValue("posY")));
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
