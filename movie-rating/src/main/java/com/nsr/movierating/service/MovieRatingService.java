package com.nsr.movierating.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsr.movierating.model.Rating;
import com.nsr.movierating.model.UserRating;

@Service
public class MovieRatingService {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Rating> getAllRatings(){
		return mongoTemplate.findAll(Rating.class);
	}
	
	public Rating addRating(Rating rating) {
		return mongoTemplate.save(rating);
	}

	public UserRating findByUserId(String userId) {
		UserRating userR = new UserRating();
		Rating userRating= mongoTemplate.findById(userId, Rating.class);
		if(userRating != null) {
			userR.setUserRatingList(userRating.getMovieRatingList());
			return userR;
		}
		return new UserRating() ;
	}
	
	
}
