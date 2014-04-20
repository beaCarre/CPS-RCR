package moteur;

import combat.CombatService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public abstract class MoteurDecorator implements MoteurService {
	protected MoteurService delegates;
	
	public MoteurDecorator(MoteurService moteur){
		this.delegates = moteur;
	}

	@Override
	public boolean estFini() {
		return delegates.estFini();
	}

	@Override
	public Resultat resultat() {
		return delegates.resultat();
	}

	@Override
	public CombatService combat() {
		return delegates.combat();
	}

	@Override
	public void init() throws InvariantError {
		delegates.init();
	}

	@Override
	public void pasJeu(Commande cR, Commande cA) throws InvariantError, PostConditionError, PreconditionError {
		delegates.pasJeu(cR, cA);
	}

	@Override
	public int pasCourant() {
		// TODO Auto-generated method stub
		return delegates.pasCourant();
	}
}
