package com.project.movies.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.movies.exceptions.MovieRepeat;
import com.project.movies.model.builder.ActorsBuilder;
import com.project.movies.model.entity.Actors;
import com.project.movies.model.entity.Movies;
import com.project.movies.model.repository.ActorsRepository;

public class MetodosSql {
	public static Actors verifyActorBD(ActorsRepository actorsRepository, Actors actor) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("Select * FROM ACTORS WHERE FIRST_NAME='" + actor.getFirstName() 
										+ "' AND SURNAME='" + actor.getSurname() + "'");
		
		if (rs.first()) {
			Actors actorBD = new Actors();
			actorBD.setId(rs.getInt("ID"));
			actorBD.setFirstName(rs.getString("FIRST_NAME"));
			actorBD.setSurname(rs.getString("SURNAME"));
			
			return actorBD; 
		}
		
	    rs.close();
	    st.close();
		
		Actors guardarActor = new ActorsBuilder().firstname(actor.getFirstName()).surname(actor.getSurname()).build();
		return actorsRepository.save(guardarActor);
	}
	
	public static void verifyMovieBD(Movies movie) throws MovieRepeat, SQLException {
		Connection conn = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM MOVIES WHERE TITLE='" + movie.getTitle() 
										+ "' AND YEAR='" + movie.getYear() + "'");
		
		if (rs.first()) throw new MovieRepeat();
	}
	
}
