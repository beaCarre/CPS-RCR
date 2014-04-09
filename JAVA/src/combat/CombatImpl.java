package combat;

import exceptions.InvariantError;
import exceptions.PostConditionError;
import exceptions.PreconditionError;
import gangster.GangsterImpl;
import gangster.GangsterService;
import ihm.ObjetGraphic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import objet.ObjetImpl;
import objet.ObjetService;
import bloc.TypeBloc;
import moteur.Commande;
import perso.PersonnageImpl;
import perso.PersonnageService;
import terrain.TerrainImpl;
import terrain.TerrainService;

public class CombatImpl implements CombatService {

	TerrainService terrain;
	PersonnageService alex;
	PersonnageService ryan;
	GangsterService slick;
	List<GangsterService> gangsters;

	HashMap<PersonnageService, Point3D> positions;
	HashMap<PersonnageService, Boolean> geles;
	HashMap<PersonnageService, Boolean> frappes;
	HashMap<PersonnageService, Boolean> visibles;

	public CombatImpl(){
		terrain = new TerrainImpl();
		alex = new PersonnageImpl();
		ryan = new PersonnageImpl();
		slick = new GangsterImpl();
		gangsters = new ArrayList<GangsterService>();
		positions = new HashMap<PersonnageService,Point3D>();
		geles = new HashMap<PersonnageService,Boolean>();
		visibles = new HashMap<PersonnageService, Boolean>();
		frappes = new HashMap<PersonnageService, Boolean>();
	}
	@Override
	public TerrainService terrain() {

		return terrain;
	}

	@Override
	public PersonnageService alex() {

		return alex;
	}

	@Override
	public PersonnageService ryan() {
		return ryan;
	}

	@Override
	public GangsterService slick() {
		return slick;
	}

	@Override
	public List<GangsterService> gangsters() {
		return gangsters;
	}

	@Override
	public int posX(PersonnageService p) throws PreconditionError {
		return positions.get(p).x;
	}

	@Override
	public int posZ(PersonnageService p) {

		return positions.get(p).z;
	}

	@Override
	public int posY(PersonnageService p) {

		return positions.get(p).y;
	}

	@Override
	public boolean estGele(PersonnageService p) {

		return geles.get(p);
	}

	@Override
	public boolean estFrappe(PersonnageService p) {

		return frappes.get(p);
	}

	@Override
	public boolean estVisible(PersonnageService p) {

		return visibles.get(p);
	}

	@Override
	public boolean collisionGauche(PersonnageService p1, GangsterService p2) 
			throws PreconditionError {

		int d = p1.largeur()/2 + p2.largeur()/2;
		int diff = (posX(p2) - posX(p1));

		return diff >= -d && diff <= d +1;
	}
	@Override
	public boolean collisionDroite (PersonnageService p1, GangsterService p2) 
			throws PreconditionError {

		int d = p1.largeur()/2 + p2.largeur()/2;
		int diff = (posX(p1) - posX(p2));
		return diff >= -d && diff <= d +1;

	}
	@Override
	public boolean collisionDessous(PersonnageService p1, GangsterService p2) 
			throws PreconditionError {

		int d = p1.hauteur()/2 + p2.hauteur()/2;
		int diff = (posZ(p1) - posZ(p2));

		return diff >= -d && diff <= d +1;
	}
	@Override
	public boolean collisionDessus(PersonnageService p1, GangsterService p2) 
			throws PreconditionError {

		int d = p1.hauteur()/2 + p2.hauteur()/2;
		int diff = (posZ(p2) - posZ(p1));

		return diff >= -d && diff <= d +1;
	}
	@Override
	public boolean collisionDevant(PersonnageService p1, GangsterService p2) 
			throws PreconditionError {

		int d = p1.profondeur()/2 + p2.profondeur()/2;
		int diff = (posY(p1) - posY(p2));
		return diff >= -d && diff <= d +1;
	}
	@Override
	public boolean collisionDerriere(PersonnageService p1, GangsterService p2)
			throws PreconditionError {

		int d = p1.profondeur()/2 + p2.profondeur()/2;
		int diff = (posY(p2) - posY(p1));
		return diff >= -d && diff <= d +1;
	}

	@Override
	public boolean collision(PersonnageService p1, GangsterService p2)
			throws PreconditionError {

		return estVisible(p1) && estVisible(p2) && collisionDerriere(p1, p2) &&
				collisionDessous(p1, p2) && collisionDessus(p1, p2) && 
				collisionDevant(p1, p2) && collisionDroite(p1, p2) && 
				collisionGauche(p1, p2);
	}

	@Override
	public void gerer(Commande c1, Commande c2) throws PreconditionError,
	InvariantError, PostConditionError {
		if(!alex.estVaincu() && !estGele(alex)){
			switch(c1){
			case DROITE :
				positions.get(alex).x = Math.min(positions.get(alex).x+10, terrain.largeur()-alex().largeur()/2);
				positions.get(alex).z = 0;
				break;
			case GAUCHE:
				positions.get(alex).x = Math.max(alex.largeur()/2,positions.get(alex).x-10);
				positions.get(alex).z = 0;
				break;
			case HAUT :
				positions.get(alex).y = Math.max(alex.profondeur()/2,positions.get(alex).y-10);
				positions.get(alex).z = 0;
				break;
			case BAS:
				positions.get(alex).y = Math.min(terrain.profondeur()-alex().profondeur()/2,positions.get(alex).y+10);
				positions.get(alex).z = 0;
				break;
			case SAUT:
				positions.get(alex).z = 100;
				break;
			case SAUTBAS:
				positions.get(alex).y = Math.max(0,positions.get(alex).y-10);
				positions.get(alex).z = 100;
				break;
			case SAUTHAUT:
				positions.get(alex).y = Math.min(positions.get(alex).y+10, terrain.profondeur()-alex().profondeur()/2);
				positions.get(alex).z = 100;
				break;
			case SAUTDROITE:
				positions.get(alex).x = Math.min(positions.get(alex).x+10, terrain.largeur()-alex().largeur()/2);
				positions.get(alex).z = 100;
				break;
			case SAUTGAUCHE:
				positions.get(alex).x = Math.max(0,positions.get(alex).x-10);
				positions.get(alex).z = 100;
				break;
			case RAMASSER:
				if(terrain.bloc(posX(alex), posY(alex)).type() == TypeBloc.OBJET){
					ObjetService o = terrain.bloc(posX(alex), posY(alex)).objet();
					if(o.estEquipable() && !alex.estEquipeObjet()){
						alex.ramasserObjet(o);
						terrain.bloc(posX(alex), posY(alex)).retirerObjet();

					}
					else if(o.estDeValeur()){
						alex.ramasserArgent(o);
						terrain.bloc(posX(alex), posY(alex)).retirerObjet();
					}

				}
				else if(collision(alex, slick) && !alex.estEquipeObjet() &&!alex.estEquipePerso()){
					alex.ramasserPerso(slick);
					visibles.put(slick, false);
				}
				else {
					for(GangsterService g : gangsters){
						if(collision(alex, g) && !alex.estEquipeObjet() && !alex.estEquipePerso()){
							alex.ramasserPerso(g);
							visibles.put(g, false);
						}
					}
				}

				break;
			case JETER:
				if(alex.estEquipeObjet() && terrain.bloc(posX(alex), posY(alex)).type() == TypeBloc.VIDE){
					terrain.bloc(posX(alex), posY(alex)).poserObjet(alex.objetEquipe());
					alex.jeter();
				}
				if(alex.estEquipePerso()){
					positions.get(alex.persoEquipe()).x = posX(alex);
					positions.get(alex.persoEquipe()).y = posY(alex);
					positions.get(alex.persoEquipe()).z = 0;
					visibles.put(alex.persoEquipe(), true);
					System.out.println("je pose "+alex.persoEquipe());
					alex.jeter();
				}

				break;
			case FRAPPE:
				if(collision(alex, slick)){
					slick.retraitPdV(alex.force());
					frappes.put(slick, true);
					//geles.put(slick, true);
					
				}
				for(GangsterService g : gangsters){
					if(collision(alex, g)){
						g.retraitPdV(alex.force());
						frappes.put(g, true);
						//geles.put(g, true);
						if(g.estVaincu()){
							visibles.put(g, false);
							ObjetService recompense = new ObjetGraphic(new ObjetImpl());
							if(terrain.bloc(posX(g),posY(g)).type() == TypeBloc.OBJET && terrain.bloc(posX(g),posY(g)).objet().estDeValeur())
								recompense.init("recompense", 0, 1000+terrain.bloc(posX(g),posY(g)).objet().valeurMarchande());
							else
								recompense.init("recompense", 0, 1000);
							terrain.bloc(posX(g),posY(g)).retirerObjet();
							terrain.bloc(posX(g),posY(g)).poserObjet(recompense);
						}
					}
				}
				break;
			default:
				break;
			}
		}
		
		if(terrain().bloc(posX(alex), posY(alex)).type() == TypeBloc.FOSSE){
			alex.retraitPdV(alex.pointsDeVie());
		}
		if(alex.estVaincu()){
			visibles.put(alex, false);
		}
		
		if(!ryan.estVaincu() && !estGele(ryan)){
			switch(c2){
			case DROITE :
				positions.get(ryan).x = Math.min(positions.get(ryan).x+10, terrain.largeur()-ryan().largeur()/2);
				positions.get(ryan).z = 0;
				break;
			case GAUCHE:
				positions.get(ryan).x = Math.max(ryan.largeur()/2,positions.get(ryan).x-10);
				positions.get(ryan).z = 0;
				break;
			case HAUT :
				positions.get(ryan).y = Math.max(ryan.profondeur()/2,positions.get(ryan).y-10);
				positions.get(ryan).z = 0;
				break;
			case BAS:
				positions.get(ryan).y = Math.min(terrain.profondeur()-ryan().profondeur()/2,positions.get(ryan).y+10);
				positions.get(ryan).z = 0;
				break;
			case SAUT:
				positions.get(ryan).z = 100;
				break;
			case SAUTBAS:
				positions.get(ryan).y = Math.max(0,positions.get(ryan).y-10);
				positions.get(ryan).z = 100;
				break;
			case SAUTHAUT:
				positions.get(ryan).y = Math.min(positions.get(ryan).y+10, terrain.profondeur()-ryan().profondeur()/2);
				positions.get(ryan).z = 100;
				break;
			case SAUTDROITE:
				positions.get(ryan).x = Math.min(positions.get(ryan).x+10, terrain.largeur()-ryan().largeur()/2);
				positions.get(ryan).z = 100;
				break;
			case SAUTGAUCHE:
				positions.get(ryan).x = Math.max(0,positions.get(ryan).x-10);
				positions.get(ryan).z = 100;
				break;
			case RAMASSER:
				if(terrain.bloc(posX(ryan), posY(ryan)).type() == TypeBloc.OBJET){
					ObjetService o = terrain.bloc(posX(ryan), posY(ryan)).objet();
					if(o.estEquipable())
						ryan.ramasserObjet(o);
					else
						ryan.ramasserArgent(o);
					terrain.bloc(posX(ryan), posY(ryan)).retirerObjet();
				}
				else if(collision(ryan, slick) && !ryan.estEquipeObjet() && !ryan.estEquipePerso()){
					ryan.ramasserPerso(slick);
					visibles.put(slick, false);
				}
				else {
					for(GangsterService g : gangsters){
						if(collision(ryan, g) && !ryan.estEquipeObjet() && !ryan.estEquipePerso()){
							ryan.ramasserPerso(g);
							visibles.put(g,false);
						}
					}
				}

				break;
			case JETER:
				if(ryan.estEquipeObjet() && terrain.bloc(posX(ryan), posY(ryan)).type() == TypeBloc.VIDE){
					terrain.bloc(posX(ryan), posY(ryan)).poserObjet(ryan.objetEquipe());
					ryan.jeter();
				}
				if(ryan.estEquipePerso()){
					positions.get(ryan.persoEquipe()).x = posX(ryan);
					positions.get(ryan.persoEquipe()).y = posY(ryan);
					positions.get(ryan.persoEquipe()).z = 0;
					visibles.put(ryan.persoEquipe(), true);
					ryan.jeter();
				}

				break;
			case FRAPPE:
				if(collision(ryan, slick)){
					slick.retraitPdV(ryan.force());
					frappes.put(slick, true);
					//geles.put(slick, true);
				}
				for(GangsterService g : gangsters){
					if(collision(ryan, g)){
						g.retraitPdV(ryan.force());
						frappes.put(g, true);
						//geles.put(g, true);
						if(g.estVaincu()){
							visibles.put(g, false);
							ObjetService recompense = new ObjetGraphic(new ObjetImpl());
							recompense.init("recompense", 0, 1000);
							terrain.bloc(posX(g),posY(g)).poserObjet(recompense);
						}
					}
				}
				break;
			default:
				break;
			}
			
		}

		if(terrain().bloc(posX(ryan), posY(ryan)).type() == TypeBloc.FOSSE){
			ryan.retraitPdV(ryan.pointsDeVie());
		}
		if(ryan.estVaincu()){
			visibles.put(ryan, false);
		}
		// slick :

		if(!slick.estVaincu() && !estGele(slick)){
			switch(actionGangster(slick)){
			case DROITE :
				positions.get(slick).x = Math.min(positions.get(slick).x+10, terrain.largeur()-slick().largeur()/2);
				positions.get(slick).z = 0;
				break;
			case GAUCHE:
				positions.get(slick).x = Math.max(slick.largeur()/2,positions.get(slick).x-10);
				positions.get(slick).z = 0;
				break;
			case HAUT :
				positions.get(slick).y = Math.max(slick.profondeur()/2,positions.get(slick).y-10);
				positions.get(slick).z = 0;
				break;
			case BAS:
				positions.get(slick).y = Math.min(terrain.profondeur()-slick().profondeur()/2,positions.get(slick).y+10);
				positions.get(slick).z = 0;
				break;
			case SAUT:
				positions.get(slick).z = 100;
				break;
			case SAUTBAS:
				positions.get(slick).y = Math.max(0,positions.get(slick).y-10);
				positions.get(slick).z = 100;
				break;
			case SAUTHAUT:
				positions.get(slick).y = Math.min(positions.get(slick).y+10, terrain.profondeur()-slick().profondeur()/2);
				positions.get(slick).z = 100;
				break;
			case SAUTDROITE:
				positions.get(slick).x = Math.min(positions.get(slick).x+10, terrain.largeur()-slick().largeur()/2);
				positions.get(slick).z = 100;
				break;
			case SAUTGAUCHE:
				positions.get(slick).x = Math.max(0,positions.get(slick).x-10);
				positions.get(slick).z = 100;
				break;
			case RAMASSER:
				if(terrain.bloc(posX(slick), posY(slick)).type() == TypeBloc.OBJET){
					ObjetService o = terrain.bloc(posX(slick), posY(slick)).objet();
					if(o.estEquipable()){
						slick.ramasserObjet(o);
						terrain.bloc(posX(slick), posY(slick)).retirerObjet();
					}

				}

				break;
			case JETER:
				if(slick.estEquipeObjet() && terrain.bloc(posX(slick), posY(slick)).type() == TypeBloc.VIDE){
					terrain.bloc(posX(slick), posY(slick)).poserObjet(slick.objetEquipe());
					slick.jeter();
				}


				break;
			case FRAPPE:
				if(collision(alex, slick)){
					alex.retraitPdV(slick.force());
					frappes.put(alex, true);
					//geles.put(alex, true);
					if(alex.estVaincu()){
						visibles.put(alex, false);

					}
				}
				else if(collision(ryan,slick)){
					ryan.retraitPdV(slick.force());
					frappes.put(ryan, true);
					//geles.put(ryan, true);
					if(ryan.estVaincu()){
						visibles.put(ryan, false);	
					}
				}

				break;
			default:
				break;
			}
		}
		if(terrain().bloc(posX(slick), posY(slick)).type() == TypeBloc.FOSSE){
			slick.retraitPdV(slick.pointsDeVie());
		}
		if(slick.estVaincu()){
			visibles.put(slick, false);
		}

		// les gangsters 

		for(GangsterService g : gangsters){
			if(!g.estVaincu() && !estGele(g)){
				switch(actionGangster(g)){
				case DROITE :
					positions.get(g).x = Math.min(positions.get(g).x+10, terrain.largeur()-g.largeur()/2);
					positions.get(g).z = 0;
					break;
				case GAUCHE:
					positions.get(g).x = Math.max(g.largeur()/2,positions.get(g).x-10);
					positions.get(g).z = 0;
					break;
				case HAUT :
					positions.get(g).y = Math.max(g.profondeur()/2,positions.get(g).y-10);
					positions.get(g).z = 0;
					break;
				case BAS:
					positions.get(g).y = Math.min(terrain.profondeur()-g.profondeur()/2,positions.get(g).y+10);
					positions.get(g).z = 0;
					break;
				case SAUT:
					positions.get(g).z = 100;
					break;
				case SAUTBAS:
					positions.get(g).y = Math.max(0,positions.get(g).y-10);
					positions.get(g).z = 100;
					break;
				case SAUTHAUT:
					positions.get(g).y = Math.min(positions.get(g).y+10, terrain.profondeur()-g.profondeur()/2);
					positions.get(g).z = 100;
					break;
				case SAUTDROITE:
					positions.get(g).x = Math.min(positions.get(g).x+10, terrain.largeur()-g.largeur()/2);
					positions.get(g).z = 100;
					break;
				case SAUTGAUCHE:
					positions.get(g).x = Math.max(0,positions.get(g).x-10);
					positions.get(g).z = 100;
					break;
				case RAMASSER:
					if(terrain.bloc(posX(g), posY(g)).type() == TypeBloc.OBJET){
						ObjetService o = terrain.bloc(posX(g), posY(g)).objet();
						if(o.estEquipable()){
							g.ramasserObjet(o);
							terrain.bloc(posX(g), posY(g)).retirerObjet();
						}

					}

					break;
				case JETER:
					if(g.estEquipeObjet() && terrain.bloc(posX(g), posY(g)).type() == TypeBloc.VIDE){
						terrain.bloc(posX(g), posY(g)).poserObjet(g.objetEquipe());

						g.jeter();
					}
					break;
				case FRAPPE:
					if(collision(alex, g)){
						alex.retraitPdV(g.force());
						frappes.put(alex, true);
						//geles.put(alex, true);
						if(alex.estVaincu()){
							visibles.put(alex, false);

						}
					}
					else if(collision(ryan,g)){
						ryan.retraitPdV(g.force());
						frappes.put(ryan, true);
						//geles.put(ryan, true);
						if(ryan.estVaincu()){
							visibles.put(ryan, false);	
						}
					}

					break;
				default:
					break;
				}
			}
			if(terrain().bloc(posX(g), posY(g)).type() == TypeBloc.FOSSE){
				g.retraitPdV(g.pointsDeVie());
			}
			if(g.estVaincu()){
				visibles.put(g, false);
			}
		}

	}

	@Override
	public void init() {


		for(int i = 0; i < 10; i++){
			gangsters.add(new GangsterImpl());
		}
		try {
			terrain.init(500,500,500);
			alex.init("Alex", 30, 30, 30, 10, 500, 10);

			positions.put(alex, new Point3D());
			visibles.put(alex, true);
			geles.put(alex, false);
			frappes.put(alex, false);

			ryan.init("Ryan", 30, 30, 30, 10, 500, 10);

			positions.put(ryan, new Point3D());
			visibles.put(ryan, true);
			geles.put(ryan, false);
			frappes.put(ryan,false);

			slick.init("Slick", 40, 40, 40, 20, 200);
			positions.put(slick, new Point3D());
			visibles.put(slick, true);
			geles.put(slick, false);
			frappes.put(slick,false);


			positions.get(ryan).x = 20;
			positions.get(ryan).y = 20;
			positions.get(alex).x = 20;
			positions.get(alex).y = terrain.largeur()-20;

			int x = terrain.largeur()-slick.largeur()-20;
			int randy;
			do{
				Random rand = new Random();
				randy = rand.nextInt(terrain.profondeur()/50)*50;
			}while(terrain.bloc(x, randy).type() != TypeBloc.VIDE);
			positions.get(slick).x = x;
			positions.get(slick).y = randy;

			for(GangsterService g : gangsters){
				g.init("noname", 30, 30, 30, 10, 50);
				positions.put(g, new Point3D());

				int randomy;
				int randomx;
				do{
					Random rand = new Random();
					randomx = rand.nextInt(terrain.largeur()/50)*50;
					randomy = rand.nextInt(terrain.profondeur()/50)*50;
				}while(terrain.bloc(randomx, randomy).type() != TypeBloc.VIDE);

				positions.get(g).x = randomx;
				positions.get(g).y = randomy;
				visibles.put(g, true);
				geles.put(g, false);
				frappes.put(g, false);
			}
		} catch (PreconditionError e) {
			e.printStackTrace();
		} catch (PostConditionError e) {
			e.printStackTrace();
		} catch (InvariantError e) {
			e.printStackTrace();
		}
	}

	@Override
	public Commande actionGangster(GangsterService g) {

		if(!g.estVaincu()){
			Random random = new Random();
			Commande randomCom = 
					Commande.values()[random.nextInt(Commande.values().length)];
			return randomCom;
		}
		return Commande.RIEN;
	}

}
