package ds4eti2019_2S.launcher;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ds4eti2019_2S.ui.Fenetre;
import ds4eti2019_2S.model.Mediatheque;
import ds4eti2019_2S.model.documents.CDRom;
import ds4eti2019_2S.model.documents.DocumentConsultable;
import ds4eti2019_2S.model.documents.Genre;
import ds4eti2019_2S.model.documents.Livre;
import ds4eti2019_2S.model.documents.OeuvreDArt;

public class TestModel {

	public static void main(String[] args) {
		Set<DocumentConsultable> documents = createDocumentsCollection();
		
		Mediatheque mediatheque1 = new Mediatheque("Réné Char", documents);
		System.out.println(mediatheque1);

		System.out.println("Par titre");
		Set<DocumentConsultable> docTitre = mediatheque1.documentsParTitre();
		afficheCollection(docTitre);
		
		System.out.println("Par auteur:");
		Set<DocumentConsultable> docAuteur = mediatheque1.documentsParAuteur();
		afficheCollection(docAuteur);
		
		System.out.println("Par titre 2ème technique");
		List<DocumentConsultable> docTitre2 = mediatheque1.documentsParTitre2();
		afficheCollection(docTitre2);
		
		System.out.println("Par auteur 2ème technique");
		List<DocumentConsultable> docAuteur2 = mediatheque1.documentsParAuteur2();
		afficheCollection(docAuteur2);
		
		/* Au programme de la 2ème session 2018 mais pas à la première de 2019*/
		new Fenetre("Recherche de documents", mediatheque1);
	}
	
	private static void afficheCollection(Collection<DocumentConsultable> col) {
		for(DocumentConsultable doc: col) {
			System.out.println("\t* "+doc);
		}
		
	}

	public static Set<DocumentConsultable> createDocumentsCollection() {
		Set<DocumentConsultable> ret = new HashSet<DocumentConsultable>();
		
		ret.add(new Livre(1000, "Au bonheur des dames", "Emile Zola", Genre.ROMAN));
		ret.add(new Livre(2000, "Les passagers du vent, tome 1", "Bourgeons", Genre.BANDE_DESSINEE));
		ret.add(new Livre(3000, "Le crime de l'orient express", "Agatha Christie", Genre.POLICIER));
		ret.add(new Livre(3500, "ABC contre Poirot", "Agatha Christie", Genre.POLICIER));
		ret.add(new Livre(4000, "La terre vue du ciel", "Yann Arthus Bertrand", Genre.DOCUMENTAIRE));
		
		DocumentConsultable livre = new Livre(1000, "Au bonheur des dames", "Emile Zola", Genre.ROMAN);
		livre.setNumExemplaire(2);
		ret.add(livre);
		
		ret.add(new CDRom(16000, "Le lac des cygnes", "Piotr Tchaïkowsky", 145));
		ret.add(new CDRom(18000, "La terre vue du ciel", "Yann Arthus Bertrand", 96));
		
		ret.add(new OeuvreDArt(28000, "La terre vue du ciel", "Yann Arthus Bertrand", 60));
		ret.add(new OeuvreDArt(29000, "Fac simile Aurore, J'accuse", "Emile Zola", 80));
		
		return ret;
	}

}
