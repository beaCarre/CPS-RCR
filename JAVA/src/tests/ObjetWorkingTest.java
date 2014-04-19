package tests;

import objet.ObjetContract;
import objet.ObjetImpl;


public class ObjetWorkingTest extends AbstractObjetTests {

	
	@Override
	public void beforeTests() {
		this.setObjet(new ObjetContract(new ObjetImpl()));
	}

}
