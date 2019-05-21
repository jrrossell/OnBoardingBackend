package com.project.movies.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="La pelicula ya existe")
public class MovieRepeat extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MovieRepeat() {
		super();
	}

}
