package com.project.movies.dto;

import java.io.Serializable;

public class ActorsFullDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String surname;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}

	public void setId(int idActor) {
		this.id = idActor;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
