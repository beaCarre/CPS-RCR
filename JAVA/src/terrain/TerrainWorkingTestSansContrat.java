package terrain;


public class TerrainWorkingTestSansContrat extends AbstractTerrainTests {

	
	@Override
	public void beforeTests() {
		this.setTerrain(new TerrainImpl());
	}

}
