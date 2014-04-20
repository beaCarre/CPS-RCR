package gangster;

import objet.ObjetService;
import perso.PersonnageService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class GangsterContract extends GangsterDecorator {

	protected GangsterContract(GangsterService delegates) {
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
		super.depotPdV(s);
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
		super.retraitArgent(s);
		checkInvariants();
		// \post argent() == argent@pre + s
		if(!(argent() == argent_at_pre + s)) throw new PostConditionError("depotArgent");
	}


	public void ramasserObjet(ObjetService o) throws PreconditionError, InvariantError, PostConditionError {
		// \pre ramasserObjet(obj) require !est_vaincu() && !est_equipeObjet()
		if(! ( !estVaincu() && !estEquipeObjet() && !estEquipePerso())) throw new PreconditionError("ramasserObjet");
		checkInvariants();
		super.ramasserObjet(o);
		checkInvariants();
		// \post objetEquipe() == objet
		if( !( objetEquipe() == o )) throw new PostConditionError("ramasserObjet()");
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
		super.jeter();
		checkInvariants();
		// \post persoEquipe() == null && objetEquipe() == null 
		if(!(persoEquipe()== null && objetEquipe() == null)) throw new PostConditionError("jeter");
	}

	


}
