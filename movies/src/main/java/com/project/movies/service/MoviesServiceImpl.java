package com.project.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movies.dto.MoviesTitleYearDto;
import com.project.movies.dto.MoviesFullDto;
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
		List<Movies> movies = moviesRepository.findAll();
		List<MoviesTitleYearDto> listaMoviesDto = new ArrayList<MoviesTitleYearDto>();

		for (Movies movie : movies) {
			listaMoviesDto.add(TransformMovies.movieToDtoTitleYear(movie));
		}

		return listaMoviesDto;
	}

	public MoviesFullDto showMovie(Integer id) {
		Movies movie = moviesRepository.findById(id).orElse(null); //cambiar orElse por orElseThrow
		//Excepciones
		//erro 404 si la peli no existe

		return TransformMovies.movieToFullDto(movie);
	}

	public Movies addMovie(Movies movie) {
		List<Movies> movies = moviesRepository.findAll();
		
		//ir directo a la pelicula
		for (Movies movieNext : movies) {
			if (movie.equals(movieNext)) {
				System.out.println("La pelicula ya existe");
				return null;
			}
		}

		List<Actors> actores = new ArrayList<Actors>();
		for (Actors actorNext : movie.getActors()) {
			Actors actorNew = verifyActor(actorNext);
			actores.add(actorNew);
		}
		movie.setActors(actores);
		return moviesRepository.save(movie);
	}
	
	public Actors verifyActor(Actors param) {
		List<Actors> actores = actorsRepository.findAll();
		for (Actors actor : actores) {
			if (actor.equals(param)) {
				return actor;
			}
		}
		Actors guardarActor = new Actors(param.getFirstName(), param.getSurname());
		return actorsRepository.save(guardarActor);
	}

	public void deleteMovie(Integer id) {
		moviesRepository.deleteById(id);
	}
}
