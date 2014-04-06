package objet;


public class ObjetWorkingTest extends AbstractObjetTests {

	
	@Override
	public void beforeTests() {
		this.setObjet(new ObjetContract(new ObjetImpl()));
	}

}
