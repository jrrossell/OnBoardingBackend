package com.project.movies.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.movies.model.entity.Actors;

public interface ActorsRepository extends JpaRepository<Actors, Integer> {
	
	@Query("SELECT a FROM Actors a WHERE a.firstname = ?1 and a.surname = ?2")
	Actors verifyActorBD(String firstname, String Surname);
}

