package gangster;


public class PersonnageWorkingTest extends AbstractGangsterTests {

	
	@Override
	public void beforeTests() {
		this.setGangster(new GangsterContract(new GangsterImpl()));
	}

}
