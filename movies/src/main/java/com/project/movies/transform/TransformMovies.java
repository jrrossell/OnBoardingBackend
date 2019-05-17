package com.project.movies.transform;

import java.util.ArrayList;
import java.util.List;

import com.project.movies.dto.ActorsFullDto;
import com.project.movies.dto.MoviesFullDto;
import com.project.movies.dto.MoviesTitleYearDto;
import com.project.movies.model.entity.Actors;
import com.project.movies.model.entity.Movies;

public class TransformMovies {
	public static MoviesTitleYearDto movieToDtoTitleYear(Movies movie) {
		MoviesTitleYearDto moviesDto = new MoviesTitleYearDto();
		moviesDto.setTitle(movie.getTitle());
		moviesDto.setYear(movie.getYear());
		
		return moviesDto;
	}
	
	public static MoviesFullDto movieToFullDto(Movies movie) {
		MoviesFullDto movieDto = new MoviesFullDto();

		movieDto.setId(movie.getId());
		movieDto.setTitle(movie.getTitle());
		movieDto.setGender(movie.getGender());
		movieDto.setYear(movie.getYear());
		
		List<Actors> listActors = movie.getActors();
		List<ActorsFullDto> listActorsDto = new ArrayList<ActorsFullDto>();
		for (Actors nextActor : listActors) {
			ActorsFullDto actorDto = new ActorsFullDto();
			actorDto.setId(nextActor.getId());
			actorDto.setFirstName(nextActor.getFirstName());
			actorDto.setSurname(nextActor.getSurname());
			listActorsDto.add(actorDto);
		}
		movieDto.setActors(listActorsDto);
		
		return movieDto;
	}
	
	public static Movies movieFullDtoToMovie(MoviesFullDto movieFullDto) {
		Movies movie = new Movies();

		movie.setId(movieFullDto.getId());
		movie.setTitle(movieFullDto.getTitle());
		movie.setGender(movieFullDto.getGender());
		movie.setYear(movieFullDto.getYear());
		
		List<ActorsFullDto> listActorsDto = movieFullDto.getActors();
		List<Actors> list = new ArrayList<Actors>();
		for (ActorsFullDto nextActor : listActorsDto) {
			Actors actor = new Actors();
			actor.setId(nextActor.getId());
			actor.setFirstName(nextActor.getFirstName());
			actor.setSurname(nextActor.getSurname());
			list.add(actor);
		}
		movie.setActors(list);
		
		return movie;
	}
}
