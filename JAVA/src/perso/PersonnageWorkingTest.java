package perso;


public class PersonnageWorkingTest extends AbstractPersonnageTests {

	
	@Override
	public void beforeTests() {
		this.setPersonnage(new PersonnageImpl());
	}

}
