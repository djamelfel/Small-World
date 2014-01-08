package modele.monde;


import modele.especes.Espece;
import modele.nourriture.Nourriture;
import java.util.ArrayList;
import modele.especes.animaux.Giraffe;
import modele.especes.animaux.GiraffeBis;
import modele.nourriture.Cadavre;
import vue.enums.Animal;
import vue.enums.Decor;
import vue.enums.NourrituresEnum;

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
  }
  
  public void initialiser(int rows, int cols)
  {
      _map = new Map(cols,rows);
  }
  
 
  public void activerAnimaux() {
       ArrayList<Espece> aTuer = new ArrayList<>();
       int lg = _listeAnimaux.size();
       Espece tmpAnimal;
       if (lg != 0) {
			for(int i = 0; i < lg; i++) {
				tmpAnimal = _listeAnimaux.get(i);
				if (tmpAnimal.getEstVivant() == true)
					tmpAnimal.verifierEtatJournee();
				else {
					//créer nourriture == Gerer temps de décomposition
					_listeNourriture.add(new Cadavre(tmpAnimal, 10));
					//detruire animal
					aTuer.add(tmpAnimal);
				}
			}
		}
	    _listeAnimaux.removeAll(aTuer);
   }
 
 
  public static ArrayList<Case> getVoisins(Case caseDepart, int champVision, int sens) {
      
		ArrayList<Case> _casesVoisines = new ArrayList();
      
      // TODO : prendre en compte le sens
      
		Case tmpCase;
		int posX = caseDepart.getPosX();
		int posY = caseDepart.getPosY();
		
		for(int i = 1; i < champVision; i++) {
				for (int j = posY - i+2; j< posY + i-1 ; j++) {
					tmpCase = _map.getCase( (posX+i-1) , j);
					if ( tmpCase == null ) continue;
					if(tmpCase.getEspece() != null)
						_casesVoisines.add(tmpCase);
					if(tmpCase.getNourriture() != null)
						_casesVoisines.add(tmpCase);
				}
		  }
    return _casesVoisines;
  }

  public Espece ajoutAnimaux(Animal animal, boolean estLeader, boolean sexe, int posX, int posY) {
      
      Espece tmpEspece = null;
      System.out.println(animal.getNom());
      switch(animal.getNom())
      {
          case "Lion":
              System.out.println("JE SUIS UN LION");
              tmpEspece = new Giraffe(estLeader, sexe);
              tmpEspece.setGraphics(Animal.lion);
              
             break;
          case "Lamasticot":
              System.out.println("JE SUIS UN LAMA");
              tmpEspece = new GiraffeBis(estLeader, sexe);
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

  public void ajoutDecors(Decor decor, int posX, int posY) {
      switch(decor.getNom())
      {
//TODO : AJOUTER TOUS LES AUTRES DECORS
			  case "Eau":
              _map.getCase(posX, posY).getDecors().setType(TypeDecors.EAU);
              break;
          case "Sable":
              _map.getCase(posX, posY).getDecors().setType(TypeDecors.SABLE);
              break;     
          default:
              _map.getCase(posX, posY).getDecors().setType(TypeDecors.BASE);
      }
  }

  public Nourriture ajoutNourriture(NourrituresEnum nourriture, int posX, int posY) {
    Nourriture tmpNourriture = null;
      
      switch(nourriture.getNom())
      {
          case "":
              break;
          default:
              tmpNourriture = new Nourriture(5);
      }
      tmpNourriture.setGraphics(nourriture);
      tmpNourriture.setPosX(posX);
      tmpNourriture.setPosY(posY);
      
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