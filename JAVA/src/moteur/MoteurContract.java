package moteur;

import exceptions.InvariantError;

public class MoteurContract extends MoteurDecorator {

	public MoteurContract(MoteurService moteur) {
		super(moteur);

	}



	public void checkInvariants() throws InvariantError{
		// estFini() == ( combat().alex().estVaincu() && combat().ryan().estVaincu() ) || combat().slick.estVaincu();
		
		if( !(estFini() == ( combat().alex().estVaincu() && combat().ryan().estVaincu()) && combat().slick().estVaincu())){
			throw new InvariantError("estFini()");
		}

	}


	public void init() throws InvariantError{
		checkInvariants();
		super.init();
		checkInvariants();

	}

	public void pasJeu(Commande cR, Commande cA) throws InvariantError{
		checkInvariants();
		super.pasJeu(cR, cA);
		checkInvariants();
	}


}
