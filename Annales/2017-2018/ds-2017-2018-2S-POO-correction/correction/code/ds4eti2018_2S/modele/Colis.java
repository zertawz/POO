package ds4eti2018_2S.modele;

import java.util.ArrayList;
import java.util.List;

import ds4eti2018_2S.modele.comportements.ComportementColis;

public class Colis implements ComportementColis{
	private static int numeroCourant = 1;
	
	private List<ComportementColis> caracteristiques = new ArrayList<ComportementColis>();
	private int numero;
	
	public Colis(List<ComportementColis> caracteristiques){
		numero = Colis.numeroCourant;
		Colis.numeroCourant++;
		this.caracteristiques = caracteristiques;
	}
	

	public boolean hasComportement(ComportementColis cc) {
		return caracteristiques.contains(cc);
	}
	
	public List<ComportementColis> getCaracteristiques() {
		return caracteristiques;
	}
	
	public String toString(){
		String info="";
		for(ComportementColis cc:caracteristiques){info+=cc+",";}
		return "Colis n°"+numero+" ("+info+")";
	}


	@Override
	public double getPrix(int km) {
		double ret=0;
		for(ComportementColis c:caracteristiques)
		{
			ret+=c.getPrix(km);
		}
		return ret*km;
	}


	@Override
	public int getDelai() {
		int ret=0;
		for(ComportementColis c:caracteristiques)
		{
			if(ret>0 && c.getDelai()<ret){ret = c.getDelai();}
			else{ret = c.getDelai();}
		}
		return ret;
	}

}
