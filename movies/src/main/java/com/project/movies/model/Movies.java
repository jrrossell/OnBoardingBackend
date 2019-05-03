package com.project.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String tittle;
	private String gender;
	private String year;
	private String actors;

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movies(int id, String tittle, String gender, String year, String actors) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.gender = gender;
		this.year = year;
		this.actors = actors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + "\n, tittle=" + tittle + "\n, gender=" + gender + "\n, year=" + year + "\n, actors="
				+ actors + "]";
	}

}
