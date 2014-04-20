package moteur;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class MoteurContract extends MoteurDecorator {

	public MoteurContract(MoteurService moteur) {
		super(moteur);

	}



	public void checkInvariants() throws InvariantError{
		// estFini() == ( combat().alex().estVaincu() && combat().ryan().estVaincu() ) || combat().slick.estVaincu();

		if( !(estFini() == ( combat().alex().estVaincu() && combat().ryan().estVaincu()) || combat().slick().estVaincu())){
			throw new InvariantError("estFini()");
		}

		/*  resultat() == 
		 *  	ALEXGAGNANT si !combat().alex().estVaincu() && combat().ryan().estVaincu() && combat().slick().estVaincu()
		 *  	RYANGAGNANT si 	combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu()
		 *  	DEUXGAGNANTS si !combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu()	
		 *  	SLICKGAGNANT si combat().alex().estVaincu() && combat().ryan().estVaincu() && !combat().slick().estVaincu()	
		 *  	NULLE sinon	
		 */
		
		if(!combat().alex().estVaincu() && combat().ryan().estVaincu() && combat().slick().estVaincu() && resultat()!=Resultat.ALEXGAGNANT)
			throw new InvariantError("resultat");
		else if(combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu() && resultat()!=Resultat.RYANGAGNANT)
			throw new InvariantError("resultat");
		else if(!combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu() && resultat()!=Resultat.DEUXGAGNANTS)
			throw new InvariantError("resultat");
		else if(!combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu() && resultat()!=Resultat.SLICKGAGNANT)
			throw new InvariantError("resultat");
		else if(resultat()!= Resultat.NULLE)
			throw new InvariantError("resultat");

	}

	// \post init() : combat() == Servicecombat().init()
	public void init() throws InvariantError{
		
		super.init();
		checkInvariants();

	}

	// \post pasJeu(cR,cA) : combat() == Servicecombat().gerer(cA,cR);
	// \post : pasCourant() == pasCourant()@pre + 1
	public void pasJeu(Commande cR, Commande cA) throws InvariantError, PostConditionError, PreconditionError{
		checkInvariants();
		int pasCourant_at_pre = pasCourant();
		super.pasJeu(cR, cA);
		checkInvariants();
		if(pasCourant()!= pasCourant_at_pre + 1) throw new PostConditionError("pasJeu");
	}


}
