package ds4eti2018_2S.modele.comportements;

public class CmpEco extends ComportementConcret {

	@Override
	public double getPrix(int km) {
		return km*0.1;
	}

	@Override
	public int getDelai() {
		return 3;
	}

}
