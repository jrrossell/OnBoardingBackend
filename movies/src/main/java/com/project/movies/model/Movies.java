package com.project.movies.model;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMovie;
	private String tittle;
	private String gender;
	private String year;
	@JoinTable(
	        name = "rel_movies_actors",
	        joinColumns = @JoinColumn(name = "FK_MOVIES", nullable = false),
	        inverseJoinColumns = @JoinColumn(name="FK_ACTORS", nullable = false)
	    )
	@ManyToMany
	//(cascade = CascadeType.ALL)
	private List<Actors> actors;
	
	public Movies() {
		super();
	}

	public Movies(String tittle, String gender, String year, List<Actors> actors) {
		super();
		this.tittle = tittle;
		this.gender = gender;
		this.year = year;
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

	public List<Actors> getActors() {
		return actors;
	}

	public void setActors(List<Actors> actors) {
        this.actors = actors;
	}

	@Override
	public String toString() {
		return "Movies [Id=" + idMovie + "\n Tittle=" + tittle + "\n Gender=" + gender + "\n Year=" + year + "\n Actors="
				+ actors + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		if (actors == null) {
			if (other.actors != null)
				return false;
		} else if (!actors.equals(other.actors))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (tittle == null) {
			if (other.tittle != null)
				return false;
		} else if (!tittle.equals(other.tittle))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
	
}
