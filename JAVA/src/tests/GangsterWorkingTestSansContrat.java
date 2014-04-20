package tests;

import gangster.GangsterImpl;


public class GangsterWorkingTestSansContrat extends AbstractGangsterTests {

	
	@Override
	public void beforeTests() {
		this.setGangster(new GangsterImpl());
	}

}
