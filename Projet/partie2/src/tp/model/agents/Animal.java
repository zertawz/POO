package tp.model.agents;
import java.awt.Point;

/**
 * Cette classe modélise un Animal dans la simulation
 * @author bruno
 *
 */
public class Animal extends Agent{
	/* attributs d'instance*/
	/** état de santé de l'animal */
	private Etat etat=Etat.Normal;
	private Sexe sexe;
	
	/* 
	 * constructeurs 
	 */
	public Animal(Sexe sexe, Point coord) {
		super(coord);
		setAge(0);
		this.sexe=sexe;
		setCoord(coord);
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
	//getter de sexe
	public Sexe getSexe(){
		return this.sexe;
	}
	
	/* 
	 * comportements d'instance
	 */
	public void seDeplacer() {
		//on génère un déplacement aléatoire en x et en y
		double dx = Math.round((Math.random()*3)-1.5);
		double dy = Math.round((Math.random()*3)-1.5);
		//On traite les cas extremes ou on peut se retrouver avec un 2
		if (dx==2 || dy==2){
			if (dx==2){
				dx=1;
			}
			else{
				dy=1;
			}
		}
		if (dx==-2 || dy==-2){
			if (dx==-2){
				dx=-1;
			}
			else{
				dy=-1;
			}
		}
		//affichage simple
		System.out.println("Les déplacements sont: " + dx + " et " + dy);
		//On récup les coordonnées
		Point pointActuel = getCoord();
		//On modifie les coordonnées
		pointActuel.x += dx;
		pointActuel.y += dy;
	}
	
	public void vieillir() {
		int a;
		a = getAge();
		a += 1;
		setAge(a);
	}
	
	public void rencontrer(Animal a) {
		//TODO
	}
	
	
	@Override
	public String toString(){
		return getClass() + " n°" + getId() + "(" + getSexe() + ", " + getCoord() + ")";
	}
	
	//Meme si les instances de Animal sont des objets le type objet n'a pas les méthodes utilisées pour les tests.
	@Override
	//On override seulement la méthode equals() de animal et de ces sous classes (pas celle de object())
	public boolean equals(Object obj){
		//Si c'est une instance d'animal il faut la caster
		if (obj instanceof Animal){
			Animal o = (Animal) obj;
			if(getAge()==o.getAge() && getSexe()==o.getSexe() && etat==o.etat){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		Animal a = new Animal();
		Animal b = new Animal(Sexe.Male);
		Animal c = new Animal(Sexe.Assexue);
		Animal d = new Animal(Sexe.Femelle,new Point(25,30));
		Animal e = new Animal(Sexe.Femelle,new Point(25,30));
		
		/*
		 * les lignes suivantes doivent afficher à terme: NomDeLaClasse n° id_animal(sexe, (position x; position y)).
		 * ex: 28 (FEMELLE, (25;30))
		 */
		System.out.println("*** Animaux créés: ***");
		System.out.println(a);
		System.out.println(a.toString());
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		System.out.println("*** Getters et setters ***");
		System.out.println(d.getSexe());
		Sexe ss = d.getSexe();
		//pas compris cette ligne et ce test
		ss=Sexe.Male;
		System.out.println(d.getSexe());
		//test perso
		d.sexe=Sexe.Male;
		System.out.println(d.getSexe());
		//les lignes suivantes devraient afficher la même chose....
		System.out.println(d.getCoord());
		Point pt = d.getCoord();
		pt.x=50;
		System.out.println(d.getCoord());
		
		System.out.println("Test perso XD");
		//test age
		//les deux fonctionnent car on test depuis le main de cette classe.
		System.out.println(a.getAge());
		System.out.println(a.getAge());
		//devrait empêcher de passer en dessous de 5
		a.setAge(2);
		System.out.println(a.getAge());
		//On met a 12 sans passer par le setter (On est dans la meme classe)
		System.out.println(a.getAge());
		//test id 
		//Les deux fonctionnent (On est dans la meme classe)
		System.out.println(a.getId());
		//test coords 
		System.out.println(a.getCoord());
		
		System.out.println("Test méthode vieillir");
		System.out.println("Avant de vieillir l'age de l'animal \"a\" est: " + a.getAge());
		a.vieillir();
		System.out.println("Il a vieilli, son age est de: " + a.getAge());
		System.out.println("Test méthode se déplacer");
		System.out.println("La position avant est:" + a.getCoord());
		a.seDeplacer();
		System.out.println("La position après est:" + a.getCoord());
		
		//test getUniqueID 
		System.out.println(a.getId());
		System.out.println(b.getId());
		System.out.println(c.getId());
		System.out.println(d.getId());
		
		/*
		 * Test comparaison
		 */
		System.out.println(a==a);
		System.out.println(d==e);
		System.out.println("Si la méthode equals a été défini correctement la ligne suivante devrait afficher true");
		//J'enlève un test que j'ai fait par le passé
		d.sexe=Sexe.Femelle;
		System.out.println(d);
		System.out.println(e);
		System.out.println(d.equals(e));
		System.out.println("Bonjour"=="Bonjour");
		// Il utilise la méthode equals de Object() (super.equals)
		Object toto = new Object();
		Object tata = new Object();
		System.out.println(toto.equals(tata));
		System.out.println("Bonjour".equals("Bonjour"));
	}
}
