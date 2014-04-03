package gangster;

import objet.ObjetService;
import perso.PersonnageService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public abstract class GangsterDecorator implements GangsterService {

	private GangsterService delegates;
	
	protected GangsterDecorator(GangsterService delegates){
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
	
	public boolean estEquipeObjet(){
		return delegates.estEquipeObjet();
	}
	
	public ObjetService objetEquipe(){
		return delegates.objetEquipe();
	}

	public boolean estEquipePerso(){
		return delegates.estEquipePerso();
	}
	
	public PersonnageService persoEquipe(){
		return delegates.persoEquipe();
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

	public void ramasserObjet(ObjetService o) throws PreconditionError, InvariantError, PostConditionError{
		delegates.ramasserObjet(o);
	}
	
	public void ramasserPerso(PersonnageService p) throws PreconditionError, InvariantError, PostConditionError{
		delegates.ramasserPerso(p);
	}
	
	public void jeter() throws PreconditionError, InvariantError, PostConditionError{
		delegates.jeter();
	}
	
	
	public void init(String n, int l, int h, int p, int f, int v, int a){
		delegates.init(n, l, h, p, f, v, a);
	}
	

}
