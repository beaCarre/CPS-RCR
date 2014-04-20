package bloc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.ContractError;

public abstract class AbstractBlocTests {
	private BlocService bloc;

	protected AbstractBlocTests(){
		bloc = null;
	}

	public void setBloc(BlocService bloc){
		this.bloc = bloc;
		
	}
	
	@Test
	public final void initWorking(){
		try{
			BlocContract bc = new BlocContract(bloc);
			bc.init(TypeBloc.VIDE, TresorBloc.CHAINEDEVELO);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}


	@Before
	public abstract void beforeTests();
	

}
