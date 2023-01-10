package ds4eti2019_2S.model.documents;

public interface DocumentEmpruntable extends DocumentConsultable {
	public boolean emprunter(int duree);
	public boolean restituer(int duree);
	public boolean declarerPerte();
}
