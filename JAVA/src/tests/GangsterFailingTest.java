package tests;

import gangster.GangsterContract;
import gangster.GangsterFailImpl;


public class GangsterFailingTest extends AbstractGangsterTests {

	
	@Override
	public void beforeTests() {
		this.setGangster(new GangsterContract(new GangsterFailImpl()));
	}

}
