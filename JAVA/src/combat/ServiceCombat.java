package combat;

import gangster.GangsterService;
import moteur.Commande;
import perso.PersonnageService;

public interface ServiceCombat {

	public PersonnageService alex();
	public PersonnageService ryan();
	public GangsterService slick();
	public GangsterService gangsters();
	// \pre positionX(id) require id == "alex" || id == "ryan" || id == "slick" || id \in gansgtersid  
	public int positionX(String id);
	// \pre positionY(id) require id == "alex" || id == "ryan" || id == "slick" || id \in gansgtersid  
	public int positionY(String id);
	// \pre positionZ(id) require id == "alex" || id == "ryan" || id == "slick" || id \in gansgtersid  
	public int positionZ(String id);
	public boolean estGele(String id);
	public boolean estFrappe(String id);
	// \pre collision(id1,id2) require (id1 == "alex" && id2 = 'ryan') || (id1 == "ryan" && id2 = "alex") || ...
	public boolean collision(String id1, String id2);
	
	public void gerer(Commande c1, Commande c2);
	
	// \post init() : terrain() == TerrainService.init(255,255,255) && alex() == Personnage.init("alex", ...)
	
	public void init();
}
