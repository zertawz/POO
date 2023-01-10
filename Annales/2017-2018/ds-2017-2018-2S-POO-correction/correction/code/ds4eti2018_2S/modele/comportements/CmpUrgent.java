package ds4eti2018_2S.modele.comportements;

public class CmpUrgent extends ComportementConcret {

	private static final double prixZ1 = 0.5;
	private static final double prixZ2 = 1;
	private static final int zone1 = 30;

	@Override
	public double getPrix(int km) {
		double prix = 0;
		if(km<zone1){
			prix=km*prixZ1;
		}
		else{
			prix=km*prixZ2;
		}
		return prix;
	}

	@Override
	public int getDelai() {
		return 1;
	}

}
