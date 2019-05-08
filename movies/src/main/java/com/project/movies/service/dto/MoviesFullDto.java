package com.project.movies.service.dto;

import java.io.Serializable;
import java.util.List;

import com.project.movies.model.Actors;

public class MoviesFullDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idMovie;
	private String tittle;
	private String gender;
	private String year;
	private List<Actors> actors;
	
	public List<Actors> getActors() {
		return actors;
	}

	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}

	public MoviesFullDto() {
		super();
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
