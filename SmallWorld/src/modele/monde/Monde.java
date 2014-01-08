package modele.monde;


import modele.especes.Espece;
import modele.nourriture.Nourriture;
import java.util.ArrayList;
import modele.especes.animaux.Lamastico;
import modele.especes.animaux.Lion;
import modele.nourriture.Cadavre;
import modele.nourriture.Herbe;
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
					//if (tmpAnimal instanceof Lamastico)
/*A REVOIR*/			//_listeNourriture.add(new Cadavre(60, tmpAnimal.getPosition().getPosX(), tmpAnimal.getPosition().getPosY()));
					//detruire animal
					aTuer.add(tmpAnimal);
					tmpAnimal.getPosition().setEspece(null);
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

  public Espece ajoutAnimaux(String animal, boolean estLeader, boolean sexe, int posX, int posY) {
      
      Espece tmpEspece = null;
      System.out.println(animal);
      switch(animal)
      {
          case "Lion":
              System.out.println("JE SUIS UN LION");
              tmpEspece = new Lion(estLeader, sexe);
              tmpEspece.setGraphics(Animal.lion);
             break;
          case "Lamasticot":
              System.out.println("JE SUIS UN LAMA");
              tmpEspece = new Lamastico(estLeader, sexe);
              tmpEspece.setGraphics(Animal.lamasticot);
             break;
          
      }
      tmpEspece.setPosition(_map.getCase(posX, posY));
      _listeAnimaux.add(tmpEspece);
      
     return tmpEspece;
  }

  public void ajoutDecors(Decor decor, int posX, int posY) {
      switch(decor.getNom())
      {
//TODO : AJOUTER TOUS LES AUTRES TYPE DE DECORS
			  case "Eau":
              _map.getCase(posX, posY).getDecors().setType(TypeDecors.EAU);
              break;
          case "Sable":
              _map.getCase(posX, posY).getDecors().setType(TypeDecors.SABLE);
              break;     
          default:
              _map.getCase(posX, posY).getDecors().setType(TypeDecors.BASE);
      }
	  _listeElementsDecors.add(_map.getCase(posX, posY).getDecors());
  }

  public void ajoutNourriture(String nourriture, int posX, int posY) {
      Nourriture tmpNourriture = null;
      switch(nourriture)
      {
          case "Banane":
			  tmpNourriture = new Herbe(_map.getCase(posX, posY));
			  tmpNourriture.setGraphics(NourrituresEnum.banane);
              break;
          default:
      }
      _map.ajouterNouriture(tmpNourriture);
      _listeNourriture.add(tmpNourriture);
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