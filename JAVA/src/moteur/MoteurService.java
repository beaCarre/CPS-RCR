package moteur;

import combat.CombatService;
import exceptions.InvariantError;

public interface MoteurService {
	public boolean estFini();
	
	// \pre resultatFinal() require estFini()
	public Resultat resultatFinal();
	
	public CombatService combat();
	
	
	// \post init() : combat() == Servicecombat().init()
	public void init() throws InvariantError;
	
	// \post pasJeu(cR,cA) : combat() == Servicecombat().gerer(cA,cR);
	public void pasJeu(Commande cR, Commande cA) throws InvariantError;
	
	/* invariants 
	 *  estFini() == ( combat().alex().estVaincu() && combat().ryan().estVaincu() ) 
	 *  || combat().slick.estVaincu();
	 *  
	 *  resultatFinal() == 
	 *  	ALEXGAGNANT si !combat().alex().estVaincu() && combat().ryan().estVaincu() && combat().slick().estVaincu()
	 *  	RYANGAGNANT si 	combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu()
	 *  	LESDEUXGAGNANTS si !combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu()	
	 *  	SLICKGAGNANT si combat().alex().estVaincu() && combat().ryan().estVaincu() && !combat().slick().estVaincu()	
	 *  	NULLE sinon	
	 */
}
