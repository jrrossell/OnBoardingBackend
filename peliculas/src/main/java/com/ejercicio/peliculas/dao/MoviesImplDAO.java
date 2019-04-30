package com.ejercicio.peliculas.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ejercicio.peliculas.model.Movies;

@Repository
public class MoviesImplDAO implements MoviesDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	ArrayList<Movies> pelis = new ArrayList<Movies>();
	
	public void insert(Movies movie) {
//		entityManager.persist(pelicula);
		pelis.add(movie);
	}
	
	public Movies find(String tittle) {	
//		return entityManager.find(Peliculas.class, id);
		for (Movies peliculaRecorrer : pelis) {
			if (peliculaRecorrer.getTittle().equals(tittle)) {
				return peliculaRecorrer;
			}
		}
		return null;
	}

	public List<Movies> list() {
//		String query = "select p from Peliculas p";
//		return entityManager.createQuery(query).getResultList();
		return pelis;
	}
}
