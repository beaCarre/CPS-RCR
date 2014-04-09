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
	public BlocGraphic(BlocService bloc){
		this.bloc = bloc;
		this.setBackground(Color.GREEN);
	}
	@Override
	public ObjetService objet() {
		// TODO Auto-generated method stub
		return bloc.objet();
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
	}

}
