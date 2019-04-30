package com.ejercicio.peliculas.negocio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ejercicio.peliculas.dao.PeliculasDAO;
import com.ejercicio.peliculas.dao.PeliculasImplDAO;
import com.ejercicio.peliculas.model.Peliculas;

@Service
public class GestionPeliculas {
	
	private PeliculasDAO peliculaDao = new PeliculasImplDAO();
	
	public PeliculasDAO getPeliculaDao() {
		return peliculaDao;
	}

	public void setPeliculaDao(PeliculasDAO peliculaDao) {
		this.peliculaDao = peliculaDao;
	}
	
	public void insertar(Peliculas pelicula) {
		System.out.println(peliculaDao);
		peliculaDao.insertar(pelicula);
	}
	
	public Peliculas buscar(int id) {
		return peliculaDao.buscar(id);
	}
	
	public List<Peliculas> listar() {
		return peliculaDao.listar();
	}
}
