package monde;


import especes.Espece;
import nourriture.Nourriture;
import java.util.ArrayList;
import java.util.Iterator;

public class Monde {

  private ArrayList<Espece> _listeAnimaux;

  private ArrayList<Nourriture> _listeNourriture;

  private ArrayList<Decors> _listeElementsDecors;

  private Map _map;

  private int _temperature;

  private Temps _temps;

   /* public Nourriture 1;
    public Decors Posseder;
    public Map Appartenir;
    public Espece Comporter;
    public Temps Contenir;
    public InterfaceMonde myInterfaceMonde;
    public Nourriture Contenir;*/
  public Monde()
  {
      _map = new Map(1920,1080);
      
      _listeAnimaux = new ArrayList<>();
      _listeElementsDecors = new ArrayList<>();
      _listeNourriture = new ArrayList<>();
      
      
      ArrayList<Case> _casesVoisines = getVoisins(_map.getCase(1917,500), 10, 1);
      System.out.println("nbCases : "+_casesVoisines.size());
      
      
      ajoutDecors("montagne1", 1500,1000);
      
      checkNourritures();
  }
  
  
  
  // Parcours la liste des nourritures et supprime
  private void checkNourritures()
  {
      Case tmpCase;
      
      for (Iterator it = _listeNourriture.iterator(); it.hasNext(); )
      {
         Nourriture n = (Nourriture) it.next();
         
          if(!n.getMangeable())
          {
              tmpCase = _map.getCase(n.getPosX(), n.getPosY());
              if(tmpCase != null)
              {
                  tmpCase.setNourriture(null);
                   it.remove();
              }
          }
      }
  }
  
  
  

  public ArrayList<Case> getVoisins(Case caseDepart, int champVision, int sens) {
      
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
      if(tmpEspece != null)
      {
         _map.ajouterAnimal(tmpEspece);
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
      String res = "";
      String tmpRes = "";
      
      
      // #### Sauvegarde des décors de la map ####
      tmpRes = "";
        for(Decors d : _listeElementsDecors)
        {
            if(d != null)
                tmpRes += d.sauvegarder();
        }
       if(!tmpRes.equalsIgnoreCase(""))
       {
           res += "<decors>"+tmpRes+"</decors>";
       }
       // ####     FIN     ####
       
       // #### Sauvegarde des animaux de la map ####
      tmpRes = "";
        for(Espece e : _listeAnimaux)
        {
            if(e != null)
                tmpRes += e.sauvegarder();
        }
       if(!tmpRes.equalsIgnoreCase(""))
       {
           res += "<animaux>"+tmpRes+"</animaux>";
       }
       // ####     FIN     ####
      
      // #### Sauvegarde des nourritures de la map ####
      tmpRes = "";
        for(Nourriture n : _listeNourriture)
        {
            if(n != null && n.getMangeable())
                tmpRes += n.sauvegarder();
        }
       if(!tmpRes.equalsIgnoreCase(""))
       {
           res += "<nourritures>"+tmpRes+"</nourritures>";
       }
       // ####     FIN     ####
      
    return res;
  }

  public void charger(String nom) {
      
      //http://cynober.developpez.com/tutoriel/java/xml/jdom/
       //Dans un premier temps on liste tous les étudiants
     /* List listEtudiant = racine.getChildren("etudiant");
      Iterator i = listEtudiant.iterator();
      //On parcours la liste grâce à un iterator
      while(i.hasNext())
      {
         Element courant = (Element)i.next();
         //Si l’étudiant possède l'Element en question on applique
         //les modifications.
         if(courant.getChild(element)!=null)
         {
            //On supprime l'Element en question
            courant.removeChild(element);
            //On renomme l'Element père sachant qu'une balise XML n'accepte
            //ni les espaces ni les caractères spéciaux
            //"étudiant modifié" devient "etudiant_modifie"
            courant.setName("etudiant_modifie");
         }
      }*/
      
      /*ajoutDecors(nom, posX, posY);
      ajoutAnimaux(nom, posX, posY);
      ajoutNourriture(nom, posX, posY);*/
      
      
  }
  
  
  
  public Map getMap() {
        return _map;
    }

    public int getTemperature() {
        return _temperature;
    }

    public Temps getTemps() {
        return _temps;
    }

}