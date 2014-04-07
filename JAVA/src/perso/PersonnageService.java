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
	// \pre n == "Alex" || n =="Ryan" && l>0 && h>0 && p>0 && f >0 && a >= 0 && v > 0 
	// \post nom.equals(n) && largeur() == l && hauteur() == h && profondeur() == p && force() == f && pointsDeVie() ==v && argent() == a
	public void init(String n, int l, int h, int p, int f, int v, int a) throws PreconditionError, InvariantError, PostConditionError;

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

	// \pre ramasserObjet(obj) require (!est_vaincu() && !estEquipeObjet() && !estEquipePerso() && obj.estEquipable()) || (obj.estDeValeur())
	// \post objetEquipe() == obj si obj.estEquipable()
	// \post objetEquipe() == null sinon
	// \post force() == force()@pre + obj.bonusForce() si obj.estEquipable()
	// \post force() == force()@pre sinon
	// \post argent() == argent()@pre + obj.valeurMarchande() si objet.estDeValeur()
	// \post argent() == argent()@pre sinon
	public void ramasserObjet(ObjetService o) throws PreconditionError, InvariantError, PostConditionError;

	// \pre ramasserPerso(perso) require !est_vaincu() && !estEuipeObjet() && !estEquipePerso()
	// \post persoEquipe() == objet
	public void ramasserPerso(PersonnageService p) throws PreconditionError, InvariantError, PostConditionError;


	// \pre jeter() require !est_vaincu() && (estEquipeObjet() || estEquipePerso())
	// \post persoEquipe() == null && objetEquipe() == null 
	// \post force() == force()@pre - objetEquipe()@pre.bonusForce() si estEquipeObjet()@pre = true
	// \post force() == force()@pre sinon
	public void jeter() throws PreconditionError, InvariantError, PostConditionError;


	/* invariants */
	// \inv estVaincu() == (pointsDeVie() <= 0)
	// \inv estEquipePerso() == (persoEquipe() != null)
	// \inv estEquipeObjet() == (objetEquipe() != null)


}
