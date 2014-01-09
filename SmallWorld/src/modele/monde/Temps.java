package modele.monde;

public class Temps {

    private static long _jeux;
    private static int _journee;

    public static long getJeux() {
        return _jeux;
    }


    public static void incrementer() {
        _jeux++;
    }

    public static void setJeux(int jeux) {
        _jeux = jeux;
    }

    public static int getJournee() {
        return (int) (_jeux % 100);//86400);
    }

    public void setJournee(int journee) {
        _journee = journee;
    }
}