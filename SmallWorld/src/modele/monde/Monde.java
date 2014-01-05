package modele.monde;


import modele.especes.Espece;
import modele.nourriture.Nourriture;
import java.util.ArrayList;
import modele.especes.animaux.Giraffe;
import vue.enums.Animal;

public class Monde {

  private ArrayList<Espece> _listeAnimaux;

  private ArrayList<Nourriture> _listeNourriture;

  private ArrayList<Decors> _listeElementsDecors;

  private static Map _map;

  private int _temperature;

  private Temps _temps;
  
  public Monde()
  {
      _listeAnimaux = new ArrayList<>();
      _listeElementsDecors = new ArrayList<>();
      _listeNourriture = new ArrayList<>();
      
      
      //System.out.println("nbCases : "+_casesVoisines.size());
      //ajoutDecors("montagne1", 1500,1000);
  }
  
  public void initialiser(int rows, int cols)
  {
      _map = new Map(cols,rows);
  }
  
 
  public void deplacerAnimaux() {
      
       int lg = _listeAnimaux.size();
       Espece tmpAnimal;
       for(int i = 0; i < lg; i++)
       {
           tmpAnimal = _listeAnimaux.get(i);
           tmpAnimal.seDeplacer();
       }
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

  public Espece ajoutAnimaux(Animal animal, int posX, int posY) {
      
      Espece tmpEspece = null;
      System.out.println(animal.getNom());
      switch(animal.getNom())
      {
          case "Lion":
              System.out.println("JE SUIS UN LION");
              tmpEspece = new Giraffe();
              tmpEspece.setGraphics(Animal.lion);
              
             break;
          case "Lamasticot":
              System.out.println("JE SUIS UN LAMA");
              tmpEspece = new Giraffe();
              tmpEspece.setGraphics(Animal.lamasticot);
             break;
          
      }
     // tmpEspece = new Giraffe();
      
      tmpEspece.setPosition(_map.getCase(posX, posY));
      
      if(tmpEspece != null)
      {
         _listeAnimaux.add(tmpEspece);
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