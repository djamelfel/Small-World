package especes;
import java.util.Random;

public class Giraffe extends EspeceTer implements Herbivore {

	public Giraffe(Espece espece) {
		super(espece);
		// TODO Auto-generated constructor stub
	}

	public Giraffe() {
		super("Giraffe", false, false, 20, 40, 100, null, 20, Math.random()<0.5, Math.random()<0.2, false, true, 65, 25,
				2, false);
	}
}