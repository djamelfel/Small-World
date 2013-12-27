package modele.especes;

import modele.utils.Utils;

public class Giraffe extends EspeceTer implements Herbivore {


    public Giraffe(Espece espece) {
        super(espece);
    }

    public Giraffe() {
        super("Giraffe", 35, 80, 20, 40, 20, Math.random() < 0.2, false, 65, 25, Utils.getRand(3));
    }

    public void verifierEtatJournee() {
        if (getSommeil()) {
            if (getSommeil() == true)
                reveiller();
            activite();
        }
        else if (getSommeil() == true)
            dormir();
    }

    public void chuteCapacite() {
        if (getSommeil() == true)
            setForce(getForce() - 40);
        else {
            setForce(getForce() - 30);
            setVitesse(getVitesse() - 10);
            setVitesseCourse(getVitesse() - 5);
        }
    }

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
    public void fuir(Espece espece) {
        // TODO Auto-generated method stub
        super.fuir(espece);
    }

    public String toString() {
        return "nom - leader - repro - " + getNom() + getEstLeader() + getNbReproductions() + super.toString();
    }

    public String sauvegarder() {
        return null;
    }
}