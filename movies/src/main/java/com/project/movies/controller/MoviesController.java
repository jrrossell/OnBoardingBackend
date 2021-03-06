package com.project.movies.controller;

import java.util.List;

import com.project.movies.dto.MoviesFullDto;
import com.project.movies.dto.MoviesTitleYearDto;
import com.project.movies.exceptions.MovieNotFound;
import com.project.movies.exceptions.MovieRepeat;
import com.project.movies.model.entity.Movies;

public interface MoviesController {
	List<MoviesTitleYearDto> listMovies();
	
	MoviesFullDto showMovie(Integer id) throws MovieNotFound;
	
	Movies addMovie(Movies movie) throws MovieRepeat;
	
	void deleteMovie(Integer id);
}
