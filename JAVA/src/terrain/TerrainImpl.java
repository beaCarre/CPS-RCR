package terrain;

import bloc.BlocService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class TerrainImpl implements TerrainService {
	int largeur, hauteur, profondeur;
	public BlocService[][] blocs; 
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
		
		return blocs[i/50][j/50];
	}

	@Override
	public void init(int l, int h, int p) throws PreconditionError,
			PostConditionError {
		largeur = l;
		hauteur = 0;
		profondeur = p; 
		blocs = new BlocService[l/50][h/50];
	}

	@Override
	public void modifierBloc(int i, int j, BlocService b)
			throws PreconditionError, PostConditionError {
		blocs[i/50][j/50] = b;
	}

}
