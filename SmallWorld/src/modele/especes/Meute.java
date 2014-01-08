package modele.especes;

import java.util.ArrayList;
import modele.utils.Utils;

public class Meute {

	private Espece _leader;
	private ArrayList<Espece> _membres;
        private int _color;

	Meute(Espece espece){
		_leader = espece;
		_membres = new ArrayList();
                _color = Utils.getRand(Integer.MAX_VALUE);
	}

	public Espece getLeader() {
		return _leader;
	}
	
	public ArrayList<Espece> getMembres() {
		return _membres;
	}
	
	public void rejoindre(Espece espece) {
		_membres.add(espece);
		espece.setMeute(this);
	}
	
	public void rejoindre(Meute meute) {
		_membres.addAll( meute.getMembres() );
	}
	
	public void quitter(Espece espece) {
		_membres.remove(espece);
	}
	
	public void detruire() {
		for(int i = 0; i < _membres.size(); i++)
			_membres.get(i).setMeute(null);
		_membres.clear();
	}
        
        
        public int getColor() {
        return _color;
    }
}