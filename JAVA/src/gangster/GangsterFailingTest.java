package gangster;


public class GangsterFailingTest extends AbstractGangsterTests {

	
	@Override
	public void beforeTests() {
		this.setGangster(new GangsterContract(new GangsterFailImpl()));
	}

}
