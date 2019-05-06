package com.project.movies.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActor;
	private String firstName;
	
	
	public Actors(int idActor, String firstName) {
		super();
		this.idActor = idActor;
		this.firstName = firstName;
	}

	public Actors() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		return "[idActor=" + idActor + ", firstName=" + firstName + "]";
	}



}
