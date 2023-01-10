package ds4eti2019_2S.model;

import java.util.Comparator;

import ds4eti2019_2S.model.documents.DocumentConsultable;

public class ComparateurTitre implements Comparator<DocumentConsultable> {

	@Override
	public int compare(DocumentConsultable o1, DocumentConsultable o2) {
		return o1.getTitre().compareTo(o2.getTitre());
	}
	
	public String toString() {
		return "TITRE";
	}

}
