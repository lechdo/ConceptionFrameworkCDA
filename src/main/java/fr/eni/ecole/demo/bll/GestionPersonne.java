package fr.eni.ecole.demo.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.ecole.demo.bo.Personne;
import fr.eni.ecole.demo.dal.PersonneDAO;

@Service("gestionPersonne")
public class GestionPersonne {

	@Autowired
	private PersonneDAO pdao;

	public List<Personne> listePersonnes() {
		return pdao.findAll();
	}

	public List<Personne> rechercherPersonne(String nom) {
		return pdao.findByNom(nom);
	}


	public void ajouterPersonne(Personne personne) {
		pdao.save(personne);
	}

	public void modifierPersonne(Personne personne) {
		pdao.save(personne);
	}

	public void supprimerPersonne(Personne personne) {
		pdao.delete(personne);
	}

	public void supprimerPersonne(int id) {
		pdao.delete(id);
	}

	public List<Personne> rechercherPersonneNomContenant(String nom) {
		return pdao.findByNomContaining(nom);
	}
	
	public List<Personne> rechercherPersonneNomNeContenantPas(String nom) {
		return pdao.findByNomNotContaining(nom);
	}
	
	public List<Personne> rechercherPersonneNomEtPrenom(String nom, String prenom) {
		return pdao.findByNomAndPrenom(nom, prenom);
	}
	
	public List<Personne> rechercherPersonneNomOuPrenom(String nom, String prenom) {
		return pdao.findByNomOrPrenom(nom, prenom);
	}
	
	public List<Personne> rechercherPersonneNomOrnonneParAdress(String nom) {
		return pdao.findByNomStartingWithOrderByAdresseVilleAscAdresseCodePostalDesc(nom);
	}
	
	public List<Personne> rechercherPersonneParVille(String nom) {
		return pdao.findByNomContaining(nom);
	}

	
}
