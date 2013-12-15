package monde;



import monde.Monde;
import java.util.ArrayList;

public class Map {

  //public ArrayList<ArrayList<Case>> listeCase;
  public Case[][] listeCase;
   private Monde mondeActuel;
   private int largeur;
   private int hauteur;
  //  public Case Composer;
   
   public Map(int largeur, int hauteur)
   {
       this.largeur = largeur;
       this.hauteur = hauteur;
       listeCase = new Case[hauteur][largeur];
       
       for(int i = 0; i < hauteur; i++)
       {
          for(int j = 0; j < largeur; j++)
          {
              listeCase[i][j] = new Case(j, i);
          } 
       }
       
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
      if(posX < 0 || posY < 0 || posX >= largeur || posY >= hauteur) return null; // Sort du tableau !
    return listeCase[posY][posX];
  }
  
   public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }
}