package modele.monde;

import modele.monde.Monde;
import java.util.ArrayList;
import modele.nourriture.Nourriture;

public class Map {

	//public ArrayList<ArrayList<Case>> listeCase;
	public Case[][] _listeCase;
	private Monde _mondeActuel;
	private int _largeur;
	private int _hauteur;
	//  public Case Composer;
   
	public Map(int largeur, int hauteur)
	{
       _largeur = largeur;
       _hauteur = hauteur;
       _listeCase = new Case[hauteur][largeur];
       
       for(int i = 0; i < _hauteur; i++)
       {
          for(int j = 0; j < _largeur; j++)
          {
              _listeCase[i][j] = new Case(j, i);
          } 
       }
       
	}
   
	public void ajouterNouriture(Nourriture nourriture)
	{
		Case tmpCase = getCase(nourriture.getPosX(), nourriture.getPosY());
		if(tmpCase != null &&  tmpCase.getNourriture() == null) 
			tmpCase.setNourriture(nourriture);
	}
   
        public void ajouterDecors(Decors elementDecors)
        {
		Case tmpCase;
		for(int i = 0; i < elementDecors.getHauteur(); i++)
		{
			for(int j = 0; j < elementDecors.getLargeur(); j++)
			{
				tmpCase = getCase(elementDecors.getPosX() + j, elementDecors.getPosY() + i);
				if(tmpCase != null)
				{
					tmpCase.setDecors(elementDecors);
				}
			} 
			System.out.println("");
		}
      }

     public Case getCase(Integer posX, Integer posY) {
		if(posX < 0 || posY < 0 || posX >= _largeur || posY >= _hauteur) return null; // Sort du tableau !
			return _listeCase[posY][posX];
       }
  
	public int getLargeur() {
        return _largeur;
    }

    public int getHauteur() {
        return _hauteur;
    }
}