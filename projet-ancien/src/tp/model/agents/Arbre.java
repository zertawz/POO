package tp.model.agents;

import tp.model.comportements.Hebergeur;

public class Arbre extends Vegetal implements Hebergeur {

	private int size = 0;
	
	public Arbre() {
		// TODO Auto-generated constructor stub
		this(1);
	}
	
	public Arbre(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
	}

	@Override
	public boolean peutAccueillir(Agent a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accueillir(Agent a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void produce() {
		this.foodUnits += Math.pow(2, this.size);
	}
}
