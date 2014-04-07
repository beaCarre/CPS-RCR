package ihm;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterService;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.Set;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import objet.ObjetService;
import bloc.TypeBloc;
import moteur.Commande;
import perso.PersonnageImpl;
import perso.PersonnageService;
import terrain.TerrainImpl;
import terrain.TerrainService;
import combat.CombatService;

public class GestionCombatGraphic extends JPanel implements CombatService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TerrainGraphic terrain; 
	PersonnageGraphic alex;
	JTextArea infos;
	public GestionCombatGraphic(){

		this.setSize(800, 600);
		infos = new JTextArea("INFOS");


		this.setLayout(null);
		infos.setLocation(510, 10);
		infos.setSize(260, 300);
		this.add(infos);
	}
	@Override
	public PersonnageService alex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonnageService ryan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GangsterService slick() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<GangsterService> gangsters() {
		// TODO Auto-generated method stub
		return null;
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
			alex.jeter();


			break;
		default:
			break;
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
		this.add(alex);
		this.add(terrain);

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

		infos.setText(info);
	}

	@Override
	public TerrainService terrain() {
		// TODO Auto-generated method stub
		return null;
	}



}
