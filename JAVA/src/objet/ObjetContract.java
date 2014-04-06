package objet;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class ObjetContract extends ObjetDecorator {

	protected ObjetContract(ObjetService delegates) {
		super(delegates);
		// TODO Auto-generated constructor stub
	}
	
	public void checkInvariants() throws InvariantError{
		// \inv estEquipable() == (bonusForce() > 0)
		if(!(estEquipable() == bonusForce() > 0)) throw new InvariantError("estEquipable");
		// \inv estDeValeur() == (valeurMarchande() > 0)
		if(!(estDeValeur() == valeurMarchande() > 0)) throw new InvariantError("estDeValeur");
		// \inv estEquipable() != estDeValeur();
		if(estEquipable() == estDeValeur()) throw new InvariantError("estEquipable != estDeValeur");
	}
	
	public void init(String nom, int bonus, int valeur) throws PreconditionError, InvariantError, PostConditionError{
		// \pre init(nom,bonus,valeur) require nom!= "" && ( (bonus > 0 && valeur == 0) || ( bonus == 0 && valeur > 0)
		if(!(!nom.equals("") && (( bonus > 0 && valeur == 0 ) || bonus == 0 && valeur > 0)))
			throw new PreconditionError("init");
		//checkInvariants();
		super.init(nom, bonus, valeur);
		checkInvariants();
		// \post nom.equals(n) && bonusForce() == bonus && valeurMarchande() == valeur
		if(!(nom.equals(nom) & bonusForce() == bonus && valeurMarchande() == valeur)) 
			throw new PostConditionError("init Objet");
	}

	
}
