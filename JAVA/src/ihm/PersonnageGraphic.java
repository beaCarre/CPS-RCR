package ihm;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import objet.ObjetService;
import perso.PersonnageService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;

public class PersonnageGraphic extends JPanel implements PersonnageService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PersonnageService perso;
	private JLabel lab;
	public PersonnageGraphic(PersonnageService perso){
		this.perso = perso;

		this.setBackground(Color.red);
		this.setVisible(true);



	}
	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return perso.nom();
	}
	@Override
	public int largeur() {
		// TODO Auto-generated method stub
		return perso.largeur();
	}
	@Override
	public int hauteur() {
		// TODO Auto-generated method stub
		return perso.hauteur();
	}
	@Override
	public int profondeur() {
		// TODO Auto-generated method stub
		return perso.profondeur();
	}
	@Override
	public int force() {
		// TODO Auto-generated method stub
		return perso.force();
	}
	@Override
	public int pointsDeVie() {
		// TODO Auto-generated method stub
		return perso.pointsDeVie();
	}
	@Override
	public int argent() {
		// TODO Auto-generated method stub
		return perso.argent();
	}
	@Override
	public boolean estVaincu() {
		// TODO Auto-generated method stub
		return perso.estVaincu();
	}
	@Override
	public boolean estEquipeObjet() {
		// TODO Auto-generated method stub
		return perso.estEquipeObjet();
	}
	@Override
	public boolean estEquipePerso() {
		// TODO Auto-generated method stub
		return perso.estEquipePerso();
	}
	@Override
	public ObjetService objetEquipe() {
		// TODO Auto-generated method stub
		return perso.objetEquipe();
	}
	@Override
	public PersonnageService persoEquipe() {
		// TODO Auto-generated method stub
		return perso.persoEquipe();
	}
	@Override
	public void init(String n, int l, int h, int p, int f, int v, int a)
			throws PreconditionError, InvariantError, PostConditionError {
		// TODO Auto-generated method stub

		perso.init(n, l, h, p, f, v, a);
		this.setSize(l, h);
		this.setLayout(new FlowLayout());
		lab = new JLabel(n+" "+v);
		lab.setSize(l,h);
		lab.setVisible(true);
		this.add(lab);

	}
	@Override
	public void retraitPdV(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		perso.retraitPdV(s);

		lab.setText(""+perso.pointsDeVie());
		if(perso.estVaincu()){
			this.setBackground(Color.white);
		}
	}



	@Override
	public void depotPdV(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		perso.depotPdV(s);

	}
	@Override
	public void retraitArgent(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		perso.retraitArgent(s);

	}
	@Override
	public void depotArgent(int s) throws PreconditionError, InvariantError,
	PostConditionError {
		perso.depotArgent(s);

	}
	@Override
	public void ramasserObjet(ObjetService o) throws PreconditionError,
	InvariantError, PostConditionError {
		perso.ramasserObjet(o);

	}
	@Override
	public void ramasserPerso(PersonnageService p) throws PreconditionError,
	InvariantError, PostConditionError {
		perso.ramasserPerso(p);

	}
	@Override
	public void jeter() throws PreconditionError, InvariantError,
	PostConditionError {
		perso.jeter();

	}



}
