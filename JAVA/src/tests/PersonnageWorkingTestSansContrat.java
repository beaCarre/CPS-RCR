package tests;

import perso.PersonnageImpl;


public class PersonnageWorkingTestSansContrat extends AbstractPersonnageTests {

	
	@Override
	public void beforeTests() {
		this.setPersonnage(new PersonnageImpl());
	}

}
