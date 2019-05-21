package com.project.movies.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Movie Not Found")
public class MovieNotFound extends Exception {

	private static final long serialVersionUID = 1L;
	
	public MovieNotFound() {
		super();
	}

}
