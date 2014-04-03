package bloc;


public class BlocWorkingTest extends AbstractBlocTests {

	@Override
	public void beforeTests() {
		/* Here we add a new target to the tester before making the tests */
		this.setBloc(new BlocImpl());
	}


}
