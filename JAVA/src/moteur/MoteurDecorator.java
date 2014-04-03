package moteur;

import combat.ServiceCombat;
import exceptions.InvariantError;

public class MoteurDecorator implements MoteurService {
	protected MoteurService delegates;
	
	public MoteurDecorator(MoteurService moteur){
		this.delegates = moteur;
	}

	@Override
	public boolean estFini() {
		return delegates.estFini();
	}

	@Override
	public Resultat resultatFinal() {
		return delegates.resultatFinal();
	}

	@Override
	public ServiceCombat combat() {
		return delegates.combat();
	}

	@Override
	public void init() throws InvariantError {
		delegates.init();
	}

	@Override
	public void pasJeu(Commande cR, Commande cA) throws InvariantError {
		delegates.pasJeu(cR, cA);
	}
}
