package ds4eti2018_2S.modele.comportements;

public abstract class ComportementConcret implements ComportementColis, Comparable<ComportementColis> {

	public boolean equals(Object o){
		return this.getClass().equals(o.getClass());
	}
	public int hashcode(){
		return this.getClass().getSimpleName().hashCode();
	}
	
	public int compareTo(ComportementColis c){
		return this.getClass().getSimpleName().compareTo(c.getClass().getSimpleName());
	}
	
	public String toString(){return this.getClass().getSimpleName();}

}
