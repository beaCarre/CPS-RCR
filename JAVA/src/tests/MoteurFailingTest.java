package tests;

import moteur.MoteurContract;
import moteur.MoteurFailImpl;


public class MoteurFailingTest extends AbstractMoteurTests {

	
	@Override
	public void beforeTests() {
		this.setMoteur(new MoteurContract(new MoteurFailImpl()));
	}

}
