package fr.eni.ecole.demo.dal;

import fr.eni.ecole.demo.bo.Session;

public class SessionDAOJDBC implements DAO<Session>{

	public void create(Session elem) {
		elem.setId(1);
		System.out.println("Création d'un cours " + elem);
	}

	public Session read(int id) {
		Session c = new Session();
		c.setId(1);
		return c;
	}

	public void update(Session elem) {
		System.out.println("Mise à jour " + elem);
	}

	public void delete(Session elem) {
		System.out.println("Suppression " + elem);
	}
}
