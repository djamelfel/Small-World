package modele.monde;

public class Temps {

    private static long jeux;
    private static int journee;

    public static long getJeux() {
        return jeux;
    }

    public void setJeux(Integer jeux) {
        this.jeux = jeux;
    }

    public static int getJournee() {
        return journee;
    }

    public void setJournee(Integer journee) {
        this.journee = journee;
    }
}