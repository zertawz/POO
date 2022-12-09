package tp.model.agents;

public class Frelon extends Animal {
	
	public Frelon() {
		// TODO Auto-generated constructor stub
	}
	
	public void rencontrer(Animal a) {
		if (a instanceof Abeille) {
			a.etat = Etat.EnDetresse;
		}
	}

	public void manger(Animal a) {
		if (this.isHungry) {
			a.setEtat(Etat.Mourant);
		}
	}

	@Override
	protected void updateStats() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void seNourrir() {
		// TODO Auto-generated method stub
		
	}
}
