package tp.model.agents;

public abstract class Vegetal extends Agent{

	protected int foodUnits = 0;
	
	public Vegetal() {
		super();
	}

	protected abstract void produce();
	
	@Override
	protected void updateStats() {
		// TODO Auto-generated method stub
		this.produce();
	}

	@Override
	protected void seNourrir() {}

	@Override
	protected void seDeplacer() {}

}
