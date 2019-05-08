package com.project.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.movies.service.dto.MoviesDto;
import com.project.movies.service.dto.MoviesFullDto;
import com.project.movies.model.Movies;
import com.project.movies.model.MoviesRepository;

@Service
public class ServiceMovies {
	private final MoviesRepository repository;
	
	public ServiceMovies(MoviesRepository repository) {
		this.repository = repository;
	}
	
	public List<MoviesDto> movies(){
		List<Movies> movies = repository.findAll();
		List<MoviesDto> listaMoviesDto = new ArrayList<MoviesDto>();
		
		for (Movies movie : movies) {
			MoviesDto moviesDto = new MoviesDto();
			moviesDto.setTittle(movie.getTittle());
			moviesDto.setYear(movie.getYear());
			listaMoviesDto.add(moviesDto);
		}
		
		return listaMoviesDto;
	}

	public MoviesFullDto movie(Integer id) {
		Movies movie = repository.findById(id).orElse(null);
		MoviesFullDto movieDto = new MoviesFullDto();
		
		movieDto.setIdMovie(movie.getIdMovie());
		movieDto.setTittle(movie.getTittle());
		movieDto.setGender(movie.getGender());
		movieDto.setYear(movie.getYear());
		movieDto.setActors(movie.getActors());
		
		return movieDto;
	}

	public Movies newMovie(Movies movie) {
		return repository.save(movie);
	}

	public void deleteMovie(Integer id) {
		repository.deleteById(id);
	}
}
