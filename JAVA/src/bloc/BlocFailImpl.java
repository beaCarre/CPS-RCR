package bloc;

import objet.ObjetService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class BlocFailImpl implements BlocService {
	ObjetService objet;
	TypeBloc type;
	@Override
	public ObjetService objet() {
		// TODO Auto-generated method stub
		return this.objet;
	}

	@Override
	public TypeBloc type() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public void init(TypeBloc ty, ObjetService obj) throws PostConditionError,
			PreconditionError {
		this.type = ty;
		this.objet = obj;
	}

	@Override
	public void retirerObjet() throws PostConditionError, PreconditionError {
		this.type = TypeBloc.VIDE;
		this.objet = null;
	}

	@Override
	public void poserObjet(ObjetService obj) throws PostConditionError,
			PreconditionError {
		this.type = TypeBloc.OBJET;
		this.objet = obj;
		
	}
	

}
