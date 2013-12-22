package especes;
import java.util.ArrayList;
import utils.Utils;
import monde.Case;
import monde.Monde;
import monde.Temps;

public class Espece {

	private String _nom;
	private int _sommeilDeb;
	private int _sommeilFin;
	private int _vitesse;
	private int _force;
	private int _energie;
	private int _faim;
	private Meute _meute;
	private int _vitesseCourse;
	private Boolean _sexe;	//false ==> femelle
	private Boolean _estLeader;		//true ==> est un Leader
	private long _dateNaissance;
	private Boolean _nage;			//trouver autre terme
	private Boolean _estVivant;
	private Case _position;
	private int _champVision;
	private int _sens;
	private int _tempIdeale;
	private int _nbReproductions;
	private Boolean _fuite;
	private Boolean _course;
	
	public String getNom() {
		return _nom;
	}
	
	//(Temps.getJournee() > _sommeilDeb && Temps.getJournee() < _sommeilFin)
	public Boolean getSommeil() {
		return (Temps.getJournee() > _sommeilDeb && Temps.getJournee() < _sommeilFin) ;
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

	public Boolean getSexe() {
		return _sexe;
	}

	public Boolean getEstLeader() {
		return _estLeader;
	}

	public long getDateNaissance() {
		return _dateNaissance;
	}

	public Boolean getNage() {
		return _nage;
	}

	public Boolean getEstVivant() {
		return _estVivant;
	}

	public void setEstVivant(Boolean estVivant) {
		_estVivant = estVivant;
	}

	public Case getPosition() {
		return _position;
	}

	public void setPosition(Case position) {
		_position = position;
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

	public Boolean getCourse() {
		return _course;
	}

	public void setCourse(Boolean course) {
		_course = course;
	}

	public Espece(){
	}
	
	public Espece(String nom, int sommeilDeb, int sommeilFin, int vitesse, int force, int vitesseCourse, Boolean estLeader, Boolean nage, int champVision, 
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
			_meute = new Meute();
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
		if ( getSommeil() ){
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
		setEnergie(100);
		chuteCapacite();
	}
	
	public void reveiller() {
		retrouveCapacite();
	}
	
	public void tuer() {
		if (_estLeader == true)
			_meute.detruire();
		setEstVivant(false);
		//new Cadavre
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
	
	public void seReproduire(Espece espece) {		//pas besoin d'argument
		setNbReproductions(_nbReproductions - 1);
		if (_sexe == false){
			//Création d'un Giraffe
		}
	}
	
	public Boolean aFaim() {
		if (_energie < 20)	//toute espece à faim avec une energie de -20
			return true;
		return false;
	}
	
	public void manger() {
		if (_position.getNourriture().getEnergieRendue() + _energie > 100)
			setEnergie(100);							//energie maximum 100
		else
			setEnergie(_position.getNourriture().getEnergieRendue() + _energie);
		_position.getNourriture().seFaireManger(this);
	}
	
	public void combattre(Espece espece) {
		if (_force < espece.getForce() ){	//perd
			if (_estLeader)						//si leader
				if (espece.getEstLeader())			//si adversaire leader
					espece.getMeute().rejoindre(_meute);	//legue sa meute
				else								//sinon
					_meute.detruire();						//dissout la meute
			tuer();
		}
		else{								//gagne
			if (_estLeader)						//si leader
				if (espece.getEstLeader())			//si adversaire est leader
					_meute.rejoindre(espece.getMeute());	//récupere sa meute
			setEnergie( (_force - espece.getForce() ) / 2);
			setFaim(_force - espece.getForce() );
		}
	}
	
	public void activite(){
		if (Temps.getJeux() % 20 == 0) {		//temps à comfirmer
			setEnergie(_energie - 5);			//baisse d'énergie à confimer
			setFaim(_faim - 20);				//baisse de faim à confirmer
		}
		if(getEnergie() <= 0)
			tuer();
		seDeplacer();
	}
	
	public void seDeplacer(int posX, int posY) {
		int x = 0, y = 0, deplacer = _vitesse;
		
		if (_course == true)				//definie le nombre de case dont il peut se deplacer
			deplacer += _vitesseCourse;

//Gestion point X	
		if (Math.abs(posX - _position.getPosX()) < deplacer)	//permet de ne pas depasser le point X
			x = Math.abs(posX - _position.getPosX());
		else
			x = deplacer;
		
		if (x > _position.getPosX())		//choisi aleatoirement un nombre compris dans son champ de deplacement
			x = Utils.getRand(x, _position.getPosX());
		else
			x = Utils.getRand(_position.getPosX(), x);
		
		deplacer -= x;		//soustrait le deplacement x a deplacer

//Gestion point Y			
		if (Math.abs(posY - _position.getPosY()) < deplacer)
			y = Math.abs(posY - _position.getPosY());
		else
			y = deplacer;
		if (y > _position.getPosX())
			y = Utils.getRand(y, _position.getPosX());
		else
			y = Utils.getRand(_position.getPosX(), y);
		
		_position.setPosX(x);
		_position.setPosY(y);
	}
	
	public void seDeplacer() {
		//deplacement aleatoire
		int x = 0, y = 0, deplacer = _vitesse;

//Gestion point X
		if ( (_position.getPosX() + deplacer) > Monde.getMap().getLargeur() ) {		//sorti tableau droite
			x = Monde.getMap().getLargeur() - _position.getPosX();
			x = Utils.getRand(x, deplacer);
		}
		if ( (_position.getPosX() - deplacer) < 0) {								//sorti tableau gauche
			x = deplacer - _position.getPosX();
			x = Utils.getRand(deplacer, 0);
		}

		deplacer -= x;		//soustrait le deplacement x a deplacer

		_position.setPosX(x);
		_position.setPosY(y);
	}
	
	public void fuir(Espece espece) {
		//s'eloigner de l'espece en question 
	}
	
	public String toString() {
		return "sexe - date - " + _sexe + _dateNaissance;
	}
	
	public String sauvegarder() {
		return null;
	}
}