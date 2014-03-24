package perso;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public interface PersonnageService {
	
	/* Observators */
	public String nom();
	public int largeur();
	public int hauteur();
	public int profondeur();
	public int force(); 
	public int pointsDeVie();
	public int argent();
	public boolean estVaincu();
	public boolean estEquipe();
	public Object choseEquipee();
	
	/* constructor */
	// \pre n !=""  && l%2==1 && h%2==1 && f >0 && f < p
	// \post nom.equals(n) && largeur() == l && hauteur() == h && profondeur() == p && force() == f && pointsDeVie() ==v && argent() == a
	public void init(String n, int l, int h, int p, int f, int v, int a);

	// \pre retraitPdV(s) require !estVaincu() && s > 0
	// \post pointsDeVie() ==  pointsDeVie@pre - s
	public void retraitPdV(int s) throws PreconditionError, InvariantError, PostConditionError;

	// \pre depotPdV(s) require !estVaincu() && s > 0
	// \post pointsDeVie() ==  pointsDeVie@pre + s
	public void depotPdV(int s) throws PreconditionError, InvariantError, PostConditionError;

	// \pre retraitArgent(s) require !estVaincu() && s > 0
	// \post argent() == argent@pre - s
	public void retraitArgent(int s) throws PreconditionError, InvariantError, PostConditionError;

	// \pre depotArgent(s) require !estVaincu(P) && s > 0
	// \post argent() == argent@pre + s
	public void depotArgent(int s) throws PreconditionError, InvariantError, PostConditionError;

	// \pre ramasser(chose) require !est_vaincu() && !est_equipe()
	// \post choseEquipee() == chose && est_equipe() == true
	public void ramasser(Object o) throws PreconditionError, InvariantError, PostConditionError;
	
	// \pre jeter() require !est_vaincu() && est_equipe()
	// \post estEquipe() == false
	public void jeter() throws PreconditionError, InvariantError, PostConditionError;
		
	
	/* invariants */
	// \inv estVaincu() == (pointsDeVie() <= 0)
	// \inv est_equipe() == (choseEquipee() != null)

	
}
