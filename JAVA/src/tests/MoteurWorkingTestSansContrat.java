package tests;

import moteur.MoteurImpl;


public class MoteurWorkingTestSansContrat extends AbstractMoteurTests {

	
	@Override
	public void beforeTests() {
		this.setMoteur(new MoteurImpl());
	}

}
