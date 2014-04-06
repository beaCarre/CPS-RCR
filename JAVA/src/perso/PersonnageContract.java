package perso;

import objet.ObjetService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class PersonnageContract extends PersonnageDecorator {

	protected PersonnageContract(PersonnageService delegates) {
		super(delegates);
		// TODO Auto-generated constructor stub
	}

	public void checkInvariants() throws InvariantError{
		// \inv : estVaincu() == (pointsDeVie() <= 0)
		if( !(estVaincu() == (pointsDeVie()<=0))){
			throw new InvariantError("estVaincu()");
		}
		// \inv estEquipePerso() == (persoEquipe() != null)

		if( !(estEquipePerso() == (persoEquipe() != null)) ){
			throw new InvariantError("estEquipePerso()");
		}

		// \inv estEquipeObjet() == (objetEquipe() != null)
		if( !(estEquipeObjet() == (objetEquipe() != null)) ){
			throw new InvariantError("estEquipeObjet()");
		}
	}

	// \pre n !=""  && l>0 && h>0 && p>0 && f >0 && a >= 0 && v > 0 
	// \post nom.equals(n) && largeur() == l && hauteur() == h && profondeur() == p && force() == f && pointsDeVie() ==v && argent() == a
	public void init(String n, int l, int h, int p, int f, int v, int a) throws PreconditionError, InvariantError, PostConditionError{
		if( ! (!n.equals("") && l>0 && h>0 && p>0 && f>0 && v>0 && a>=0 ))
			throw new PreconditionError("init(): Personnage");
		checkInvariants();
		super.init(n, l, h, p, f, v, a);
		checkInvariants();
		
		if(!(nom().equals(n) && largeur() == l && hauteur() ==h && profondeur() == p && force()==f && pointsDeVie() == v && argent()==a)) throw new PostConditionError("init(): Personnage");
		
	}




	public void depotPdV(int s) throws PreconditionError, InvariantError, PostConditionError{
		// \pre depotPdV(s) require !estVaincu() && s > 0
		if(estVaincu() || s <= 0) 
			throw new PreconditionError("depotPdV");
		checkInvariants();
		int pointsDeVie_at_pre = pointsDeVie();
		super.depotPdV(s);
		checkInvariants();
		// \post pointsDeVie() ==  pointsDeVie@pre + s
		if(!(pointsDeVie() == pointsDeVie_at_pre + s)) throw new PostConditionError("depotPdV");
	}

	public void retraitPdV(int s) throws PreconditionError, InvariantError, PostConditionError{
		// \pre retraitPdV(s) require !estVaincu() && s > 0
		if(estVaincu() || s <= 0) 
			throw new PreconditionError("retraitPdV");
		checkInvariants();
		int pointsDeVie_at_pre = pointsDeVie();
		super.retraitPdV(s);
		checkInvariants();
		// \post pointsDeVie() ==  pointsDeVie@pre - s
		
		if(!(pointsDeVie() == pointsDeVie_at_pre - s)) throw new PostConditionError("retraitPdV");
	}



	public void retraitArgent(int s) throws PreconditionError, InvariantError, PostConditionError{
		// \pre retraitArgent(s) require !estVaincu() && s > 0
		if(estVaincu() || s <=0) throw new PreconditionError("retraitArgent");
		checkInvariants();
		int argent_at_pre = argent();
		super.retraitArgent(s);
		checkInvariants();
		// \post argent() == argent@pre - s
		if(!(argent() == argent_at_pre - s)) throw new PostConditionError("retraitArgent");
	}

	public void depotArgent(int s) throws PreconditionError, InvariantError, PostConditionError{
		// \pre depotArgent(s) require !estVaincu() && s > 0 && argent() >= s
		if(estVaincu() || s <=0 || argent() < s ) throw new PreconditionError("depotArgent");
		checkInvariants();
		int argent_at_pre = argent();
		super.depotArgent(s);
		checkInvariants();
		// \post argent() == argent@pre + s
		if(!(argent() == argent_at_pre + s)) throw new PostConditionError("depotArgent");
	}


	public void ramasserObjet(ObjetService o) throws PreconditionError, InvariantError, PostConditionError {
		// \pre ramasserObjet(obj) require !est_vaincu() && !est_equipeObjet()
		if(! ( !estVaincu() && !estEquipeObjet() && !estEquipePerso())) throw new PreconditionError("ramasserObjet");
		checkInvariants();
		int argent_at_pre = argent();
		int force_at_pre = force();
		super.ramasserObjet(o);
		checkInvariants();
		// \post objetEquipe() == objet
		// \post force() == force() + objet.bonusForce() si objet.estEquipable()
		// \post force() == force() sinon
		// \post argent() == argent() + objet.valeurMarchande() si objet.estDeValeur()
		// \post argent() == argent() sinon
		if( !( objetEquipe() == o )) throw new PostConditionError("ramasserObjet()");
		if(o.estEquipable() && force()!= force_at_pre + o.bonusForce()) 
			throw new PostConditionError("ramasserObjet()");
		if(o.estDeValeur() && argent()!= argent_at_pre + o.valeurMarchande()) 
			throw new PostConditionError("ramasserObjet()");
		if(!o.estDeValeur() && argent() != argent_at_pre) 
			throw new PostConditionError("ramasserObjet()");
		if(!o.estEquipable() && force()!= force_at_pre)
			throw new PostConditionError("ramasserObjet()");
	}


	public void ramasserPerso(PersonnageService p) throws PreconditionError, InvariantError, PostConditionError {
		// \pre ramasserPerso(perso) require !est_vaincu() && !est_equipePerso && !est_equipeObjet()
		if (!(! estVaincu() && !estEquipeObjet() && !estEquipePerso())) throw new PreconditionError("ramassePerso");
		checkInvariants();
		super.ramasserPerso(p);
		// \post persoEquipe() == objet
		if( !( persoEquipe() == p )) throw new PostConditionError("ramasserObjet()");
	}




	public void jeter() throws PreconditionError, InvariantError, PostConditionError{
		// \pre jeter() require !est_vaincu() && (estEquipeObjet() || estEquipePerso())
		if(! ( !estVaincu() &&  (estEquipeObjet() || estEquipePerso() ) ) ) throw new PreconditionError("jeter");
		checkInvariants();
		int force_at_pre = force();
		ObjetService objetEquipe_at_pre = objetEquipe();
		boolean est_EquipeObjet_at_pre = estEquipeObjet();
		super.jeter();
		checkInvariants();
		// \post persoEquipe() == null && objetEquipe() == null 
		// \post force() == force() - objetEquipe().bonusForce() si estEquipeObjet()
		// \post force() == force() sinon
		if(!(persoEquipe()== null && objetEquipe() == null)) throw new PostConditionError("jeter");
		if(est_EquipeObjet_at_pre && objetEquipe_at_pre.estEquipable() && force() != force_at_pre - objetEquipe_at_pre.bonusForce())
			throw new PostConditionError("jeter");
		else if (force() != force_at_pre)
			throw new PostConditionError("jeter");
	}




}
