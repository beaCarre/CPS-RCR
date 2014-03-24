package perso;

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
		// \inv est_equipe() == (choseEquipee() != null)
		if( !(estEquipe() == (choseEquipee() != null) )){
			throw new InvariantError("estEquipe()");
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
		
		public void ramasser(Object chose) throws PreconditionError, InvariantError, PostConditionError{
			// \pre ramasser(chose) require !est_vaincu() && !est_equipe()
			if(estVaincu() || estEquipe()) throw new PreconditionError("ramasser");
			checkInvariants();
			super.ramasser(chose);
			checkInvariants();
			// \post choseEquipee() == chose && est_equipe() == true
			if(!(choseEquipee() == chose && estEquipe())) throw new PostConditionError("ramasser");	
		}
		
	
		
		
		
		
		public void jeter() throws PreconditionError, InvariantError, PostConditionError{
			// \pre jeter() require !est_vaincu() && est_equipe()
			if(estVaincu() || !estEquipe()) throw new PreconditionError("jeter");
			checkInvariants();
			super.jeter();
			checkInvariants();
			// \post estEquipe() == false
			if(estEquipe()) throw new PostConditionError("jeter");
		}
	
	
}
