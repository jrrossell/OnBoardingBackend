package com.ejercicio.peliculas.model;

import org.springframework.stereotype.Component;

@Component
public class Actores {
	private String nombre;
	private String apellido;
	private int edad;

	
	public Actores(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}

	public Actores() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Actor [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + "]";
	}
	
	

}
