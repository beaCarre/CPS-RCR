package bloc;

import exceptions.PostConditionError;

public class BlocImpl implements BlocService {
	TresorBloc tresor;
	TypeBloc type; 
	public BlocImpl(){
		type = null;
		tresor = null;
		
	}

	@Override
	public TresorBloc tresor() {
		return tresor;
	}

	@Override
	public TypeBloc type() {
		return type;
	}

	@Override
	public void init(TypeBloc ty, TresorBloc tr) throws PostConditionError {
		tresor = tr;
		type = ty;
	}

}
