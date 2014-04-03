package terrain;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import bloc.BlocImpl;
import bloc.BlocService;
import exceptions.ContractError;

public abstract class AbstractTerrainTests {
	private TerrainService terrain;

	protected AbstractTerrainTests(){
		terrain = null;
	}

	public void setTerrain(TerrainService terrain){
		this.terrain = terrain;
		
	}
	
	@Test
	public final void initWorking(){
		try{
			TerrainContract tc = new TerrainContract(terrain);
			tc.init(10, 10, 10);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initFailing(){
		try{
			TerrainContract tc = new TerrainContract(terrain);
			tc.init(0, 0, 0);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void modifierBlocWorking(){
		try{
			TerrainContract tc = new TerrainContract(terrain);
			tc.init(10, 10, 10);
			BlocService bloc = new BlocImpl();
			tc.modifierBloc(1, 1, 1, bloc);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void modifierBlocFailing(){
		try{
			TerrainContract tc = new TerrainContract(terrain);
			tc.init(10, 10, 10);
			BlocService bloc = new BlocImpl();
			tc.modifierBloc(1, 30, 1, bloc);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	
	
	@Before
	public abstract void beforeTests();
	

}
