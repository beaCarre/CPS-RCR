package bloc;

import exceptions.PostConditionError;

public class BlocFailImpl implements BlocService {
	TresorBloc tresor;
	TypeBloc type; 
	public BlocFailImpl(){
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
		tresor = null;
		type = null;
	}

}
