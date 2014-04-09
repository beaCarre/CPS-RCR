package terrain;

import bloc.BlocService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public interface TerrainService {
	public int largeur();
	public int  hauteur();
	public int profondeur();
	
	// \pre bloc(x,y) require 0 <= x <= largeur && 0 <= y <= profondeur
	public BlocService bloc(int x, int y);
	
	// \pre init(l,h,p) require l > 0 && h > 0 && p > 0 && l%50 = 0 && p%50  = 0
	// \post init(l,h,p) : largeur() == l  && hauteur() == h && profondeur() == p && bloc(x,y,z) != null
	public void init(int l, int h, int p) throws PreconditionError, PostConditionError; 
	
	
	// \pre modifierBloc(i,j,b) require 0 <= i <= largeur && 0 <= j <= profondeur && b != null
	// \post modifierBloc(i,j,b) : bloc(i,j,k) == b 
	public void modifierBloc(int x, int y, BlocService b) throws PreconditionError, PostConditionError;
	
}
