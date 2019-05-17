package com.project.movies.dto;

import java.util.List;

//extender de moviesDto
public class MoviesFullDto extends MoviesTitleYearDto {

	private static final long serialVersionUID = 1L;
	private int id;
	private String gender;
	private List<ActorsFullDto> actors;
	
	public List<ActorsFullDto> getActors() {
		return actors;
	}

	public void setActors(List<ActorsFullDto> actors) {
		this.actors = actors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
