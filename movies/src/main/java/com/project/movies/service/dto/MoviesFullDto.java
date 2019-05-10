package com.project.movies.service.dto;

import java.io.Serializable;
import java.util.List;

public class MoviesFullDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idMovie;
	private String tittle;
	private String gender;
	private String year;
	private List<ActorsFullDto> actors;
	
	public MoviesFullDto() {
		super();
	}
	
	public List<ActorsFullDto> getActors() {
		return actors;
	}

	public void setActors(List<ActorsFullDto> actors) {
		this.actors = actors;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	
	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
