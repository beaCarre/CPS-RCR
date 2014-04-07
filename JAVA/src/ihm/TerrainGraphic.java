package ihm;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import objet.ObjetImpl;
import terrain.TerrainService;
import bloc.BlocImpl;
import bloc.BlocService;
import bloc.TypeBloc;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class TerrainGraphic extends JPanel implements TerrainService {

	TerrainService terrain;
	BlocGraphic[][] blocsg;
	public TerrainGraphic(TerrainService t){
		terrain = t; 
		this.setLayout(null);

	}
	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return terrain.largeur();
	}

	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return terrain.hauteur();
	}

	@Override
	public int profondeur() {
		// TODO Auto-generated method stub
		return terrain.profondeur();
	}

	@Override
	public BlocService bloc(int i, int j) {
		// TODO Auto-generated method stub
		return terrain.bloc(i, j);
	}

	@Override
	public void init(int l, int h, int p) throws PreconditionError,
	PostConditionError{
		terrain.init(l, h, p);
		blocsg = new BlocGraphic[l/50][p/50];
		int nbFosseMax = 10;
		this.setBackground(Color.gray);
		this.setSize(l, p);
		for(int i = 0; i < l/50; i++){
			for(int j = 0; j < p/50; j++){
				BlocGraphic bloc = new BlocGraphic(new BlocImpl());
				BlocImpl bloci = new BlocImpl();
				Random random = new Random();  

				TypeBloc randomType = TypeBloc.values()[random.nextInt(TypeBloc.values().length)];  

				if(i == 0) randomType = TypeBloc.VIDE;
				if(randomType == TypeBloc.OBJET){
					ObjetGraphic obj = new ObjetGraphic(new ObjetImpl());
					if(random.nextInt(10)<5){
						obj.init("Batte", random.nextInt(20)+1, 0);
					}
					else{
						obj.init("Sous", 0, random.nextInt(100)+1);
					}
					bloc.init(randomType, obj);
					//bloci.init(randomType, obj);

					bloc.add(obj);
					obj.setLocation(15, 15);
				}
				else{
					if(randomType == TypeBloc.FOSSE && nbFosseMax>0){
						bloc.init(randomType, null);
						nbFosseMax--;
					}
					else{
						bloc.init(TypeBloc.VIDE, null);
					}
					//bloci.init(randomType, null);
				}
				if(bloc.type() == TypeBloc.FOSSE)
					bloc.setBackground(Color.GRAY);
				this.add(bloc);


				//terrain.modifierBloc(i*50, j*50, bloci);
				this.modifierBloc(i*50, j*50, bloc);
				//bloc.setSize(50,50);
				//bloc.setBorder(BorderFactory.createLineBorder(Color.gray));
				bloc.setBounds(i*50, j*50,49,49);
				bloc.setVisible(true);
			}
		}
	}

	@Override
	public void modifierBloc(int i, int j, BlocService b)
			throws PreconditionError, PostConditionError {
		terrain.modifierBloc(i, j, b);
		blocsg[i/50][j/50] = (BlocGraphic) b;

	}

}
