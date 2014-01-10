package modele.monde;

import modele.especes.Espece;
import modele.nourriture.Nourriture;
import org.jdom2.Element;
import vue.enums.Decor;



public class Case {
	private int _posX;
	private int _posY;
	private Decors _decors;
	private Espece _espece;
	private Nourriture _nourriture;
        
	
        
        public Case(int posX, int posY)
        {
            _posX = posX;
            _posY = posY;
			_espece = null;
			_nourriture = null;
			_decors = new Decors(posX, posY);
        }
        
	public Boolean estVide() {
  
		return _espece == null && _nourriture == null;
	}
        
        public String toString ( ){
            if(_nourriture != null)
                return _nourriture.getGraphics().getNom()+" : x: " + _posX + " , y: " + _posY +"";
            return "Case : x: " + _posX + " , y: " + _posY +"";
        }
        
        public Element sauvegarder(){
			Element decors = new Element("Decors");

			decors.setAttribute("Decors", ""+_decors.getGraphics().getNom());
			decors.setAttribute("posX",""+_posX);
			decors.setAttribute("posY",""+_posY);

			return decors;
		}
        
        public int getPosX() {
            return _posX;
        }

        public int getPosY() {
            return _posY;
        }

        public Decors getDecors() {
            return _decors;
        }

        public void setDecors(Decors element) {
            _decors = element;
        }

        public Espece getEspece() {
            return _espece;
        }

        public void setEspece(Espece espece) {
            _espece = espece;
        }

        public Nourriture getNourriture() {
            return _nourriture;
        }

        public void setNourriture(Nourriture nourriture) {
            _nourriture = nourriture;
        }
}