package controleur;

import modele.monde.Monde;


/**
 *
 * @author Benjamin
 */
public class ManagerAnimaux implements Runnable{
    
    private Thread _instance;
    
    private Controleur _controleur;
    private Monde _monde;

    private int _duree = 500; // Contient la duree d'endormissement du Thread entre chaque tour de boucle en ms
    
    private boolean _pause = false;
    
    public ManagerAnimaux(Controleur controleur)
    {
        _controleur = controleur;
        _monde = new Monde();
    }
    
    public void initialiser(int rows, int cols)
    {
        _monde.initialiser(rows, cols);
    }

    public void start() 
    {
	if (_instance==null) 
	{
            _instance = new Thread(this);
            _instance.start();
	}
    }
    @Override
    public void run() {
        System.out.println("Start manager");
        while (true) 
        {
            if(_pause) continue;
            try 
            {
                Thread.sleep(_duree);
            } 
            catch (InterruptedException e) {e.printStackTrace();}
				
            long currentTime = System.currentTimeMillis();
		
            _monde.deplacerAnimaux();
            
            _controleur.getFenetre().getGrille().repaint();
           
            //System.out.println("> Heure = "+currentTime);
	}
    }
    
    
    public Monde getMonde() {
        return _monde;
    }
    
    
    
}
