package bloc;

import objet.ObjetService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class BlocContract extends BlocDecorator {

	public BlocContract(BlocService delegates) {
		super(delegates);

	}


	public void init(TypeBloc ty, ObjetService obj) throws PostConditionError, PreconditionError {
		// \pre init(ty,obj) require ((ty == VIDE || ty == FOSSE) && obj == null) || (ty == OBJ && o != null)
		if(!
				(
				((ty == TypeBloc.VIDE || ty == TypeBloc.FOSSE) && obj == null) 
				|| 
				( ty == TypeBloc.OBJET && obj!=null)
				)
			)
			throw new PreconditionError("init()");
		super.init(ty, obj);
		// \post init(ty,obj): type() == ty && objet(init(ty,obj) == obj
		if(!(type() == ty && objet() == obj)) 
			throw new PostConditionError("init Bloc");
	}


	// \pre retirerObjet() require type() == OBJET
	// \post retirerObjet() : type() == VIDE && objet() == null
	public void retirerObjet() throws PostConditionError, PreconditionError{
		if(type() != TypeBloc.OBJET) throw new PreconditionError("retirerObjet()");
		super.retirerObjet();
		if(type() != TypeBloc.VIDE && objet() != null) throw new PostConditionError("retirerObjet()");
	}

	// \pre poserObjet(obj) require type() == VIDE
	// \post poserObjet(obj) : type() == OBJET && objet() == obj
	public void poserObjet(ObjetService obj)throws PostConditionError, PreconditionError{
		if(type() != TypeBloc.VIDE) throw new PreconditionError("poserObjet()");
		super.poserObjet(obj);
		if(type() != TypeBloc.OBJET || objet() != obj) throw new PostConditionError("poserObjet()");
	}


}
