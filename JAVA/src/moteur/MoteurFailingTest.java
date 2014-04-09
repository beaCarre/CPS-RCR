package moteur;


public class MoteurFailingTest extends AbstractMoteurTests {

	
	@Override
	public void beforeTests() {
		this.setMoteur(new MoteurContract(new MoteurFailImpl()));
	}

}
