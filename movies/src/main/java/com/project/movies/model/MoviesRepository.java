package com.project.movies.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MoviesRepository extends JpaRepository<Movies, Integer>{
	
	@Query(nativeQuery = true, value = "select tittle, year from Movies")
	public List<Object> findData();
}
