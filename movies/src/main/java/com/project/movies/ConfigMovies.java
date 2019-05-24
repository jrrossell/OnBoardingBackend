
package com.project.movies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.movies.model.builder.ActorsBuilder;
import com.project.movies.model.builder.MoviesBuilder;
import com.project.movies.model.entity.Actors;
import com.project.movies.model.entity.Movies;
import com.project.movies.model.repository.ActorsRepository;
import com.project.movies.model.repository.MoviesRepository;

@Configuration
public class ConfigMovies {
	
	@Bean
	public CommandLineRunner iniciarDatos(MoviesRepository repository, ActorsRepository repositoryActors) {
		return args -> {
			
			Actors actor1 = new ActorsBuilder()
					.firstname("Chris")
					.surname("Evans")
					.build();
			
			Actors actor2 = new ActorsBuilder()
					.firstname("Don")
					.surname("Cheadle")
					.build();

			repositoryActors.save(actor1);
			repositoryActors.save(actor2);
			
			List<Actors> actores = new ArrayList<Actors>();
			actores.add(actor1);
			actores.add(actor2);
			
			Movies movie1 = new MoviesBuilder()
					.title("Capitan America")
					.gender("Accion")
					.year("2010")
					.actors(actores)
					.build();
			
			Actors actor3 = new ActorsBuilder()
					.firstname("Mark")
					.surname("Ruffalo")
					.build();
			
			Actors actor4 = new ActorsBuilder()
					.firstname("Edward")
					.surname("Norton")
					.build();

			repositoryActors.save(actor3);
			repositoryActors.save(actor4);
			
			List<Actors> actores2 = new ArrayList<Actors>();
			actores2.add(actor3);
			actores2.add(actor4);
			
			Movies movie2 = new MoviesBuilder()
					.title("Hulk")
					.gender("Ciencia Ficcion")
					.year("2011")
					.actors(actores2)
					.build();

			repository.save(movie1);
			repository.save(movie2);			
		};
	}
}
