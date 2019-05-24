package com.project.movies.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movies.dto.MoviesTitleYearDto;
import com.project.movies.exceptions.MovieNotFound;
import com.project.movies.exceptions.MovieRepeat;
import com.project.movies.dto.MoviesFullDto;
import com.project.movies.model.builder.ActorsBuilder;
import com.project.movies.model.entity.Actors;
import com.project.movies.model.entity.Movies;
import com.project.movies.model.repository.ActorsRepository;
import com.project.movies.model.repository.MoviesRepository;
import com.project.movies.transform.TransformMovies;

@Service
public class MoviesServiceImpl implements MoviesService {

	private final MoviesRepository moviesRepository;
	private final ActorsRepository actorsRepository;

	@Autowired
	public MoviesServiceImpl(MoviesRepository repository, ActorsRepository actorsRepository) {
		this.moviesRepository = repository;
		this.actorsRepository = actorsRepository; 
	}

	public List<MoviesTitleYearDto> listMovies() { 
		return moviesRepository.findAll()
								.stream()
								.map(TransformMovies::movieToDtoTitleYear)
								.collect(Collectors.toList());
	}
	
	public MoviesFullDto showMovie(Integer id) throws MovieNotFound {
		return moviesRepository.findById(id)
								.map(TransformMovies::movieToFullDto)
								.orElseThrow(() -> new MovieNotFound());
	}

	public Movies addMovie(Movies movie) throws MovieRepeat {
		Movies movieBD = moviesRepository.findMovieBD(movie.getTitle(), movie.getYear());
		if (movieBD != null) throw new MovieRepeat();
			
		movie.setActors(movie.getActors().stream().map(actor -> {
			Actors actorBD = actorsRepository.verifyActorBD(actor.getFirstName(), actor.getSurname());
			if (actorBD == null)
				return actorsRepository.save(new ActorsBuilder().firstname(actor.getFirstName()).surname(actor.getSurname()).build());
			return actorBD;
		}).collect(Collectors.toList()));
		return moviesRepository.save(movie);
	}
	
	public void deleteMovie(Integer id) {
		moviesRepository.deleteById(id);
	}
}
