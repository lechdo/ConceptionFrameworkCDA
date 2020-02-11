package fr.eni.ecole.demo.dal.ms;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.eni.ecole.demo.bo.Personne;
import fr.eni.ecole.demo.dal.PersonneDAO;

@Repository("personneJDBCMSBean")
public class PersonneJDBCMS implements PersonneDAO {

	@PersistenceContext(unitName = "PU2")
	EntityManager em;

	@Transactional("transactionManager2")
	@Override
	public void add(Personne personne) {
		em.persist(personne);
	}

	@Transactional("transactionManager2")
	@Override
	public void update(Personne personne) {
		em.merge(personne);
	}

	@Transactional("transactionManager2")
	@Override
	public void delete(Personne personne) {
		em.remove(personne);
	}

	@Override
	public List<Personne> findAll() {
		return em.createQuery("select p from Personne p", Personne.class).getResultList();
	}

	@Transactional("transactionManager2")
	@Override
	public void delete(int id) {
		Personne personne = findById(id);
		em.remove(personne);
	}

	@Transactional("transactionManager2")
	@Override
	public void delete(String nom) {
		em.createQuery("delete from Personne p where p.nom = :nom").setParameter("nom", nom).executeUpdate();
	}

	@Override
	public Personne findById(int id) {
		return em.find(Personne.class, id);
	}

	@Override
	public Personne findLast() {
		String req = "select p from Personne p order by p.id desc limit 1";
		return em.createQuery(req, Personne.class).getSingleResult();
	}

}
