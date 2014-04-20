package objet;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public interface ObjetService {
	/* Observators */
	public String nom();
	public boolean estEquipable();
	public boolean estDeValeur();
	public int bonusForce();
	public int valeurMarchande();
	
	/* Constructor */
	// \pre init(nom,bonus,valeur) require n!= "" && ( (bonus > 0 && valeur == 0) || ( bonus == 0 && valeur > 0)
	// \post nom.equals(nom) && bonusForce() == bonus && valeurMarchande() == valeur
	public void init(String nom, int bonus, int valeur) throws PreconditionError, InvariantError, PostConditionError;
	
	/* Invariants */
	// \inv estEquipable() == (bonusForce() > 0)
	// \inv estDeValeur() == (valeurMarchande() > 0)
	// \inv estEquipable() != estDeValeur();
	
	
	

}
