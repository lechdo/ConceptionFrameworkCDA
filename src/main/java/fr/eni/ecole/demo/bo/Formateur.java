package fr.eni.ecole.demo.bo;

import java.util.ArrayList;
import java.util.List;

public class Formateur {
	private int id;
	private String nom;
	private String prenom;
	private List<Cours> cours;

	public Formateur() {
		cours = new ArrayList<>();
	}

	public void addCours(Cours c) {
		cours.add(c);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cours=" + cours + "]";
	}

}
