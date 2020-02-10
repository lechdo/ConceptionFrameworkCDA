package fr.eni.ecole.demo.dal;

//Design Pattern -- CRUD
public interface DAO<T> {
	void create(T elem);

	T read(int id);

	void update(T elem);

	void delete(T elem);
}
