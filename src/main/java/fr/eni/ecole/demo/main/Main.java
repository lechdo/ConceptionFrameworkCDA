package fr.eni.ecole.demo.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.ecole.demo.bll.GestionPersonne;
import fr.eni.ecole.demo.bll.GestionPersonneMS;
import fr.eni.ecole.demo.bo.Personne;

public class Main {

	public static void main(String[] args) {
		Personne p1 = new Personne("Robert", "Marta", 75);
		Personne p2 = new Personne("Malice", "Denis", 8);
		Personne p1MS = new Personne("Robert", "Marta", 75);
		Personne p2MS = new Personne("Malice", "Denis", 8);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		GestionPersonne gp = context.getBean("gestionPersonne", GestionPersonne.class);
		GestionPersonneMS gpMS = context.getBean("gestionPersonneMS", GestionPersonneMS.class);
		
		try {
			///////////////////////////////////////////////////////
			gp.ajouterPersonne(p1);
			gp.ajouterPersonne(p2);
			

			System.out.println("\nListe des personnes (Mysql):");
			List<Personne> liste = gp.listePersonnes();

			for (Personne personne : liste) {
				System.out.println(personne);
			}
			/////////////////////////////////////////////////////////
			gpMS.ajouterPersonne(p1MS);
			gpMS.ajouterPersonne(p2MS);
			

			System.out.println("\nListe des personnes (sqlserver):");
			liste = gpMS.listePersonnes();

			for (Personne personne : liste) {
				System.out.println(personne);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		context.close();
	}

}
