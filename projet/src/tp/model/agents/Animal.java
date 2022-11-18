package tp.model.agents;

import java.awt.Point;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno
 *
 */
public class Animal {
	/* attributs de classe */
	private static int currentId = 0;
	
	/* attributs d'instance*/
	/** identifiant unique de l'animal*/
	private int id;
	/** age en unité de temps*/
	private int age;
	/** position sur la carte*/
	private Point coord;
	/** état de santé de l'animal */
	private Etat etat=Etat.Normal;
	private Sexe sexe;
	
	/* 
	 * constructeurs 
	 */
	
	public Animal(Sexe sexe, Point coord) {
		age = 0;
		id = Animal.getUniqueId();
		this.sexe=sexe;
		//this.coord=coord;
		this.coord=new Point(coord);
	}
	

	public Animal(Sexe sexe) {
		//TODO
		/* crée un animal avec le sexe passé en paramètre, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(Sexe.Male, new Point(0,0));
	}
	
	public Animal() {
		//TODO
		/* crée un animal de sexe femelle, à la position (0;0), d'âge 0 et lui attribue un id unique
		 * une bonne manière de faire 
		 * en utilisant ce qui existe déjà, une moins bonne
		 */
		this(Sexe.Male);
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */
	//TODO
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (this.age < age) {
			this.age = age;
		}
	}
	
	public int getId() {
		return id;
	}

	public Sexe getSexe() {
		return sexe;
	}
	

	
	/*
	 * Redéfinitions de méthodes d'object
	 */
	//TODO
	@Override
	public String toString() {
		return String.format("%s %d(%d;%d)", getClass().getName(), this.id, this.coord.x, this.coord.y);
	}
	

	/* 
	 * comportements d'instance
	 */
	
	

	public void seDeplacer() {
		//TODO utiliser Math.random() pour choisir une direction de déplacement
		int dx = (int) (2 * Math.random() - 1);
		int dy = (int) (2 * Math.random() - 1);
		
		this.coord.x += dx;
		this.coord.y += dy;
	}
	
	public void vieillir() {
		//TODO fait vieillir l'animal d'une unité de temps
		//une bonne manière de faire, une moins bonne...
		this.age += 1;
	}
	
	public void rencontrer(Animal a) {
		//TODO
	}
	
	/* comportements de classe */ 
	/**
	 * Renvoie un identifiant unique non encore utilisé
	 * @return un identifiant entier unique d'animal
	 */
	private static int getUniqueId() {
		//TODO 
		return currentId++;
	}
	
	public static void main(String args[]) {
		//tests unitaires de la classe Animal
		//TODO décommentez les lignes pour approfondir le test unitaire
		//complétez la méthode pour tester les nouvelles fonctionnalités que vous allez implémenter
		Animal a = new Animal();
		Animal b = new Animal(Sexe.Male);
		//Animal c = new Animal(Sexe.Assexue);
		Animal d = new Animal(Sexe.Femelle,new Point(25,30));
		Animal e = new Animal(Sexe.Femelle,new Point(25,30));
		
		/*
		 * les lignes suivantes doivent afficher à terme: NomDeLaClasse n° id_animal(sexe, (position x; position y)).
		 * ex: 28 (FEMELLE, (25;30))
		 */
		System.out.println("*** Animaux créés: **********");
		System.out.println(a);
		System.out.println(a.toString());
		System.out.println(b);
		//System.out.println(c);
		System.out.println(d);
		
		System.out.println("*** Getters et setters **********");
		
		System.out.println(d.getSexe());
		Sexe ss = d.getSexe();
		ss=Sexe.Male;
		System.out.println(d.getSexe());
		
		//les lignes suivantes devraient afficher la même chose....
		/*
		System.out.println(d.getCoord());
		Point pt = d.getCoord();
		pt.x=50;
		System.out.println(d.getCoord());
		*/
		
		//TODO ajoutez vos propres tests de getters et setters
		
		//TODO test vieillir
		
		//TODO test seDeplacer
		
		//TODO test id
		/*
		System.out.println(a.getId());
		System.out.println(b.getId());
		*/
		
		/*
		 * Test comparaison
		 */
		/*
		System.out.println(d==e);
		System.out.println(d.equals(e));
		System.out.println("Bonjour"=="Bonjour");
		System.out.println("Bonjour".equals("Bonjour"));
		*/
	}

}
