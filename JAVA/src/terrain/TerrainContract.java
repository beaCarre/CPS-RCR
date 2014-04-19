package terrain;

import bloc.BlocService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class TerrainContract extends TerrainDecorator {

	public TerrainContract(TerrainService terrain) {
		super(terrain);
		// TODO Auto-generated constructor stub
	}

	// \pre init(l,h,p) require l > 0 && h > 0 && p > 0 && l%50 = 0 && p%50  = 0
	// \post init(l,h,p) : largeur() == l  && hauteur() == h && profondeur() == p && bloc(x,y,z) != null
	public void init(int l, int h, int p) throws PreconditionError, PostConditionError{
		if(!(l>=50 && (l%50 == 0) && h>=100 && p>=50 && (p%50==0))) throw new PreconditionError("init() : Terrain");
		super.init(l, h, p);
		if(!(largeur() == l && hauteur() == h && profondeur() == p)) 
			throw new PostConditionError("init(): Terrain");
	}

	public void modifierBloc(int i, int j, BlocService b) throws PreconditionError, PostConditionError{
		// \pre modifierBloc(i,j,k,b) require 0 <= i <= largeur && 0 <= j <= hauteur && 0 <= k <= profondeur && b != null
		if(! ( 0 <= i && i <= hauteur() && 0 <= j && j <= profondeur()  && b != null)){
			throw new PreconditionError("modifierBloc");

		}
		super.modifierBloc(i, j, b);
		// \post modifierBloc(i,j,b) : bloc(i,j) == b 
		if( bloc(i,j) != b )
			throw new PostConditionError("modifierBloc");
	}

}
