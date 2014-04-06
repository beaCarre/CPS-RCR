package bloc;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import objet.ObjetImpl;

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
		
			bloc.init(TypeBloc.VIDE, null);
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	@Test
	public final void initFailing(){
		try{
		
			bloc.init(TypeBloc.VIDE, new ObjetImpl());
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	public final void retirerObjetWorking(){
		try{
			
			bloc.init(TypeBloc.OBJET, new ObjetImpl());
			bloc.retirerObjet();
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	public final void poserObjetWorking(){
		try{
			
			bloc.init(TypeBloc.VIDE, null);
			bloc.poserObjet(new ObjetImpl());
			assertTrue(true);
		}catch(ContractError ce){
			ce.printStackTrace();
			fail();
		}
	}
	
	
	

	@Before
	public abstract void beforeTests();
	

}
