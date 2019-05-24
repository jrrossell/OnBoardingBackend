package com.project.movies.model.builder;

import com.project.movies.model.entity.Actors;

public class ActorsBuilder {
	private int id;
	private String firstname;
	private String surname;

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
	
	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}	
	
	public Actors build() {
		Actors actor = new Actors();
		actor.setFirstName(this.firstname);
		actor.setSurname(this.surname);
		actor.setId(this.id);
        return actor;
    }
}
