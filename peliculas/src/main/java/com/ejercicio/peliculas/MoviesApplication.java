package com.ejercicio.peliculas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ejercicio.peliculas.controller.ManageMovies;
import com.ejercicio.peliculas.model.Actors;
import com.ejercicio.peliculas.model.Movies;

@SpringBootApplication
public class MoviesApplication {

	private static ApplicationContext context;

	static {
		// context = new AnnotationConfigApplicationContext(Configuracion.class);
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
		
		Actors actor1 = context.getBean(Actors.class);
		actor1.setFirstName("Junior");
		actor1.setLastName("Rossell");
		actor1.setAge(27);
		
		Actors actor2 = context.getBean(Actors.class);
		actor2.setFirstName("Pepito");
		actor2.setLastName("Rossellito");
		actor2.setAge(30);
		
		ArrayList<Actors> actors = new ArrayList<Actors>();
		actors.add(actor1);
		actors.add(actor2);
		
		Movies movie1 = context.getBean(Movies.class);
		movie1.setId(1);
		movie1.setTittle("Los vengadores");
		movie1.setGender("Accion");
		movie1.setYear("2019");
		movie1.getActors().add(actor1);
		
		Movies movie2 = context.getBean(Movies.class);
		movie2.setId(2);
		movie2.setTittle("Capitan America");
		movie2.setGender("Accion");
		movie2.setYear("2013");
		movie2.setActors(actors);
		
		ManageMovies business = context.getBean(ManageMovies.class);
		business.insert(movie1);
		System.out.println("Inserted Movie");
		business.insert(movie2);
		System.out.println("Inserted Movie");
		
		System.out.println();
		System.out.println("-- List of Movies --");
		List<Movies> listadoPelis = business.list();
		for (Movies peli : listadoPelis) {
			System.out.println(peli.getTittle() + " - " + peli.getYear());
		}
		
		System.out.println();
		String nombrePeli = "Capitan America";
		System.out.println("-- Data of the Movie " + nombrePeli + " --");
		Movies peli = business.find(nombrePeli);
		System.out.println("Tittle: " + peli.getTittle() + "\nGender: " + peli.getGender() + "\nYear: " + peli.getYear() + "\nActors: " + peli.getActors());
	
	}	

}
