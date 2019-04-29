package com.ejercicio.peliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ejercicio.peliculas.model.Actores;
import com.ejercicio.peliculas.model.Peliculas;
import com.ejercicio.peliculas.negocio.GestionPeliculas;

@SpringBootApplication
public class PeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeliculasApplication.class, args);
		
		Actores actor1 = new Actores();
		actor1.setNombre("Junior");
		Actores actor2 = new Actores();
		actor2.setNombre("Manuel");
		
		Peliculas pelicula1 = new Peliculas();
		pelicula1.setTitulo("Los vengadores");
		pelicula1.setGenero("Accion");
		pelicula1.setYear("2019");
		//pelicula1.getActores().add(actor1);
		
		GestionPeliculas negocio = new GestionPeliculas();
		negocio.insertar(pelicula1);
		System.out.println("Pelicula insertada");
		
		System.out.println("Pelicula 1");
		System.out.println(negocio.buscar(1));
		
		System.out.println("Listado de Peliculas");
		System.out.println(negocio.listar());
		
		
	}

}
