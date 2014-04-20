package combat;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterService;

import java.util.List;

import moteur.Commande;
import perso.PersonnageService;
import terrain.TerrainService;

public interface CombatService {

	public TerrainService terrain();
	public PersonnageService alex();
	public PersonnageService ryan();
	public GangsterService slick();
	public List<GangsterService> gangsters();
	 
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public int posX(PersonnageService p) throws PreconditionError;
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public int posZ(PersonnageService p);
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public int posY(PersonnageService p);
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public boolean estGele(PersonnageService p);
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public boolean estFrappe(PersonnageService p);
	// pre p == alex() || p == ryan() || p == slick() || p \in gangsters()
	public boolean estVisible(PersonnageService p);
	
	// pre !g.estVaincu()
	public Commande actionGangster(GangsterService g);
	
	// pre (p1 = alex || p1 =  ryan) && (p2 = slick || p2 \in gangsters) 
	public boolean collisionGauche(PersonnageService p1, GangsterService p2) throws PreconditionError;
	// pre (p1 = alex || p1 =  ryan) && (p2 = slick || p2 \in gangsters)
	public boolean collisionDroite(PersonnageService p1, GangsterService p2) throws PreconditionError;
	// pre (p1 = alex || p1 =  ryan) && (p2 = slick || p2 \in gangsters)
	public boolean collisionDessous(PersonnageService p1, GangsterService p2) throws PreconditionError;
	// pre (p1 = alex || p1 =  ryan) && (p2 = slick || p2 \in gangsters)
	public boolean collisionDessus(PersonnageService p1, GangsterService p2) throws PreconditionError;
	// pre (p1 = alex || p1 =  ryan) && (p2 = slick || p2 \in gangsters)
	public boolean collisionDevant(PersonnageService p1, GangsterService p2) throws PreconditionError;
	// pre (p1 = alex || p1 =  ryan) && (p2 = slick || p2 \in gangsters)
	public boolean collisionDerriere(PersonnageService p1, GangsterService p2) throws PreconditionError;
	// pre (p1 = alex || p1 =  ryan) && (p2 = slick || p2 \in gangsters)
	public boolean collision(PersonnageService p1, GangsterService p2) throws PreconditionError;
	
	
	
	public void gerer(Commande c1, Commande c2) throws PreconditionError, InvariantError, PostConditionError;
	
	
	public void init();

}
