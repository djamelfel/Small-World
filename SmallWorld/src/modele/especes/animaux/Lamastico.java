package modele.especes.animaux;

import modele.especes.Espece;
import modele.especes.EspeceTer;
import modele.especes.Herbivore;
import modele.monde.Case;
import modele.monde.Monde;
import modele.monde.Temps;
import modele.monde.TypeDecors;
import modele.utils.Utils;

import java.util.ArrayList;

public class Lamastico extends EspeceTer implements Herbivore {


    public Lamastico(Espece espece) {
        super(espece);
    }

    public Lamastico(boolean estLeader, boolean sexe) {
        super("Lamastico", 35, 80, 2, 40, 20, estLeader, false, 65, 25, Utils.getRand(3), sexe);
    }

    @Override
    public void chuteCapacite() {
        if (getSommeil() == true)
            setForce(getForce() - 40);
        else if (getFuite() == true) {
            setForce(getForce() - 30);
            setVitesse(getVitesse() - 10);
            setVitesseCourse(getVitesse() - 5);
        }
        setFuite(false);
    }

    @Override
    public void retrouveCapacite() {
        if (getSommeil() == true)
            setForce(getForce() + 40);
        else {
            setForce(getForce() + 30);
            setVitesse(getVitesse() + 10);
            setVitesseCourse(getVitesse() + 5);
        }
    }

    @Override
    public void combattre(Espece espece) {
        int resultat = 0;
        if (getForce() < espece.getForce())                                        //plus faible que adversaire
            resultat = 1;
        else if (getForce() > espece.getForce())                                //plus fort que adversaire
            resultat = 2;
        else                                                                    //aussi fort que adversaire
            if (getEnergie() < espece.getEnergie())                                //adversaire a plus d'energie
                resultat = 1;
            else                                                                //plus d'energie que adversaire
                resultat = 2;

        switch (resultat) {
            case 1:                                                                //perd
                if (getEstLeader())                                                //si leader
                    if (espece.getEstLeader() && espece instanceof Lamastico)        //si adversaire leader et de la meme espece
                        espece.getMeute().rejoindre(getMeute());                //legue ma meute
                    else                                                        //sinon
                        getMeute().detruire();                                    //dissout la meute
                break;

            case 2:                                                                //gagne
                setEnergie((getForce() - espece.getForce()) / 2);
                espece.tuer();
                break;

            default:                                                            //match null

        }
    }

    @Override
    public void activite() {

        if (Temps.getJeux() % 20 == 0) {                                        //temps à comfirmer
            setEnergie(getEnergie() - 30);                                        //baisse d'énergie à confimer
            setFaim(getFaim() - 20);                                            //baisse de faim à confirmer
            System.out.println("energie" + getFaim() + " - " + getEnergie());
        }
        if (getFaim() < 40)                                                        //si trop faim perte de vie
            setEnergie(getEnergie() - 1);
        if (getEnergie() <= 0)                                                    //si plus d'energie animal meurt
            tuer();
        else {
            if (getFuite() == true) {                                            //si animal en fuite
                if (Math.abs(getPosition().getPosX() - getDanger().getPosition().getPosX()) < 7 && Math.abs(getPosition().getPosY() - getDanger().getPosition().getPosY()) < 7) { //si danger persiste (stocké un pointeur de l'animal dangereux ?)
                    fuir(getDanger());                                            //fuire
                    System.out.println("en fuite");
                }
                else {
                    setDanger(null);                                            //sinon ne plus fuire
                    setFuite(false);
                    System.out.println("fin fuite");
                }
            }
            else {
                //System.out.println(getPosition().getDecors() + " ou "+ TypeDecors.EAU);
                if (getPosition().getDecors().getType() == TypeDecors.EAU) {    //sinon si zone inadapter
                    setFuite(true);
                    chuteCapacite();
                    seDeplacer();
                    System.out.println("mauvaise zone");
                }
                else if (getPosition().getEspece() != null && getPosition().getEspece() != this) {                        //sinon si case animal
                    if (getCourse())                                            //si doit se battre
                    {
                        combattre(getPosition().getEspece());                                            //combatre
                        System.out.println("combat");
                    }
                    else if (getPosition().getEspece() instanceof Lamastico && getSexe() == false && getPosition().getEspece().getSexe() != getSexe())    //si animal meme espece de sexe different du mien et moi femelle
                    {
                        seReproduire();                                            //faire des bébés

                        System.out.println("bébé");
                    }
                }
                else if (getPosition().getNourriture() != null && getPosition().getNourriture().getMangeable() == true) {                //sinon si case nourriture et mangeable
                    System.out.println("HO de la nourriture");
                    if (aFaim()) {
                        manger();
                        System.out.println("mange");
                    }
                    else
                        seDeplacer();
                }
                else {                                                            //gestion des autres cas
                    ArrayList<Case> vision;
                    int i = 0;
                    boolean finAction = false;
                    setCourse(false);
                    vision = Monde.getVoisins(getPosition(), getChampVision(), getSens());    //recupere champs vision dans tempObj
                    if (vision.isEmpty()) {                                    //se deplace rien apperçu
                        finAction = true;
                        seDeplacer();
                    }
                    while (finAction == false && i < vision.size()) {
                        if (vision.get(i).getEspece() != null) {                //si apperçoit animal
// TODO : VOIR SI ANIMAL EN QUESTION EST DANGEREUX POUR MES FESSES
                            if (false) {                                    //si animal dangereux
                                setFuite(true);
                                setDanger(vision.get(i).getEspece());
                                fuir(getDanger());
                                finAction = true;
                                System.out.println("DANGER");
                            }
                            else if (vision.get(i).getEspece() instanceof Lion) {                //sinon si animal convoiter
                                setCourse(true);
                                seDeplacer(vision.get(i).getEspece().getPosition());
                                finAction = true;
                                System.out.println("à la chasse");
                            }
                            else if (vision.get(i).getEspece() instanceof Lamastico) {    //sinon si animal même espece
                                if (vision.get(i).getEspece().getEstLeader() == true && getEstLeader() == true) {    //si animal leader et moi leader
                                    seDeplacer(vision.get(i).getEspece().getPosition());
                                    finAction = true;
                                    System.out.println("go bataille");
                                }
                                else if (vision.get(i).getEspece().getEstLeader() == true && getMeute() == null)    //sinon si adversaire leader et moi sans meute
                                {
                                    vision.get(i).getEspece().getMeute().rejoindre(this);                        //adhérer
                                    System.out.println("adhere meute");
                                }
                                else if (vision.get(i).getEspece().getEstLeader() == true && getMeute() != null)    //sinon si adversaire est leader mais pas le mien et moi meute
                                    if (vision.get(i).getEspece() != getMeute().getLeader()) {
                                        appelLeader();                            //appeler leader
                                        System.out.println("appel leader");
                                    }
                                    else if (vision.get(i).getEspece().getSexe() == true && vision.get(i).getEspece().getNbReproductions() > 0 && getNbReproductions() > 0) {//sinon si male, si il peut s'accoupler et moi aussi et moi femmelle
                                        seDeplacer(vision.get(i).getEspece().getPosition());
                                        finAction = true;
                                        System.out.println("direction accouplement");
                                    }
                            }
                        }
                        if (vision.get(i).getNourriture() != null) {            //si nourriture
                            if (aFaim()) {                                    //si faim
                                seDeplacer(vision.get(i).getNourriture().getPosition());
                                finAction = true;
                            }
                        }
                        i++;
                    }
                    if (finAction == false)                                    //se deplace si aucun autre deplacement a été effectué
                        seDeplacer();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "nom - leader - repro - " + getNom() + getEstLeader() + getNbReproductions() + super.toString();
    }
}