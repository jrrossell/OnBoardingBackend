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

import com.project.movies.model.builder.MoviesBuilder;
import com.project.movies.model.entity.Movies;
import com.project.movies.model.repository.ActorsRepository;
import com.project.movies.model.repository.MoviesRepository;
import com.project.movies.service.MoviesServiceImpl;
import com.project.movies.transform.TransformMovies;
import com.project.movies.dto.MoviesTitleYearDto;
import com.project.movies.exceptions.MovieNotFound;
import com.project.movies.exceptions.MovieRepeat;
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
	public void testNewMovie() throws MovieRepeat {
		Movies movie = new MoviesBuilder()
				.title("Los Vengadores")
				.gender("Accion")
				.year("2019")
				.actors(new ArrayList<>())
				.build();

		when(moviesRepository.save(movie)).thenReturn(movie);
		
		Movies testMovie = serviceMovies.addMovie(movie);
		
		assertTrue("No se ha creado la pelicula", movie.equals(testMovie));
	}

	@Test
	public void testNewMovieRepeat() throws MovieRepeat {
		Movies movie1 = new MoviesBuilder()
				.title("Los Vengadores")
				.gender("Accion")
				.year("2019")
				.actors(new ArrayList<>())
				.build();
		
		when(moviesRepository.save(movie1)).thenReturn(movie1);
		
		Movies testMovie1 = serviceMovies.addMovie(movie1);
		Movies testMovie2;
		try {
			testMovie2 = serviceMovies.addMovie(movie1);
		}catch (MovieRepeat mr) {
			testMovie2 = null;
		}
		System.out.println(testMovie1.getId());
		System.out.println(testMovie2.getId());
		assertTrue("Las peliculas son iguales", testMovie1.equals(movie1) && testMovie2 == null);
	}
	
	@Test
	public void testFindMovieNull() throws MovieNotFound {
		Movies movieNull = null;
		
		when(moviesRepository.findById(1)).thenReturn(Optional.ofNullable(movieNull));
		
		MoviesFullDto movieDtoNull;
		try {
			movieDtoNull = serviceMovies.showMovie(1);
		}catch (MovieNotFound m) {
			movieDtoNull = null;
		}

		assertTrue("Existe la pelicula, No es Null", movieDtoNull == null && movieNull == null);
	}
	
	@Test
	public void testFindMovie() throws MovieNotFound {
		Movies movie = new MoviesBuilder()
				.title("Los Vengadores")
				.gender("Accion")
				.year("2019")
				.actors(new ArrayList<>())
				.build();
		
		when(moviesRepository.findById(1)).thenReturn(Optional.of(movie));
		
		MoviesFullDto movieDto = serviceMovies.showMovie(1);
		Movies mov = TransformMovies.movieFullDtoToMovie(movieDto);
		
		assertTrue("No se guardo la pelicula", movie.equals(mov));
	}
	
	@Test
	public void testListMovies() {
		Movies movie1 = new MoviesBuilder()
				.title("Los Vengadores")
				.gender("Accion")
				.year("2019")
				.actors(new ArrayList<>())
				.build();
		Movies movie2 = new MoviesBuilder()
				.title("Capitan America")
				.gender("Ciencia Ficcion")
				.year("2013")
				.actors(new ArrayList<>())
				.build();
		
		List<Movies> listMovies = new ArrayList<>();
		listMovies.add(movie1);
		listMovies.add(movie2);
		
		when(moviesRepository.findAll()).thenReturn(listMovies);
		
		List<MoviesTitleYearDto> moviesDto = serviceMovies.listMovies();
		
		assertTrue("Lista de peliculas nula", listMovies.size() == moviesDto.size());
	}
	
	@Test
	public void testListMoviesNull() {
		List<Movies> listMovies = new ArrayList<>();

		when(moviesRepository.findAll()).thenReturn(listMovies);
		
		List<MoviesTitleYearDto> moviesDto = serviceMovies.listMovies();

		assertTrue("Lista de peliculas no es null", moviesDto.size() == listMovies.size());
	}
}
