package com.ejercicio.peliculas.dao;

import java.util.List;

import com.ejercicio.peliculas.model.Movies;

public interface MoviesDAO {
	void insert(Movies movie);

	Movies find(String tittle);
 
	List<Movies> list();
}