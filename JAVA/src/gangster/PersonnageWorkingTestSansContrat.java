package gangster;


public class PersonnageWorkingTestSansContrat extends AbstractGangsterTests {

	
	@Override
	public void beforeTests() {
		this.setGangster(new GangsterImpl());
	}

}
