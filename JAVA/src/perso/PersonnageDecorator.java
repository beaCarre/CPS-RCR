package perso;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public abstract class PersonnageDecorator implements PersonnageService {

	private PersonnageService delegates;
	
	protected PersonnageDecorator(PersonnageService delegates){
		this.delegates = delegates;
	}
	
	/* Observators */
	public String nom(){
		return delegates.nom();
	}
	
	public int largeur(){
		return delegates.largeur();
	}
	
	public int hauteur(){
		return delegates.hauteur();
	}
	
	public int profondeur(){
		return delegates.profondeur();
	}
	
	public int force(){
		return delegates.force();
	}
	
	public int pointsDeVie(){
		return delegates.pointsDeVie();
	}
	
	public int argent(){
		return delegates.argent();
	}
	
	public boolean estVaincu(){
		return delegates.estVaincu();
	}
	
	public boolean estEquipe(){
		return delegates.estEquipe();
	}
	
	public Object choseEquipee(){
		return delegates.choseEquipee();
	}

	public void retraitPdV(int s) throws PreconditionError, InvariantError, PostConditionError{
		delegates.retraitPdV(s);
	}


	public void depotPdV(int s) throws PreconditionError, InvariantError, PostConditionError{
		delegates.depotPdV(s);
	}

	
	public void retraitArgent(int s) throws PreconditionError, InvariantError, PostConditionError{
		delegates.retraitArgent(s);
	}
	
	public void depotArgent(int s) throws PreconditionError, InvariantError, PostConditionError{
		delegates.depotArgent(s);
	}

	public void ramasser(Object o) throws PreconditionError, InvariantError, PostConditionError{
		delegates.ramasser(o);
	}
	
	public void jeter() throws PreconditionError, InvariantError, PostConditionError{
		delegates.jeter();
	}
	
	
	public void init(String n, int l, int h, int p, int f, int v, int a){
		delegates.init(n, l, h, p, f, v, a);
	}
	

}
