package vue.observer;

/**
 * Created by Edwin on 19/12/13.
 */
public interface ObservableMonde {
    public void addObservateur(ObservableMonde obs);

    public void updateObservateur();

    public void delObservateur();
}
