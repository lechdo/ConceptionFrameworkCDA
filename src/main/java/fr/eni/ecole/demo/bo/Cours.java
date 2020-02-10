package fr.eni.ecole.demo.bo;

public class Cours {
	private int id;
	private String nom;
	private int duree;

	public Cours() {
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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Cours [id=" + id + ", nom=" + nom + ", duree=" + duree + "]";
	}

}
