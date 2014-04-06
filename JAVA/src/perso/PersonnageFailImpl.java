package perso;

import objet.ObjetService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class PersonnageFailImpl implements PersonnageService {

	String nom;
	int largeur,hauteur,profondeur,force,argent,vie;
	ObjetService objet;
	PersonnageService perso;

	@Override
	public String nom() {

		return nom;
	}

	@Override
	public int largeur() {

		return largeur;
	}

	@Override
	public int hauteur() {

		return hauteur;
	}

	@Override
	public int profondeur() {

		return profondeur;
	}

	@Override
	public int force() {

		return force;
	}

	@Override
	public int pointsDeVie() {

		return vie;
	}

	@Override
	public int argent() {

		return argent;
	}

	@Override
	public boolean estVaincu() {

		return (vie<=0);
	}

	@Override
	public boolean estEquipeObjet() {

		return (objetEquipe()!=null);
	}

	@Override
	public boolean estEquipePerso() {

		return (persoEquipe()!=null);
	}

	@Override
	public ObjetService objetEquipe() {

		return objet;
	}

	@Override
	public PersonnageService persoEquipe() {

		return perso;
	}

	@Override
	public void init(String n, int l, int h, int p, int f, int v, int a)
			throws PreconditionError, InvariantError, PostConditionError {
		nom = n;
		largeur = l;
		hauteur = h;
		profondeur = p;
		force = f;
		vie = v; 
		argent = a;

	}

	@Override
	public void retraitPdV(int s) throws PreconditionError, InvariantError,
	PostConditionError {

		vie-=s;
	}

	@Override
	public void depotPdV(int s) throws PreconditionError, InvariantError,
	PostConditionError {

		vie+=s;
	}

	@Override
	public void retraitArgent(int s) throws PreconditionError, InvariantError,
	PostConditionError {

		argent-=s;
	}

	@Override
	public void depotArgent(int s) throws PreconditionError, InvariantError,
	PostConditionError {

		argent+=s;
	}

	@Override
	public void ramasserObjet(ObjetService o) throws PreconditionError,
	InvariantError, PostConditionError {

		objet = o;
	}

	@Override
	public void ramasserPerso(PersonnageService p) throws PreconditionError,
	InvariantError, PostConditionError {

		perso = p;
	}

	@Override
	public void jeter() throws PreconditionError, InvariantError,
	PostConditionError {

		objet = null;
		perso = null;

	}

}
