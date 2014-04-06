package ihm;

import java.awt.Color;
import java.util.Random;

import javax.swing.JPanel;

import objet.ObjetImpl;
import terrain.TerrainService;
import bloc.BlocImpl;
import bloc.BlocService;
import bloc.TypeBloc;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class TerrainGraphic extends JPanel implements TerrainService {

	TerrainService terrain;
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
	PostConditionError {
		terrain.init(l, h, p);
		this.setBackground(Color.gray);
		this.setSize(l, p);
		for(int i = 0; i < l/50; i++){
			for(int j = 0; j < p/50; j++){
				BlocGraphic bloc = new BlocGraphic(new BlocImpl());
				BlocImpl bloci = new BlocImpl();
				Random random = new Random();  

				TypeBloc randomType = TypeBloc.values()[random.nextInt(TypeBloc.values().length)];  

				if(randomType == TypeBloc.OBJET){
					bloc.init(randomType, new ObjetImpl());
					bloci.init(randomType, new ObjetImpl());
					bloc.setBackground(Color.YELLOW);
				}
				else{
					bloc.init(randomType, null);
					bloci.init(randomType, null);
				}
				if(bloc.type() == TypeBloc.FOSSE)
					bloc.setBackground(Color.GRAY);
				this.add(bloc);


				terrain.modifierBloc(i*50, j*50, bloci);

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
	}

}
