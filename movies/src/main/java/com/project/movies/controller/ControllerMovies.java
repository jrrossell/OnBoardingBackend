package com.project.movies.controller;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.movies.model.Movies;
import com.project.movies.model.MoviesRepository;


@Service
public class ControllerMovies {
	private final MoviesRepository repository;
	
	public ControllerMovies(MoviesRepository repository) {
		this.repository = repository;
	}
	
	public List<Movies> movies(){
		return repository.findAll();
	}

	public Movies movie(Integer id) {
		return repository.findById(id)
				.orElse(null);
	}
	
	public Movies newMovie(Movies movie) {
		return repository.save(movie);
	}
	
	public void deleteMovie(Integer id) {
		repository.deleteById(id);
	}
}
