package com.acro.jobListing.service;

import com.acro.jobListing.model.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();
    Post createPost(Post post);
    Post getById(String id);
    String deleteById(String id);
}
