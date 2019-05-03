
package com.project.movies.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.movies.model.Movies;
import com.project.movies.model.MoviesRepository;


@Configuration
public class ConfigMovies {
	
	@Bean
	public CommandLineRunner iniciarBaseDeDatos(MoviesRepository repository) {
		return args -> {
			repository.save(new Movies(1, "Rossell", "Madrid", "1999", "jrrrr"));
		};
	}
}
