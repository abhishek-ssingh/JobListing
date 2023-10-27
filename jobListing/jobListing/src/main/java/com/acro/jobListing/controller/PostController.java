package com.acro.jobListing.controller;

import com.acro.jobListing.model.Post;
import com.acro.jobListing.service.PostService;
import com.acro.jobListing.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class PostController {

    @Autowired
    private RedisService redisService;
    @Autowired
    private PostService postService;
    //post methods
    @Cacheable(value = "cachedPost")
    @GetMapping("/posts")
    public List<Post> getAllPost(){
        System.out.println("Searching in db");
        return postService.getAllPost();
    }

    @PostMapping("/createPost")
    @CachePut(value = "cachedPut", key = "#post")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @Cacheable(value = "cachedId", key = "#id")
    @GetMapping("/getPost")
    public Post getPost(@RequestParam String id){
        return postService.getById(id);
    }

    @CacheEvict(value = "cachedId", key = "#id")
    @DeleteMapping("/deletePost")
    public void deletePost(@RequestParam String id){
        postService.deleteById(id);
    }

    @GetMapping("/redis-keys")
    public Set<String> getAllKeys(){
        return redisService.getAllKeys();
    }
}
