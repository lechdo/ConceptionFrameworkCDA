package fr.eni.ecole.demo.dal;

import java.util.List;

import fr.eni.ecole.demo.bo.Personne;

public interface PersonneDAO {

	void add(Personne personne);

	Personne getPersonne(int id);

	void update(Personne personne);

	void delete(Personne personne);

	List<Personne> findAll();

	int nbPersonnes();

}
