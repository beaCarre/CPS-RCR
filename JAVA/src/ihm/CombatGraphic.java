package ihm;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterImpl;
import gangster.GangsterService;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import bloc.TypeBloc;
import moteur.Commande;
import perso.PersonnageImpl;
import perso.PersonnageService;
import terrain.TerrainImpl;
import terrain.TerrainService;
import combat.CombatService;
import combat.Point3D;

public class CombatGraphic extends JPanel implements CombatService{

	TerrainGraphic terrain;
	CombatService combat;
	PersonnageGraphic alex;
	PersonnageGraphic ryan;
	GangsterGraphic slick;
	List<GangsterGraphic> gangsters;

	JTextArea infos;

	public CombatGraphic(CombatService combat){
		this.setSize(800,600);
		this.setLayout(null);
		infos = new JTextArea();
		this.add(infos);
		infos.setLocation(550, 50);
		infos.setSize(200, 300);

		this.combat = combat;
		gangsters = new ArrayList<GangsterGraphic>();
		infos.setEditable(false);
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
		return combat.estGele(p);
	}

	@Override
	public boolean estFrappe(PersonnageService p) {
		// TODO Auto-generated method stub
		return combat.estFrappe(p);
	}

	@Override
	public boolean estVisible(PersonnageService p) {
		// TODO Auto-generated method stub
		return combat.estVisible(p);
	}

	@Override
	public Commande actionGangster(GangsterService g) {
		// TODO Auto-generated method stub
		return combat.actionGangster(g);
	}

	@Override
	public boolean collisionGauche(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.collisionGauche(p1, p2);
	}

	@Override
	public boolean collisionDroite(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.collisionDroite(p1, p2);
	}

	@Override
	public boolean collisionDessous(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.collisionDessous(p1, p2);
	}

	@Override
	public boolean collisionDessus(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.collisionDessus(p1, p2);
	}

	@Override
	public boolean collisionDevant(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.collisionDevant(p1, p2);
	}

	@Override
	public boolean collisionDerriere(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.collisionDerriere(p1, p2);
	}

	@Override
	public boolean collision(PersonnageService p1, GangsterService p2)
			throws PreconditionError {
		// TODO Auto-generated method stub
		return combat.collision(p1, p2);
	}

	@Override
	public void gerer(Commande c1, Commande c2) throws PreconditionError,
	InvariantError, PostConditionError {

		combat.gerer(c1, c2);
		alex.setLocation(posX(combat.alex())-alex.largeur()/2, posY(combat.alex())-alex.profondeur()/2);
		ryan.setLocation(posX(combat.ryan())-ryan.largeur()/2, posY(combat.ryan())-ryan.profondeur()/2);
		slick.setLocation(posX(combat.slick())-slick.largeur()/2, posY(combat.slick())-slick.profondeur()/2);
		for(GangsterGraphic g : gangsters){

			g.setLocation(posX(g.gangster)-g.largeur()/2, posY(g.gangster)-g.profondeur()/2);
			g.lab.setText(""+g.gangster.pointsDeVie());
			g.repaint();
		}
		slick.lab.setText(""+slick.pointsDeVie());

		majInfos();
		majVisibles();
	}

	private void majVisibles() {
		for(GangsterGraphic g : gangsters){

			if(!estVisible(g.gangster)){ 
				g.setVisible(false);

			}
			else
				g.setVisible(true);
			this.repaint();
		}
		if(!estVisible(combat.alex())) alex.setVisible(false);
		if(!estVisible(combat.ryan())) ryan.setVisible(false);
		if(!estVisible(combat.slick())) slick.setVisible(false);
		else slick.setVisible(true);
		alex.repaint();
		slick.repaint();
		ryan.repaint();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		combat.init();
		terrain = new TerrainGraphic(combat.terrain());
		alex = new PersonnageGraphic(combat.alex());
		ryan  = new PersonnageGraphic(combat.ryan());
		slick = new GangsterGraphic(combat.slick());
		for(int i = 0; i < 10; i++){
			GangsterGraphic g = new GangsterGraphic(combat.gangsters().get(i));
			gangsters.add(g);
			this.add(g);
		}
		this.add(slick);
		this.add(alex);
		this.add(ryan);

		this.add(terrain);


		try {
			terrain.init(500, 500, 500);
			terrain.setSize(500,500);
			alex.init("Alex", 30, 30, 30, 10, 500, 10);
			ryan.init("Ryan", 30, 30, 30, 10, 500, 10);
			slick.init("Slick", 40, 40, 40, 20, 200);
			for(GangsterGraphic g : gangsters){
				g.init("noname", 30, 30, 30, 10, 50);
				g.setSize(g.gangster.largeur(),g.gangster.profondeur());
				g.setLocation(posX(g.gangster)-g.largeur()/2, posY(g.gangster)-g.profondeur()/2);
			}
			alex.setSize(alex.largeur(), alex.profondeur());
			ryan.setSize(ryan.largeur(), ryan.profondeur());
			slick.setSize(slick.largeur(), slick.profondeur());

			alex.setLocation(posX(combat.alex())-alex.largeur()/2,posY(combat.alex())-alex.profondeur()/2);

			ryan.setLocation(posX(combat.ryan())-ryan.largeur()/2,posY(combat.ryan())-ryan.profondeur()/2);
		
			slick.setLocation(posX(combat.slick())-slick.largeur()/2,posY(combat.slick())-slick.profondeur()/2);
			this.repaint();

		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PostConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		majInfos();

	}

	public void majInfos(){
		String info = "";

		info +=alex.nom()+": \n"+combat.alex().pointsDeVie()+" pdv \n";
		info +=alex.force()+" force \n";
		info +=alex.argent()+"$\n";
		info+="est equipe de : ";
		if(alex.estEquipeObjet())
			info+=alex.objetEquipe().nom();
		else if(alex.estEquipePerso())
			info+=alex.persoEquipe().nom();
		else
			info+="rien";
		info+="\n";
		try {
			info+="Position :"+posX(combat.alex())+","+posY(combat.alex());
			info+="\nSur le bloc :"+posX(combat.alex())/50+","+posY(combat.alex())/50;
			info+="("+combat.terrain().bloc(posX(combat.alex()), posY(combat.alex())).type()+")";
		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(GangsterGraphic g : gangsters){
			try {
				if(collision(combat.alex(),g.gangster))
					info+="\nCollision avec "+g.nom();
			} catch (PreconditionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if(collision(combat.alex(),combat.slick())){
				info+="\nCollision avec "+slick.nom();
			}
		} catch (PreconditionError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if(terrain.bloc(posX(combat.alex()), posY(combat.alex())).type() == TypeBloc.OBJET)
				info+="\n *Alex est sur un objet : "+terrain.bloc(posX(combat.alex()), posY(combat.alex())).objet().nom()+" *";
		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		info +="\n\n"+ryan.nom()+": \n"+combat.ryan().pointsDeVie()+" pdv \n";
		info +=ryan.force()+" force \n";
		info +=ryan.argent()+"$\n";
		info+="est equipe de : ";
		if(ryan.estEquipeObjet())
			info+=ryan.objetEquipe().nom();
		else if(ryan.estEquipePerso())
			info+=ryan.persoEquipe().nom();
		else
			info+="rien";
		info+="\n";
		try {
			info+="Position :"+posX(combat.ryan())+","+posY(combat.ryan());
			info+="\nSur le bloc :"+posX(combat.ryan())/50+","+posY(combat.ryan())/50;
			info+="("+combat.terrain().bloc(posX(combat.ryan()), posY(combat.ryan())).type()+")";
		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(GangsterGraphic g : gangsters){
			try {
				if(collision(combat.ryan(),g.gangster))
					info+="\nCollision avec "+g.nom();
			} catch (PreconditionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if(collision(combat.ryan(),combat.slick())){
				info+="\nCollision avec "+slick.nom();
			}
		} catch (PreconditionError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if(terrain.bloc(posX(combat.ryan()), posY(combat.ryan())).type() == TypeBloc.OBJET)
				info+="\n *Ryan est sur un objet : "+terrain.bloc(posX(combat.ryan()), posY(combat.ryan())).objet().nom()+" *";
		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		infos.setText(info);
	}


}
