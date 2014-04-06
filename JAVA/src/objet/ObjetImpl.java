package objet;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class ObjetImpl implements ObjetService {
	String nom;
	int bonus, valeur;
	@Override
	public String nom() {
		
		return nom;
	}

	@Override
	public boolean estEquipable() {
		
		return (bonus>0);
	}

	@Override
	public boolean estDeValeur() {
		
		return (valeur>0);
	}

	@Override
	public int bonusForce() {
		
		return bonus;
	}

	@Override
	public int valeurMarchande() {
		
		return valeur;
	}

	@Override
	public void init(String nom, int bonus, int valeur)
			throws PreconditionError, InvariantError, PostConditionError {
		if(!nom.equals("") && ((bonus>0 && valeur == 0) || (bonus == 0 && valeur>0))){
			this.nom = nom;
			this.bonus = bonus;
			this.valeur = valeur;
		}
		

	}

}
