package com.project.movies.model.builder;

import java.util.List;

import com.project.movies.model.entity.Actors;
import com.project.movies.model.entity.Movies;

public class MoviesBuilder {
	
	private int id;
	private String title;
	private String gender;
	private String year;
	private List<Actors> actors;
	
	public MoviesBuilder() {
	}

	public MoviesBuilder id(int id) {
		this.id = id;
		return this;
	}
	
	public MoviesBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MoviesBuilder gender(String gender) {
		this.gender = gender;
		return this;
	}
	
	public MoviesBuilder year(String year) {
		this.year = year;
		return this;
	}
	
	public MoviesBuilder actors(List<Actors> actors) {
		this.actors = actors;
		return this;
	}
	
	public Movies build() {
        return new Movies(this);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<Actors> getActors() {
		return actors;
	}

	public void setActors(List<Actors> actors) {
		this.actors = actors;
	}
	
	
}
