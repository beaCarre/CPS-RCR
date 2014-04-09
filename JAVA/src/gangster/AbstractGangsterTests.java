package gangster;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import objet.ObjetImpl;
import objet.ObjetService;

import org.junit.Before;
import org.junit.Test;

import exceptions.ContractError;

public abstract class AbstractGangsterTests {
	private GangsterService gangster;

	protected AbstractGangsterTests(){
		gangster = null;
	}

	public void setGangster(GangsterService perso){ // Soit on lui donne un contrat soit un perso 
		this.gangster = perso;
		
	}
	
	@Test
	public final void initWorking(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void initFailing2(){
		try{
			
			gangster.init("machin", -5, 10, 10, 10, 100);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing3(){
		try{
			
			gangster.init("machin", 10, -2, 10, 10, 100);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing4(){
		try{
			
			gangster.init("machin", 10, 10, -2, 10, 100);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing5(){
		try{
			
			gangster.init("machin", 10, 10, 10, -5, 100);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing6(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, -1);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void retraitVieWorking(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			gangster.retraitPdV(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void retraitVieFailing(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			gangster.retraitPdV(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void retraitArgentWorking(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			gangster.retraitArgent(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void retraitArgentFailing(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			gangster.retraitArgent(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}

	@Test
	public final void depotArgentWorking(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			gangster.depotArgent(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void depotArgentFailing(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			gangster.depotArgent(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void ramasserObjetWorking(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			ObjetService obj = new ObjetImpl();
			obj.init("arme", 10, 0);
			gangster.ramasserObjet(obj);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void ramasserArgentWorking(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100);
			ObjetService obj = new ObjetImpl();
			obj.init("truc", 0, 10);
			gangster.ramasserArgent(obj);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	public final void ramasserObjetFailing(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100);
			ObjetService obj = new ObjetImpl();
			gangster.retraitPdV(1000);
			gangster.ramasserObjet(obj);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void ramasserPersoWorking(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			GangsterService perso = new GangsterImpl();
			gangster.ramasserPerso(perso);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void ramasserPersoFailing(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			GangsterService perso = new GangsterImpl();
			gangster.retraitPdV(10000);
			gangster.ramasserPerso(perso);
			fail();
		}catch(ContractError ce){
			
			assertTrue(true);
		}
	}
	
	@Test
	public final void jeterWorking(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			GangsterService perso = new GangsterImpl();
			gangster.ramasserPerso(perso);
			gangster.jeter();
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void jeterFailing(){
		try{
			
			gangster.init("machin", 10, 10, 10, 10, 100, 100);
			gangster.jeter();
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	


	@Before
	public abstract void beforeTests();
	

}
