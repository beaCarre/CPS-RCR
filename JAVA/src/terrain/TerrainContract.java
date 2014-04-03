package terrain;

import exceptions.PostConditionError;
import exceptions.PreconditionError;
import bloc.BlocService;

public class TerrainContract extends TerrainDecorator {

	public TerrainContract(TerrainService terrain) {
		super(terrain);
		// TODO Auto-generated constructor stub
	}

	// \pre init(l,h,p) require l > 0 && h > 0 && p > 0 
	// \post init(l,h,p) : largeur() == l  && hauteur() == h && profondeur() == p && bloc(x,y,z) != null
	public void init(int l, int h, int p) throws PreconditionError, PostConditionError{
		if(!(l > 0 && h > 0 && p > 0)) throw new PreconditionError("init() : Terrain");
		super.init(l, h, p);
		if(!(largeur() == l && hauteur() == h && profondeur() == p)) 
			throw new PostConditionError("init(): Terrain");
	}

	public void modifierBloc(int i, int j, int k, BlocService b) throws PreconditionError, PostConditionError{
		// \pre modifierBloc(i,j,k,b) require 0 <= i <= largeur && 0 <= j <= hauteur && 0 <= k <= profondeur && b != null
		if(! ( 0 <= i && i <= hauteur() && 0 <= j && j <= hauteur() && 0 <= k && k <= profondeur() && b != null)){
			throw new PreconditionError("modifierBloc");

		}
		super.modifierBloc(i, j, k, b);
		// \post modifierBloc(i,j,k,b) : bloc(i,j,k) == b 
		if( bloc(i,j,k) == b )
			throw new PostConditionError("modifierBloc");
	}

}
