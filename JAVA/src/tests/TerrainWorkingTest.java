package tests;

import terrain.TerrainContract;
import terrain.TerrainImpl;


public class TerrainWorkingTest extends AbstractTerrainTests {

	
	@Override
	public void beforeTests() {
		this.setTerrain(new TerrainContract(new TerrainImpl()));
	}

}
