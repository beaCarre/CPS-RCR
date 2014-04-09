package combat;

import org.junit.Before;

public abstract class AbstractCombatTests {
	private CombatService combat;

	protected AbstractCombatTests(){
		combat = null;
	}

	public void setCombat(CombatService c){ // Soit on lui donne un contrat soit un perso 
		this.combat = c;
		
	}
	
	


	@Before
	public abstract void beforeTests();
	

}
