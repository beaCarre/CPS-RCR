package tests;

import perso.PersonnageContract;
import perso.PersonnageImpl;


public class PersonnageWorkingTest extends AbstractPersonnageTests {

	
	@Override
	public void beforeTests() {
		this.setPersonnage(new PersonnageContract(new PersonnageImpl()));
	}

}
