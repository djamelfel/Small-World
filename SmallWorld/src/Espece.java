

public class Espece {

	private String nom;
	private Boolean nocturne;
	private Boolean sommeil;
	private int vitesse;
	private int force;
	private int energie;
	private Meute meute;
	private int vitesseCourse;
	private Boolean sexe;
	private Boolean estLeader;
	private int dateNaissance;
	private Boolean nage;
	private Boolean estVivant;
	private Case position;
	private int champVision;
	private int sens;
	private int tempIdeale;
	private int nbReproductions;
	private Boolean fuite;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getNocturne() {
		return nocturne;
	}

	public void setNocturne(Boolean nocturne) {
		this.nocturne = nocturne;
	}

	public Boolean getSommeil() {
		return sommeil;
	}

	public void setSommeil(Boolean sommeil) {
		this.sommeil = sommeil;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getEnergie() {
		return energie;
	}

	public void setEnergie(int energie) {
		this.energie = energie;
	}

	public Meute getMeute() {
		return meute;
	}

	public void setMeute(Meute meute) {
		this.meute = meute;
	}

	public int getVitesseCourse() {
		return vitesseCourse;
	}

	public void setVitesseCourse(int vitesseCourse) {
		this.vitesseCourse = vitesseCourse;
	}

	public Boolean getSexe() {
		return sexe;
	}

	public void setSexe(Boolean sexe) {
		this.sexe = sexe;
	}

	public Boolean getEstLeader() {
		return estLeader;
	}

	public void setEstLeader(Boolean estLeader) {
		this.estLeader = estLeader;
	}

	public int getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(int dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Boolean getNage() {
		return nage;
	}

	public void setNage(Boolean nage) {
		this.nage = nage;
	}

	public Boolean getEstVivant() {
		return estVivant;
	}

	public void setEstVivant(Boolean estVivant) {
		this.estVivant = estVivant;
	}

	public Case getPosition() {
		return position;
	}

	public void setPosition(Case position) {
		this.position = position;
	}

	public int getChampVision() {
		return champVision;
	}

	public void setChampVision(int champVision) {
		this.champVision = champVision;
	}

	public int getSens() {
		return sens;
	}

	public void setSens(int sens) {
		this.sens = sens;
	}

	public int getTempIdeale() {
		return tempIdeale;
	}

	public void setTempIdeale(int tempIdeale) {
		this.tempIdeale = tempIdeale;
	}

	public int getNbReproductions() {
		return nbReproductions;
	}

	public void setNbReproductions(int nbReproductions) {
		this.nbReproductions = nbReproductions;
	}

	public Boolean getFuite() {
		return fuite;
	}

	public void setFuite(Boolean fuite) {
		this.fuite = fuite;
	}
	
	public Espece(){
		
	}
	
	public Espece(Espece espece){
		this.nom=espece.nom;
		
		this.nocturne=espece.nocturne;
		this.sommeil=espece.sommeil;
		this.vitesse=espece.vitesse;
		this.force=espece.force;
		this.energie=espece.energie;
		this.meute=espece.meute;
		this.vitesseCourse=espece.vitesseCourse;
		this.sexe=espece.sexe;
		this.estLeader=espece.estLeader;
		this.dateNaissance=espece.dateNaissance;
		this.nage=espece.nage;
		this.estVivant=espece.estVivant;
		this.position=espece.position;
		this.champVision=espece.champVision;
		this.sens=espece.sens;
		this.tempIdeale=espece.tempIdeale;
		this.nbReproductions=espece.nbReproductions;
		this.fuite=espece.fuite;
	}
	
	public void verifierEtatJournee() {
	}
	
	public void chuteCapacite() {
	}
	
	public void retrouveCapacite() {
	}
	
	public void dormir() {
		setSommeil(true);
		chuteCapacite();
	}
	
	public void reveiller() {
		
	}
	
	public void tuer() {
	}
	
	public void rejoindreMeute(Meute meute) {
	}
	
	public void seDeplacer() {
	}
	
	public void fuir(Espece espece) {
	}
	
	public void appelLeader() {
	}
	
	public void chasser(Espece espece) {
	}
	
	public void seReproduire(Espece espece) {
	}
	
	public Boolean aFaim() {
		return null;
	}
	
	public void combattre(Espece espece) {
		
	}
	
	public void manger(Nourriture nour) {
	}
	
	public String sauvegarder() {
		return null;
	}
}