
import java.util.ArrayList;

public class Monde {

  public ArrayList<Espece> listeAnimaux;

  public ArrayList<Nourriture> listeNourriture;

  public ArrayList<Decors> listeElementsDecors;

  public Map map;

  public int temperature;

  public Temps temps;

   /* public Nourriture 1;
    public Decors Posseder;
    public Map Appartenir;
    public Espece Comporter;
    public Temps Contenir;
    public InterfaceMonde myInterfaceMonde;
    public Nourriture Contenir;*/
  public Monde()
  {
      map = new Map(1920,1080);
      
      
  }
  
  
  
  

  public ArrayList<Case> getVoisins(Case caseDepart, int champVision, int sens) {
      
      ArrayList<Case> _casesVoisines = new ArrayList();
      
      // TODO : prendre en compte le sens
      
      Case tmpCase;
      int posX = caseDepart.posX;
      int posY = caseDepart.posY;
      
      for(int i = 0; i < champVision; i++)
      {
          tmpCase = map.getCase(posX + i, posY);
          if(tmpCase == null) continue;
          
      }
      
      
    return null;
  }

  public Espece ajoutAnimaux(String nom) {
     return null;
  }

  public Decors ajoutDecors(String nom) {
  return null;
  }

  public Nourriture ajoutNourriture(String nom) {
  return null;
  }

  public String sauvegarder() {
  return null;
  }

  public void charger(String nom) {
  }

}