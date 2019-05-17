package com.project.movies.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.movies.model.entity.Actors;

public interface ActorsRepository extends JpaRepository<Actors, Integer>{

}
