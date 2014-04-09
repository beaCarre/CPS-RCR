package combat;

import java.util.List;

import moteur.Commande;
import perso.PersonnageService;
import terrain.TerrainService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterService;

public class CombatFailImpl implements CombatService {

	@Override
	public TerrainService terrain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnageService alex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnageService ryan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GangsterService slick() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GangsterService> gangsters() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int posX(PersonnageService p) throws PreconditionError {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int posZ(PersonnageService p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int posY(PersonnageService p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean estGele(PersonnageService p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estFrappe(PersonnageService p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estVisible(PersonnageService p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande actionGangster(GangsterService g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean collisionGauche(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collisionDroite(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collisionDessous(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collisionDessus(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collisionDevant(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collisionDerriere(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collision(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void gerer(Commande c1, Commande c2) throws PreconditionError,
			InvariantError, PostConditionError {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
