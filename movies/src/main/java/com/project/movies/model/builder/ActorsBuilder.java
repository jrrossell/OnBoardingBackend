package com.project.movies.model.builder;

import com.project.movies.model.entity.Actors;

public class ActorsBuilder {
	private int id;
	private String firstname;
	private String surname;
	
	public ActorsBuilder() {
	}

	public ActorsBuilder id(int id) {
		this.id = id;
		return this;
	}
	
	public ActorsBuilder firstname(String firstname) {
		this.firstname = firstname;
		return this;
	}
	
	public ActorsBuilder surname(String surname) {
		this.surname = surname;
		return this;
	}

	public Actors build() {
        return new Actors(this);
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
