package tests;

import perso.PersonnageContract;
import perso.PersonnageFailImpl;


public class PersonnageFailingTest extends AbstractPersonnageTests {

	
	@Override
	public void beforeTests() {
		this.setPersonnage(new PersonnageContract(new PersonnageFailImpl()));
	}

}
