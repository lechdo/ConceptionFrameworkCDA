package fr.eni.ecole.demo.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.ecole.demo.bll.GestionPersonne;
import fr.eni.ecole.demo.bo.Adresse;
import fr.eni.ecole.demo.bo.Personne;

public class Main {

	public static void main(String[] args) {
		Adresse a1 = new Adresse("35000", "Rennes");
		Adresse a2 = new Adresse("75001", "Paris");
		Adresse a3 = new Adresse("29000", "Quimper");
		Adresse a4 = new Adresse("35000", "Rennes");
		Personne p1 = new Personne("Robert", "Marta", 75, a1);
		Personne p2 = new Personne("Malice", "Denis", 8, a2);
		Personne p3 = new Personne("Malice", "Julien", 18, a3);
		Personne p4 = new Personne("Paul", "Julien", 8, a4);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		GestionPersonne gp = context.getBean("gestionPersonne", GestionPersonne.class);
		try {
			gp.ajouterPersonne(p1);
			gp.ajouterPersonne(p2);
			gp.ajouterPersonne(p3);
			gp.ajouterPersonne(p4);

			System.out.println("\nListe des personnes :");
			List<Personne> liste = gp.listePersonnes();
			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nRechercher dont le nom est 'Malice'");
			liste = gp.rechercherPersonne("Malice");
			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nRechercher dont le nom contient 'ma'");
			liste = gp.rechercherPersonneNomContenant("ma");
			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nRechercher dont le nom contient pas 'ma'");
			liste = gp.rechercherPersonneNomNeContenantPas("ma");
			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nRechercher dont le nom et le prenom -- Malice Julien");
			liste = gp.rechercherPersonneNomEtPrenom("Malice", "Julien");
			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nRechercher dont le nom OU le prenom -- Malice Julien");
			liste = gp.rechercherPersonneNomOuPrenom("Malice", "Julien");
			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nRechercher les Malice ordonnés par Adresse");
			liste = gp.rechercherPersonneNomOrnonneParAdress("Malice");
			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nRechercher par ville");
			liste = gp.rechercherPersonneParVille("Rennes");
			for (Personne personne : liste) {
				System.out.println(personne);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		context.close();
	}

}
