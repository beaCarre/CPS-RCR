package bloc;

import objet.ObjetService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;



public abstract class BlocDecorator implements BlocService{

	private BlocService delegates;

	public BlocDecorator(BlocService delegates){
		this.delegates = delegates;
	}
	public ObjetService objet(){
		return delegates.objet();
	}
	public TypeBloc type(){
		return delegates.type();
	}
	
	// \post type(init(ty,obj) == ty && objet(init(ty,obj) == obj
	public void init(TypeBloc ty, ObjetService obj) throws PostConditionError, PreconditionError{
		this.delegates.init(ty, obj);
	}

	// \pre retirerObjet() require type() == OBJET
	// \post retirerObjet() : type() == VIDE && objet() == null
	
	public void retirerObjet() throws PostConditionError, PreconditionError{
		this.delegates.retirerObjet();
	}

	// \pre poserObjet(obj) require type() == VIDE
	// \post poserObjet(obj) : type() == OBJET && objet() == obj
	public void poserObjet(ObjetService obj)throws PostConditionError, PreconditionError{
		this.delegates.poserObjet(obj);
	}


}
