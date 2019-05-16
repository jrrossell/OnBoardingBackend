package com.project.movies.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.project.movies.service.dto.ActorsFullDto;
import com.project.movies.service.dto.MoviesDto;
import com.project.movies.service.dto.MoviesFullDto;
import com.project.movies.model.Actors;
import com.project.movies.model.ActorsRepository;
import com.project.movies.model.Movies;
import com.project.movies.model.MoviesRepository;

@Service
public class ServiceMovies {

	private final MoviesRepository repository;
	private final ActorsRepository actorsRepository;

	public ServiceMovies(MoviesRepository repository, ActorsRepository actorsRepository) {
		this.repository = repository;
		this.actorsRepository = actorsRepository;
	}

	public List<MoviesDto> movies() {
		List<Movies> movies = repository.findAll();
		if (movies.size() == 0) {
			System.out.println("No existen peliculas");
			return null;
		}
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
		if (movie == null) {
			System.out.println("La pelicula no existe");
			return null;
		}
		MoviesFullDto movieDto = new MoviesFullDto();

		movieDto.setIdMovie(movie.getIdMovie());
		movieDto.setTittle(movie.getTittle());
		movieDto.setGender(movie.getGender());
		movieDto.setYear(movie.getYear());

		List<Actors> listActors = movie.getActors();
		List<ActorsFullDto> listActorsDto = new ArrayList<ActorsFullDto>();
		for (Actors nextActor : listActors) {
			ActorsFullDto actorDto = new ActorsFullDto();
			actorDto.setIdActor(nextActor.getIdActor());
			actorDto.setFirstName(nextActor.getFirstName());
			actorDto.setSurname(nextActor.getSurname());
			listActorsDto.add(actorDto);
		}
		movieDto.setActors(listActorsDto);

		return movieDto;
	}

	public Movies newMovie(Movies movie) {
		List<Movies> movies = repository.findAll();
		for (Movies movieNext : movies) {
			if (movie.equals(movieNext)) {
				System.out.println("La pelicula ya existe");
				return null;
			}
		}

		List<Actors> actores = new ArrayList<Actors>();
		for (Actors actorNext : movie.getActors()) {
			Actors actorNew = findActor(actorNext);
			actores.add(actorNew);
		}
		movie.setActors(actores);
		return repository.save(movie);
	}

	public Actors findActor(Actors param) {
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
		repository.deleteById(id);
	}

	public Movies updateMovies(Movies movie, Integer idMovie) {
		return repository.findById(idMovie).map(c -> {
			c.setTittle(movie.getTittle());
			c.setGender(movie.getGender());
			c.setYear(movie.getYear());
			List<Actors> actores = new ArrayList<Actors>();
			movie.getActors().forEach(actor -> {
				Actors actorNew = findActor(actor);
				actores.add(actorNew);
			});
			c.setActors(actores);
			return repository.save(c);
		}).orElseGet(() -> {
			movie.setIdMovie(idMovie);
			return repository.save(movie);
		});
	}
}
