package perso;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import objet.ObjetImpl;
import objet.ObjetService;

import org.junit.Before;
import org.junit.Test;

import exceptions.ContractError;

public abstract class AbstractPersonnageTests {
	private PersonnageService personnage;

	protected AbstractPersonnageTests(){
		personnage = null;
	}

	public void setPersonnage(PersonnageService perso){ // Soit on lui donne un contrat soit un perso 
		this.personnage = perso;
		
	}
	
	@Test
	public final void initWorking(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initFailing(){
		try{
			
			personnage.init("alex", -5, 10, 10, 10, 100, 100);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void retraitVieWorking(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.retraitPdV(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void retraitVieFailing(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.retraitPdV(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void depotVieWorking(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.depotPdV(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void depotVieFailing(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.depotPdV(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void retraitArgentWorking(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.retraitArgent(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void retraitArgentFailing(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.retraitArgent(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void depotArgentWorking(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.depotArgent(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void depotArgentFailing(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.depotArgent(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void ramasserObjetWorking(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			ObjetService obj = new ObjetImpl();
			personnage.ramasserObjet(obj);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	public final void ramasserObjetFailing(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			ObjetService obj = new ObjetImpl();
			personnage.retraitPdV(1000);
			personnage.ramasserObjet(obj);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void ramasserPersoWorking(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			PersonnageService perso = new PersonnageImpl();
			personnage.ramasserPerso(perso);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void ramasserPersoFailing(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			PersonnageService perso = new PersonnageImpl();
			personnage.retraitPdV(10000);
			personnage.ramasserPerso(perso);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void jeterWorking(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			PersonnageService perso = new PersonnageImpl();
			personnage.ramasserPerso(perso);
			personnage.jeter();
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void jeterFailing(){
		try{
			
			personnage.init("alex", 10, 10, 10, 10, 100, 100);
			personnage.jeter();
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	


	@Before
	public abstract void beforeTests();
	

}
