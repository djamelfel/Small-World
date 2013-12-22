package monde;


import especes.Espece;
import nourriture.Nourriture;
import java.util.ArrayList;

public class Monde {

  private ArrayList<Espece> _listeAnimaux;

  private ArrayList<Nourriture> _listeNourriture;

  private ArrayList<Decors> _listeElementsDecors;

  private static Map _map;

  private int _temperature;

  private Temps _temps;

	/* 	public Nourriture 1;
		public Decors Posseder;
		public Map Appartenir;
		public Espece Comporter;
		public Temps Contenir;
		public InterfaceMonde myInterfaceMonde;
		public Nourriture Contenir;
	*/
  public Monde()
  {
      _map = new Map(1920,1080);
      
      _listeAnimaux = new ArrayList<>();
      _listeElementsDecors = new ArrayList<>();
      _listeNourriture = new ArrayList<>();
      
      
      ArrayList<Case> _casesVoisines = getVoisins(_map.getCase(1917,500), 10, 1);
      System.out.println("nbCases : "+_casesVoisines.size());
      
      
      ajoutDecors("montagne1", 1500,1000);
  }

  public static ArrayList<Case> getVoisins(Case caseDepart, int champVision, int sens) {
      
      ArrayList<Case> _casesVoisines = new ArrayList();
      
      // TODO : prendre en compte le sens
      // TODO : retourner une zone en cone et non en ligne
      
      Case tmpCase;
      int posX = caseDepart.getPosX();
      int posY = caseDepart.getPosY();
      
      for(int i = 0; i < champVision; i++)
      {
          tmpCase = _map.getCase(posX + i, posY);
          if(tmpCase == null) continue;
          _casesVoisines.add(tmpCase);
      }
      
      
    return _casesVoisines;
  }

  public Espece ajoutAnimaux(String nom, int posX, int posY) {
      
      Espece tmpEspece = null;
      
      switch(nom)
      {
          case "":
             break;
          
          
      }
      
      
      
     return tmpEspece;
  }

  public Decors ajoutDecors(String nom, int posX, int posY) {
      Decors tmpDecors = null;
      
      switch(nom)
      {
          case "montagne1":
              tmpDecors = new Decors(TypeDecors.BASE, 1918, 1076, 5, 5);
              break;
          
          
      }
      
      if(tmpDecors != null)
      {
         _map.ajouterDecors(tmpDecors);
         _listeElementsDecors.add(tmpDecors);
      }
        
      
     return tmpDecors;
  }

  public Nourriture ajoutNourriture(String nom, int posX, int posY) {
    Nourriture tmpNourriture = null;
      
      switch(nom)
      {
          case "":
              break;
          
          
      }
      
      if(tmpNourriture != null)
      { 
        _map.ajouterNouriture(tmpNourriture);
        _listeNourriture.add(tmpNourriture);
      }
        
      
     return tmpNourriture;
  }

  public String sauvegarder() {
  return "";
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