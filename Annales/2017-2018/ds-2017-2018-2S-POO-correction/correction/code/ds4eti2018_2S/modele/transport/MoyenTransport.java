package ds4eti2018_2S.modele.transport;

import java.util.ArrayList;
import java.util.List;

import ds4eti2018_2S.modele.Colis;
import ds4eti2018_2S.modele.comportements.ComportementColis;

public class MoyenTransport {
	private List<ComportementColis> comportementsGeres = new ArrayList<ComportementColis>();
	private String immatriculation;
	private List<Colis> chargement = new ArrayList<Colis>();
	
	public MoyenTransport(String immatriculation, List<ComportementColis> cmp){
		this.immatriculation = immatriculation;
		comportementsGeres = cmp;
	}
	
	public boolean addColis(Colis c){
		boolean ret = false;
		if(comportementsGeres.containsAll(c.getCaracteristiques())){ret = chargement.add(c);}
		return ret;
	}
	
	public List<ComportementColis> getComportementsGeres(){return comportementsGeres;}
	
	public String toString(){
		String ret = "Chargement du véhicule "+immatriculation;
		for(Colis c:chargement){
			ret+="\n\t"+c;
		}
		return ret;
	}
}
