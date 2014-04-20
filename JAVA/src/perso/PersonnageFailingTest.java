package perso;


public class PersonnageFailingTest extends AbstractPersonnageTests {

	
	@Override
	public void beforeTests() {
		this.setPersonnage(new PersonnageFailImpl());
	}

}
