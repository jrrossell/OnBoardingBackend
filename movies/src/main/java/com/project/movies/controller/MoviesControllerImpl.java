package com.project.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.movies.dto.MoviesTitleYearDto;
import com.project.movies.exceptions.MovieNotFound;
import com.project.movies.exceptions.MovieRepeat;
import com.project.movies.dto.MoviesFullDto;
import com.project.movies.model.entity.Movies;
import com.project.movies.service.MoviesService;

@RestController
public class MoviesControllerImpl implements MoviesController {
	private final MoviesService moviesService;
	
	@Autowired
	public MoviesControllerImpl(MoviesService service) {
		this.moviesService = service;
	}

	@GetMapping("/movie")
	public List<MoviesTitleYearDto> listMovies(){
		return moviesService.listMovies();
	}

	@GetMapping("/movie/{id}")
	public MoviesFullDto showMovie(@PathVariable Integer id) throws MovieNotFound {
		return moviesService.showMovie(id);
	}

	@PostMapping("/movie")
	public Movies addMovie(@RequestBody Movies movie) throws MovieRepeat {
		return moviesService.addMovie(movie);
	}

	@DeleteMapping("/movie/{id}")
	public void deleteMovie(@PathVariable Integer id) {
		moviesService.deleteMovie(id);
	}
}
