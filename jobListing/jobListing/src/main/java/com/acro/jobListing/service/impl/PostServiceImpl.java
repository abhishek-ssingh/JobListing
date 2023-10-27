package com.acro.jobListing.service.impl;

import com.acro.jobListing.model.Post;
import com.acro.jobListing.repository.PostRepo;
import com.acro.jobListing.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Override
    public List<Post> getAllPost() {
        return postRepo.findAll();
    }
    @Override
    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    @Override
    public Post getById(String id) {
        return postRepo.findById(id).get();
    }
    @Override
    public String deleteById(String id) {
        postRepo.deleteById(id);

        return "Post Deleted";
    }
}
