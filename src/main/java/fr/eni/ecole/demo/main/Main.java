package fr.eni.ecole.demo.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.eni.ecole.demo.bo.Personne;
import fr.eni.ecole.demo.dal.PersonneDAO;
import fr.eni.ecole.demo.dal.PersonneJDBC;

public class Main {

	public static void main(String[] args) {
		Personne p1 = new Personne("Robert", "Marta", 75);
		Personne p2 = new Personne("Malice", "Denis", 8);

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		PersonneDAO personneJDBC = context.getBean("personneJDBCBean", PersonneJDBC.class);
		try {
			System.out.println(p1);
			personneJDBC.add(p1);
			personneJDBC.add(p2);

			System.out.println("\nListe des personnes :");
			List<Personne> liste = personneJDBC.findAll();

			for (Personne personne : liste) {
				System.out.println(personne);
			}

			System.out.println("\nLe nombre de personnes :");
			int nb = personneJDBC.nbPersonnes();
			System.out.println(nb);

			System.out.println("\nSuppression de " + p1);
			personneJDBC.delete(p1);

			liste = personneJDBC.findAll();
			for (Personne personne : liste) {
				System.out.println(personne);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		context.close();
	}

}
