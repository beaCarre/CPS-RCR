package gangster;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import perso.PersonnageService;

public interface GangsterService extends PersonnageService {
	/* constructor */
	// \pre n!=0 && l>0 && h>0 && p>0 && f >0 && v > 0 
	// \post nom.equals(n) && largeur() == l && hauteur() == h && profondeur() == p && force() == f && pointsDeVie() ==v && argent() == a
	public void init(String n, int l, int h, int p, int f, int v) throws PreconditionError, InvariantError, PostConditionError;


}
