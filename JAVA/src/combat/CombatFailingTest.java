package combat;


public class CombatFailingTest extends AbstractCombatTests {

	
	@Override
	public void beforeTests() {
		this.setCombat(new CombatContract(new CombatFailImpl()));
	}

}
