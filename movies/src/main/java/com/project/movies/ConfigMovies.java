
package com.project.movies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.movies.model.entity.Actors;
import com.project.movies.model.entity.Movies;
import com.project.movies.model.repository.ActorsRepository;
import com.project.movies.model.repository.MoviesRepository;


@Configuration
public class ConfigMovies {
	
	@Bean
	public CommandLineRunner iniciarDatos(MoviesRepository repository, ActorsRepository repositoryActors) {
		return args -> {
			
			Actors actor1 = new Actors("Chris", "Evans");
			Actors actor2 = new Actors("Don", "Cheadle");
			repositoryActors.save(actor1);
			repositoryActors.save(actor2);
			
			List<Actors> actores = new ArrayList<Actors>();
			actores.add(actor1);
			actores.add(actor2);
			
			Movies movie1 = new Movies("Capitan America", "Accion", "2010", actores);
			
			Actors actor3 = new Actors("Mark", "Ruffalo"); 
			Actors actor4 = new Actors("Edward", "Norton");
			repositoryActors.save(actor3);
			repositoryActors.save(actor4);
			
			List<Actors> actores2 = new ArrayList<Actors>();
			actores2.add(actor3);
			actores2.add(actor4);
			
			Movies movie2 = new Movies("Hulk", "Ciencia Ficcion", "2011", actores2);

			repository.save(movie1);
			repository.save(movie2);			
		};
	}
}
