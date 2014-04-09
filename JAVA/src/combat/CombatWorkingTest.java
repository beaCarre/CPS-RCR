package combat;


public class CombatWorkingTest extends AbstractCombatTests {

	
	@Override
	public void beforeTests() {
		this.setCombat(new CombatContract(new CombatImpl()));
	}

}
