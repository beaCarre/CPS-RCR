package moteur;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import exceptions.ContractError;

public abstract class AbstractMoteurTests {
	private MoteurService moteur;

	protected AbstractMoteurTests(){
		moteur = null;
	}

	public void setMoteur(MoteurService moteur){
		this.moteur = moteur;
		
	}
	
	@Test
	public final void initWorking(){
		try{
			MoteurContract mc = new MoteurContract(moteur);
			mc.init();
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void pasJeuWorking(){
		try{
			MoteurContract mc = new MoteurContract(moteur);
			mc.init();
			mc.pasJeu(Commande.BAS, Commande.HAUT);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	

	@Before
	public abstract void beforeTests();
	

}
