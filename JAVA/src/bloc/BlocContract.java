package bloc;

import exceptions.PostConditionError;

public class BlocContract extends BlocDecorator {

	public BlocContract(BlocService delegates) {
		super(delegates);
		
	}
	
	
	public TresorBloc tresor() {
		return super.tresor();
	}


	public TypeBloc type() {
		return super.type();
	}

	
	public void init(TypeBloc ty, TresorBloc tr) throws PostConditionError {
		super.init(ty, tr);
		// \post type(init(ty,tr) == ty && tresor(init(ty,tr) == tr
		if(!(type() == ty && tresor() == tr)) 
				throw new PostConditionError("init Bloc");
	}

}
