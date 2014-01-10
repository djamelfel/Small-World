package modele.monde;


import controleur.Controleur;
import modele.especes.Espece;
import modele.nourriture.Nourriture;
import java.util.ArrayList;
import modele.especes.animaux.Lamastico;
import modele.especes.animaux.Lion;
import modele.nourriture.Herbe;
import org.jdom2.Element;
import utilitaires.Sauvegarder;
import vue.enums.Animal;
import vue.enums.Decor;
import vue.enums.NourrituresEnum;

public class Monde {

  private ArrayList<Espece> _listeAnimaux;
  private ArrayList<Nourriture> _listeNourriture;
  private static Map _map;
  private int _temperature;
  private Temps _temps;
  private Controleur _controleur;
  
  public Monde(Controleur controleur)
  {
      _listeAnimaux = new ArrayList<>();
      _listeNourriture = new ArrayList<>();
	  _controleur = controleur;
	  new Sauvegarder(this);
	  _temperature = 20;
  }
  
  public void initialiser(int rows, int cols)
  {
      _map = new Map(cols,rows);
  }
  
 
  public void activerAnimaux() {
       ArrayList<Espece> aTuer = new ArrayList<>();
       int lg = _listeAnimaux.size();
       Espece tmpAnimal;
		for(int i = 0; i < lg; i++) {
			tmpAnimal = _listeAnimaux.get(i);
			if ( tmpAnimal.getEstVivant() )
				tmpAnimal.verifierEtatJournee();
			else {
				//créer nourriture == Gerer temps de décomposition
				//if (tmpAnimal instanceof Lamastico)
/*A REVOIR*/			//_listeNourriture.add(new Cadavre(60, tmpAnimal.getPosition().getPosX(), tmpAnimal.getPosition().getPosY()));
				//detruire animal
				aTuer.add(tmpAnimal);
			}
		}
		lg = aTuer.size();
		for(int i=0; i< lg; i++)
			_controleur.supprimerEspece(aTuer.get(i));
	    aTuer.removeAll(aTuer);
   }
 
   public static ArrayList<Case> getVoisins(Case caseDepart, int champVision, int sens) {
      
		ArrayList<Case> _casesVoisines = new ArrayList();
      
      // TODO : prendre en compte le sens
     //0 : haut, 1 : droite, 2 : bas, 3 : gauche
      
		Case tmpCase;
		int posX = caseDepart.getPosX();
		int posY = caseDepart.getPosY();
                
		
		if(sens == 1) {
			//System.out.println("droite "+champVision);
			for(int i = 1; i < champVision; i++) {
				for (int j = posY - i; j<= posY + i ; j++) {
					tmpCase = _map.getCase( (posX+i) , j);
					if ( tmpCase == null ) continue;
						if(tmpCase.getEspece() != null)
							_casesVoisines.add(tmpCase);
						else if(tmpCase.getNourriture() != null)
							_casesVoisines.add(tmpCase);
				}
			}
		}
        else if(sens == 3) {
			//System.out.println("GAUCHE "+champVision);
			for(int i = 1; i < champVision; i++) {
				for (int j = posY - i; j<= posY + i ; j++) {
					tmpCase = _map.getCase( (posX-i) , j);
					if ( tmpCase == null ) continue;
						if(tmpCase.getEspece() != null)
							_casesVoisines.add(tmpCase);
						else if(tmpCase.getNourriture() != null)
							_casesVoisines.add(tmpCase);
				}
			}
		}
		else if(sens == 2) {
			// System.out.println("bas "+champVision);
			for(int i = 1; i < champVision; i++) {
				for (int j = posX - i; j<= posX + i ; j++) {
					tmpCase = _map.getCase( j , posY + i);
					if ( tmpCase == null ) continue;
						if(tmpCase.getEspece() != null)
							_casesVoisines.add(tmpCase);
						else if(tmpCase.getNourriture() != null)
							_casesVoisines.add(tmpCase);
				}
			}
		}
		else if(sens == 0) {
			// System.out.println("haut");
			for(int i = 1; i < champVision; i++) {
				for (int j = posX - i; j<= posX + i ; j++) {
					tmpCase = _map.getCase( j , posY - i);
					if ( tmpCase == null ) continue;
						if(tmpCase.getEspece() != null)
							_casesVoisines.add(tmpCase);
						else if(tmpCase.getNourriture() != null)
							_casesVoisines.add(tmpCase);
				}
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
          case "Lamastico":
              System.out.println("JE SUIS UN LAMA");
              tmpEspece = new Lamastico(estLeader, sexe);
              tmpEspece.setGraphics(Animal.lamastico);
             break;
          
      }
      tmpEspece.setPosition(_map.getCase(posX, posY));
      _listeAnimaux.add(tmpEspece);
      
     return tmpEspece;
  }

		public ArrayList<Espece> getListeAnimaux() {
				return _listeAnimaux;
		}

		public ArrayList<Nourriture> getListeNourriture() {
				return _listeNourriture;
		}

  public void ajoutDecors(Decor decor, int posX, int posY) {
	  _map.getCase(posX, posY).getDecors().setGraphics(decor);
  }

  public void ajoutNourriture(String nourriture, int posX, int posY) {
      Nourriture tmpNourriture = null;
      switch(nourriture)
      {
          case "Banane":
			  tmpNourriture = new Herbe(_map.getCase(posX, posY));
			  tmpNourriture.setGraphics(NourrituresEnum.banane);
              break;
          case "Carotte":
			  tmpNourriture = new Herbe(_map.getCase(posX, posY));
			  tmpNourriture.setGraphics(NourrituresEnum.carotte);
              break;				  
          default:
      }
      _map.ajouterNouriture(tmpNourriture);
      _listeNourriture.add(tmpNourriture);
  }

  public Element sauvegarder() {
		Element manager = new Element("Manager");
		Element monde = new Element("Monde");
		Element animaux = new Element("Animaux");
		Element nourriture = new Element("Nourriture");
		
		int lg=_listeAnimaux.size();
		for(int i = 0; i < lg;i++)
			animaux.addContent(_listeAnimaux.get(i).sauvegarder());
		
		lg=_listeNourriture.size();
		for(int i = 0; i < lg;i++)
			nourriture.addContent(_listeNourriture.get(i).sauvegarder());		
		
		manager.addContent(_map.sauvegarder());
		monde.setAttribute("Temperature",_temperature+"");
		monde.addContent(animaux);
		monde.addContent(nourriture);
		manager.addContent(monde);
		return manager;
  }

  public void charger(String nom) {
	
  }
  
  public void setTemperature(int temperature) {
		_temperature = temperature;
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