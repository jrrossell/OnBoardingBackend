package com.ejercicio.peliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ejercicio.peliculas.model.Actores;
import com.ejercicio.peliculas.model.Peliculas;
import com.ejercicio.peliculas.negocio.GestionPeliculas;

@SpringBootApplication
public class PeliculasApplication {

	private static ApplicationContext context;

	static {
		// context = new AnnotationConfigApplicationContext(Configuracion.class);
		context = new ClassPathXmlApplicationContext("beans.xml");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PeliculasApplication.class, args);
		
		Actores actor1 = context.getBean(Actores.class);
		actor1.setNombre("Junior");
		actor1.setApellido("Rossell");
		actor1.setEdad(27);
		
		Peliculas pelicula1 = context.getBean(Peliculas.class);
		pelicula1.setTitulo("Los vengadores");
		pelicula1.setGenero("Accion");
		pelicula1.setYear("2019");
		//pelicula1.getActores().add(actor1);
		
		GestionPeliculas negocio = context.getBean(GestionPeliculas.class);
		negocio.insertar(pelicula1);
		System.out.println("Pelicula insertada");
		
//		System.out.println("Pelicula 0");
//		System.out.println(negocio.buscar(0));
		
		System.out.println("Listado de Peliculas");
		System.out.println(negocio.listar());
		
		
	}

}
