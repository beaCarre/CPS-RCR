package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import terrain.TerrainService;
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
	
			terrain.init(50, 50, 50);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initFailing(){
		try{
	
			terrain.init(0, 0, 0);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void modifierBlocWorking(){
		try{
	
			terrain.init(50, 50, 50);
			BlocService bloc = new BlocImpl();
			terrain.modifierBloc(1, 1, bloc);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void modifierBlocFailing(){
		try{
	
			terrain.init(50, 50, 50);
			BlocService bloc = new BlocImpl();
			terrain.modifierBloc(1, 100, bloc);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	
	
	@Before
	public abstract void beforeTests();
	

}
