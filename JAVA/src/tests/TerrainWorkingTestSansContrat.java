package tests;

import terrain.TerrainImpl;


public class TerrainWorkingTestSansContrat extends AbstractTerrainTests {

	
	@Override
	public void beforeTests() {
		this.setTerrain(new TerrainImpl());
	}

}
