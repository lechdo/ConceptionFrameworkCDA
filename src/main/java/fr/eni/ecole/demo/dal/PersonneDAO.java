package fr.eni.ecole.demo.dal;

import java.util.List;

import fr.eni.ecole.demo.bo.Personne;

public interface PersonneDAO {

	void add(Personne personne);

	void update(Personne personne);

	void delete(Personne personne);

	void delete(int id);

	void delete(String nom);

	List<Personne> findAll();

	Personne findById(int id);

	Personne findLast();

}
