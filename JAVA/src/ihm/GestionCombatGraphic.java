package ihm;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterImpl;
import gangster.GangsterService;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import moteur.Commande;
import objet.ObjetService;
import perso.PersonnageImpl;
import perso.PersonnageService;
import terrain.TerrainImpl;
import terrain.TerrainService;
import bloc.TypeBloc;
import combat.CombatService;

public class GestionCombatGraphic extends JPanel implements CombatService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TerrainGraphic terrain; 
	PersonnageGraphic alex;
	GangsterGraphic slick;
	List<GangsterService> gangsters;
	JTextArea infos;
	public GestionCombatGraphic(){

		this.setSize(800, 600);
		infos = new JTextArea("INFOS");


		this.setLayout(null);
		infos.setLocation(510, 10);
		infos.setSize(260, 300);
		this.add(infos);
		gangsters = new ArrayList<GangsterService>();
		for(int i = 0; i < 10; i++){
			gangsters.add(new GangsterGraphic(new GangsterImpl()));
		}
	}
	@Override
	public PersonnageService alex() {
		// TODO Auto-generated method stub
		return alex;
	}

	@Override
	public PersonnageService ryan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GangsterService slick() {
		// TODO Auto-generated method stub
		return slick;
	}

	@Override
	public List<GangsterService> gangsters() {
		// TODO Auto-generated method stub
		return gangsters;
	}

	@Override
	public int posX(PersonnageService p) throws PreconditionError {
		// TODO Auto-generated method stub
		return ((Component) p).getLocation().x;
	}

	@Override
	public int posZ(PersonnageService p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int posY(PersonnageService p) {
		// TODO Auto-generated method stub
		return ((Component) p).getLocation().y;
	}

	@Override
	public boolean estGele(PersonnageService p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean estFrappe(PersonnageService p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean collision(PersonnageService p1, GangsterService p2) throws PreconditionError {

		return estVisible(p1) && estVisible(p2) && collisionDerriere(p1, p2) && collisionDessous(p1, p2) && collisionDessus(p1, p2) && collisionDevant(p1, p2) && collisionDroite(p1, p2) && collisionGauche(p1, p2);
	}

	public void deplacer(PersonnageGraphic p, Commande c) throws PreconditionError, PostConditionError, InvariantError{

		switch(c){
		case DROITE : 	
			p.setLocation(Math.min(posX(p)+10, terrain.largeur()-p.largeur()), posY(p));
			break;
		case GAUCHE:

			p.setLocation(Math.max(0, posX(p)-10), posY(p));

			break;
		case HAUT : 
			p.setLocation(posX(p),Math.max(posY(p)-10, 0));
			break;
		case BAS :
			p.setLocation(posX(p),Math.min(posY(p)+10, terrain.profondeur()-p.profondeur()));
			break;
		case RAMASSER :
			if(terrain.bloc(posX(p), posY(p)).type() == TypeBloc.OBJET){
				if(!p.estVaincu()){
					ObjetService objet = terrain.bloc(posX(p), posY(p)).objet();
					if(objet.estEquipable() && !p.estEquipeObjet() && !p.estEquipePerso())
						terrain.bloc(posX(p), posY(p)).retirerObjet();
					else if(terrain.bloc(posX(p), posY(p)).objet().estDeValeur())
						terrain.bloc(posX(p), posY(p)).retirerObjet();
					p.ramasserObjet(objet);
				}
			}

			for(GangsterService g : gangsters){
				try {
					if(collision(alex,g) && p == alex){
						alex.ramasserPerso(g);
						((Component)g).setVisible(false);

						//System.out.println("bye");
					}
				} catch (PreconditionError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if(collision(alex,slick)){
					alex.ramasserPerso(slick);
					(slick).setVisible(false);
				}
			} catch (PreconditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


			break;
		case JETER :
			if(terrain.bloc(posX(p), posY(p)).type() == TypeBloc.VIDE && p.estEquipeObjet()){

				terrain.bloc(posX(p), posY(p)).poserObjet(p.objetEquipe());

				p.jeter();
			}
			if(p.estEquipePerso()){
				Component perso = (Component) p.persoEquipe();
				
				p.jeter();
				perso.setVisible(true);
				perso.setLocation(posX(p), posY(p));
				perso.repaint();
				this.setComponentZOrder(perso, 1);

			}
			break;
		case FRAPPE :
			for(GangsterService g : gangsters){
				try {
					if(collision(alex,g) && p == alex){
						g.retraitPdV(p.force());

					}
					if(collision(alex,g) && p == g){
						alex.retraitPdV(p.force());
						if(collisionDroite(alex, g))
							alex.setLocation(Math.max(0,posX(alex)-16), posY(p));
						else if(collisionGauche(alex, g))
							alex.setLocation(Math.min(posX(alex)+16,terrain.largeur()), posY(p));
						else if(collisionDevant(alex, g))
							alex.setLocation(posX(alex), Math.max(0,posY(p)-16));
						else if(collisionDerriere(alex, g))
							alex.setLocation(posX(alex), Math.min(posY(p)+16,terrain.profondeur()));

					}
				} catch (PreconditionError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				if(collision(alex,slick) && p == alex)
					slick.retraitPdV(p.force());
				if(collision(alex,slick) && p == slick)
					alex.retraitPdV(p.force());
			} catch (PreconditionError e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		default:
			break;
		}


		if(terrain.bloc(posX(p), posY(p)).type() == TypeBloc.FOSSE){
			p.retraitPdV(p.pointsDeVie());
		}
		p.repaint();
		majInfos();
		majVisibles();
	}

	@Override
	public void gerer(Commande c1, Commande c2) throws PreconditionError, InvariantError, PostConditionError {
		// TODO Auto-generated method stub
		if(!alex.estVaincu())
			deplacer(alex,c1);
		for(GangsterService g : gangsters){
			if(!g.estVaincu() && estVisible(g)){
				Random random = new Random();  

				Commande randomCom = Commande.values()[random.nextInt(Commande.values().length)];
				deplacer((PersonnageGraphic) g,randomCom);
			}
		}
		if(!slick.estVaincu()){
			Random random = new Random();  

			Commande randomCom = Commande.values()[random.nextInt(Commande.values().length)];
			deplacer(slick,randomCom);
		}
	}




	private void majVisibles() {
		for(GangsterService g: gangsters){
			if(g.estVaincu() && ((Component)g).isVisible()) {
				((Component)g).setVisible(false);
			}
		}
		if(slick.estVaincu() && slick.isVisible()) slick.setVisible(false);
		if(alex.estVaincu()) alex.setVisible(false);

	}
	@Override
	public void init(){
		// TODO Auto-generated method stub
		terrain = new TerrainGraphic(new TerrainImpl());
		alex = new PersonnageGraphic(new PersonnageImpl());
		slick = new GangsterGraphic(new GangsterImpl());

		this.add(alex);
		this.add(terrain);
		this.add(slick);

		try {
			terrain.init(500, 500, 500);

		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PostConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			alex.init("Alex", 30, 30, 30, 10, 500, 10);
			slick.init("Slick", 30, 30, 30, 20, 200);
			int randy;
			Random rand = new Random();
			slick.setLocation(terrain.largeur()-50, 100);
			do{
				randy = rand.nextInt(terrain.profondeur()/50)*50;

				((Component) slick).setLocation(terrain.profondeur()-50,randy);
			}while(terrain.bloc(terrain.profondeur()/50,randy).type() != TypeBloc.VIDE);
			this.setComponentZOrder(slick, 1);
			for(GangsterService g : gangsters){
				g.init("noname", 30, 30, 30, 10, 100);
				Random rand1 = new Random();
				int randx, randy1;
				do{
					randx = rand1.nextInt(terrain.largeur()/50)*50;
					randy1 = rand1.nextInt(terrain.profondeur()/50)*50;
					((Component) g).setLocation(randx,randy1);
				}while(terrain.bloc(randx,randy1).type() != TypeBloc.VIDE);
				this.add((Component) g);
				this.setComponentZOrder((Component) g, 1);
			}

			majInfos();
		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvariantError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PostConditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void majInfos(){
		String info = "";

		info +=alex.nom()+": \n"+alex.pointsDeVie()+" pdv \n";
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
			info+="Position :"+posX(alex)+","+posY(alex);
			info+="\nSur le bloc :"+posX(alex)/50+","+posY(alex)/50;
		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(GangsterService g : gangsters){
			try {
				if(collision(alex,g))
					info+="\nCollision avec "+g.nom();
			} catch (PreconditionError e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if(collision(alex,slick)){
				info+="\nCollision avec "+slick.nom();
			}
		} catch (PreconditionError e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if(terrain.bloc(posX(alex), posY(alex)).type() == TypeBloc.OBJET)
				info+="\n *Alex est sur un objet : "+terrain.bloc(posX(alex), posY(alex)).objet().nom()+" *";
		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		infos.setText(info);
	}

	@Override
	public TerrainService terrain() {
		// TODO Auto-generated method stub
		return this.terrain();
	}
	@Override
	public boolean estVisible(PersonnageService p) {
		// TODO Auto-generated method stub
		return ((Component)p).isVisible();
	}
	@Override
	public boolean collisionGauche(PersonnageService p1, GangsterService p2) throws PreconditionError {
		// TODO Auto-generated method stub
		int d = p1.largeur()/2 + p2.largeur()/2;
		int diff = (posX(p2) - posX(p1));

		return diff >= -d && diff <= d +1;
	}
	@Override
	public boolean collisionDroite (PersonnageService p1, GangsterService p2) throws PreconditionError {
		// TODO Auto-generated method stub
		int d = p1.largeur()/2 + p2.largeur()/2;
		int diff = (posX(p1) - posX(p2));
		return diff >= -d && diff <= d +1;

	}
	@Override
	public boolean collisionDessous(PersonnageService p1, GangsterService p2) throws PreconditionError {
		// TODO Auto-generated method stub
		int d = p1.hauteur()/2 + p2.hauteur()/2;
		int diff = (posZ(p1) - posZ(p2));

		return diff >= -d && diff <= d +1;
	}
	@Override
	public boolean collisionDessus(PersonnageService p1, GangsterService p2) throws PreconditionError {
		// TODO Auto-generated method stub
		int d = p1.hauteur()/2 + p2.hauteur()/2;
		int diff = (posZ(p2) - posZ(p1));

		return diff >= -d && diff <= d +1;
	}
	@Override
	public boolean collisionDevant(PersonnageService p1, GangsterService p2) throws PreconditionError {
		// TODO Auto-generated method stub
		int d = p1.profondeur()/2 + p2.profondeur()/2;
		int diff = (posY(p1) - posY(p2));
		return diff >= -d && diff <= d +1;
	}
	@Override
	public boolean collisionDerriere(PersonnageService p1, GangsterService p2) throws PreconditionError {
		// TODO Auto-generated method stub
		int d = p1.profondeur()/2 + p2.profondeur()/2;
		int diff = (posY(p2) - posY(p1));
		return diff >= -d && diff <= d +1;
	}
	@Override
	public Commande actionGangster(GangsterService g) {
		// TODO Auto-generated method stub
		return null;
	}



}
