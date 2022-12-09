package tp.model.agents;

public class FrelonAsiatique extends Frelon{

	public void rencontrer(Animal a) {
		if (a instanceof FrelonEuropeen) {
			this.etat = Etat.EnDetresse;
		}
	}
	
	public FrelonAsiatique() {
		// TODO Auto-generated constructor stub
	}

}
