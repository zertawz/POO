package ds4eti2019_2S.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import ds4eti2019_2S.model.documents.DocumentConsultable;

public class Mediatheque {

	public static final int PRET_MAX = 90;
	private Set<DocumentConsultable> collection;
	private String nom;
	private Map<String,Comparator<DocumentConsultable>> comparateurs;
	
	public Mediatheque(String nom, Set<DocumentConsultable> collection) {
		this.collection = collection;
		this.nom = nom;
		
		comparateurs = new HashMap<String,Comparator<DocumentConsultable>>();
		comparateurs.put("TITRE", new ComparateurTitre());
		comparateurs.put("AUTEUR", new ComparateurAuteur());
	}
	
	



	public Mediatheque(String nom) {
		this(nom, new TreeSet<DocumentConsultable>());
	}
	
	private void addComparateur(String type, Comparator<DocumentConsultable> comparateur) {
		comparateurs.put(type,comparateur);
	}

	
	public String toString() {
		String ret = "Médiathèque "+nom;
		ret+="\nNous gérons "+collection.size()+" références";
		for(DocumentConsultable doc:collection) {
			ret+="\n\t- "+doc;
		}
		return ret;
	}
	
	public Set<DocumentConsultable> documentsParTitre(){
		Set<DocumentConsultable> ret =  new TreeSet<DocumentConsultable>(comparateurs.get("TITRE"));
		ret.addAll(collection);
		return ret;
	}
	
	public Set<DocumentConsultable> documentsParAuteur(){
		Set<DocumentConsultable> ret =  new TreeSet<DocumentConsultable>(comparateurs.get("AUTEUR"));
		ret.addAll(collection);
		return ret;
	}
	
	public List<DocumentConsultable> documentsParTitre2(){
		List<DocumentConsultable> ret = new ArrayList<DocumentConsultable>();
		ret.addAll(collection);
		ret.sort(comparateurs.get("TITRE"));
		return ret;
	}
	
	public List<DocumentConsultable> documentsParAuteur2(){
		List<DocumentConsultable> ret = new ArrayList<DocumentConsultable>();
		ret.addAll(collection);
		ret.sort(comparateurs.get("AUTEUR"));
		return ret;
	}
	
	public Map<String, Comparator<DocumentConsultable>> getComparators(){
		return comparateurs;
	}
	
	public List<DocumentConsultable> trier(String clef){
		List<DocumentConsultable> ret = new ArrayList<DocumentConsultable>();
		ret.addAll(collection);
		if(comparateurs.containsKey(clef)) {
			ret.sort(comparateurs.get(clef));
		}
		else {
			Collections.sort(ret);
		}
		return ret;
	}

}
