package combat;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterService;

import java.util.Set;

import moteur.Commande;
import perso.PersonnageService;
import terrain.TerrainService;

public interface CombatService {

	public TerrainService terrain();
	public PersonnageService alex();
	public PersonnageService ryan();
	public GangsterService slick();
	public Set<GangsterService> gangsters();
	 
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public int positionX(PersonnageService p) throws PreconditionError;
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public int positionZ(PersonnageService p);
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public int positionY(PersonnageService p);
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public boolean estGele(PersonnageService p);
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public boolean estFrappe(PersonnageService p);
	
	public boolean collision(PersonnageService p1, GangsterService p2);
	
	public void gerer(Commande c1, Commande c2) throws PreconditionError, InvariantError, PostConditionError;
	
	
	public void init();

}
