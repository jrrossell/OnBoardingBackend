package com.project.movies.service;

import java.util.List;

import com.project.movies.dto.MoviesTitleYearDto;
import com.project.movies.dto.MoviesFullDto;
import com.project.movies.model.entity.Actors;
import com.project.movies.model.entity.Movies;

public interface MoviesService {
	List<MoviesTitleYearDto> listMovies();
	
	MoviesFullDto showMovie(Integer id);
	
	Movies addMovie(Movies movie);
	
	Actors verifyActor(Actors param);
	
	void deleteMovie(Integer id);
}
