package ds4eti2019_2S.model;

import java.util.Comparator;

import ds4eti2019_2S.model.documents.DocumentConsultable;

public class ComparateurAuteur implements Comparator<DocumentConsultable> {

	@Override
	public int compare(DocumentConsultable o1, DocumentConsultable o2) {
		return o1.getAuteur().compareTo(o2.getAuteur());
	}
	
	public String toString() {
		return "AUTEUR";
	}

}
