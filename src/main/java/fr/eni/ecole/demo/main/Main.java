package fr.eni.ecole.demo.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.ecole.demo.bll.GestionPersonne;
import fr.eni.ecole.demo.bo.Personne;

public class Main {

	public static void main(String[] args) {
		Personne p1 = new Personne("Robert", "Marta", 75);
		Personne p2 = new Personne("Malice", "Denis", 8);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		GestionPersonne gp = context.getBean("gestionPersonne", GestionPersonne.class);
		
		try {
			gp.ajouterPersonne(p1);
			gp.ajouterPersonne(p2);
			

			System.out.println("\nListe des personnes :");
			List<Personne> liste = gp.listePersonnes();

			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nmodifier p1 :");
			p1.setNom("Leblond");
			gp.modifierPersonne(p1);
			liste = gp.listePersonnes();
			for (Personne personne : liste) {
				System.out.println(personne);
			}

//			System.out.println("\nSuppression de " + p1);
//			gp.supprimerPersonne(p1);
//
//			liste = gp.listePersonnes();
//			for (Personne personne : liste) {
//				System.out.println(personne);
//			}
			
			Personne p3 = new Personne("Pagnol", "Marcel", 75);
			Personne p4 = new Personne("Paul", "Robert", 8);
			
			gp.ajouterPersonne(p3);
			gp.ajouterPersonne(p4);
			for (Personne personne : liste) {
				System.out.println(personne);
			}
			
			System.out.println("\nSuppression à partir de l'id :");
			gp.supprimerPersonne(p3.getId());
			gp.supprimerPersonne(p4.getNom());
			for (Personne personne : liste) {
				System.out.println(personne);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		context.close();
	}

}
