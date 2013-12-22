package monde;
public class Temps {

	private static long _jeux;
	private static int _journee;
	
	public static long getJeux() {
		return _jeux;
	}
	public void setJeux(int jeux) {
		_jeux = jeux;
	}
	public static int getJournee() {
		return _journee;
	}
	public void setJournee(int journee) {
		_journee = journee;
	}
}