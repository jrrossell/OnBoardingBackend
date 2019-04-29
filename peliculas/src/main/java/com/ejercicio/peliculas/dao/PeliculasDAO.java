package com.ejercicio.peliculas.dao;

import java.util.List;

import com.ejercicio.peliculas.model.Peliculas;

public interface PeliculasDAO {
	void insertar(Peliculas pelicula);

	Peliculas buscar(int id);
 
	List<Peliculas> listar();
}