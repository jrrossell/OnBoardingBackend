package com.project.movies.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.project.movies.model.entity.Actors;
import com.project.movies.model.entity.Movies;
import com.project.movies.model.repository.ActorsRepository;
import com.project.movies.model.repository.MoviesRepository;
import com.project.movies.service.MoviesServiceImpl;
import com.project.movies.dto.MoviesTitleYearDto;
import com.project.movies.dto.MoviesFullDto;

@RunWith(MockitoJUnitRunner.class)
public class TestService {
	
	@InjectMocks
	MoviesServiceImpl serviceMovies;
	
	@Mock
	MoviesRepository moviesRepository;
	
	@Mock
	ActorsRepository actorsRepository;
	
	@Test
	public void testNewMovie() {
		Movies movie = new Movies("Los Vengadores", "Accion", "2019", new ArrayList<>());

		when(moviesRepository.save(movie)).thenReturn(movie);
		
		Movies testMovie = serviceMovies.addMovie(movie);
		
		assertTrue("No se ha creado la pelicula", movie.equals(testMovie));
	}
	
	//revisar
	@Test
	public void testNewMovieRepeat() {
		Movies movie = new Movies("Los Vengadores", "Accion", "2019", new ArrayList<>());
		Movies movie2 = new Movies("Los Vengadores", "Accion", "2019", new ArrayList<>());
		
		when(moviesRepository.save(movie)).thenReturn(movie);
		
		Movies testMovie = serviceMovies.addMovie(movie2);

		assertTrue("No se ha creado la pelicula", testMovie.equals(movie));
	}
	
	@Test
	public void testOneMovieNull() {
		Optional<Movies> movieNull = Optional.ofNullable(null);

		when(moviesRepository.findById(1)).thenReturn(movieNull);

		MoviesFullDto movieDtoNull = serviceMovies.showMovie(1);

		assertTrue("No existe la pelicula", movieDtoNull == null);
	}
	
	@Test
	public void testOneMovie() {
		Optional<Movies> movie = Optional.of(new Movies("Los Vengadores", "Accion", "2019", new ArrayList<>()));
		
		when(moviesRepository.findById(1)).thenReturn(movie);
		
		MoviesFullDto movieDto = serviceMovies.showMovie(1);
		
		//comparar con movieDto y movie
		MoviesFullDto movieDtoTest = new MoviesFullDto();
		movieDtoTest.setTitle("Los Vengadores");
		movieDtoTest.setGender("Accion");
		movieDtoTest.setYear("2019");
		movieDtoTest.setActors(new ArrayList<>());
		
		assertTrue("No existe la pelicula", movieDto.getTitle() == movieDtoTest.getTitle() 
											&& movieDto.getGender() == movieDtoTest.getGender() 
											&& movieDto.getYear() == movieDtoTest.getYear());
	}
	
	@Test
	public void testListMovies() {
		Movies movie = new Movies("Los Vengadores", "Accion", "2019", new ArrayList<>());
		Movies movie2 = new Movies("Capitan America", "Ciencia Ficcion", "2013", new ArrayList<>());
		
		List<Movies> listMovies = new ArrayList<>();
		listMovies.add(movie);
		listMovies.add(movie2);
		
		when(moviesRepository.findAll()).thenReturn(listMovies);
		
		List<MoviesTitleYearDto> moviesDto = serviceMovies.listMovies();
		
		assertTrue("No existe la pelicula", listMovies.size() == moviesDto.size());
	}
	
	@Test
	public void testListMoviesNull() {
		List<Movies> listMovies = new ArrayList<>();

		when(moviesRepository.findAll()).thenReturn(listMovies);
		
		List<MoviesTitleYearDto> moviesDto = serviceMovies.listMovies();

		assertTrue("No existe la pelicula", moviesDto == null);
	}
	
	@Test
	public void testFindActors() {
		Actors actor = new Actors("Actor", "Apellido");
		Actors actor2 = new Actors("Actor2", "Apellido2");
		
		List<Actors> listActors = new ArrayList<>();
		listActors.add(actor);
		listActors.add(actor2);
		
		when(actorsRepository.findAll()).thenReturn(listActors);
		
		Actors actorService = serviceMovies.verifyActor(actor);
		
		assertTrue("No existe la pelicula", actor.equals(actorService));
	}

}
