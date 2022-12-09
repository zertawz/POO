package tp.model.agents;

import java.awt.Point;

public abstract class Agent {
	
	// ===================== ATTRIBUTES ===========================

	//--------- CLASS -----------------
	private static int currentId = 0;
	
	//--------- INSTANCE --------------
	/** identifiant unique de l'animal*/
	protected int id;
	
	
	
	/** position sur la carte*/
	protected Point coord;
	
	
	
	// ===================== CONSTRUCTOR ===========================
		public Agent() {
			this(new Point(0,0));
		}
		
		public Agent(Point coord) {
			this.id = Agent.getUniqueId();
			this.coord = coord;
		}

	// ================= GETTER SETTER ====================
	
	/**
	 * Renvoie un identifiant unique non encore utilisé
	 * @return un identifiant entier unique d'animal
	 */
	protected static int getUniqueId() {
		return currentId++;
	}
	
	
	// ------------------------------------

	public int getId() {
		return id;
	}

	// ------------------------------------
	
	
	// ===================== OVERRIDE ===========================

	@Override
	public String toString() {
		return String.format("%s %d(%d;%d)", getClass().getName(), this.id, this.coord.x, this.coord.y);
	}	
	
	// ===================== METHODS ===========================

	
	final public void cycle() {
		this.vieillir();
		this.seDeplacer();
		this.seNourrir();
		this.updateStats();
	}
	
	protected abstract void vieillir();

	protected abstract void updateStats();

	protected abstract void seNourrir();

	protected abstract void seDeplacer();
	
	public abstract void rencontrer(Animal a);

}