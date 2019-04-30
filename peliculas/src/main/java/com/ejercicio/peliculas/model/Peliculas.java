package com.ejercicio.peliculas.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Peliculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private String genero;
	private String year;
	@Autowired
	private List<Actores> actores;

	
	public Peliculas(int id, String titulo, String genero, String year, List<Actores> actores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.genero = genero;
		this.year = year;
		this.actores = actores;
	}

	public Peliculas() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public List<Actores> getActores() {
		return actores;
	}

	public void setActores(List<Actores> actores) {
		this.actores = actores;
	}

	@Override
	public String toString() {
		return "Peliculas [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", year=" + year + ", actores="
				+ actores + "]";
	}

}
