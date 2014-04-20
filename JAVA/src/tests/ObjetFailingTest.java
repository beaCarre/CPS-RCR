package tests;

import objet.ObjetFailImpl;


public class ObjetFailingTest extends AbstractObjetTests {

	
	@Override
	public void beforeTests() {
		this.setObjet(new ObjetFailImpl());
	}

}
