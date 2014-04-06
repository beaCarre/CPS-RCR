package terrain;

import bloc.BlocService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class TerrainFailImpl implements TerrainService {
	int largeur, hauteur, profondeur;
	BlocService[][] blocs; // Mon tableau de blocs 
	@Override
	public int largeur() {
		
		return largeur;
	}

	@Override
	public int hauteur() {
		
		return hauteur;
	}

	@Override
	public int profondeur() {
		
		return profondeur;
	}

	@Override
	public BlocService bloc(int i, int j) {
		
		return blocs[i][j];
	}

	@Override
	public void init(int l, int h, int p) throws PreconditionError,
			PostConditionError {
		largeur = l;
		hauteur = h;
		profondeur = p; 
		blocs = new BlocService[l][h];
	}

	@Override
	public void modifierBloc(int i, int j, BlocService b)
			throws PreconditionError, PostConditionError {
		blocs[i][j] = b;
	}

}
