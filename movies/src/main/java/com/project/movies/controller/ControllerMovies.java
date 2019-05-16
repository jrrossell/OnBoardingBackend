package com.project.movies.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.movies.service.dto.MoviesDto;
import com.project.movies.service.dto.MoviesFullDto;
import com.project.movies.model.Movies;
import com.project.movies.service.ServiceMovies;

@RestController
public class ControllerMovies {
	private final ServiceMovies service;

	public ControllerMovies(ServiceMovies service) {
		this.service = service;
	}

	@GetMapping("/movies")
	public List<MoviesDto> movies(){
		return service.movies();
	}

	@GetMapping("/movies/{id}")
	public MoviesFullDto movie(@PathVariable Integer id) {
		return service.movie(id);
	}

	@PostMapping("/movies")
	public Movies newMovie(@RequestBody Movies movie) {
		return service.newMovie(movie);
	}

	@DeleteMapping("/movies/{id}")
	public void deleteMovie(@PathVariable Integer id) {
		service.deleteMovie(id);
	}
	
	@PutMapping("/movies/{id}")
	public Movies updateMovies(@RequestBody Movies movie,@PathVariable Integer id) {
		return service.updateMovies(movie, id);
	}
}
