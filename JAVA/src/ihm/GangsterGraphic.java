package ihm;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterService;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objet.ObjetService;
import perso.PersonnageService;

public class GangsterGraphic extends PersonnageGraphic implements GangsterService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GangsterService gangster;
	JLabel lab;
	
	public GangsterGraphic(GangsterService gangster){
		super(gangster);
		this.gangster = gangster;

		this.setBackground(new Color(100,100,200));
		this.setVisible(true);
		lab = new JLabel("0");
		this.add(lab);

	}
	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return gangster.nom();
	}
	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return gangster.largeur();
	}
	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return gangster.hauteur();
	}
	@Override
	public int profondeur() {
		// TODO Auto-generated method stub
		return gangster.profondeur();
	}
	@Override
	public int force() {
		// TODO Auto-generated method stub
		return gangster.force();
	}
	@Override
	public int pointsDeVie() {
		// TODO Auto-generated method stub
		return gangster.pointsDeVie();
	}
	@Override
	public int argent() {
		// TODO Auto-generated method stub
		return gangster.argent();
	}
	@Override
	public boolean estVaincu() {
		// TODO Auto-generated method stub
		return gangster.estVaincu();
	}
	@Override
	public boolean estEquipeObjet() {
		// TODO Auto-generated method stub
		return gangster.estEquipeObjet();
	}
	@Override
	public boolean estEquipePerso() {
		// TODO Auto-generated method stub
		return gangster.estEquipePerso();
	}
	@Override
	public ObjetService objetEquipe() {
		// TODO Auto-generated method stub
		return gangster.objetEquipe();
	}

	@Override
	public void init(String n, int l, int h, int p, int f, int v, int a)
			throws PreconditionError, InvariantError, PostConditionError {
		// TODO Auto-generated method stub

		gangster.init(n, l, h, p, f, v, a);

	}
	@Override
	public void retraitPdV(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		gangster.retraitPdV(s);

		lab.setText(""+pointsDeVie());
		this.setBackground(new Color(255-pointsDeVie(), 255-pointsDeVie(), 200));
	}

	@Override
	public void retraitArgent(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		gangster.retraitArgent(s);

	}
	@Override
	public void depotArgent(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		gangster.depotArgent(s);

	}
	@Override
	public void ramasserObjet(ObjetService o) throws PreconditionError,
	InvariantError, PostConditionError {
		gangster.ramasserObjet(o);

	}
	@Override
	public void ramasserPerso(PersonnageService p) throws PreconditionError,
	InvariantError, PostConditionError {
		gangster.ramasserPerso(p);

	}
	@Override
	public void jeter() throws PreconditionError, InvariantError,
	PostConditionError {
		gangster.jeter();

	}
	@Override
	public void ramasserArgent(ObjetService o) throws PreconditionError,
			InvariantError, PostConditionError {
		gangster.ramasserArgent(o);
		
	}
	@Override
	public void init(String n, int l, int h, int p, int f, int v)
			throws PreconditionError, InvariantError, PostConditionError {
		gangster.init(n, l, h, p, f, v);
		this.setSize(l, h);
		this.setLayout(new FlowLayout());
		lab.setText(""+this.pointsDeVie());

		this.repaint();
		
	}
	@Override
	public PersonnageService persoEquipe() {
		// TODO Auto-generated method stub
		return null;
	}



}
