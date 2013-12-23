package modele.especes;
import utils.Utils;
import modele.monde.Case;
import modele.monde.Monde;
import modele.monde.Temps;

public class Espece {

	private String _nom;
	private int _sommeilDeb;
	private int _sommeilFin;
	private boolean _sommeil;
	private int _vitesse;
	private int _force;
	private int _energie;
	private int _faim;
	private Meute _meute;
	private int _vitesseCourse;
	private boolean _sexe;							//false ==> femelle
	private boolean _estLeader;						//true ==> est un Leader
	private long _dateNaissance;
	private boolean _nage;							//trouver autre terme
	private boolean _estVivant;
	private Case _position;
	private int _champVision;
	private int _sens;							//0 : haut, 1 : droite, 2 : bas, 3 : gauche
	private int _tempIdeale;
	private int _nbReproductions;
	private boolean _fuite;
	private boolean _course;
	
	public String getNom() {
		return _nom;
	}
	
	public boolean setSommeil(boolean sommeil) {
		return _sommeil = sommeil;
	}
	
	public boolean getSommeil() {
		return _sommeil ;
	}
	
	public int getSommeilDeb() {
		return _sommeilDeb;
	}
	
	public int getSommeilFin() {
		return _sommeilFin;
	}

	public int getVitesse() {
		return _vitesse;
	}

	public void setVitesse(int vitesse) {
		_vitesse = vitesse;
	}

	public int getForce() {
		return _force;
	}

	public void setForce(int force) {
		_force = force;
	}

	public int getEnergie() {
		return _energie;
	}

	public void setEnergie(int energie) {
		_energie = energie;
	}
	
	public void setFaim(int faim) {
		_faim = faim;
	}
	
	public int getFaim() {
		return _faim;
	}

	public Meute getMeute() {
		return _meute;
	}

	public void setMeute(Meute meute) {
		_meute = meute;
	}

	public int getVitesseCourse() {
		return _vitesseCourse;
	}

	public void setVitesseCourse(int vitesseCourse) {
		_vitesseCourse = vitesseCourse;
	}

	public boolean getSexe() {
		return _sexe;
	}

	public boolean getEstLeader() {
		return _estLeader;
	}

	public long getDateNaissance() {
		return _dateNaissance;
	}

	public boolean getNage() {
		return _nage;
	}

	public boolean getEstVivant() {
		return _estVivant;
	}

	public void setEstVivant(Boolean estVivant) {
		_estVivant = estVivant;
	}

	public Case getPosition() {
		return _position;
	}

	public void setPosition(int posX, int posY) {
		_position.setPosX(posX);
		_position.setPosX(posX);
	}

	public int getChampVision() {
		return _champVision;
	}

	public int getSens() {
		return _sens;
	}

	public void setSens(int sens) {
		_sens = sens;
	}

	public int getTempIdeale() {
		return _tempIdeale;
	}

	public int getNbReproductions() {
		return _nbReproductions;
	}

	public void setNbReproductions(int nbReproductions) {
		_nbReproductions = nbReproductions;
	}
	
	public boolean getFuite() {
		return _fuite;
	}
	
	public void setFuite(boolean fuite) {
		_fuite = fuite;
	}
	
	public boolean getCourse() {
		return _course;
	}

	public void setCourse(Boolean course) {
		_course = course;
	}

	public Espece(){
	}
	
	public Espece(String nom, int sommeilDeb, int sommeilFin, int vitesse, int force, int vitesseCourse, boolean estLeader, boolean nage, int champVision, 
			int tempIdeale, int nbReproductions) {
		_nom = nom;
		_sommeilDeb = sommeilDeb;
		_sommeilFin = sommeilFin;
		_vitesse = vitesse;
		_force = force;
		_energie = 100;
		_faim = 100;
		_meute = null;
		_vitesseCourse = vitesseCourse;
		_sexe = Math.random()<0.5;
		if (estLeader == true)
			_meute = new Meute(this);
		_estLeader = estLeader;
		_dateNaissance = Temps.getJeux();
		_nage = nage;
		_estVivant = true;
		_champVision = champVision;
		_tempIdeale = tempIdeale;
		_nbReproductions = nbReproductions;
		_course = false;
	}
		
	public Espece(Espece espece){
		_nom = espece.getNom();
		_sommeilDeb = espece.getSommeilDeb();
		_sommeilFin = espece.getSommeilFin();
		_vitesse = espece.getVitesse();
		_force = espece.getForce();
		_energie = espece.getEnergie();
		_faim = espece.getFaim();
		_meute = espece.getMeute();
		_vitesseCourse = espece.getVitesseCourse();
		_sexe = espece.getSexe();
		_estLeader = espece.getEstLeader();
		_dateNaissance = espece.getDateNaissance();
		_nage = espece.getNage();
		_estVivant = espece.getEstVivant();
		_position = espece.getPosition();
		_champVision = espece.getChampVision();
		_sens = espece.getSens();
		_tempIdeale = espece.getTempIdeale();
		_nbReproductions = espece.getNbReproductions();
		_course = espece.getCourse();
	}
	
	public void verifierEtatJournee() {
		if ( Temps.getJournee() > _sommeilDeb && Temps.getJournee() < _sommeilFin ){
			if(getSommeil() == true)
				reveiller();
			activite();
		}	
		else
			if (getSommeil() == true)
				dormir();
	}
	
	public void chuteCapacite() {	}
	
	public void retrouveCapacite() {	}
	
	public void dormir() {
		setSommeil(true);
		setEnergie(100);
		chuteCapacite();
	}
	
	public void reveiller() {
		retrouveCapacite();
		setSommeil(false);
	}
	
	public void tuer() {
		if (_estLeader == true)
			_meute.detruire();
		else if (_meute != null)
			_meute.quitter(this);
		setEstVivant(false);
		//==> new Cadavre
	}
	
	public void rejoindreMeute(Meute meute) {
		setMeute(meute);
		_meute.rejoindre(this);
	}
	
	public void appelLeader() {
		_meute.getLeader().seDeplacer(_position.getPosX(), _position.getPosY() );
	}
	
	public void chasser(Espece espece) {
		seDeplacer(espece.getPosition().getPosX(), espece.getPosition().getPosY() );
	}
	
	public void seReproduire(Espece espece) {				//pas besoin d'argument
		_nbReproductions -= 1;
		if (_sexe == false){
			//Création d'un Giraffe
		}
	}
	
	public boolean aFaim() {
		return _energie < 20;
	}
	
	public void manger() {
		if (_position.getNourriture() != null ){
			if ( _position.getNourriture().getEnergieRendue() + _energie > 100)
				setEnergie(100);					//energie maximum 100
			else
				setEnergie(_position.getNourriture().getEnergieRendue() + _energie);
			_position.getNourriture().seFaireManger(this);
		}
	}
	
	public void combattre(Espece espece) {
		if (_force < espece.getForce() ){				//perd
			if (_estLeader)						//si leader et de la meme espece
				if (espece.getEstLeader() && this.getClass().getName().equals(espece.getClass().getName()) )			//si adversaire leader
					espece.getMeute().rejoindre(_meute);	//legue sa meute
				else						//sinon
					_meute.detruire();			//dissout la meute
		}
		else{								//gagne
			if (_estLeader)						//si leader
				if (espece.getEstLeader())			//si adversaire est leader
					_meute.rejoindre(espece.getMeute());	//récupere sa meute
			setEnergie( (_force - espece.getForce() ) / 2);
			setFaim(_force - espece.getForce() );
			espece.tuer();
		}
	}
	
	public void activite(){
		if (Temps.getJeux() % 20 == 0) {				//temps à comfirmer
			setEnergie(_energie - 5);				//baisse d'énergie à confimer
			setFaim(_faim - 20);					//baisse de faim à confirmer
		}
		if(getEnergie() <= 0)
			tuer();
		seDeplacer();
	}

	public void sens(int x, int y) {
		if (Utils.getRand(1) == 1) {					//gestion du sens
			if ( _position.getPosX() < x )
				_sens = 1;
			else
				_sens = 3;
		}
		else {
			if ( _position.getPosY() < y )
				_sens = 0;
			else
				_sens = 2;
		}
	}
		
	public void seDeplacer(int posX, int posY) {
		int x, y, vitesse = _vitesse;
		
		if (_course == true)						//definie le nombre de case dont il peut se deplacer
			vitesse += _vitesseCourse;

//Gestion point X	
		if (Math.abs(posX - _position.getPosX()) < vitesse)		//permet de ne pas depasser le point X
			x = Math.abs(posX - _position.getPosX());
		else
			x = vitesse;
		
		if (x > _position.getPosX())		//choisi aleatoirement un nombre compris dans son champ de deplacement
			x = Utils.getRand(x, _position.getPosX());
		else
			x = Utils.getRand(_position.getPosX(), x);
		
		vitesse -= x;							//soustrait le deplacement x a deplacer

//Gestion point Y			
		if (Math.abs(posY - _position.getPosY()) < vitesse)
			y = Math.abs(posY - _position.getPosY());
		else
			y = vitesse;
		if (y > _position.getPosX())
			y = Utils.getRand(y, _position.getPosX());
		else
			y = Utils.getRand(_position.getPosX(), y);
		
		sens(x,y);
		
		_position.setPosX(x);
		_position.setPosY(y);
	}
	
	public void seDeplacer() {
		int x = 0, y = 0, vitesse = _vitesse;
		int hauteur = 0, largeur;
		
		if(_meute == null || _estLeader) {				//definition du périmetre de deplacement
			largeur = Monde.getMap().getLargeur();
			hauteur = Monde.getMap().getHauteur();
		}
		else {
			
			largeur = 35;
			hauteur = 35;
		}
					//deplacement aleatoire	
	//Gestion point X
			if ( (_position.getPosX() + vitesse) > largeur ) {		//sorti tableau droite
				x = largeur - _position.getPosX();
				x = Utils.getRand(x, vitesse);
			}
			else if ( (_position.getPosX() - vitesse) < 0) {
				x = Utils.getRand(_position.getPosX(), 0);
			}

			vitesse -= x;						//soustrait le deplacement x a deplacer

	//Gestion point Y
			if ( (_position.getPosY() + vitesse) > hauteur ) {		//sorti tableau droite
				y = hauteur - _position.getPosY();
				y = Utils.getRand(y, vitesse);
			}
			else if ( (_position.getPosY() - vitesse) < 0) {
				y = Utils.getRand(_position.getPosY(), 0);
			}
		sens(x,y);							//gestion du sens du regard des especes
		
		_position.setPosX(x);
		_position.setPosY(y);
	}
	
	public void fuir(Espece espece) {
		//s'eloigner de l'espece en question 
	}
	
	@Override
	public String toString() {
		return "sexe - date - " + _sexe + _dateNaissance;
	}
	
	public String sauvegarder() {
		return null;
	}
}