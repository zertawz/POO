package ds4eti2018_2S.modele;

import java.util.ArrayList;
import java.util.List;

import ds4eti2018_2S.modele.comportements.CmpEco;
import ds4eti2018_2S.modele.comportements.CmpFroid;
import ds4eti2018_2S.modele.comportements.CmpUrgent;
import ds4eti2018_2S.modele.comportements.ComportementColis;
import ds4eti2018_2S.modele.transport.MoyenTransport;

public class Test {
	
	public static List<Colis> fabriqueColis(int nb){
		List<Colis> liste = new ArrayList<Colis>();
		for (int i=0;i<nb;i++){
			List<ComportementColis> cc = new ArrayList<ComportementColis>();
			if(Math.random()<0.5){cc.add(new CmpUrgent());}
			if(Math.random()<0.5){cc.add(new CmpFroid());}
			cc.add(new CmpEco());
			liste.add(new Colis(cc));
		}
		return liste;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ComportementColis c1 = new CmpUrgent();
		ComportementColis c2 = new CmpFroid();
		ComportementColis c3 = new CmpEco();

		List<ComportementColis> lT1=new ArrayList<ComportementColis>();
		List<ComportementColis> lT2=new ArrayList<ComportementColis>();
		List<ComportementColis> lT3=new ArrayList<ComportementColis>();
		
		lT1.add(c1);
		lT1.add(c3);
		lT2.add(c3);
		lT3.add(c1);
		lT3.add(c3);
		List<MoyenTransport> transports = new ArrayList<MoyenTransport>();
		transports.add(new MoyenTransport("1234FZ21",lT1));
		transports.add(new MoyenTransport("4578AZ12",lT2));
		transports.add(new MoyenTransport("BF214",lT3));
		
		Agence a = new Agence("Mon Agence","Lyon", transports);
		System.out.println(a);
		
		List<Colis> l = fabriqueColis(20);
		for(Colis c:l){
			if(a.addColis(c)){System.out.println("Colis "+c +" ajouté");}
			else{System.out.println("Colis "+ c + "non pris en charge");}
		}
		
		a.affecteChargement();
		System.out.println("Prix du transport pour 25km: "+a.calculPrix(25));
		System.out.println("Prix du transport pour 185km: "+a.calculPrix(185));

	}

}
