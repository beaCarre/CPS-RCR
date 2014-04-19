package combat;

import moteur.Commande;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;


public class CombatContract extends CombatDecorator {

	public CombatContract(CombatService c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	

	public void gerer(Commande c1, Commande c2) throws PreconditionError, InvariantError, PostConditionError{
		super.gerer(c1, c2);
	}


}
