
package com.project.movies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.movies.model.Actors;
import com.project.movies.model.ActorsRepository;
import com.project.movies.model.Movies;
import com.project.movies.model.MoviesRepository;


@Configuration
public class ConfigMovies {
	
	@Bean
	public CommandLineRunner iniciarDatos(MoviesRepository repository, ActorsRepository repositoryActors) {
		return args -> {
			
			Actors actor1 = new Actors("Actor N1", "Apellido N1");
			Actors actor2 = new Actors("Actor N2", "Apellido N2");
			
			List<Actors> actores = new ArrayList<Actors>();
			actores.add(actor1);
			actores.add(actor2);
			Movies movie1 = new Movies("Capitan America", "Accion", "2010",actores);
			
			Actors actor3 = new Actors("Actor N3", "Apellido N4");
			Actors actor4 = new Actors("Actor N4", "Apellido N3");
			
			List<Actors> actores2 = new ArrayList<Actors>();
			actores2.add(actor3);
			actores2.add(actor4);
			Movies movie2 = new Movies("Hulk", "Ciencia Ficcion", "2011", actores2);
			Movies movie3 = new Movies("Thor", "Accion", "2013", null);

			repository.save(movie1);
			repository.save(movie2);
			repository.save(movie3);
			
		};
	}
}
