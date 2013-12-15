public class Case {
	public int posX;
	public int posY;
	public Decors element;
	public Espece espece;
	public Nourriture nourriture;
	
        
        public Case(int posX, int posY)
        {
            this.posX = posX;
            this.posY = posY;
        }
        
	public Boolean estVide() {
  
		return espece == null && nourriture == null;
	}
}