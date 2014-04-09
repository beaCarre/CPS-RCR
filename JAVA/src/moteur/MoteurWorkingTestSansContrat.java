package moteur;


public class MoteurWorkingTestSansContrat extends AbstractMoteurTests {

	
	@Override
	public void beforeTests() {
		this.setMoteur(new MoteurImpl());
	}

}
