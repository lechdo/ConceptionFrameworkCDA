package fr.eni.jpa.entity;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.eni.jpa.entity.User;

public class TestUser {

	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Mysql_UP");
		EntityManager em = emf.createEntityManager();
		
		
		User u1 = new User(1, "java", "avance");
		
		em.getTransaction().begin();
		try {
			em.persist(u1);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();// mode dev
			em.getTransaction().rollback();
		}
		
		// PL SQL -- pseudo langage de requete orienté objet
		String request = "from User u";
		List<User> liste = em.createQuery(request, User.class).getResultList();
		System.out.println("Liste des utilisateurs : ");
		System.out.println(liste);
		
		em.close();
		emf.close();
		
	}
}
