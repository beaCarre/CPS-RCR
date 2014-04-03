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

	public void setPersonnage(PersonnageService perso){
		this.personnage = perso;
		
	}
	
	@Test
	public final void initWorking(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initFailing(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", -5, 10, 10, 10, 100, 100);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void retraitVieWorking(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.retraitPdV(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void retraitVieFailing(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.retraitPdV(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void depotVieWorking(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.depotPdV(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void depotVieFailing(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.depotPdV(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void retraitArgentWorking(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.retraitArgent(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void retraitArgentFailing(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.retraitArgent(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void depotArgentWorking(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.depotArgent(3);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void depotArgentFailing(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.depotArgent(-5);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void ramasserObjetWorking(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			ObjetService obj = new ObjetImpl();
			pc.ramasserObjet(obj);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	public final void ramasserObjetFailing(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			ObjetService obj = new ObjetImpl();
			pc.retraitPdV(1000);
			pc.ramasserObjet(obj);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
	public final void ramasserPersoWorking(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			PersonnageService perso = new PersonnageImpl();
			pc.ramasserPerso(perso);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void ramasserPersoFailing(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			PersonnageService perso = new PersonnageImpl();
			pc.retraitPdV(10000);
			pc.ramasserPerso(perso);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void jeterWorking(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			PersonnageService perso = new PersonnageImpl();
			pc.ramasserPerso(perso);
			pc.jeter();
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void jeterFailing(){
		try{
			PersonnageContract pc = new PersonnageContract(personnage);
			pc.init("alex", 10, 10, 10, 10, 100, 100);
			pc.jeter();
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	


	@Before
	public abstract void beforeTests();
	

}
