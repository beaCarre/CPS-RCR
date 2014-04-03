package bloc;

import exceptions.PostConditionError;

public interface BlocService {
	public tresorBloc tresor();
	public typeBloc type();
	
	// \post type(init(ty,tr) == ty && tresor(init(ty,tr) == tr
	public void init(typeBloc ty, tresorBloc tr) throws PostConditionError;
}
