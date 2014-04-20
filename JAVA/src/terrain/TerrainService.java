package terrain;

import exceptions.PostConditionError;
import exceptions.PreconditionError;
import bloc.BlocService;

public interface TerrainService {
	public int largeur();
	public int  hauteur();
	public int profondeur();
	
	// \pre bloc(i,j,k) require 0 <= i <= largeur && 0 <= j <= hauteur && 0 <= k <= profondeur
	public BlocService bloc(int i, int j, int k);
	
	// \pre init(l,h,p) require l > 0 && h > 0 && p > 0 
	// \post init(l,h,p) : largeur() == l  && hauteur() == h && profondeur() == p && bloc(x,y,z) != null
	public void init(int l, int h, int p) throws PreconditionError, PostConditionError; 
	
	
	// \pre modifierBloc(i,j,k,b) require 0 <= i <= largeur && 0 <= j <= hauteur && 0 <= k <= profondeur && b != null
	// \post modifierBloc(i,j,k,b) : bloc(i,j,k) == b 
	public void modifierBloc(int i, int j, int k, BlocService b) throws PreconditionError, PostConditionError;
	
}
