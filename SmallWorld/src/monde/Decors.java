package monde;

public class Decors {

	private int _type;
        private int _posX;
	private int _posY;        
	private int _largeur;
	private int _hauteur;
                
        public Decors(int type, int posX, int posY, int largeur, int hauteur)
        {
            this._type = type;
            this._posX = posX;
            this._posY = posY;
            this._largeur = largeur;
            this._hauteur = hauteur;
        }
        
        public String sauvegarder() {
            String res = 
                    "<elementDecors type='"+_type+"'>"
                    + "<position x='"+_posX+"' y='"+_posY+"' largeur='"+_largeur+"' hauteur='"+_hauteur+"'/>"
                    + "</elementDecors>";
		return res;
	}
	
        public int getType() {
            return _type;
        }
        public int getPosX() {
            return _posX;
        }

        public int getPosY() {
            return _posY;
        }
        public int getLargeur() {
            return _largeur;
        }

        public int getHauteur() {
            return _hauteur;
        }
	

}