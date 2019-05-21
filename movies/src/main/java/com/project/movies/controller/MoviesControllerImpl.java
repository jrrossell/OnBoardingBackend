package com.project.movies.controller;

import java.sql.SQLException;
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
import com.project.movies.service.MoviesServiceImpl;

@RestController
public class MoviesControllerImpl implements MoviesController {
	private final MoviesServiceImpl moviesService;
	
	@Autowired
	public MoviesControllerImpl(MoviesServiceImpl service) {
		this.moviesService = service;
	}

	@GetMapping("/movies")
	public List<MoviesTitleYearDto> listMovies(){
		return moviesService.listMovies();
	}

	@GetMapping("/movies/{id}")
	public MoviesFullDto showMovie(@PathVariable Integer id) throws MovieNotFound {
		return moviesService.showMovie(id);
	}

	@PostMapping("/movies")
	public Movies addMovie(@RequestBody Movies movie) throws MovieRepeat, SQLException {
		return moviesService.addMovie(movie);
	}

	@DeleteMapping("/movies/{id}")
	public void deleteMovie(@PathVariable Integer id) {
		moviesService.deleteMovie(id);
	}
}
