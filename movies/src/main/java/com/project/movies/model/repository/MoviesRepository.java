package com.project.movies.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movies.model.entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer>{

}
