package modele.nourriture;
import modele.especes.Espece;
import modele.monde.Case;
import org.jdom2.Element;
import vue.enums.NourrituresEnum;

public class Nourriture {
        
    private Case _position;
    private int _energieRendue;
    private Boolean _mangeable; // indique si la nourriture a deja ete mangee par un animal et doit donc etre supprimee par le Monde
        
        
    private NourrituresEnum _graphics; // contient les graphismes
	
    public Nourriture(int energieRendue, Case position) {
        _energieRendue = energieRendue;
        _mangeable = true;
		_position = position;
    }

	public void seFaireManger() {
            _mangeable = false;
	}
	
	public void detruire() {
	}
	
	public Element sauvegarder() {
		return null;
	}
	
	public boolean getMangeable() {
			return _mangeable;
	}
	
	public void setMangeable(boolean mangeable) {
			_mangeable = mangeable;
                        
                 System.out.println("mangeable : "+mangeable);
	}
        
    public Case getPosition() {
        return _position;
    }

    public int getEnergieRendue() {
        return _energieRendue;
    }
    
     public void setPosition(Case position) {
        _position = position;
    }
    
    public void setGraphics(NourrituresEnum nourriture) {
        _graphics = nourriture;
    }
    
    public NourrituresEnum getGraphics() {
        return _graphics;
    }

}