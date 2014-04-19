package tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import objet.ObjetImpl;

import org.junit.Before;
import org.junit.Test;

import bloc.BlocService;
import bloc.TypeBloc;
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
	public final void initFailing1(){
		try{
		
			bloc.init(TypeBloc.VIDE, new ObjetImpl());
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	@Test
	public final void initFailing2(){
		try{
		
			bloc.init(TypeBloc.OBJET, null);
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
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
	
	@Test
	public final void retirerObjetFailing(){
		try{
			
			bloc.init(TypeBloc.VIDE, null);
			bloc.retirerObjet();
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	@Test
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
	
	@Test
	public final void poserObjetFailing(){
		try{
			
			bloc.init(TypeBloc.OBJET, new ObjetImpl());
			bloc.retirerObjet();
			fail();
		}catch(ContractError ce){
			assertTrue(true);
		}
	}
	
	
	

	@Before
	public abstract void beforeTests();
	

}
