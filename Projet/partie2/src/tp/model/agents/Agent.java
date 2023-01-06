package tp.model.agents;
import java.awt.Point;

public class Agent {
	/* attributs de classe */
	private static int currentId = 0;
	/* attributs d'instance*/
	/** identifiant unique de l'animal*/
	private int id;
	/** age en unité de temps*/
	private int age;
	/** position sur la carte*/
	private Point coord;
	/**Statut de faim de l'agent**/
	private boolean faim;
	
	/*
	 * constructeurs
	 */
	//Ne sert pas a grand chose...
	public Agent(){
		this(new Point(0,0));
	}
	
	public Agent(Point coord){
		this.coord=new Point(coord);
		faim = false;
		id = Animal.getUniqueId();
	}
	
	/* comportements de classe */ 
	private static int getUniqueId() {
		currentId++;
		return currentId;
	}
}
