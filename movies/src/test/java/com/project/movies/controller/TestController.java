package com.project.movies.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mock;

import com.project.movies.model.Movies;

public class TestController {
	
	@Mock
	ControllerMovies repository;
	
	@Test
	public void testSaveMovies() {
		Movies movie = new Movies();
		movie.setTittle("Los Vengadores");
		repository.newMovie(movie);
		
		boolean existeAula = false;
		if (repository.movies().size() >= 1) {
			existeAula = true;
		}
		
		assertTrue("No se registro la pelicula nueva", existeAula);
	}

}
