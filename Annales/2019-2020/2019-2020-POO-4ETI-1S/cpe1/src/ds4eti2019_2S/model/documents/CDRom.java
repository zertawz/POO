package ds4eti2019_2S.model.documents;

public class CDRom extends AbstractDocument {
	
	private int duree;

	public CDRom(int numISBN, String titre, String auteur, int duree) {
		super(numISBN, titre, auteur);
		this.duree = duree;
	}
	
	public String toString() {
		String ret = "CD-ROM ("+super.toString()+", durée "+duree;
		return ret;
	}

	@Override
	public CDRom clone() {
		return new CDRom(getISBN(), getTitre(), getAuteur(), duree);
	}

}
