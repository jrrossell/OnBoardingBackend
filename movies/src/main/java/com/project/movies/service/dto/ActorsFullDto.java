package com.project.movies.service.dto;

import java.io.Serializable;

public class ActorsFullDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idActor;
	private String firstName;
	private String surname;


	public ActorsFullDto() {
		super();
	}
	
	public ActorsFullDto(String firstName, String surname) {
		super();
		this.firstName = firstName;
		this.surname = surname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getIdActor() {
		return idActor;
	}

	public void setIdActor(int idActor) {
		this.idActor = idActor;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
