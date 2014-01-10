package modele.monde;

import modele.nourriture.Nourriture;
import org.jdom2.Element;
import vue.enums.Decor;

public class Map {

	//public ArrayList<ArrayList<Case>> listeCase;
	public Case[][] _listeCase;
	private int _largeur;
	private int _hauteur;
	private Monde _monde;
	//  public Case Composer;
   
	public Map(int largeur, int hauteur)
	{
       _largeur = largeur;
       _hauteur = hauteur;
       _listeCase = new Case[hauteur][largeur];
       
       for(int i = 0; i < _hauteur; i++)
          for(int j = 0; j < _largeur; j++)
              _listeCase[i][j] = new Case(j, i);
	}
   
	public void ajouterNouriture(Nourriture nourriture)
	{
		Case tmpCase = getCase(nourriture.getPosition().getPosX(), nourriture.getPosition().getPosY());
		if(tmpCase != null &&  tmpCase.getNourriture() == null) 
			tmpCase.setNourriture(nourriture);
	}
   
    public void ajouterDecors(Decors elementDecors)
    {
		Case tmpCase;
		tmpCase = getCase(elementDecors.getPosX(), elementDecors.getPosX());
		tmpCase.setDecors(elementDecors);
    }

     public Case getCase(Integer posX, Integer posY) {
		if(posX < 0 || posY < 0 || posX >= _largeur || posY >= _hauteur) return null; // Sort du tableau !
			return _listeCase[posY][posX];
       }
     
     
     public Element sauvegarder(){
		Element map = new Element("Map");
		
		map.setAttribute("Hauteur",""+_hauteur);
		map.setAttribute("Largeur",""+_largeur);
		for(int i =0; i< _hauteur;i++)
			for(int j=0; j<_largeur; j++) {
				if( !(_listeCase[i][j].getDecors().getGraphics().getNom().equals(Decor.herbe.getNom())) )
					map.addContent(_listeCase[i][j].sauvegarder());
			}
		
		return map;
	}
  
	public int getLargeur() {
        return _largeur;
    }

    public int getHauteur() {
        return _hauteur;
    }
}