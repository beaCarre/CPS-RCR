package ihm;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import objet.ObjetService;

public class ObjetGraphic extends JPanel implements ObjetService{

	ObjetService obj;
	JLabel lab;
	public ObjetGraphic(ObjetService o){
		obj = o;
		this.setSize(20,20);
		this.setBackground(Color.YELLOW);
		lab = new JLabel();
		lab.setSize(20,20);
		
	}
	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return obj.nom();
	}

	@Override
	public boolean estEquipable() {
		// TODO Auto-generated method stub
		return obj.estEquipable();
	}

	@Override
	public boolean estDeValeur() {
		// TODO Auto-generated method stub
		return obj.estDeValeur();
	}

	@Override
	public int bonusForce() {
		// TODO Auto-generated method stub
		return obj.bonusForce();
	}

	@Override
	public int valeurMarchande() {
		// TODO Auto-generated method stub
		return obj.valeurMarchande();
	}

	@Override
	public void init(String nom, int bonus, int valeur)
			throws PreconditionError, PostConditionError {
		// TODO Auto-generated method stub
		obj.init(nom, bonus, valeur);
		lab.setText("+"+bonus);
		this.add(lab);
		if(this.estDeValeur()){
			this.setBackground(Color.white);
			lab.setText("$"+valeur);
		}
		
	}
	
}
