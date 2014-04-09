package ihm;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import objet.ObjetService;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import bloc.BlocService;
import bloc.TypeBloc;

public class BlocGraphic extends JPanel implements BlocService {
	BlocService bloc;
	ObjetGraphic obj;
	public BlocGraphic(BlocService bloc){
		this.bloc = bloc;
		if(bloc.type() == TypeBloc.FOSSE)
			this.setBackground(Color.gray);
		else
			this.setBackground(Color.GREEN);
		if(bloc.type() == TypeBloc.OBJET){
			obj = new ObjetGraphic(bloc.objet());
			try {
				obj.init(bloc.objet().nom(), bloc.objet().bonusForce(), bloc.objet().valeurMarchande());
			} catch (PreconditionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PostConditionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.add(obj);
		}
	
	}
	@Override
	public ObjetService objet() {
		// TODO Auto-generated method stub
		return obj;
	}

	@Override
	public TypeBloc type() {
		// TODO Auto-generated method stub
		return bloc.type();
	}

	@Override
	public void init(TypeBloc ty, ObjetService obj) throws PostConditionError,
			PreconditionError {
		bloc.init(ty, obj);
		
	}

	@Override
	public void retirerObjet() throws PostConditionError, PreconditionError {
		// TODO Auto-generated method stub
		bloc.retirerObjet();
		this.removeAll();
		this.repaint();
	
	}

	@Override
	public void poserObjet(ObjetService obj) throws PostConditionError,
			PreconditionError {
		// TODO Auto-generated method stub
		bloc.poserObjet(obj);
		this.add((Component) obj);
		this.repaint();
		this.obj = (ObjetGraphic) obj;
	}

}
