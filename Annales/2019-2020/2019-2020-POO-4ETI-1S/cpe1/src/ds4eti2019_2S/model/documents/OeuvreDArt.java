package ds4eti2019_2S.model.documents;

import ds4eti2019_2S.model.Mediatheque;

public class OeuvreDArt extends AbstractDocument {
	
	private int dureePretMax;

	public OeuvreDArt(int numISBN, String titre, String auteur, int dureePretMax) {
		super(numISBN, titre, auteur);
		setDureePretMax(dureePretMax);
	}

	public void setDureePretMax(int dureePretMax) {
		if(dureePretMax>=0 && dureePretMax<Mediatheque.PRET_MAX) {
			this.dureePretMax = dureePretMax;
		}
		else {
			this.dureePretMax=0;
		}
		
	}
	
	public int getDureePretMax() {
		return dureePretMax;
	}
	
	public String toString() {
		String ret = "Oeuvre d'art ("+super.toString()+", durée maximale de prêt "+dureePretMax;
		return ret;
	}

	@Override
	public OeuvreDArt clone() {
		return new OeuvreDArt(getISBN(),getTitre(),getAuteur(), dureePretMax);
	}

}
