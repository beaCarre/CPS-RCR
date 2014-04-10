package ihm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import combat.CombatImpl;
import moteur.Commande;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class RiverCityGraphic extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Commande cA;
	static Commande cR;
	static RiverCityGraphic game;
	//static GestionCombatGraphic combat;
	static CombatGraphic combat;
	static MoteurGraphic moteur;
	static JDialog diag;
	public RiverCityGraphic(){
		this.setSize(800,600);
		this.setVisible(true);
		this.addKeyListener(this);
		cA = Commande.RIEN;
		cR = Commande.RIEN;
		diag = new JDialog(this);
		
		diag.setVisible(false);
		diag.setSize(300,100);
		diag.setLocation(50, 50);
	}


	public static void main(String[] args) throws InvariantError{
		game = new RiverCityGraphic();
		//combat = new GestionCombatGraphic();
		//combat = new CombatGraphic(new CombatImpl());
		moteur = new MoteurGraphic();
		game.setContentPane(moteur);
		//game.setContentPane(combat);
		//combat.init();
		//combat.init();
		moteur.init();
		moteur.setSize(800,600);
		Thread t = new Thread(){
			public void run() {
				while(!moteur.estFini()) {
					try {
						moteur.pasJeu(cA, cR);
						//cA = Commande.RIEN;
						//cR = Commande.RIEN;
					} catch (InvariantError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PostConditionError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (PreconditionError e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						Thread.sleep(60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				diag.add(new JLabel(""+moteur.resultat()));
				diag.setVisible(true);
			}
		};
		t.start();


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
			cA = Commande.GAUCHE;
			break;
		case KeyEvent.VK_RIGHT :
			cA = Commande.DROITE;
			break;
		case KeyEvent.VK_UP :
			cA = Commande.HAUT;
			break;
		case KeyEvent.VK_DOWN :
			cA = Commande.BAS;
			break;
		case KeyEvent.VK_Q :
			cR = Commande.GAUCHE;
			break;
		case KeyEvent.VK_D :
			cR = Commande.DROITE;
			break;
		case KeyEvent.VK_Z :
			cR = Commande.HAUT;
			break;
		case KeyEvent.VK_S :
			cR = Commande.BAS;
			break;
		case KeyEvent.VK_A :
			cR = Commande.RAMASSER;
			break;
		case KeyEvent.VK_E :
			cR = Commande.JETER;
			break;
		case KeyEvent.VK_SHIFT :
			cR = Commande.FRAPPE;
			break;
		case KeyEvent.VK_SPACE :
			cA = Commande.FRAPPE;
			break;
		case KeyEvent.VK_R :
			cA = Commande.RAMASSER;
			break;
		case KeyEvent.VK_J :
			cA = Commande.JETER;
			break;
		default:
			cA = Commande.RIEN;
			break;
		}

	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		cA = Commande.RIEN;
		cR = Commande.RIEN;
	}
}

