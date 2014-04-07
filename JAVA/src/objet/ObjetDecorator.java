package objet;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public abstract class ObjetDecorator implements ObjetService {
	private ObjetService delegates;

	protected ObjetDecorator(ObjetService delegates){
		this.delegates = delegates;
	}

	public String nom(){ 
		return delegates.nom();
	}
	public boolean estEquipable(){
		return delegates.estEquipable();
	}
	public boolean estDeValeur(){
		return delegates.estDeValeur();
	}
	public int bonusForce(){
		return delegates.bonusForce();
	}
	public int valeurMarchande(){
		return delegates.valeurMarchande();
	}

	public void init(String nom, int bonus, int valeur) throws PreconditionError, PostConditionError{
		delegates.init(nom, bonus, valeur);
	}
}
