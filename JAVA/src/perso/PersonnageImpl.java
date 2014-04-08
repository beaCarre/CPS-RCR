package perso;

import objet.ObjetService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class PersonnageImpl implements PersonnageService {

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
		if(!estVaincu() && s>0)
			vie-=s;
	}

	

	@Override
	public void retraitArgent(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		if(!estVaincu() && s>0 && argent() >=s)
			argent-=s;
	}

	@Override
	public void depotArgent(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		if(!estVaincu() && s>0)
			argent+=s;
	}

	@Override

	public void ramasserObjet(ObjetService o) throws PreconditionError,
	InvariantError, PostConditionError {
		if(!estVaincu() && !estEquipeObjet() && !estEquipePerso() && o.estEquipable()){
			force += o.bonusForce();
			objet = o;
		}
		//System.out.println(force);
	}

	@Override
	public void ramasserPerso(PersonnageService p) throws PreconditionError,
	InvariantError, PostConditionError {
		if(!estVaincu() && !estEquipeObjet() && !estEquipePerso())
			perso = p;
	}

	@Override
	public void jeter() throws PreconditionError, InvariantError,
	PostConditionError {

		if(!estVaincu() && (estEquipeObjet() || estEquipePerso())){
			if(estEquipeObjet() && objetEquipe().estEquipable()){
				force -= objetEquipe().bonusForce();
			}
			objet = null;
			perso = null;
		}
	}

	@Override
	public void ramasserArgent(ObjetService o) throws PreconditionError,
	InvariantError, PostConditionError {
		if(!estVaincu() && o.estDeValeur()){
			argent += o.valeurMarchande();
		}
	}

}
