package com.acro.jobListing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public Set<String> getAllKeys() {
        return redisTemplate.keys("*");
    }
}