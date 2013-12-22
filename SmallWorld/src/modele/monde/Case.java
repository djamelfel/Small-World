package monde;

import especes.Espece;
import nourriture.Nourriture;



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
        }
        
	public Boolean estVide() {
  
		return _espece == null && _nourriture == null;
	}
        
        public String toString ( ){
            return "[Case : posX : " + _posX + " , posY : " + _posY +" ]";
        }
        
        public int getPosX() {
            return _posX;
        }

        public int getPosY() {
            return _posY;
        }

        public Decors getDecorst() {
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

		public void setPosX(int posX) {
			_posX = posX;
		}
		
		public void setPosY(int posY) {
			_posY = posY;
		}
}