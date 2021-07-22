package com.nsr.movieinfo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.nsr.movieinfo.model.Movie;
@Repository
public interface MovieRepository  extends MongoRepository<Movie, String>{

}
