package com.project.movies.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.movies.model.Movies;
import com.project.movies.model.MoviesRepository;


@RestController
public class ControllerMovies {
	private final MoviesRepository repository;
	
	public ControllerMovies(MoviesRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/movies")
	public List<String> movies(){
		List<Movies> movies = repository.findAll();
		List<String> moviesEnviar = new ArrayList<String>();
		for (Movies movie : movies) {
			moviesEnviar.add("Tittle: " + movie.getTittle() + " - Year: " + movie.getYear());
		}
		return moviesEnviar;
	}
	
	@GetMapping("/movies/{id}")
	public Movies movie(@PathVariable Integer id) {
		return repository.findById(id)
				.orElse(null);
	}
	
	@PostMapping("/movies")
	public Movies newMovie(@RequestBody Movies movie) {
		return repository.save(movie);
	}
	
	@DeleteMapping("/movies/{id}")
	public void deleteMovie(@PathVariable Integer id) {
		repository.deleteById(id);
	}
}
