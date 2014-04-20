package tests;

import objet.ObjetImpl;


public class ObjetWorkingTestSansContrat extends AbstractObjetTests {

	
	@Override
	public void beforeTests() {
		this.setObjet(new ObjetImpl());
	}

}
