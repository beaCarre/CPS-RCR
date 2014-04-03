package perso;

import objet.ObjetService;
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
	public boolean estEquipeObjet();
	public boolean estEquipePerso();
	public ObjetService objetEquipe();
	public PersonnageService persoEquipe();

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

	// \pre ramasserObjet(obj) require !est_vaincu() && !estEuipeObjet() && !estEquipePerso()
	// \post objetEquipe() == objet
	public void ramasserObjet(ObjetService o) throws PreconditionError, InvariantError, PostConditionError;

	// \pre ramasserPerso(perso) require !est_vaincu() && !estEuipeObjet() && !estEquipePerso()
	// \post persoEquipe() == objet
	public void ramasserPerso(PersonnageService p) throws PreconditionError, InvariantError, PostConditionError;


	// \pre jeter() require !est_vaincu() && (estEquipeObjet() || estEquipePerso())
	// \post persoEquipe() == null && objetEquipe() == null 
	public void jeter() throws PreconditionError, InvariantError, PostConditionError;


	/* invariants */
	// \inv estVaincu() == (pointsDeVie() <= 0)
	// \inv estEquipePerso() == (persoEquipe() != null)
	// \inv estEquipeObjet() == (objetEquipe() != null)


}
