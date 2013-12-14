
import java.util.ArrayList;

public class Map {

  //public ArrayList<ArrayList<Case>> listeCase;
  public Case[][] listeCase;
   public Monde mondeActuel;
   private int largeur;
   private int hauteur;
  //  public Case Composer;
   
   public Map(int largeur, int hauteur)
   {
       this.largeur = largeur;
       this.hauteur = hauteur;
       for(int i = 0; i < hauteur; i++)
       {
          for(int j = 0; j < largeur; i++)
          {
              listeCase[i][j] = new Case(j, i);
          } 
       }
       
   }

  public Case getCase(Integer posX, Integer posY) {
    return null;
  }

}