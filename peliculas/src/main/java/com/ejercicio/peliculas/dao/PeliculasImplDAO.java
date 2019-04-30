package com.ejercicio.peliculas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ejercicio.peliculas.model.Peliculas;

@Repository
public class PeliculasImplDAO implements PeliculasDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	ArrayList<Peliculas> pelis = new ArrayList<Peliculas>();
	
	public void insertar(Peliculas pelicula) {
//		entityManager.persist(pelicula);
		pelis.add(pelicula);
	}
	
	public Peliculas buscar(int id) {	
		return entityManager.find(Peliculas.class, id);
	}

	public List<Peliculas> listar() {
//		String query = "select p from Peliculas p";
//		return entityManager.createQuery(query).getResultList();
		return pelis;
	}
}
