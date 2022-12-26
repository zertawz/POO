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
		age = 12;
		id = Animal.getUniqueId();
		this.sexe=sexe;
		this.coord=new Point(coord);
	}
	
	public Animal(Sexe sexe) {
		 this(sexe, new Point(0,0));
	}
	
	public Animal() {
		 this(Sexe.Femelle);
	}
	
	/*
	 *  Accesseurs et mutateurs
	 */
	//getter age
	public int getAge(){
		return this.age;
	}
	//setter age
	public void setAge(int nouvelAge){
		if (nouvelAge>=age){
			this.age=nouvelAge;
		}
	}
	//getter de id
	public int getId(){
		return this.id;
	}
	//getter de sexe
	public Sexe getSexe(){
		return this.sexe;
	}
	//getter de coord
	public Point getCoord(){
		return this.coord;
	}
	/*
	 * Redéfinitions de méthodes d'object
	 */
	//TODO
	
	/* 
	 * comportements d'instance
	 */
	
	
	public void seDeplacer() {
		//TODO utiliser Math.random() pour choisir une direction de déplacement
	}
	
	public void vieillir() {
		//TODO fait vieillir l'animal d'une unité de temps
		//une bonne manière de faire, une moins bonne...
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
		return 0;
	}
	
	public static void main(String args[]) {
		//tests unitaires de la classe Animal
		//TODO décommentez les lignes pour approfondir le test unitaire
		//complétez la méthode pour tester les nouvelles fonctionnalités que vous allez implémenter
		Animal a = new Animal();
		Animal b = new Animal(Sexe.Male);
		Animal c = new Animal(Sexe.Assexue);
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
		System.out.println(c);
		System.out.println(d);
		
		System.out.println("*** Getters et setters **********");
		
		System.out.println(d.getSexe());
		Sexe ss = d.getSexe();
		//pas compris cette ligne et ce test
		ss=Sexe.Male;
		System.out.println(d.getSexe());
		//test perso
		d.Sexe=d.Sexe.Male;
		System.out.println(d.getSexe());
		
		//les lignes suivantes devraient afficher la même chose....
		System.out.println(d.getCoord());
		Point pt = d.getCoord();
		pt.x=50;
		System.out.println(d.getCoord());
		
		//TODO ajoutez vos propres tests de getters et setters
		//test de l'age
		System.out.println("Test perso XD");
		//les deux fonctionnent car on test depuis le main de cette classe.
		System.out.println(a.age);
		System.out.println(a.getAge());
		
		a.age=5;
		System.out.println(a.getAge());
		//devrait empêcher de passer en dessous de 5
		a.setAge(2);
		System.out.println(a.getAge());
		
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
