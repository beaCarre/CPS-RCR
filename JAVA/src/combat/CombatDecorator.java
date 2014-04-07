package combat;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterService;

import java.util.Set;

import moteur.Commande;
import perso.PersonnageService;
import terrain.TerrainService;

public abstract class CombatDecorator implements CombatService {

	private CombatService combat;
	public CombatDecorator(CombatService c){
		combat = c;
	}
	@Override
	public TerrainService terrain() {
		// TODO Auto-generated method stub
		return combat.terrain();
	}
	
	@Override
	public PersonnageService alex() {
		// TODO Auto-generated method stub
		return combat.alex();
	}

	@Override
	public PersonnageService ryan() {
		// TODO Auto-generated method stub
		return combat.ryan();
	}

	@Override
	public GangsterService slick() {
		// TODO Auto-generated method stub
		return combat.slick();
	}

	@Override
	public Set<GangsterService> gangsters() {
		// TODO Auto-generated method stub
		return combat.gangsters();
	}

	@Override
	public int positionX(PersonnageService p) throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.positionX(p);
	}

	@Override
	public int positionZ(PersonnageService p) {
		// TODO Auto-generated method stub
		return combat.positionZ(p);
	}

	@Override
	public int positionY(PersonnageService p) {
		// TODO Auto-generated method stub
		return combat.positionY(p);
	}

	@Override
	public boolean estGele(PersonnageService p) {
		// TODO Auto-generated method stub
		return  combat.estGele(p);
	}

	@Override
	public boolean estFrappe(PersonnageService p) {
		// TODO Auto-generated method stub
		return combat.estFrappe(p);
	}

	@Override
	public boolean collision(PersonnageService p1, GangsterService p2) {
		// TODO Auto-generated method stub
		return combat.collision(p1, p2);
	}

	@Override
	public void gerer(Commande c1, Commande c2) throws PreconditionError, InvariantError, PostConditionError {
		// TODO Auto-generated method stub
		combat.gerer(c1, c2);
	}

	@Override
	public void init(){
		// TODO Auto-generated method stub
		combat.init();
	}

}
