package terrain;

import exceptions.PostConditionError;
import exceptions.PreconditionError;
import bloc.BlocService;

public abstract class TerrainDecorator implements TerrainService {
	private TerrainService delegates;
	
	public TerrainDecorator(TerrainService terrain){
		this.delegates = terrain;
	}
	@Override
	public int largeur() {
		return delegates.largeur();
	}

	@Override
	public int hauteur() {
		return delegates.hauteur();
	}

	@Override
	public int profondeur() {
		return delegates.profondeur();
	}

	@Override
	public BlocService bloc(int i, int j, int k) {
		return delegates.bloc(i, j, k);
	}

	@Override
	public void init(int l, int h, int p) {
		delegates.init(l, h, p);
	}

	@Override
	public void modifierBloc(int i, int j, int k, BlocService b) throws PreconditionError, PostConditionError {
		delegates.modifierBloc(i, j, k, b);
	}

}
