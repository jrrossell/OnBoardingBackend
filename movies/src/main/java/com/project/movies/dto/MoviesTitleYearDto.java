package com.project.movies.dto;

import java.io.Serializable;

public class MoviesTitleYearDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String title;
	private String year;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}
