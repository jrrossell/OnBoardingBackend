package com.project.movies.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="actors")
public class Actors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idActor;
	private String firstName;
	private String surname;
	@ManyToMany(mappedBy = "actors")
    private List<Movies> movies;

	public Actors() {
		super();
	}
	
	public Actors(String firstName, String surname) {
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

	@Override
	public String toString() {
		return "Actors [idActor=" + idActor + ", firstName=" + firstName + ", surname=" + surname + "]";
	}

}
