package fr.eni.ecole.demo.dal;

import javax.inject.Named;

import fr.eni.ecole.demo.bo.Cours;

@Named("coursDAOBean")
public class CoursDAOJDBC implements DAO<Cours>{

	public void create(Cours elem) {
		elem.setId(1);
		System.out.println("Création d'un cours " + elem);
	}

	public Cours read(int id) {
		Cours c = new Cours();
		c.setId(1);
		return c;
	}

	public void update(Cours elem) {
		System.out.println("Mise à jour " + elem);
	}

	public void delete(Cours elem) {
		System.out.println("Suppression " + elem);
	}
}
