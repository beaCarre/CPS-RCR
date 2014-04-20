package tests;

import combat.CombatContract;
import combat.CombatFailImpl;


public class CombatFailingTest extends AbstractCombatTests {

	
	@Override
	public void beforeTests() {
		this.setCombat(new CombatContract(new CombatFailImpl()));
	}

}
