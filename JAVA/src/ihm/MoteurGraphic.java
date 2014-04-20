package ihm;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import combat.CombatImpl;
import combat.CombatService;
import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import moteur.Commande;
import moteur.MoteurService;
import moteur.Resultat;

public class MoteurGraphic extends JPanel implements MoteurService {
	CombatGraphic combat;
	int pasCourant;
	
	public MoteurGraphic(){
		combat = new CombatGraphic(new CombatImpl());
	
		this.setLayout(null);
		
	}
	@Override
	public boolean estFini() {
		// TODO Auto-generated method stub
		return (combat().alex().estVaincu() && combat().ryan().estVaincu() ) || combat().slick().estVaincu();
	}

	@Override
	public Resultat resultat() {
		// TODO Auto-generated method stub
		Resultat r;
		if(!combat().alex().estVaincu() && combat().ryan().estVaincu() && combat().slick().estVaincu())
			r = Resultat.ALEXGAGNANT;
		else if(combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu())
			r = Resultat.RYANGAGNANT;
		else if(!combat().alex().estVaincu() && !combat().ryan().estVaincu() && combat().slick().estVaincu())
			r = Resultat.DEUXGAGNANTS;
		else if(combat().alex().estVaincu() && combat().ryan().estVaincu() && !combat().slick().estVaincu())
			r = Resultat.SLICKGAGNANT;
		else
			r = Resultat.NULLE;
		return r;
	}

	@Override
	public CombatService combat() {
		// TODO Auto-generated method stub
		return combat;
	}

	@Override
	public int pasCourant() {
		// TODO Auto-generated method stub
		return pasCourant;
	}

	@Override
	public void init() throws InvariantError {
		// TODO Auto-generated method stub
		this.add(combat);
		combat.init();
		
		
	}

	@Override
	public void pasJeu(Commande cA, Commande cR) throws InvariantError,
			PostConditionError, PreconditionError {
		// TODO Auto-generated method stub
		pasCourant++;
		combat().gerer(cA, cR);
	}

}
