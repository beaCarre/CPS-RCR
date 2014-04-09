package moteur;

import combat.CombatImpl;
import combat.CombatService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class MoteurImpl implements MoteurService {

	CombatService combat;
	int pasCourant;
	
	
	@Override
	public boolean estFini() {
		// TODO Auto-generated method stub
		return (combat().alex().estVaincu() && combat().ryan().estVaincu() ) || combat().slick().estVaincu();
	}

	@Override
	public Resultat resultat() {
		// TODO Auto-generated method stub
		Resultat r;
		if(!combat().alex().estVaincu() && combat().ryan().estVaincu() && combat().slick().estVaincu())
			r = Resultat.ALEXGAGNANT;
		else if(combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu())
			r = Resultat.RYANGAGNANT;
		else if(!combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu())
			r = Resultat.DEUXGAGNANTS;
		else if(!combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu())
			r = Resultat.SLICKGAGNANT;
		else
			r = Resultat.NULLE;
		return r;
	}

	@Override
	public CombatService combat() {
		// TODO Auto-generated method stub
		return combat;
	}

	@Override
	public int pasCourant() {
		// TODO Auto-generated method stub
		return pasCourant;
	}

	@Override
	public void init() throws InvariantError {
		combat = new CombatImpl();
		combat.init();
		pasCourant = 0;
	}

	@Override
	public void pasJeu(Commande cR, Commande cA) throws InvariantError,
			PostConditionError, PreconditionError {
		combat.gerer(cR, cA);
		pasCourant++;

	}

}
