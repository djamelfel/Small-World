package controleur;

import modele.monde.Monde;
import modele.monde.Temps;


/**
 * @author Benjamin
 */
public class ManagerAnimaux implements Runnable {

    private Thread _instance;
    private Controleur _controleur;
    private Monde _monde;
    private int _duree = 500; // Contient la duree d'endormissement du Thread entre chaque tour de boucle en ms


    private boolean _pause = false;


    public ManagerAnimaux(Controleur controleur) {
        _controleur = controleur;
        _monde = new Monde(_controleur);
    }

    public void initialiser(int rows, int cols) {
        _monde.initialiser(rows, cols);
    }

    public void start() {
        if (_instance == null) {
            _instance = new Thread(this);
            _instance.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Start manager");
        while (true) {
            if (_pause) continue;
            try {
                Thread.sleep(_duree);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            long currentTime = System.currentTimeMillis();

            Temps.incrementer();

            _monde.activerAnimaux();
            _monde.gererNourriture();

            _controleur.getFenetre().getGrille().repaint();

            _controleur.getFenetre().getBarreEtat().update("Temps : " + Temps.getJournee());
            _controleur.getFenetre().getArbre().updateTree();

            //System.out.println("> Heure = "+currentTime);
        }
    }


    public Monde getMonde() {
        return _monde;
    }

    public boolean isPause() {
        return _pause;
    }

    public void setPause(boolean _pause) {
        this._pause = _pause;
    }

    public void setDuree(int _duree) {
        this._duree = _duree;
    }

    public int getDuree() {
        return _duree;
    }

}
