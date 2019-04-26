package com.ejercicio.peliculas.model;

import java.util.Date;
import java.util.List;

public class Peliculas {
	private String titulo;
	private String genero;
	private Date year;
	private List<Actores> actores;

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

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
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
		return "Peliculas [titulo=" + titulo + ", genero=" + genero + ", year=" + year + ", actores=" + actores + "]";
	}
	
	

}
