package bloc;

import objet.ObjetService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class BlocImpl implements BlocService {
	ObjetService objet;
	TypeBloc type;
	@Override
	public ObjetService objet() {
		return this.objet;
	}

	@Override
	public TypeBloc type() {
		return this.type;
	}

	@Override
	public void init(TypeBloc ty, ObjetService obj) throws PostConditionError,
	PreconditionError {
		if((
				((ty == TypeBloc.VIDE || ty == TypeBloc.FOSSE) && obj == null) 
				|| 
				( ty == TypeBloc.OBJET && obj!=null)
				)
				){
			this.type = ty;
			this.objet = obj;
		}
	}

	@Override
	public void retirerObjet() throws PostConditionError, PreconditionError {
		if(type == TypeBloc.OBJET){
			this.objet = null;
			this.type = TypeBloc.VIDE;
		}
	}

	@Override
	public void poserObjet(ObjetService obj) throws PostConditionError,
	PreconditionError {
		if(type == TypeBloc.VIDE){
			this.type = TypeBloc.OBJET;
			this.objet = obj;
		}
	}

}
