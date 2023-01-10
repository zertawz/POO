package ds4eti2019_2S.model.documents;

public abstract class AbstractDocument implements DocumentConsultable, Cloneable {

	private int numISBN;
	private int numExemplaire;
	private String titre;
	private String auteur;
	private boolean disponible;
	
	public AbstractDocument(int numISBN, String titre, String auteur) {
		setNum(numISBN);
		this.titre = titre;
		this.auteur = auteur;
		disponible = true;
	}
	


	public AbstractDocument(int numISBN, String titre) {
		this(numISBN, titre, "inconnu");
	}
	
	private void setNum(int numISBN) {
		this.numISBN=0;
		if(numISBN>0 && numISBN<10000) {
			this.numISBN = numISBN;
		}
	}
	
	@Override
	public boolean consulter() {
		boolean retour = false;
		if(isDisponible()) {
			disponible=false;
			retour= true;
		}
		return retour;
	}

	private boolean isDisponible() {
		return disponible;
	}

	@Override
	public int getISBN() {
		return numISBN;
	}
	
	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setNumExemplaire(int num) {
		numExemplaire = num;
	}

	@Override
	public int compareTo(DocumentConsultable o) {
		return o.getISBN()-getISBN();
	}
	
	public String toString() {
		return titre+", auteur: "+auteur+", num: "+numISBN;
	}
	
	public abstract AbstractDocument clone();



	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numExemplaire;
		result = prime * result + numISBN;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractDocument other = (AbstractDocument) obj;
		if (numExemplaire != other.numExemplaire)
			return false;
		if (numISBN != other.numISBN)
			return false;
		return true;
	}

}
