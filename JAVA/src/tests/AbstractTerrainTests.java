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
	
			terrain.init(50, 100, 50);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initFailing1(){
		try{
	
			terrain.init(0, 100, 50);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing2(){
		try{
	
			terrain.init(50, 100, 0);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing3(){
		try{
	
			terrain.init(50, 10, 50);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing4(){
		try{
	
			terrain.init(60, 100, 50);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing5(){
		try{
	
			terrain.init(50, 100, 60);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void modifierBlocWorking(){
		try{
	
			terrain.init(500, 100, 500);
			BlocService bloc = new BlocImpl();
			terrain.modifierBloc(10, 10, bloc);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void modifierBlocFailing1(){
		try{
	
			terrain.init(500, 100, 500);
			BlocService bloc = new BlocImpl();
			terrain.modifierBloc(-1, 10, bloc);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void modifierBlocFailing2(){
		try{
	
			terrain.init(500, 100, 500);
			BlocService bloc = new BlocImpl();
			terrain.modifierBloc(1000, 10, bloc);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void modifierBlocFailing3(){
		try{
	
			terrain.init(500, 100, 500);
			BlocService bloc = new BlocImpl();
			terrain.modifierBloc(10, -1, bloc);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void modifierBlocFailing4(){
		try{
	
			terrain.init(500, 100, 500);
			BlocService bloc = new BlocImpl();
			terrain.modifierBloc(10, 1000, bloc);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void modifierBlocFailing5(){
		try{
	
			terrain.init(500, 100, 500);
			BlocService bloc = null;
			terrain.modifierBloc(10, 10, bloc);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	
	
	@Before
	public abstract void beforeTests();
	

}
