package com.nsr.movierating.model;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rating {

	@Id
	private String userId;
	private List<Map<String,Integer>>  movieRatingList;

	public Rating() {}
	
	public Rating(String userId, List<Map<String, Integer>> movieRatingList) {
		super();
		this.userId = userId;
		this.movieRatingList = movieRatingList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Map<String, Integer>> getMovieRatingList() {
		return movieRatingList;
	}

	public void setMovieRatingList(List<Map<String, Integer>> movieRatingList) {
		this.movieRatingList = movieRatingList;
	}
	
	
	
	
}
