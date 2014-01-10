package modele.monde;


import controleur.Controleur;
import modele.especes.Espece;
import modele.especes.animaux.*;
import modele.nourriture.Cadavre;
import modele.nourriture.Carotte;
import modele.nourriture.Herbe;
import modele.nourriture.Nourriture;
import modele.utils.Utils;
import org.jdom2.Element;
import utilitaires.Sauvegarder;
import vue.enums.Animal;
import vue.enums.Decor;
import vue.enums.NourrituresEnum;

import java.awt.*;
import java.util.ArrayList;

public class Monde {

    private ArrayList<Espece> _listeAnimaux;
    private ArrayList<Nourriture> _listeNourriture;
    private static Map _map;
    private int _temperature;
    private Temps _temps;
    private Controleur _controleur;

    public Monde(Controleur controleur) {
        _listeAnimaux = new ArrayList<>();
        _listeNourriture = new ArrayList<>();
        _controleur = controleur;

        new Sauvegarder(this);
    }

    public void initialiser(int rows, int cols) {
        _map = new Map(cols, rows);
    }


    public void activerAnimaux() {
        ArrayList<Espece> aTuer = new ArrayList<>();
        int lg = _listeAnimaux.size();
        Espece tmpAnimal;
        for (int i = 0; i < lg; i++) {
            tmpAnimal = _listeAnimaux.get(i);
            if (tmpAnimal.getEstVivant()) {
                tmpAnimal.verifierEtatJournee();
                if (tmpAnimal.isNeedToCreateABaby()) {
                    tmpAnimal.setNeedToCreateABaby(false);
                    _controleur.ajouterAnimal(tmpAnimal.getNom(), "Baby " + tmpAnimal.getNom(), Utils.getRand(10) < 6, Utils.getRand(10) < 3, new Point(tmpAnimal.getPosition().getPosX(), tmpAnimal.getPosition().getPosY()));
                }
            }
            else {
                //créer nourriture == Gerer temps de décomposition
                //if (tmpAnimal instanceof Lamastico)
/*A REVOIR*/            //_listeNourriture.add(new Cadavre(60, tmpAnimal.getPosition().getPosX(), tmpAnimal.getPosition().getPosY()));
                //detruire animal
                aTuer.add(tmpAnimal);
            }
        }
        lg = aTuer.size();
        for (int i = 0; i < lg; i++) {
            tmpAnimal = aTuer.get(i);
            if (tmpAnimal.getPosition().getNourriture() == null)
                ajoutNourriture("Cadavre", tmpAnimal.getPosition().getPosX(), tmpAnimal.getPosition().getPosY());
            _controleur.supprimerEspece(tmpAnimal);

        }

        _listeAnimaux.removeAll(aTuer);
    }

    public static ArrayList<Case> getVoisins(Case caseDepart, int champVision, int sens) {

        ArrayList<Case> _casesVoisines = new ArrayList();

        // TODO : prendre en compte le sens
        //0 : haut, 1 : droite, 2 : bas, 3 : gauche

        Case tmpCase;
        int posX = caseDepart.getPosX();
        int posY = caseDepart.getPosY();


        if (sens == 1) {
            //System.out.println("droite "+champVision);
            for (int i = 1; i < champVision; i++) {
                for (int j = posY - i; j <= posY + i; j++) {
                    tmpCase = _map.getCase((posX + i), j);
                    if (tmpCase == null) continue;
                    if (tmpCase.getEspece() != null)
                        _casesVoisines.add(tmpCase);
                    else if (tmpCase.getNourriture() != null)
                        _casesVoisines.add(tmpCase);
                }
            }
        }
        else if (sens == 3) {
            //System.out.println("GAUCHE "+champVision);
            for (int i = 1; i < champVision; i++) {
                for (int j = posY - i; j <= posY + i; j++) {
                    tmpCase = _map.getCase((posX - i), j);
                    if (tmpCase == null) continue;
                    if (tmpCase.getEspece() != null)
                        _casesVoisines.add(tmpCase);
                    else if (tmpCase.getNourriture() != null)
                        _casesVoisines.add(tmpCase);
                }
            }
        }
        else if (sens == 2) {
            // System.out.println("bas "+champVision);
            for (int i = 1; i < champVision; i++) {
                for (int j = posX - i; j <= posX + i; j++) {
                    tmpCase = _map.getCase(j, posY + i);
                    if (tmpCase == null) continue;
                    if (tmpCase.getEspece() != null)
                        _casesVoisines.add(tmpCase);
                    else if (tmpCase.getNourriture() != null)
                        _casesVoisines.add(tmpCase);
                }
            }
        }
        else if (sens == 0) {
            // System.out.println("haut");
            for (int i = 1; i < champVision; i++) {
                for (int j = posX - i; j <= posX + i; j++) {
                    tmpCase = _map.getCase(j, posY - i);
                    if (tmpCase == null) continue;
                    if (tmpCase.getEspece() != null)
                        _casesVoisines.add(tmpCase);
                    else if (tmpCase.getNourriture() != null)
                        _casesVoisines.add(tmpCase);
                }
            }
        }
        return _casesVoisines;
    }

    public Espece ajoutAnimaux(String animal, boolean estLeader, boolean sexe, int posX, int posY) {

        Espece tmpEspece = null;
        System.out.println(animal);
        switch (animal) {
            case "Lion":
                System.out.println("JE SUIS UN LION");
                tmpEspece = new Lion(estLeader, sexe);
                tmpEspece.setGraphics(Animal.lion);
                break;
            case "Lamastico":
                System.out.println("JE SUIS UN LAMA");
                tmpEspece = new Lamastico(estLeader, sexe);
                tmpEspece.setGraphics(Animal.lamastico);
                break;

            case "Araignee":
                System.out.println("JE SUIS UNE ARAIGNEE");
                tmpEspece = new Araignee(estLeader, sexe);
                tmpEspece.setGraphics(Animal.araignee);
                break;

            case "Elephant":
                System.out.println("JE SUIS UN Elephant");
                tmpEspece = new Elephant(estLeader, sexe);
                tmpEspece.setGraphics(Animal.elephant);
                break;

            case "Renard":
                System.out.println("JE SUIS UN Renard");
                tmpEspece = new Renard(estLeader, sexe);
                tmpEspece.setGraphics(Animal.renard);
                break;

            case "PoissonVolant":
                System.out.println("JE SUIS UN PoissonVolant");
                tmpEspece = new PoissonVolant(estLeader, sexe);
                tmpEspece.setGraphics(Animal.poissonVolant);
                break;

            case "Schtroumpf":
                System.out.println("JE SUIS UN Schtroumpf");
                tmpEspece = new Schtroumpf(estLeader, sexe);
                tmpEspece.setGraphics(Animal.schtroumpf);
                break;

        }
        tmpEspece.setPosition(_map.getCase(posX, posY));
        _listeAnimaux.add(tmpEspece);

        return tmpEspece;
    }

    public void ajoutDecors(Decor decor, int posX, int posY) {
        _map.getCase(posX, posY).getDecors().setGraphics(decor);
    }

    public void ajoutNourriture(String nourriture, int posX, int posY) {
        Nourriture tmpNourriture = null;
        switch (nourriture) {
            case "Banane":
                tmpNourriture = new Herbe(_map.getCase(posX, posY));
                tmpNourriture.setGraphics(NourrituresEnum.banane);
                break;
            case "Carotte":
                System.out.println("On ajoute une carotte");
                tmpNourriture = new Carotte(_map.getCase(posX, posY));
                tmpNourriture.setGraphics(NourrituresEnum.carotte);
                break;
            case "Cadavre":
                System.out.println("On ajoute une cadavre");
                tmpNourriture = new Cadavre(100, _map.getCase(posX, posY));
                tmpNourriture.setGraphics(NourrituresEnum.cadavre);
                break;
            default:
                System.out.println("On ajoute une carotte");
                tmpNourriture = new Carotte(_map.getCase(posX, posY));

                NourrituresEnum[] resourcesNourriture = NourrituresEnum.values(); // Récupération des valeurs de l'énumération
                int valuesNumber = resourcesNourriture.length;
                for (int i = 0; i < valuesNumber; i++) {
                    final NourrituresEnum type = resourcesNourriture[i];
                    if (type.getNom() == nourriture) {
                        tmpNourriture.setGraphics(type);
                        break;
                    }
                }


        }
        _map.ajouterNouriture(tmpNourriture);
        _listeNourriture.add(tmpNourriture);

    }


    public void gererNourriture() {
        ArrayList<Nourriture> aTuer = new ArrayList<>();
        int lg = _listeNourriture.size();
        Nourriture tmpNourriture;
        for (int i = 0; i < lg; i++) {
            tmpNourriture = _listeNourriture.get(i);

            if (tmpNourriture instanceof Cadavre) // Gére le temps de décomposition
            {
                ((Cadavre) tmpNourriture).setTempsDecomposition(((Cadavre) tmpNourriture).getTempsDecomposition() - 1);
                if (((Cadavre) tmpNourriture).getTempsDecomposition() <= 0)
                    tmpNourriture.setMangeable(false);
            }

            if (tmpNourriture.getMangeable() == false) {
                aTuer.add(tmpNourriture);
            }
        }
        lg = aTuer.size();
        for (int i = 0; i < lg; i++) {
            tmpNourriture = aTuer.get(i);
            System.out.println("Delete nourriture");
            tmpNourriture.getPosition().setNourriture(null);
        }

        _listeNourriture.removeAll(aTuer);
    }

    public Element sauvegarder() {
        Element monde = new Element("Monde");
        Element animaux = new Element("Animaux");
        Element nourriture = new Element("Nourriture");

        int lg = _listeAnimaux.size();
        for (int i = 0; i < lg; i++)
            animaux.addContent(_listeAnimaux.get(i).sauvegarder());

        lg = _listeNourriture.size();
        for (int i = 0; i < lg; i++)
            nourriture.addContent(_listeNourriture.get(i).sauvegarder());

        monde.setAttribute("Temperature", _temperature + "");
        monde.addContent(_map.sauvegarder());
        monde.addContent(animaux);
        monde.addContent(nourriture);

        return monde;
    }

    public void charger(String nom) {


    }

    public static Map getMap() {
        return _map;
    }

    public int getTemperature() {
        return _temperature;
    }

    public Temps getTemps() {
        return _temps;
    }


}