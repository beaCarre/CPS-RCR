package tests;

import combat.CombatImpl;


public class CombatWorkingTestSansContrat extends AbstractCombatTests {

	
	@Override
	public void beforeTests() {
		this.setCombat(new CombatImpl());
	}

}
