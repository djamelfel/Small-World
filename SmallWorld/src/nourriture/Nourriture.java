package nourriture;

import especes.Espece;


public class Nourriture {
        
        private int _posX;
	private int _posY; 
        
	private int _energieRendue;
	private Boolean _mangeable; // indique si la nourriture a deja ete mangee par un animal et doit donc etre supprimee par le Monde
        
        public Nourriture(int energieRendue)
        {
            _energieRendue = energieRendue;
            _mangeable = true;
            
            _posX = -1;
            _posY = -1;
        }

	public void seFaireManger(Espece espece) {
            _mangeable = false;
	}
	
	public void detruire() {
	}
        
        
	public String sauvegarder() {
            return sauvegarder("inconnu");
        }
	public String sauvegarder(String typeNourriture) {
            String res = 
                    "<nourriture type='"+typeNourriture+"'>"
                    + "<energie rendue='"+_energieRendue+"'/>"
                    + "<position x='"+_posX+"' y='"+_posY+"'/>"
                    + "</nourriture>";
		return res;
	}
        
        
        
        public int getPosX() {
            return _posX;
        }

        public int getPosY() {
            return _posY;
        }

        public int getEnergieRendue() {
            return _energieRendue;
        }

        public Boolean getMangeable() {
            return _mangeable;
        }
        
         public void setPosX(int _posX) {
            this._posX = _posX;
        }

        public void setPosY(int _posY) {
            this._posY = _posY;
        }

}