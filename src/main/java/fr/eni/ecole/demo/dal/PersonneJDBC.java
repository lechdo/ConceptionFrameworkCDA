package fr.eni.ecole.demo.dal;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.eni.ecole.demo.bo.Personne;

public class PersonneJDBC implements PersonneDAO {
	JdbcTemplate jt;

	@Override
	public void add(Personne personne) {
		String req = "insert into Personnes (nom, prenom, age) values (?,?,?)";
		jt.update(req, personne.getNom(), personne.getPrenom(), personne.getAge());

	}

	@Override
	public Personne getPersonne(int id) {
		String req = "select id, nom, prenom, age from Personnes where id = ?";
		return jt.queryForObject(req, new BeanPropertyRowMapper<Personne>(Personne.class), id);

	}

	@Override
	public void update(Personne personne) {
		String req = "update Personnes set nom = ?, prenom = ?, age = ? where id = ?";
		jt.update(req, personne.getNom(), personne.getPrenom(), personne.getAge(), personne.getId());

	}

	@Override
	public void delete(Personne personne) {
		String req = "delete from Personnes where id = ?";
		jt.update(req, personne.getId());

	}

	@Override
	public List<Personne> findAll() {
		String req = "select nom, prenom, age from Personnes";
		return jt.query(req, new BeanPropertyRowMapper<Personne>(Personne.class));
	}

	@Override
	public int nbPersonnes() {
		String req = "select count(*) from Personnes";
		return jt.queryForObject(req, Integer.class);
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

}
