package com.project.movies.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.movies.model.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer>{
	
	@Query("SELECT m FROM Movies m WHERE m.title = ?1 and m.year = ?2")
	Movies findMovieBD(String title, String year);
	
}
