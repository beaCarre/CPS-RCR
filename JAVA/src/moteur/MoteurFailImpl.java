package moteur;

import combat.CombatService;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class MoteurFailImpl implements MoteurService {

	@Override
	public boolean estFini() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Resultat resultat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CombatService combat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int pasCourant() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void init() throws InvariantError {
		// TODO Auto-generated method stub

	}

	@Override
	public void pasJeu(Commande cR, Commande cA) throws InvariantError,
			PostConditionError, PreconditionError {
		// TODO Auto-generated method stub

	}

}
