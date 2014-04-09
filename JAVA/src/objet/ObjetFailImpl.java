package objet;

import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class ObjetFailImpl implements ObjetService {
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
			throws PreconditionError, PostConditionError {
		this.nom = nom;
		this.bonus = bonus;
		this.valeur = valeur;

	}

}
