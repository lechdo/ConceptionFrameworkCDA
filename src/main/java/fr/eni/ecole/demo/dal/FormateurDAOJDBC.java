package fr.eni.ecole.demo.dal;

import fr.eni.ecole.demo.bo.Formateur;

public class FormateurDAOJDBC implements DAO<Formateur>{

	public void create(Formateur elem) {
		elem.setId(1);
		System.out.println("Création d'un cours " + elem);
	}

	public Formateur read(int id) {
		Formateur c = new Formateur();
		c.setId(1);
		return c;
	}

	public void update(Formateur elem) {
		System.out.println("Mise à jour " + elem);
	}

	public void delete(Formateur elem) {
		System.out.println("Suppression " + elem);
	}
}
