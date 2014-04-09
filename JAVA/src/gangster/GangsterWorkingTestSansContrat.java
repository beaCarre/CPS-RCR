package gangster;


public class GangsterWorkingTestSansContrat extends AbstractGangsterTests {

	
	@Override
	public void beforeTests() {
		this.setGangster(new GangsterImpl());
	}

}
