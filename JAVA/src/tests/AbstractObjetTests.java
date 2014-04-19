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
	public final void initWorking(){
		try{
		
			objet.init("fusil", 10, 0);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initFailing(){
		try{
		
			objet.init("fusil", 10, 10);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing2(){
		try{
		
			objet.init("fusil", 0, 0);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing3(){
		try{
		
			objet.init("", 10, 0);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	


	@Before
	public abstract void beforeTests();
	

}
