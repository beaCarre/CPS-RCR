package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import objet.ObjetService;

import org.junit.Before;
import org.junit.Test;

import exceptions.ContractError;

public abstract class AbstractObjetTests {
	private ObjetService objet;

	protected AbstractObjetTests(){
		objet = null;
	}

	public void setObjet(ObjetService objet){
		this.objet = objet;
		
	}
	
	@Test
	public final void initWorking1(){
		try{
		
			objet.init("machin", 10, 0);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initWorking2(){
		try{
		
			objet.init("machin", 0, 10);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initFailing1(){
		try{
		
			objet.init("", 0, 10);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing2(){
		try{
		
			objet.init("machin", 10, 10);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing3(){
		try{
		
			objet.init("machin", -1, 0);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing4(){
		try{
		
			objet.init("", 0, -1);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	


	@Before
	public abstract void beforeTests();
	

}
