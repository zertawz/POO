package tp.model.agents;

import java.awt.Point;
import tp.model.comportements.Hebergeur;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno
 *
 */
public abstract class Animal extends Agent {
	
	// ===================== ATTRIBUTES ===========================
	
	//--------- INSTANCE --------------
	protected boolean isHungry = false;
	protected Etat etat = Etat.Normal;
	protected Sexe sexe;
	protected int age = 0;
	
	// ===================== CONSTRUCTOR ===========================
	
	public Animal(Sexe sexe, Point coord) {
		super(coord);
		this.sexe = sexe;
	}

	public Animal(Sexe sexe) {
		/* crée un animal avec le sexe passé en paramètre, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(Sexe.Male, new Point(0,0));
	}
	
	public Animal() {
		/* crée un animal de sexe femelle, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(Sexe.Male);
	}
	
	// ================= GETTER SETTER ====================
	
	// ------------------------------------
	public int getAge() {
		return age;
	}

	protected void setAge(int age) {
		if (this.age < age) {
			this.age = age;
		}
	}
	
	// ------------------------------------
	protected Etat getEtat() {
		return this.etat;
	}
	
	protected void setEtat(Etat etat) {
		this.etat = etat;
	}
	
	//-------------------------------------
	public Sexe getSexe() {
		return sexe;
	}
	
	// ===================== OVERRIDE ===========================
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (age != other.age)
			return false;
		if (etat != other.etat)
			return false;
		if (sexe != other.sexe)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((etat == null) ? 0 : etat.hashCode());
		result = prime * result + ((sexe == null) ? 0 : sexe.hashCode());
		return result;
	}
	
	// ===================== METHODS ===========================

	public void seDeplacer() {
		//utiliser Math.random() pour choisir une direction de déplacement
		int dx = (int) (2 * Math.random() - 1);
		int dy = (int) (2 * Math.random() - 1);
		
		this.coord.x += dx;
		this.coord.y += dy;
	}
	
	public void vieillir() {
		//Fait vieillir l'animal d'une unité de temps
		//une bonne manière de faire, une moins bonne...
		this.age += 1;
	}
	

	public void takeDamage() {		
	    Etat[] states = Etat.values();
	    int i = 0;
	    for (; states[i] != this.etat; i++);
	    i = Math.min(i+1, states.length);
	    
	    this.etat =  states[i];
	}
	
	public void healOneState() {		
	    Etat[] states = Etat.values();
	    int i = 0;
	    for (; states[i] != this.etat; i++);
	    i = Math.max(i-1, 0);
	    
	    this.etat =  states[i];
	}
}
