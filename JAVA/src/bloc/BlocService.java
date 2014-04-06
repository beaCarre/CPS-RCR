package bloc;

import objet.ObjetService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public interface BlocService {
	public ObjetService objet();
	public TypeBloc type();
	
	// \pre init(ty,obj) require ((ty == VIDE || ty == FOSSE) && obj == null) || (t == OBJ && o != null)
	// \post init(ty,obj): type() == ty && objet(init(ty,obj) == obj
	public void init(TypeBloc ty, ObjetService obj) throws PostConditionError, PreconditionError;
	
	// \pre retirerObjet() require type() == OBJET
	// \post retirerObjet() : type() == VIDE && objet() == null
	public void retirerObjet() throws PostConditionError, PreconditionError;
	
	// \pre poserObjet(obj) require type() == VIDE
	// \post poserObjet(obj) : type() == OBJET && objet() == obj
	public void poserObjet(ObjetService obj)throws PostConditionError, PreconditionError;
	
}
