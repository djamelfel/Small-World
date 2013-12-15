
import monde.Monde;
import especes.Giraffe;


public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//            System.out.println("test");
//            new Monde();
            
            System.out.println("-- Espece --");
            for(int i=0; i<10 ;i++)
            	System.out.println(new Giraffe());
            System.out.println("==> Giraffe 1 <==");
            Giraffe g1 = new Giraffe();
            for(int i=0; i<7; i++) {
	            g1.verifierEtatJournee();
	            System.out.println(g1 + "==> Giraffe 2");
            }
	}
}
