package fr.eni.ecole.demo.bll;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.eni.ecole.demo.bo.Cours;
import fr.eni.ecole.demo.bo.Formateur;
import fr.eni.ecole.demo.bo.Session;
import fr.eni.ecole.demo.dal.DAO;

@Service("planningManagerBean")
public class PlanningManager {
	
	@Autowired
	@Qualifier("coursDAOBean")
	private DAO<Cours> coursDAO;
	
	@Resource(name="formateurDAOBean")
	private DAO<Formateur> formateurDAO;
	
	@Inject
	@Named("sessionDAOBean")
	private DAO<Session> sessionDAO;

	public PlanningManager() {
	}
	
	

	public PlanningManager(DAO<Cours> coursDAO, DAO<Formateur> formateurDAO, DAO<Session> sessionDAO) {
		super();
		this.coursDAO = coursDAO;
		this.formateurDAO = formateurDAO;
		this.sessionDAO = sessionDAO;
	}



	public Cours creerUnCours(String nom, int duree) {
		// Vérification de la durée
		if (duree > 0) {
			Cours c = new Cours();
			c.setNom(nom);
			c.setDuree(duree);
			coursDAO.create(c);
			return c;
		} else {
			System.out.println("La durée d'un cours est au minimum d'un jour");
		}
		return null;
	}

	public Formateur creerUnFormateur(String nom, String prenom, List<Cours> cours) {
		// Vérifier que la liste n'est pas null ou vide
		if (cours == null || cours.isEmpty()) {
			System.out.println("Le formateur doit avoir une liste de cours associée");
		} else {
			Formateur f = new Formateur();
			f.setNom(nom);
			f.setPrenom(prenom);
			f.setCours(cours);
			formateurDAO.create(f);
			return f;
		}
		return null;
	}

	public Session creerUneSession(Cours c, Formateur f, LocalDate debut) {
		// Vérification que le formateur donne ce cours
		boolean coursConnu = false;
		for (Cours cours : f.getCours()) {
			if (cours.getNom().equals(c.getNom())) {
				coursConnu = true;
			}
		}
		if (coursConnu) {
			// vérification de la date
			if (debut.isAfter(LocalDate.now())) {
				Session s = new Session();
				s.setCours(c);
				s.setFormateur(f);
				s.setDateDebut(debut);
				sessionDAO.create(s);
				return s;
			} else {
				System.out.println("Impossible de créer cette session - " + "la date est déjà passée");
			}
		} else {
			System.out.println("Impossible de créer cette session - " + "le formateur ne connaît pas ce cours");
		}
		return null;
	}

	public DAO<Cours> getCoursDAO() {
		return coursDAO;
	}

	public void setCoursDAO(DAO<Cours> coursDAO) {
		this.coursDAO = coursDAO;
	}

	public DAO<Formateur> getFormateurDAO() {
		return formateurDAO;
	}

	public void setFormateurDAO(DAO<Formateur> formateurDAO) {
		this.formateurDAO = formateurDAO;
	}

	public DAO<Session> getSessionDAO() {
		return sessionDAO;
	}

	public void setSessionDAO(DAO<Session> sessionDAO) {
		this.sessionDAO = sessionDAO;
	}
	
	
}
