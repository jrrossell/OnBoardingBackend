package com.ejercicio.peliculas.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejercicio.peliculas.dao.MoviesDAO;
import com.ejercicio.peliculas.dao.MoviesImplDAO;
import com.ejercicio.peliculas.model.Movies;

@Service
public class ManageMovies {
	
	private MoviesDAO movieDao = new MoviesImplDAO();
	
	public MoviesDAO getMovieDao() {
		return movieDao;
	}

	public void setMovieDao(MoviesDAO movieDao) {
		this.movieDao = movieDao;
	}
	
	public void insert(Movies movie) {
		movieDao.insert(movie);
	}
	
	public Movies find(String tittle) {
		return movieDao.find(tittle);
	}
	
	public List<Movies> list() {
		return movieDao.list();
	}
}
