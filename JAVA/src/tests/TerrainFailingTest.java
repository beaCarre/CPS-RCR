package tests;

import terrain.TerrainFailImpl;


public class TerrainFailingTest extends AbstractTerrainTests {

	
	@Override
	public void beforeTests() {
		this.setTerrain(new TerrainFailImpl());
	}

}
