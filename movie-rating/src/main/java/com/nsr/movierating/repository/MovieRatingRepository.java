package com.nsr.movierating.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nsr.movierating.model.Rating;

@Repository
public interface MovieRatingRepository extends MongoRepository<Rating, String> {

}
