package tests;

import combat.CombatContract;
import combat.CombatImpl;


public class CombatWorkingTest extends AbstractCombatTests {

	
	@Override
	public void beforeTests() {
		this.setCombat(new CombatContract(new CombatImpl()));
	}

}
