package com.project.movies.service.dto;

import java.io.Serializable;

public class MoviesDto implements Serializable{

	private static final long serialVersionUID = 1L;
	private String tittle;
	private String year;

	public MoviesDto() {
		super();
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
