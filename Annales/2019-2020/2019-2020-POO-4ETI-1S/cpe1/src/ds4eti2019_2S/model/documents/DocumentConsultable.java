package ds4eti2019_2S.model.documents;

public interface DocumentConsultable extends Comparable<DocumentConsultable>{
	public boolean consulter();
	public int getISBN();
	public String getTitre();
	public String getAuteur();
	public void setNumExemplaire(int num);
}
