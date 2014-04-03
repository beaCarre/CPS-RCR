package bloc;

import exceptions.PostConditionError;


public abstract class BlocDecorator implements BlocService{
	
	private BlocService delegates;
	
	public BlocDecorator(BlocService delegates){
		this.delegates = delegates;
	}
	@Override
	public tresorBloc tresor() {
		return delegates.tresor();
	}

	@Override
	public typeBloc type() {
		return delegates.type();
		
	}

	@Override
	public void init(typeBloc ty, tresorBloc tr) throws PostConditionError {
		delegates.init(ty, tr);
	}

}
