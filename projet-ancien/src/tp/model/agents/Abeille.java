package tp.model.agents;

import tp.model.comportements.Hebergeur;

public abstract class Abeille extends Animal implements Hebergeur {

	// ================= ATTRIBUTES ===============
	
	//---------------- Instance -----------
	private int honeyLevel = 0;
	private Varroa Parasite;

	// ================= CONSTRUCTORS ===============
	
	// ================= GETTER SETTER  ===============
	
	// ================= OVERRIDE ===============
	
	// ------------------ Hebergeur --------------------------
	@Override
	public boolean peutAccueillir(Agent a) {
		return (a instanceof Varroa) && (this.Parasite == null);
	}

	@Override
	public boolean accueillir(Agent a) {
		if (this.peutAccueillir(a)) {
			return false;
		}
	
		this.Parasite = (Varroa) a;
		this.takeDamage();
		
		return true;
	}
	
	// ------------------ Animal --------------------------
	
	@Override
	public void seDeplacer() {
		super.seDeplacer();
		this.Parasite.setCoord(this.coord);
	}
	
	@Override
	public void rencontrer(Animal a) {
		
	}
	
	@Override
	public void seNourrir() {
		this.rencontrer(a);
		this.pollinate(flower);
		this.honeyLevel += 1;
	}
	
	// ================= METHODS ===============
	protected void pollinate(Fleur flower) {}
}
