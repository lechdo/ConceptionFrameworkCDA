package fr.eni.ecole.demo.bll;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import fr.eni.ecole.demo.bo.Personne;
import fr.eni.ecole.demo.dal.PersonneDAO;

@Service("gestionPersonneMS")
public class GestionPersonneMS {

	@Resource(name = "personneJDBCMSBean")
	private PersonneDAO pdao;

	public List<Personne> listePersonnes() {
		return pdao.findAll();
	}

	public Personne rechercherPersonne(int id) {
		return pdao.findById(id);
	}

	public Personne rechercherDernier() {
		return pdao.findLast();
	}

	public void ajouterPersonne(Personne personne) {
		pdao.add(personne);
	}

	public void modifierPersonne(Personne personne) {
		pdao.update(personne);
	}

	public void supprimerPersonne(Personne personne) {
		pdao.delete(personne);
	}

	public void supprimerPersonne(int id) {
		pdao.delete(id);
	}

	public void supprimerPersonne(String nom) {
		pdao.delete(nom);
	}

}
