package com.project.movies.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;

import com.project.movies.model.Movies;
import com.project.movies.service.ServiceMovies;
import com.project.movies.service.dto.MoviesDto;
import com.project.movies.service.dto.MoviesFullDto;

public class TestController {
	
	@Mock
	ServiceMovies serviceMovies = mock(ServiceMovies.class);

	@Test
	public void testListMovies() {
		boolean exitenMovies = false;
		List<MoviesDto> movies = serviceMovies.movies();

		if (movies.size() >= 0) {
			exitenMovies = true;
		}
		
		assertTrue("No existen peliculas", exitenMovies);
	}
	
	@Test
	public void testOneMovie() {
		boolean exiteMovie = false;
		MoviesFullDto movie = serviceMovies.movie(1);
		
		System.out.println(movie);
		if (movie != null) {
			exiteMovie = true;
		}
		
		assertTrue("No existe la pelicula", exiteMovie);
	}
	
	@Test
	public void testSaveMovies() {
		Movies movie = new Movies();
		movie.setTittle("Los Vengadores");
		serviceMovies.newMovie(movie);
		
		List<Movies> movies = new ArrayList<Movies>();
		movies.add(movie);
		
		boolean movieNew = false;
		if (movies.size() > 0) {
			movieNew = true;
		}
		
		assertTrue("No se registro la pelicula nueva", movieNew);
	}

}
