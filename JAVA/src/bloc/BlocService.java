package bloc;

import exceptions.PostConditionError;

public interface BlocService {
	public TresorBloc tresor();
	public TypeBloc type();
	
	// \post type(init(ty,tr) == ty && tresor(init(ty,tr) == tr
	public void init(TypeBloc ty, TresorBloc tr) throws PostConditionError;
}
