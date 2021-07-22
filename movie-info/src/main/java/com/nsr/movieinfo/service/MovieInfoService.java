package com.nsr.movieinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsr.movieinfo.model.Movie;

@Service
public class MovieInfoService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Movie> getAllMovies(){
		List<Movie> movies= mongoTemplate.findAll(Movie.class);
		if(movies==null) {
			return new ArrayList<>();
		}
		return movies;
	}
	
	public void addMovie(Movie movie) {
		mongoTemplate.save(movie);
	}
	
	public Movie findMovieById(String movieId) {
		return mongoTemplate.findById(movieId, Movie.class);
	}
	
	public ResponseEntity<String> updateMovie(String movieId,Movie movie) {
		Movie movieObject=mongoTemplate.findById(movieId, Movie.class);
		if(movieObject != null) {
			movieObject.setMovieName(movie.getMovieName());
			movieObject.setMovieDesc(movie.getMovieDesc());
			mongoTemplate.save(movieObject);
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Movie not found",HttpStatus.NOT_FOUND);
		
	}

	public ResponseEntity<String> deleteMovie(String movieId){
		Movie movieObject=mongoTemplate.findById(movieId, Movie.class);
		if(movieObject != null) {
			mongoTemplate.remove(movieObject);
			return new ResponseEntity<String>("Movie Delete Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Movie not found",HttpStatus.NOT_FOUND);
		
	}
	
}
