package monde;

import especes.Espece;
import nourriture.Nourriture;



public class Case {
	private int posX;
	private int posY;
	private Decors decors;
	private Espece espece;
	private Nourriture nourriture;
	
        
        public Case(int posX, int posY)
        {
            this.posX = posX;
            this.posY = posY;
        }
        
	public Boolean estVide() {
  
		return espece == null && nourriture == null;
	}
        
        public String toString ( ){
            return "[Case : posX : "+posX+" , posY : "+posY+" ]";
        }
        
        public int getPosX() {
            return posX;
        }

        public int getPosY() {
            return posY;
        }

        public Decors getDecorst() {
            return decors;
        }

        public void setDecors(Decors element) {
            this.decors = element;
        }

        public Espece getEspece() {
            return espece;
        }

        public void setEspece(Espece espece) {
            this.espece = espece;
        }

        public Nourriture getNourriture() {
            return nourriture;
        }

        public void setNourriture(Nourriture nourriture) {
            this.nourriture = nourriture;
        }
}