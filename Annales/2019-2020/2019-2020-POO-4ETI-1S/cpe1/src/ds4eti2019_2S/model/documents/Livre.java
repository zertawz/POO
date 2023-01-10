package ds4eti2019_2S.model.documents;

public class Livre extends AbstractDocument{

	private Genre genre;
	public Livre(int numISBN, String titre, String auteur, Genre genre) {
		super(numISBN, titre, auteur);
		this.genre=genre;
	}
	public Genre getGenre() {
		return genre;
	}
	
	public String toString() {
		String ret = "Livre ("+super.toString()+", genre: "+genre+")";
		return ret;
	}
	@Override
	public Livre clone() {
		return new Livre(getISBN(), getTitre(), getAuteur(), genre);
	}

}
