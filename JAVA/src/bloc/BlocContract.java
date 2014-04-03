package bloc;

import exceptions.PostConditionError;

public class BlocContract extends BlocDecorator {

	public BlocContract(BlocService delegates) {
		super(delegates);
		// TODO Auto-generated constructor stub
	}
	
	
	public tresorBloc tresor() {
		return super.tresor();
	}


	public typeBloc type() {
		return super.type();
	}

	
	public void init(typeBloc ty, tresorBloc tr) throws PostConditionError {
		super.init(ty, tr);
		// \post type(init(ty,tr) == ty && tresor(init(ty,tr) == tr
		if(!(type() == ty && tresor() == tr)) 
				throw new PostConditionError("init Bloc");
	}

}
