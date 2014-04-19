package tests;

import static org.junit.Assert.*;
import moteur.Commande;

import org.junit.Before;
import org.junit.Test;

import combat.CombatService;
import exceptions.ContractError;

public abstract class AbstractCombatTests {
	private CombatService combat;

	protected AbstractCombatTests(){
		combat = null;
	}

	public void setCombat(CombatService c){ // Soit on lui donne un contrat soit un perso 
		this.combat = c;
		
	}
	
	@Test
	public final void gererWorking(){
		combat.init();
		try {
			combat.gerer(Commande.BAS, Commande.SAUT);
		} catch (ContractError e){
			e.printStackTrace();
			fail();
		}
	}
	
	


	@Before
	public abstract void beforeTests();
	

}
