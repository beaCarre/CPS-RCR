package ihm;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterImpl;
import gangster.GangsterService;

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
	public int positionX(PersonnageService p) throws PreconditionError {
		// TODO Auto-generated method stub
		return ((PersonnageGraphic) p).getLocation().x;
	}

	@Override
	public int positionZ(PersonnageService p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int positionY(PersonnageService p) {
		// TODO Auto-generated method stub
		return ((PersonnageGraphic) p).getLocation().y;
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
	public boolean collision(PersonnageService p1, GangsterService p2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void gerer(Commande c1, Commande c2) throws PreconditionError, InvariantError, PostConditionError {
		// TODO Auto-generated method stub
		if(!alex.estVaincu()){
			switch(c1){
			case DROITE : 
				if(terrain.largeur()-positionX(alex)-alex.largeur()>10)
					alex.setLocation(positionX(alex)+10, positionY(alex));
				else
					alex.setLocation(terrain.largeur()-alex.largeur(), positionY(alex));
				break;
			case GAUCHE:
				if(positionX(alex)>10)
					alex.setLocation(positionX(alex)-10, positionY(alex));
				else
					alex.setLocation(0, positionY(alex));

				break;
			case HAUT : 
				if(positionY(alex)>10)
					alex.setLocation(positionX(alex), positionY(alex)-10);
				else
					alex.setLocation(positionX(alex), 0);
				break;
			case BAS :
				if(terrain.profondeur()-positionY(alex)-alex.profondeur()>10)
					alex.setLocation(positionX(alex), positionY(alex)+10);
				else
					alex.setLocation(positionX(alex), terrain.profondeur()-alex.profondeur());
				break;
			case RAMASSER :
				if(terrain.bloc(positionX(alex), positionY(alex)).type() == TypeBloc.OBJET){
					if(!alex.estVaincu()){
						ObjetService objet = terrain.bloc(positionX(alex), positionY(alex)).objet();
						if(objet.estEquipable() && !alex.estEquipeObjet() && !alex.estEquipePerso())
							terrain.bloc(positionX(alex), positionY(alex)).retirerObjet();
						else if(terrain.bloc(positionX(alex), positionY(alex)).objet().estDeValeur())
							terrain.bloc(positionX(alex), positionY(alex)).retirerObjet();
						alex.ramasserObjet(objet);
					}
				}

				break;
			case JETER :
				if(terrain.bloc(positionX(alex), positionY(alex)).type() == TypeBloc.VIDE)
					alex.jeter();
				break;
			default:
				break;
			}
		}

		if(terrain.bloc(positionX(alex), positionY(alex)).type() == TypeBloc.FOSSE){
			alex.retraitPdV(alex.pointsDeVie());
		}
		alex.repaint();
		majInfos();
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
			alex.init("Alex", 30, 30, 30, 10, 10, 10);
			slick.init("Slick", 30, 30, 30, 20, 20);
			int randy;
			Random rand = new Random();
			slick.setLocation(terrain.largeur()-50, 100);
			do{
				randy = rand.nextInt(terrain.profondeur()/50)*50;

				((Component) slick).setLocation(terrain.profondeur()-50,randy);
			}while(terrain.bloc(terrain.profondeur()/50,randy).type() != TypeBloc.VIDE);
			this.setComponentZOrder(slick, 1);
			for(GangsterService g : gangsters){
				g.init("noname", 30, 30, 30, 10, 10);
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
			info+="Position :"+positionX(alex)+","+positionY(alex);
			info+="\nSur le bloc :"+positionX(alex)/50+","+positionY(alex)/50;
		} catch (PreconditionError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		info+="\nCollision = ";
		try {
			if(terrain.bloc(positionX(alex), positionY(alex)).type() == TypeBloc.OBJET)
			info+="\n *Alex est sur un objet : "+terrain.bloc(positionX(alex), positionY(alex)).objet().nom()+" *";
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
		return false;
	}
	@Override
	public boolean collisionGauche(PersonnageService p1, GangsterService p2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean collisionDroite(PersonnageService p1, GangsterService p2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean collisionDessous(PersonnageService p1, GangsterService p2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean collisionDessus(PersonnageService p1, GangsterService p2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean collisionDevant(PersonnageService p1, GangsterService p2) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean collisionDerriere(PersonnageService p1, GangsterService p2) {
		// TODO Auto-generated method stub
		return false;
	}



}
