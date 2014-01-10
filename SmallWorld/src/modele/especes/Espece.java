package modele.especes;

import modele.monde.Case;
import modele.monde.Monde;
import modele.monde.Temps;
import modele.nourriture.Cadavre;
import modele.utils.Utils;
import org.jdom2.Element;
import vue.enums.Animal;

import java.util.ArrayList;

public class Espece {

    private String _nom;
    private int _sommeilDeb;
    private int _sommeilFin;
    private boolean _sommeil;
    private int _vitesse;
    private int _force;
    private int _energie;
    private int _faim;
    private Meute _meute;
    private int _vitesseCourse;
    private boolean _sexe;                                //false ==> femelle
    private boolean _estLeader;                            //true ==> est un Leader
    private long _dateNaissance;
    private boolean _nage;                                //trouver autre terme
    private boolean _estVivant;
    private Case _position;
    private int _champVision;
    private int _sens;                                    //0 : haut, 1 : droite, 2 : bas, 3 : gauche
    private int _tempsIdeal;
    private int _nbReproductions;
    private boolean _fuite;
    private boolean _course;
    private Espece _danger;
    private ArrayList<String> _convoiter;


    private ArrayList<String> _dangeureux;

    private Animal _graphics; // contient les graphismes
    private boolean _needToCreateABaby;


    public String getNom() {
        return _nom;
    }

    public ArrayList<String> getConvoiter() {
        return _convoiter;
    }

    public ArrayList<String> getDangeureux() {
        return _dangeureux;
    }

    public boolean setSommeil(boolean sommeil) {
        return _sommeil = sommeil;
    }

    public boolean getSommeil() {
        return _sommeil;
    }

    public int getSommeilDeb() {
        return _sommeilDeb;
    }

    public int getSommeilFin() {
        return _sommeilFin;
    }

    public int getVitesse() {
        return _vitesse;
    }

    public void setVitesse(int vitesse) {
        _vitesse = vitesse;
    }

    public int getForce() {
        return _force;
    }

    public void setForce(int force) {
        _force = force;
    }

    public int getEnergie() {
        return _energie;
    }

    public void setEnergie(int energie) {
        _energie = energie;
    }

    public void setFaim(int faim) {
        _faim = faim;
    }

    public int getFaim() {
        return _faim;
    }

    public Meute getMeute() {
        return _meute;
    }

    public void setMeute(Meute meute) {
        _meute = meute;
    }

    public int getVitesseCourse() {
        return _vitesseCourse;
    }

    public void setVitesseCourse(int vitesseCourse) {
        _vitesseCourse = vitesseCourse;
    }

    public boolean getSexe() {
        return _sexe;
    }

    public boolean getEstLeader() {
        return _estLeader;
    }

    public long getDateNaissance() {
        return _dateNaissance;
    }

    public boolean getNage() {
        return _nage;
    }

    public boolean getEstVivant() {
        return _estVivant;
    }

    public void setEstVivant(Boolean estVivant) {
        _estVivant = estVivant;
    }

    public Case getPosition() {
        return _position;
    }

    public void setPosition(Case position) {
        if (_position != null) {
            _position.setEspece(null);
        }

        _position = position;
        _position.setEspece(this);
    }

    public int getChampVision() {
        return _champVision;
    }

    public int getSens() {
        return _sens;
    }

    public void setSens(int sens) {
        _sens = sens;
    }

    public int getNbReproductions() {
        return _nbReproductions;
    }

    public void setNbReproductions(int nbReproductions) {
        _nbReproductions = nbReproductions;
    }

    public boolean getFuite() {
        return _fuite;
    }

    public void setFuite(boolean fuite) {
        _fuite = fuite;
    }

    public boolean getCourse() {
        return _course;
    }

    public void setCourse(Boolean course) {
        _course = course;
    }

    public Espece getDanger() {
        return _danger;
    }

    public void setDanger(Espece danger) {
        _danger = danger;
    }

    public Espece() {
    }

    public Espece(String nom, int sommeilDeb, int sommeilFin, int vitesse, int force, int vitesseCourse, boolean estLeader, boolean nage, int champVision,
                  int tempIdeale, int nbReproductions, boolean sexe) {
        _nom = nom;
        _sommeilDeb = sommeilDeb;
        _sommeilFin = sommeilFin;
        _vitesse = vitesse;
        _force = force;
        _energie = 100;
        _faim = 100;
        _meute = null;
        _vitesseCourse = vitesseCourse;
        _sexe = sexe;
        if (estLeader == true)
            _meute = new Meute(this);
        else
            _meute = null;
        _estLeader = estLeader;
        _dateNaissance = Temps.getJeux();
        _nage = nage;
        _estVivant = true;
        _champVision = champVision;
        _tempsIdeal = tempIdeale;
        _nbReproductions = nbReproductions;
        _course = false;
        _danger = null;
        _dangeureux = new ArrayList();
        _convoiter = new ArrayList();
    }

    public Espece(String nom, int sommeilDeb, int sommeilFin, int champVision, int tempsIdeal, boolean course, int dateNaissance, int energie, boolean estLeader, int faim, int force, boolean sexe, boolean fuite, boolean nage, int nbReproductions, int sens, boolean sommeil, int vitesse, int vitesseCourse) {
        _nom = nom;
        _sommeilDeb = sommeilDeb;
        _sommeilFin = sommeilFin;
        _vitesse = vitesse;
        _force = force;
        _energie = 100;
        _faim = 100;
        _meute = null;
        _vitesseCourse = vitesseCourse;
        _sexe = sexe;
        if (estLeader == true)
            _meute = new Meute(this);
        else
            _meute = null;
        _estLeader = estLeader;
        _dateNaissance = Temps.getJeux();
        _nage = nage;
        _estVivant = true;
        _champVision = champVision;
        _tempsIdeal = tempsIdeal;
        _nbReproductions = nbReproductions;
        _course = false;
        _danger = null;
        _dangeureux = new ArrayList();
        _convoiter = new ArrayList();
    }

    public void verifierEtatJournee() {
        if (Temps.getJournee() > _sommeilDeb && Temps.getJournee() < _sommeilFin) {
            if (getSommeil() == true)
                reveiller();
            activite();
        }
        else if (getSommeil() == false)
            dormir();
    }

    public void chuteCapacite() {
    }

    public void retrouveCapacite() {
    }

    public void dormir() {
        System.out.println("dormir()");
        setSommeil(true);
        setEnergie(100);
        chuteCapacite();
    }

    public void reveiller() {
        System.out.println("reveiller()");
        retrouveCapacite();
        setSommeil(false);
    }

    public void tuer() {
        System.out.println("tuer()");
        if (_estLeader == true)
            _meute.detruire();
        else if (_meute != null)
            _meute.quitter(this);
        setEstVivant(false);
    }

    public void rejoindreMeute(Meute meute) {
        System.out.println("rejoindreMeute()");
        setMeute(meute);
        _meute.rejoindre(this);
    }

    public void appelLeader() {
        _meute.getLeader().seDeplacer(_position);
    }

    public void chasser(Espece espece) {
        seDeplacer(espece.getPosition());
    }

    public void seReproduire() {
        if (_nbReproductions <= 0) return;
        _nbReproductions -= 1;
        _position.getEspece().setNbReproductions(_position.getEspece().getNbReproductions() - 1);
        if (_sexe == false) {
            //Création d'un bébé
            _needToCreateABaby = true;
        }
    }

    public boolean aFaim() {
        return _faim < 40;
    }

    public void manger() {

        if (this instanceof Herbivore && _position.getNourriture() instanceof Cadavre) return;
        if (this instanceof Carnivore && !(_position.getNourriture() instanceof Cadavre)) return;
        if (_position.getNourriture().getEnergieRendue() + _faim > 100)
            setFaim(100);                    //energie maximum 100
        else
            setFaim(_position.getNourriture().getEnergieRendue() + _faim);
        _position.getNourriture().seFaireManger();
    }

    public void combattre(Espece espece) {
    }

    public void activite() {
    }

    public void sens(int x, int y) {
        if (Utils.getRand(1) == 1) {                    //gestion du sens
            if (_position.getPosX() < x)
                _sens = 1;
            else
                _sens = 3;
        }
        else {
            if (_position.getPosY() < y)
                _sens = 0;
            else
                _sens = 2;
        }
    }

    public void seDeplacer(Case position) {
        int x, y, temp, vitesse = _vitesse;
        int posX = position.getPosX();
        int posY = position.getPosY();

        if (_course == true)                                                    //definie le nombre de case dont il peut se deplacer
            vitesse += _vitesseCourse;

//Gestion point X        
        if (Math.abs(posX - _position.getPosX()) < vitesse)                        //permet de ne pas depasser le point X
            temp = Math.abs(posX - _position.getPosX());
        else
            temp = vitesse;

        if (posX > _position.getPosX())                                            //choisi aleatoirement un nombre compris dans son champ de deplacement
            x = Utils.getRand(_position.getPosX() + temp, _position.getPosX());
        else
            x = Utils.getRand(_position.getPosX(), _position.getPosX() - temp);

        vitesse -= Math.abs(_position.getPosX() - x);                                                            //soustrait le deplacement x a deplacer

//Gestion point Y        
        if (Math.abs(posY - _position.getPosY()) < vitesse)                        //permet de ne pas depasser le point X
            temp = Math.abs(posY - _position.getPosY());
        else
            temp = vitesse;

        if (posY > _position.getPosY())                                            //choisi aleatoirement un nombre compris dans son champ de deplacement
            y = Utils.getRand(_position.getPosY() + temp, _position.getPosY());
        else
            y = Utils.getRand(_position.getPosY(), _position.getPosY() - temp);
        sens(x, y);
        setPosition(Monde.getMap().getCase(x, y));
    }

    public void seDeplacer() {                        //deplacement aleatoire
        int x, y, vitesse = _vitesse;
        if (_meute == null || _estLeader) {                                        //si l'espece est sans meute ou si il est leader
            //Gestion point X
            if ((_position.getPosX() + vitesse) > (Monde.getMap().getLargeur() - 1) && (_position.getPosX() - vitesse) < 0)   //sorti tableau droite et gauche
                x = Utils.getRand(Monde.getMap().getLargeur() - 1);
            else if ((_position.getPosX() - vitesse) < 0)                        //sorti tableau gauche
                x = Utils.getRand(_position.getPosX() + vitesse);
            else if ((_position.getPosX() + vitesse) > (Monde.getMap().getLargeur() - 1))                //sorti du tableau a droite
                x = Utils.getRand((Monde.getMap().getLargeur() - 1), (_position.getPosX() - vitesse));
            else
                x = Utils.getRand((_position.getPosX() + vitesse), (_position.getPosX() - vitesse));

            vitesse -= Math.abs(_position.getPosX() - x);                        //soustrait le deplacement x a deplacer

            //Gestion point Y
            if ((_position.getPosY() + vitesse) >= Monde.getMap().getHauteur() && (_position.getPosY() - vitesse) < 0)   //sorti tableau bat et haut
                y = Utils.getRand(Monde.getMap().getHauteur() - 1);
            else if ((_position.getPosY() + vitesse) >= Monde.getMap().getHauteur())                //sorti du tableau bas
                y = Utils.getRand((Monde.getMap().getHauteur() - 1), (_position.getPosY() - vitesse));
            else if ((_position.getPosY() - vitesse) < 0)                        //sorti tableau haut
                y = Utils.getRand(_position.getPosY() + vitesse);
            else
                y = Utils.getRand((_position.getPosY() + vitesse), (_position.getPosY() - vitesse));
        }
        else {                                                                    //sinon espece pas leader et appartient a une meute
            //Gestion point X                        
            int var = _meute.getLeader().getPosition().getPosX() - _position.getPosX();                //calcul de la distance sur l'axe x entre l'espece et son chef de meute
            if (Math.abs(var) > 5) {                                                //si la distance est supérieur à 50 unités alors
                if (var < 0)                                                    //si espece s'éloigne par la droite
                    x = Utils.getRand(_position.getPosX(), _position.getPosX() - vitesse);
                else                                                            //si espece s'éloigne par la gauche
                    x = Utils.getRand(_position.getPosX() + vitesse, _position.getPosX());
            }
            else {
                if ((_position.getPosX() + vitesse) > (Monde.getMap().getLargeur() - 1) && (_position.getPosX() - vitesse) < 0)   //sorti tableau droite et gauche
                    x = Utils.getRand(Monde.getMap().getLargeur() - 1);
                else if ((_position.getPosX() - vitesse) < 0)                    //sorti tableau gauche
                    x = Utils.getRand(_position.getPosX() + vitesse);
                else if ((_position.getPosX() + vitesse) > (Monde.getMap().getLargeur() - 1))                //sorti du tableau a droite
                    x = Utils.getRand((Monde.getMap().getLargeur() - 1), (_position.getPosX() - vitesse));
                else
                    x = Utils.getRand((_position.getPosX() + vitesse), (_position.getPosX() - vitesse));
            }
            vitesse -= Math.abs(_position.getPosX() - x);                        //soustrait le deplacement x a deplacer

            //Gestion point Y
            var = _meute.getLeader().getPosition().getPosY() - _position.getPosY();
            if (Math.abs(var) > 5) {                                                //si la distance est supérieur à 50 unités alors
                if (var < 0)                                                    //si espece s'éloigne par le bas
                    y = Utils.getRand(_position.getPosY(), _position.getPosY() - vitesse);
                else
                    y = Utils.getRand(_position.getPosY() + vitesse, _position.getPosY());
            }
            else {
                if ((_position.getPosY() + vitesse) >= Monde.getMap().getHauteur() && (_position.getPosY() - vitesse) < 0)   //sorti tableau bat et haut
                    y = Utils.getRand(Monde.getMap().getHauteur() - 1);
                else if ((_position.getPosY() + vitesse) >= Monde.getMap().getHauteur())                //sorti du tableau bas
                    y = Utils.getRand((Monde.getMap().getHauteur() - 1), (_position.getPosY() - vitesse));
                else if ((_position.getPosY() - vitesse) < 0)        //sorti tableau haut
                    y = Utils.getRand(_position.getPosY() + vitesse);
                else
                    y = Utils.getRand((_position.getPosY() + vitesse), (_position.getPosY() - vitesse));
            }
        }
        sens(x, y);                                                                //gestion du sens du regard des especes
        setPosition(Monde.getMap().getCase(x, y));
    }

    public void fuir(Espece espece) {
        int x, y, vitesse = _vitesse + _vitesseCourse;
        int var = _position.getPosX() - espece.getPosition().getPosX();

        //Gestion point X
        if ((_position.getPosX() + vitesse) >= Monde.getMap().getLargeur())        //sorti tableau droite
            x = Utils.getRand((Monde.getMap().getLargeur() - 1), _position.getPosX());
        else if ((_position.getPosX() - vitesse) <= 0)                            //sorti tableau gauche
            x = Utils.getRand(_position.getPosX());
        else {
            if (var < 0)                                                        //fuite à gauche
                x = Utils.getRand(_position.getPosX(), (_position.getPosX() - vitesse));
            else                                                                //fuite à droite
                x = Utils.getRand((_position.getPosX() + vitesse), _position.getPosX());
        }
        vitesse -= Math.abs(_position.getPosX() - x);                            //soustrait le deplacement x a deplacer
        var = _position.getPosY() - espece.getPosition().getPosY();

        //Gestion point Y
        if ((_position.getPosY() + vitesse) >= Monde.getMap().getHauteur())        //sorti tableau bas
            y = Utils.getRand((Monde.getMap().getHauteur() - 1), _position.getPosY());
        else if ((_position.getPosY() - vitesse) <= 0)                            //sorti tableau haut
            y = Utils.getRand(_position.getPosY());
        else {
            if (var < 0)                                                        //fuite en haut
                y = Utils.getRand(_position.getPosY(), (_position.getPosY() - vitesse));
            else                                                                //fuite en bas
                y = Utils.getRand((_position.getPosY() + vitesse), _position.getPosY());
        }
        setPosition(Monde.getMap().getCase(x, y));
    }

    @Override
    public String toString() {
        return getNom() + " (" + getEnergie() + "): x: " + getPosition().getPosX() + ", y:" + getPosition().getPosY();
    }

    public Element sauvegarder() {
        Element espece = new Element("Espece");

        espece.setAttribute("champVision", getChampVision() + "");
        espece.setAttribute("course", getCourse() + "");
        espece.setAttribute("dateNaissance", getDateNaissance() + "");
        espece.setAttribute("energie", getEnergie() + "");
        espece.setAttribute("estLeader", getEstLeader() + "");
        espece.setAttribute("estVivant", getEstVivant() + "");
        espece.setAttribute("faim", getFaim() + "");
        espece.setAttribute("force", getForce() + "");
        espece.setAttribute("fuite", getFuite() + "");
        if (getMeute() != null)
            espece.setAttribute("meute", getMeute().getColor() + "");
        espece.setAttribute("nage", getNage() + "");
        espece.setAttribute("nbReproductions", getNbReproductions() + "");
        espece.setAttribute("nom", getNom());
        espece.setAttribute("positionX", getPosition().getPosX() + "");
        espece.setAttribute("positionY", getPosition().getPosY() + "");
        espece.setAttribute("sens", getSens() + "");
        espece.setAttribute("sexe", getSexe() + "");
        espece.setAttribute("sommeil", getSommeil() + "");
        espece.setAttribute("sommeilDeb", getSommeilDeb() + "");
        espece.setAttribute("sommeilFin", getSommeilFin() + "");
        espece.setAttribute("tempIdeal", getTempsIdeal() + "");
        espece.setAttribute("vitesse", getVitesse() + "");
        espece.setAttribute("vitesseCourse", getVitesseCourse() + "");

        return espece;
    }

    public void setGraphics(Animal animal) {
        _graphics = animal;
    }

    public Animal getGraphics() {
        return _graphics;
    }

    public int getTempsIdeal() {
        return _tempsIdeal;
    }

    public boolean isNeedToCreateABaby() {
        return _needToCreateABaby;
    }

    public void setNeedToCreateABaby(boolean _needToCreateABaby) {
        this._needToCreateABaby = _needToCreateABaby;
    }
}