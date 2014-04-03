package bloc;

import exceptions.PostConditionError;


public abstract class BlocDecorator implements BlocService{
	
	private BlocService delegates;
	
	public BlocDecorator(BlocService delegates){
		this.delegates = delegates;
	}
	@Override
	public TresorBloc tresor() {
		return delegates.tresor();
	}

	@Override
	public TypeBloc type() {
		return delegates.type();
		
	}

	@Override
	public void init(TypeBloc ty, TresorBloc tr) throws PostConditionError {
		delegates.init(ty, tr);
	}

}
