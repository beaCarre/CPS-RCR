package tests;

import gangster.GangsterContract;
import gangster.GangsterImpl;


public class GangsterWorkingTest extends AbstractGangsterTests {

	
	@Override
	public void beforeTests() {
		this.setGangster(new GangsterContract(new GangsterImpl()));
	}

}
