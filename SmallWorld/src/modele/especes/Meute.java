package modele.especes;

import modele.utils.Utils;

import java.util.ArrayList;

public class Meute {

    private Espece _leader;
    private ArrayList<Espece> _membres;
    private int _color;

    Meute(Espece espece) {
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
        _leader.setForce(_leader.getForce() + 5);
    }

    public void rejoindre(Meute meute) {
        _membres.addAll(meute.getMembres());
        _leader.setForce(_leader.getForce() + (meute.getMembres().size() * 5));
    }

    public void quitter(Espece espece) {
        _membres.remove(espece);
        _leader.setForce(_leader.getForce() - 5);
    }

    public void detruire() {
        for (int i = 0; i < _membres.size(); i++)
            _membres.get(i).setMeute(null);
        _membres.clear();
    }

    public int getColor() {
        return _color;
    }
}