package ihm;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import moteur.Commande;

public class RiverCityGraphic extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static RiverCityGraphic game;
	static GestionCombatGraphic combat;
	public RiverCityGraphic(){
		this.setSize(800,600);
		this.setVisible(true);
		this.addKeyListener(this);
	}


	public static void main(String[] args) throws InvariantError{
		game = new RiverCityGraphic();
		combat = new GestionCombatGraphic();
		game.setContentPane(combat);
		combat.init();
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_LEFT :
			try {
				combat.gerer(Commande.GAUCHE, Commande.GAUCHE);
			} catch (PreconditionError | InvariantError | PostConditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case KeyEvent.VK_RIGHT :
			try {
				combat.gerer(Commande.DROITE, Commande.GAUCHE);
			} catch (PreconditionError | InvariantError | PostConditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case KeyEvent.VK_UP :
			try {
				combat.gerer(Commande.HAUT, Commande.GAUCHE);
			} catch (PreconditionError | InvariantError | PostConditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case KeyEvent.VK_DOWN :
			try {
				combat.gerer(Commande.BAS, Commande.GAUCHE);
			} catch (PreconditionError | InvariantError | PostConditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case KeyEvent.VK_SPACE :
			try {
				combat.gerer(Commande.FRAPPE, Commande.GAUCHE);
			} catch (PreconditionError | InvariantError | PostConditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case KeyEvent.VK_R :
			try {
				combat.gerer(Commande.RAMASSER, Commande.GAUCHE);
			} catch (PreconditionError | InvariantError | PostConditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		case KeyEvent.VK_J :
			try {
				combat.gerer(Commande.JETER, Commande.GAUCHE);
			} catch (PreconditionError | InvariantError | PostConditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		default:
			try {
				combat.gerer(Commande.RIEN, Commande.GAUCHE);
			} catch (PreconditionError | InvariantError | PostConditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		try {
			combat.gerer(Commande.RIEN, Commande.GAUCHE);
		} catch (PreconditionError | InvariantError | PostConditionError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

