package tests;

import moteur.MoteurContract;
import moteur.MoteurImpl;


public class MoteurWorkingTest extends AbstractMoteurTests {

	
	@Override
	public void beforeTests() {
		this.setMoteur(new MoteurContract(new MoteurImpl()));
	}

}
