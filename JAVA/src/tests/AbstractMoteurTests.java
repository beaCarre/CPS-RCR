package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import moteur.Commande;
import moteur.MoteurService;

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
			
			moteur.init();
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	@Test
	public final void pasJeuWorking(){
		try{
			
			moteur.init();
			moteur.pasJeu(Commande.BAS, Commande.HAUT);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	

	@Before
	public abstract void beforeTests();
	

}
