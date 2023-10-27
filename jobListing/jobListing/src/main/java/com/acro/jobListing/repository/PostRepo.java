package com.acro.jobListing.repository;

import com.acro.jobListing.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends MongoRepository<Post, String> {

}
