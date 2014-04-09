package combat;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterService;

import java.util.List;

import moteur.Commande;
import perso.PersonnageService;
import terrain.TerrainService;

public abstract class CombatDecorator implements CombatService {

	private CombatService combat;
	public CombatDecorator(CombatService c){
		combat = c;
	}
	@Override
	public TerrainService terrain() {
		// TODO Auto-generated method stub
		return combat.terrain();
	}

	@Override
	public PersonnageService alex() {
		// TODO Auto-generated method stub
		return combat.alex();
	}

	@Override
	public PersonnageService ryan() {
		// TODO Auto-generated method stub
		return combat.ryan();
	}

	@Override
	public GangsterService slick() {
		// TODO Auto-generated method stub
		return combat.slick();
	}

	@Override
	public List<GangsterService> gangsters() {
		// TODO Auto-generated method stub
		return combat.gangsters();
	}


	public Commande actionGangster(GangsterService g){
		return combat.actionGangster(g);
	}

	@Override
	public int posX(PersonnageService p) throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.posX(p);
	}

	@Override
	public int posZ(PersonnageService p) {
		// TODO Auto-generated method stub
		return combat.posZ(p);
	}

	@Override
	public int posY(PersonnageService p) {
		// TODO Auto-generated method stub
		return combat.posY(p);
	}

	@Override
	public boolean estGele(PersonnageService p) {
		// TODO Auto-generated method stub
		return  combat.estGele(p);
	}

	@Override
	public boolean estFrappe(PersonnageService p) {
		// TODO Auto-generated method stub
		return combat.estFrappe(p);
	}
	public boolean estVisible(PersonnageService p){
		return combat.estVisible(p);
	}

	public boolean collisionGauche(PersonnageService p1, GangsterService p2) throws PreconditionError{
		return combat.collisionGauche(p1, p2);
	}
	public boolean collisionDroite(PersonnageService p1, GangsterService p2) throws PreconditionError{
		return combat.collisionDroite(p1, p2);
	}
	public boolean collisionDessous(PersonnageService p1, GangsterService p2) throws PreconditionError{
		return combat.collisionDessous(p1, p2);
	}
	public boolean collisionDessus(PersonnageService p1, GangsterService p2) throws PreconditionError{
		return combat.collisionDessus(p1, p2);
	}
	public boolean collisionDevant(PersonnageService p1, GangsterService p2) throws PreconditionError{
		return combat.collisionDevant(p1, p2);
	}
	public boolean collisionDerriere(PersonnageService p1, GangsterService p2) throws PreconditionError{
		return combat.collisionDerriere(p1, p2);
	}


	@Override
	public boolean collision(PersonnageService p1, GangsterService p2) throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.collision(p1, p2);
	}

	@Override
	public void gerer(Commande c1, Commande c2) throws PreconditionError, InvariantError, PostConditionError {
		// TODO Auto-generated method stub
		combat.gerer(c1, c2);
	}

	@Override
	public void init(){
		// TODO Auto-generated method stub
		combat.init();
	}

}
