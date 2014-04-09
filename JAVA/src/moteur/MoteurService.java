package moteur;

import combat.CombatService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public interface MoteurService {
	public boolean estFini();
	
	// \pre resultat() require estFini()
	public Resultat resultat();
	
	public CombatService combat();
	
	public int pasCourant();
	
	// \post init() : combat() == Servicecombat().init()
	public void init() throws InvariantError;
	
	// \post pasJeu(cR,cA) : combat() == Servicecombat().gerer(cA,cR);
	// \post : pasCourant() == pasCourant()@pre + 1
	public void pasJeu(Commande cR, Commande cA) throws InvariantError, PostConditionError, PreconditionError;
	
	/* invariants 
	 *  estFini() == ( combat().alex().estVaincu() && combat().ryan().estVaincu() ) 
	 *  || combat().slick.estVaincu();
	 *  
	 *  resultat() == 
	 *  	ALEXGAGNANT si !combat().alex().estVaincu() && combat().ryan().estVaincu() && combat().slick().estVaincu()
	 *  	RYANGAGNANT si 	combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu()
	 *  	DEUXGAGNANTS si !combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu()	
	 *  	SLICKGAGNANT si combat().alex().estVaincu() && combat().ryan().estVaincu() && !combat().slick().estVaincu()	
	 *  	NULLE sinon	
	 */
}
