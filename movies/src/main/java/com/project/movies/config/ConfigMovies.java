
package com.project.movies.config;

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
	public CommandLineRunner iniciarBaseDeDatos(MoviesRepository repository, ActorsRepository repositoryActors) {
		return args -> {
			repository.save(new Movies(1, "Capitan America", "Accion", "2010", "Juan - Pedro - Jose"));
			repository.save(new Movies(2, "Hulk", "Ciencia Ficcion", "2011", "Raul - Junior"));
			repository.save(new Movies(3, "Thor", "Accion", "2013", "Jose - Paco"));
			
			repositoryActors.save(new Actors(1, 1, "Juan"));
			repositoryActors.save(new Actors(2, 2, "Raul"));
			repositoryActors.save(new Actors(3, 1, "Pedro"));
			
			List<Movies> movies = repository.findAll();
			List<Actors> actors = repositoryActors.findAll();
			
			System.out.println("-- List of Movies --");
			for (Movies movie : movies) {
				System.out.println(movie.getTittle() + " - " + movie.getYear());
			}
			
			System.out.println();
			System.out.println("-- Movie 1 --");
			System.out.println(repository.findById(1));
			System.out.println("Actors: ");
			for (Actors actor : actors) {
				if (actor.getCodMovie() == 1) {
					System.out.println(actor.getFirstName());
				}
			}
			
			System.out.println();
			System.out.println("-- Movie 2 --");
			System.out.println(repository.findById(2));
			System.out.println("Actors: ");
			for (Actors actor : actors) {
				if (actor.getCodMovie() == 2) {
					System.out.println(actor.getFirstName());
				}
			}
			
		};
	}
}
