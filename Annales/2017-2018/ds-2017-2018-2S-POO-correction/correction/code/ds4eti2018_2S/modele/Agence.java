package ds4eti2018_2S.modele;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ds4eti2018_2S.modele.comportements.ComportementColis;
import ds4eti2018_2S.modele.transport.MoyenTransport;

public class Agence {
	private String nom;
	private String ville;
	private Set<ComportementColis> comportementsPossibles = new TreeSet<ComportementColis>();
	private List<MoyenTransport> transports;
	
	private List<Colis> lesColis = new ArrayList<Colis>();
	
	public Agence(String nom, String adresse, List<MoyenTransport> transports){
		this.nom=nom;
		this.ville=adresse;
		this.transports=transports;
		if(transports!=null){majComportements();}
	}
	

	public Agence(String nom, String adresse){
		this(nom, adresse, null);
		transports = new ArrayList<MoyenTransport>();
	}

	private void majComportements() {
		for(MoyenTransport m:transports){
			comportementsPossibles.addAll(m.getComportementsGeres());
		}
		
	}
	
	public boolean addColis(Colis c){
		boolean ok=true;
		Iterator<ComportementColis> it = c.getCaracteristiques().iterator();
		while(ok && it.hasNext()){
			if(!comportementsPossibles.contains(it.next())){
				ok=false;
			}
		}
		if(ok){lesColis.add(c);}
		return ok;
	}
	
	public void affecteChargement(){
		for(Colis c:lesColis){
			boolean trouve=false;
			Iterator<MoyenTransport> it = transports.iterator();
			while(!trouve && it.hasNext()){
				if(it.next().addColis(c)){trouve=true;}
			}
		}
	}
	
	public double calculPrix(int km){
		double prix=0;
		for(Colis c:lesColis){prix+=c.getPrix(km);}
		return prix;
	}
	
	public String toString(){
		String cmp ="";
		for(ComportementColis cc:comportementsPossibles){
			cmp+="\t"+cc+"\n";
		}
		return "Agence "+nom+ " située à "+ville+"\n"+cmp;
	}
}
