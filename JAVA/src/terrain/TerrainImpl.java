package terrain;

import ihm.BlocGraphic;
import ihm.ObjetGraphic;

import java.awt.Color;
import java.util.Random;

import objet.ObjetImpl;
import objet.ObjetService;
import bloc.BlocImpl;
import bloc.BlocService;
import bloc.TypeBloc;
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
		if(l>0 && (l%50 == 0) && h>0 && p>0 && (p%50==0)){
			largeur = l;
			hauteur = 0;
			profondeur = p; 
			blocs = new BlocService[l/50][h/50];
			int nbFosseMax = 10;
			for(int i = 0; i < l/50; i++){
				for(int j = 0; j < p/50; j++){
					BlocService bloc = new BlocImpl();
					
					Random random = new Random();  

					TypeBloc randomType = TypeBloc.values()[random.nextInt(TypeBloc.values().length)];  

					if(i == 0) randomType = TypeBloc.VIDE;
					if(randomType == TypeBloc.OBJET){
						ObjetService obj = new ObjetImpl();
						if(random.nextInt(10)<5){
							obj.init("Batte", random.nextInt(20)+1, 0);
						}
						else{
							obj.init("Sous", 0, random.nextInt(100)+1);
						}
						bloc.init(randomType, obj);
					}
					else{
						if(randomType == TypeBloc.FOSSE && nbFosseMax>0){
							bloc.init(randomType, null);
							nbFosseMax--;
						}
						else{
							bloc.init(TypeBloc.VIDE, null);
						}
					}
					
					this.modifierBloc(i*50, j*50, bloc);
					
				}
			}
		}
	}

	@Override
	public void modifierBloc(int i, int j, BlocService b)
			throws PreconditionError, PostConditionError {
		blocs[i/50][j/50] = b;
	}

}
