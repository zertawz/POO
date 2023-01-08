package model.decor;

import java.awt.Point;
import java.util.HashSet;

import model.agents.Animal;
import model.agents.Sexe;
import model.agents.animaux.AbeilleDomestique;
import model.comportements.Hebergeur;

public class Ruche extends Decor implements Hebergeur{
	
	/**
	 * Liste des abeilles de la ruche 
	 */
	private static HashSet<AbeilleDomestique> population;
	/**
	 * constante taille maximale de la ruche
	 */
	private static int populationMax = 1000;
	
	public Ruche(Point p) {
		super(p);
		population = new HashSet<AbeilleDomestique>();
	}

	@Override
	public boolean peutAccueillir(Animal a) {
		return a instanceof AbeilleDomestique 
				&& population.size() < populationMax //population ok
				&& !population.contains(a); //l'abeille n'appartient pas déjà à la ruche
				 
	}

	@Override
	public boolean accueillir(Animal a) {
		boolean ret = false;
		if(peutAccueillir(a)) {
			/* Ne pas faire ça ici: c'est à l'animal de mettre à jour ses attributs
			 * a.setHebergeur(this);
			 */
			population.add((AbeilleDomestique) a);
			ret=true;
		}
		return ret;
	}
	
	public String toString() {
		String ret = getClass().getSimpleName() 
				+ " (" 
				+ (int) getCoord().getX() 
				+ ";"
				+ (int) getCoord().getY() 
				+ ") "
				+ "population " 
				+ population.size() 
				+ " abeilles"
				+ "\n";
		
		for (AbeilleDomestique a : population ) {
			ret += "\t*" + a + "\n";
		}
		
		/*
		 * "\t" code une tabulation dans une chaine de caractères
		 * "\n" un saut de ligne 
		 */
		return ret;
	}
	
	public static void main(String[] a) {
		/*
		Ruche r = new Ruche(new Point(0,0));
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Assexue, new Point(10,20),r);
		System.out.println(r);
		new AbeilleDomestique(Sexe.Femelle, new Point(5,10),r);
		System.out.println(r);
		*/
	}

	@Override
	public void supprimer(Animal a) {
		if (population.contains(a)) {
			population.remove(a);
		}
	}
}
