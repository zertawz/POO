package ds4eti2018_2S.modele.comportements;

public class CmpFroid extends ComportementConcret {

	@Override
	public double getPrix(int km) {
		int majoration = km/100;
		return km*0.25+majoration;
	}

	@Override
	public int getDelai() {
		return 2;
	}

}
