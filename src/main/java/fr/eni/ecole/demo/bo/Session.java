package fr.eni.ecole.demo.bo;

import java.time.LocalDate;

public class Session {
	private int id;
	private LocalDate dateDebut;
	private Formateur formateur;
	private Cours cours;

	public Session() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Session [id=" + id + ", dateDebut=" + dateDebut + ", formateur=" + formateur + ", cours=" + cours + "]";
	}

}
