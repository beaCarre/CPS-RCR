package gangster;


public class GangsterWorkingTest extends AbstractGangsterTests {

	
	@Override
	public void beforeTests() {
		this.setGangster(new GangsterContract(new GangsterImpl()));
	}

}
